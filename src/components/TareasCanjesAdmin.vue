<template>
    <div class="container">
        <Sidebar />
        <div class="tareas-canjes-admin">
            <div class="tareas-canjes-admin-box">
                <h1 class="welcome-text">Tareas y Canjes</h1>
                <h2 class="center-text">Tareas y Canjes del Grupo {{ grupo.Nombre }}</h2>
                <div class="content">
                    <div>
                        <h3>Tareas:</h3>
                        <ul>
                            <li v-for="tarea in tareas" :key="tarea.ID">
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
                            <li v-for="canje in canjes" :key="canje.ID">
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
import Sidebar from './Sidebar.vue';
import { cargarDatosDesdeJSON } from '../utils/datos_avance2.js';
import '@/assets/global.css';


export default {
    name: 'TareasCanjesAdmin',
    components: {
        Sidebar
    },
    data() {
        return {
            grupo: {
                Nombre: 'Grupo de Tareas'
            },
            tareas: [],
            canjes: [],
            tareaEnEdicion: null,
            canjeEnEdicion: null
        };
    },
    methods: {
        iniciarEdicionTarea(tarea) {
            this.tareaEnEdicion = { ...tarea };
        },
        cancelarEdicionTarea() {
            this.tareaEnEdicion = null;
        },
        guardarTareaEditada() {
            const index = this.tareas.findIndex(t => t.ID === this.tareaEnEdicion.ID);
            if (index !== -1) {
                this.tareas.splice(index, 1, this.tareaEnEdicion);
            }
            this.tareaEnEdicion = null;
        },
        iniciarEdicionCanje(canje) {
            this.canjeEnEdicion = { ...canje };
        },
        cancelarEdicionCanje() {
            this.canjeEnEdicion = null;
        },
        guardarCanjeEditado() {
            const index = this.canjes.findIndex(c => c.ID === this.canjeEnEdicion.ID);
            if (index !== -1) {
                this.canjes.splice(index, 1, this.canjeEnEdicion);
            }
            this.canjeEnEdicion = null;
        },
        eliminarTarea(id) {
            this.tareas = this.tareas.filter(t => t.ID !== id);
        },
        eliminarCanje(id) {
            this.canjes = this.canjes.filter(c => c.ID !== id);
        },
        cargarDatos() {
            cargarDatosDesdeJSON()
                .then(data => {
                    this.tareas = data.grupos[0].Tareas;
                    this.canjes = data.grupos[0].Canjes;
                })
                .catch(error => {
                    console.error('Error al cargar datos desde JSON:', error);
                });
        }
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

.content>div {
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

    .content>div {
        width: 100%;
        margin-bottom: 20px;
    }
}
</style>
