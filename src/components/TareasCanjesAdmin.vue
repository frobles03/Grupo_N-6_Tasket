<template>
    <div class="container">
        <Sidebar />
        <div class="tareas-canjes-admin">
            <div class="tareas-canjes-admin-box">
                <h1 class="welcome-text">Tareas y Canjes</h1>
                <h2 class="center-text">Tareas y Canjes del Grupo {{ nombreGrupo }}</h2>
                <div class="content">
                    <div>
                        <h3>Tareas:</h3>
                        <ul>
                            <li v-for="tarea in grupo.Tareas" :key="tarea.ID">
                                {{ tarea.Nombre }} - {{ tarea.Descripcion }} - Puntaje: {{ tarea.Puntaje }}
                                <button @click="iniciarEdicionTarea(tarea)">Editar</button>
                                <button @click="eliminarTarea(tarea.ID)">Eliminar</button>
                            </li>
                        </ul>
                        <div v-if="tareaEnEdicion">
                            <h3>Editar Tarea</h3>
                            <form @submit.prevent="guardarTareaEditada">
                                <label>Nombre: <input v-model="tareaEnEdicion.Nombre" /></label><br>
                                <label>Descripción: <input v-model="tareaEnEdicion.Descripcion" /></label><br>
                                <label>Puntaje: <input type="number" v-model="tareaEnEdicion.Puntaje" /></label><br>
                                <button type="submit">Guardar</button>
                                <button @click="cancelarEdicionTarea">Cancelar</button>
                            </form>
                        </div>
                    </div>
                    <div>
                        <h3>Canjes:</h3>
                        <ul>
                            <li v-for="canje in grupo.Canjes" :key="canje.ID">
                                {{ canje.Nombre }} - {{ canje.Descripcion }} - Puntaje Requerido: {{ canje.PuntajeRequerido }}
                                <button @click="iniciarEdicionCanje(canje)">Editar</button>
                                <button @click="eliminarCanje(canje.ID)">Eliminar</button>
                            </li>
                        </ul>
                        <div v-if="canjeEnEdicion">
                            <h3>Editar Canje</h3>
                            <form @submit.prevent="guardarCanjeEditado">
                                <label>Nombre: <input v-model="canjeEnEdicion.Nombre" /></label><br>
                                <label>Descripción: <input v-model="canjeEnEdicion.Descripcion" /></label><br>
                                <label>Puntaje Requerido: <input type="number" v-model="canjeEnEdicion.PuntajeRequerido" /></label><br>
                                <button type="submit">Guardar</button>
                                <button @click="cancelarEdicionCanje">Cancelar</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
import axios from 'axios';
import Sidebar from './Sidebar.vue';
import '@/assets/global.css';

export default {
    name: 'TareasCanjesAdmin',
    components: {
        Sidebar
    },
    data() {
        return {
            grupo: {
                Nombre: '',
                Tareas: [],
                Canjes: []
            },
            tareaEnEdicion: null,
            canjeEnEdicion: null
        };
    },
    computed: {
        nombreGrupo() {
            if (this.grupo && this.grupo.Nombre) {
                return this.grupo.Nombre;
            } else {
                return 'seleccionado';
            }
        }
    },
    methods: {
        async cargarDatos() {
            try {
                const response = await axios.get('http://localhost:3000/grupos');
                this.grupo = response.data[0];
                console.log(this.grupo);
            } catch (error) {
                console.error('Error al cargar datos desde JSON Server:', error);
            }
        },
        async guardarTareaEditada() {
            try {
                const tareaIndex = this.grupo.Tareas.findIndex(t => t.ID === this.tareaEnEdicion.ID);
                if (tareaIndex !== -1) {
                    this.grupo.Tareas[tareaIndex] = { ...this.tareaEnEdicion };
                }
                await axios.put(`http://localhost:3000/grupos/${this.grupo.id}`, this.grupo);
            } catch (error) {
                console.error('Error al guardar tarea editada:', error);
            }
            this.tareaEnEdicion = null;
        },
        async guardarCanjeEditado() {
            try {
                const canjeIndex = this.grupo.Canjes.findIndex(c => c.ID === this.canjeEnEdicion.ID);
                if (canjeIndex !== -1) {
                    this.grupo.Canjes[canjeIndex] = { ...this.canjeEnEdicion };
                }
                await axios.put(`http://localhost:3000/grupos/${this.grupo.id}`, this.grupo);
            } catch (error) {
                console.error('Error al guardar canje editado:', error);
            }
            this.canjeEnEdicion = null;
        },
        async eliminarTarea(id) {
            try {
                this.grupo.Tareas = this.grupo.Tareas.filter(t => t.ID !== id);
                await axios.put(`http://localhost:3000/grupos/${this.grupo.id}`, this.grupo);
            } catch (error) {
                console.error('Error al eliminar tarea:', error);
            }
        },
        async eliminarCanje(id) {
            try {
                this.grupo.Canjes = this.grupo.Canjes.filter(c => c.ID !== id);
                await axios.put(`http://localhost:3000/grupos/${this.grupo.id}`, this.grupo);
            } catch (error) {
                console.error('Error al eliminar canje:', error);
            }
        },
        iniciarEdicionTarea(tarea) {
            this.tareaEnEdicion = { ...tarea };
        },
        iniciarEdicionCanje(canje) {
            this.canjeEnEdicion = { ...canje };
        },
        cancelarEdicionTarea() {
            this.tareaEnEdicion = null;
        },
        cancelarEdicionCanje() {
            this.canjeEnEdicion = null;
        },
    },
    mounted() {
        this.cargarDatos();
    }
};
</script>

<style scoped>
.container {
    display: flex;
}

.tareas-canjes-admin {
    flex: 1;
    padding: 20px;
    margin-left: 220px; /* Ajuste para evitar superposición con la barra lateral */
}

.tareas-canjes-admin-box {
    border: 1px solid #ccc;
    border-radius: 10px;
    padding: 20px;
}

.welcome-text {
    background-color: orange;
    padding: 10px;
    border-radius: 5px;
    text-align: center;
}

.center-text {
    text-align: center;
}

.content {
    display: flex;
    justify-content: space-between;
}

.content > div {
    width: 48%;
}

@media (max-width: 768px) {
    .tareas-canjes-admin {
        margin-left: 0;
        padding: 10px;
    }

    .content {
        flex-direction: column;
    }

    .content > div {
        width: 100%;
        margin-bottom: 20px;
    }
}
</style>