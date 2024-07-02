<template>
    <div class="container">
      <Sidebar />
      <div class="estadisticas-admin">
        <h1 class="welcome-text">Estadísticas del Grupo</h1>
        <h2 class="center-text">Estadísticas del Grupo {{ nombreGrupo }}</h2>
        <div class="content">
          <div>
            <h3>Tareas Completadas</h3>
            <ul>
              <li v-for="tarea in grupo.Tareas" :key="tarea.ID">
                <div>
                  <span>{{ tarea.Nombre }} - Completadas: {{ tarea.Completadas }}</span>
                </div>
              </li>
            </ul>
          </div>
          <div>
            <h3>Canjes Realizados</h3>
            <ul>
              <li v-for="canje in grupo.Canjes" :key="canje.ID">
                <div>
                  <span>{{ canje.Nombre }} - Realizados: {{ canje.Realizados }}</span>
                </div>
              </li>
            </ul>
          </div>
          <div>
            <h3>Participación de Usuarios</h3>
            <ul>
              <li v-for="usuario in grupo.Usuarios" :key="usuario.ID">
                <div>
                  <span>{{ usuario.Nombre }} - Tareas Completadas: {{ usuario.TareasCompletadas }}</span>
                </div>
              </li>
            </ul>
          </div>
        </div>
      </div>
    </div>
  </template>
  
  <script>
  import axios from 'axios';
  import Sidebar from '../common/Sidebar.vue'
  import '@/assets/global.css';
  
  export default {
    name: 'AdminEstadisticas',
    components: {
      Sidebar
    },
    data() {
      return {
        grupo: {
          Nombre: '',
          Tareas: [],
          Canjes: [],
          Usuarios: []
        }
      };
    },
    computed: {
      nombreGrupo() {
        return this.grupo?.Nombre || 'seleccionado';
      }
    },
    methods: {
      async cargarDatos() {
        try {
          const response = await axios.get('http://localhost:3000/grupos');
          this.grupo = response.data[0];
        } catch (error) {
          console.error('Error al cargar datos desde JSON Server:', error);
        }
      }
    },
    mounted() {
      this.cargarDatos();
    }
  };
  </script>
  
  <style scoped>
  /* Estilos similares a los de TareasCanjesAdmin.vue, ajustados para esta vista */
  .container {
    display: flex;
    flex-wrap: wrap;
    background-color: #f3f4f6;
    font-family: 'Helvetica Neue', Arial, sans-serif;
    color: #333;
  }
  
  .estadisticas-admin {
    flex: 1;
    padding: 20px;
    margin-left: 220px;
    background-color: #fdfdfd;
    box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
    border-radius: 10px;
  }
  
  .welcome-text {
    background-color: #ff9800;
    color: #fff;
    padding: 15px;
    border-radius: 5px;
    text-align: center;
    font-size: 1.5em;
    margin-bottom: 20px;
  }
  
  .center-text {
    text-align: center;
    font-size: 1.3em;
    margin-bottom: 20px;
    color: #555;
  }
  
  .content {
    display: flex;
    flex-direction: column;
    gap: 20px;
  }
  
  .content>div {
    background-color: #fff8e1;
    padding: 15px;
    border-radius: 5px;
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
    margin-bottom: 20px;
  }
  
  h3 {
    font-size: 1.2em;
    margin-bottom: 15px;
    color: #ff9800;
  }
  
  ul {
    list-style-type: none;
    padding: 0;
  }
  
  li {
    padding: 10px;
    border-bottom: 1px solid #ddd;
    font-size: 1em;
    color: #333;
  }
  
  li:last-child {
    border-bottom: none;
  }
  
  label {
    display: block;
    margin-bottom: 10px;
    color: #333;
  }
  
  input[type="text"] {
    width: calc(100% - 10px);
    padding: 8px;
    margin-bottom: 10px;
    border: 1px solid #ccc;
    border-radius: 5px;
    box-shadow: inset 0 1px 3px rgba(0, 0, 0, 0.1);
  }
  </style>
  