<template>
    <div class="container">
      <Sidebar />
      <div class="reportes-admin">
        <h1 class="welcome-text">Reportes y Analíticas</h1>
        <div class="content">
          <h3>Generar Reporte</h3>
          <form @submit.prevent="generarReporte">
            <label>Tipo de Reporte:
              <select v-model="tipoReporte">
                <option value="tareas">Tareas Completadas</option>
                <option value="canjes">Canjes Realizados</option>
                <option value="usuarios">Participación de Usuarios</option>
              </select>
            </label><br />
            <label>Fecha Inicio: <input type="date" v-model="fechaInicio" /></label><br />
            <label>Fecha Fin: <input type="date" v-model="fechaFin" /></label><br />
            <button type="submit">Generar</button>
          </form>
          <div v-if="reporteGenerado">
            <h3>Reporte: {{ tipoReporte }}</h3>
            <div v-if="tipoReporte === 'tareas'">
              <!-- Mostrar reporte de tareas -->
            </div>
            <div v-if="tipoReporte === 'canjes'">
              <!-- Mostrar reporte de canjes -->
            </div>
            <div v-if="tipoReporte === 'usuarios'">
              <!-- Mostrar reporte de usuarios -->
            </div>
          </div>
        </div>
      </div>
    </div>
  </template>
  
  <script>
  import Sidebar from '../common/Sidebar.vue';
  import '@/assets/global.css';
  
  export default {
    name: 'AdminReportes',
    components: {
      Sidebar
    },
    data() {
      return {
        tipoReporte: 'tareas',
        fechaInicio: '',
        fechaFin: '',
        reporteGenerado: false
      };
    },
    methods: {
      async generarReporte() {
        try {
          // Lógica para generar el reporte basado en los datos seleccionados
          this.reporteGenerado = true;
        } catch (error) {
          console.error('Error al generar el reporte:', error);
        }
      }
    }
  };
  </script>
  
  <style scoped>
  /* Estilos similares a los de otros componentes de administración */
  .container {
    display: flex;
    flex-wrap: wrap;
    background-color: #f3f4f6;
    font-family: 'Helvetica Neue', Arial, sans-serif;
    color: #333;
  }
  
  .reportes-admin {
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
  
  .content {
    display: flex;
    flex-direction: column;
    gap: 20px;
  }
  
  h3 {
    font-size: 1.2em;
    margin-bottom: 15px;
    color: #ff9800;
  }
  
  label {
    display: block;
    margin-bottom: 10px;
    color: #333;
  }
  
  select, input[type="date"] {
    width: calc(100% - 10px);
    padding: 8px;
    margin-bottom: 10px;
    border: 1px solid #ccc;
    border-radius: 5px;
  }
  
  button {
    background-color: #ff9800;
    color: white;
    padding: 10px 15px;
    border: none;
    border-radius: 5px;
    cursor: pointer;
    margin-right: 10px;
    transition: background-color 0.3s;
  }
  
  button:hover {
    background-color: #e68900;
  }
  </style>
  