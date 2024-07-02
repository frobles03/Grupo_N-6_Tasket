<template>
    <div class="container">
      <Sidebar />
      <div class="roles-admin">
        <h1 class="welcome-text">Gestión de Roles</h1>
        <div class="content">
          <div>
            <h3>Usuarios y Roles</h3>
            <ul>
              <li v-for="usuario in grupo.Usuarios" :key="usuario.ID">
                <div>
                  <span>{{ usuario.Nombre }} - {{ usuario.Rol }}</span>
                  <div class="buttons">
                    <button @click="editarRol(usuario)">Editar Rol</button>
                  </div>
                </div>
              </li>
            </ul>
          </div>
          <div v-if="usuarioSeleccionado">
            <h3>Editar Rol de Usuario</h3>
            <form @submit.prevent="guardarRolEditado">
              <label>Nombre: <input v-model="usuarioSeleccionado.Nombre" disabled /></label><br />
              <label>Rol: 
                <select v-model="usuarioSeleccionado.Rol">
                  <option value="admin">Administrador</option>
                  <option value="usuario">Usuario</option>
                  <!-- Otros roles -->
                </select>
              </label><br />
              <button type="submit">Guardar</button>
              <button @click="cancelarEdicionRol">Cancelar</button>
            </form>
          </div>
        </div>
      </div>
    </div>
  </template>
  
  <script>
  import axios from 'axios';
  import Sidebar from '../common/Sidebar.vue';
  import '@/assets/global.css';
  
  export default {
    name: 'AdminRoles',
    components: {
      Sidebar
    },
    data() {
      return {
        grupo: {
          Usuarios: []
        },
        usuarioSeleccionado: null
      };
    },
    methods: {
      async cargarDatos() {
        try {
          const response = await axios.get('http://localhost:3000/grupos');
          this.grupo = response.data[0];
        } catch (error) {
          console.error('Error al cargar datos desde JSON Server:', error);
        }
      },
      editarRol(usuario) {
        this.usuarioSeleccionado = { ...usuario };
      },
      cancelarEdicionRol() {
        this.usuarioSeleccionado = null;
      },
      async guardarRolEditado() {
        try {
          const usuarioIndex = this.grupo.Usuarios.findIndex(u => u.ID === this.usuarioSeleccionado.ID);
          if (usuarioIndex !== -1) {
            this.grupo.Usuarios[usuarioIndex] = { ...this.usuarioSeleccionado };
          }
          await axios.put(`http://localhost:3000/grupos/${this.grupo.id}`, this.grupo);
        } catch (error) {
          console.error('Error al guardar rol editado:', error);
        }
        this.usuarioSeleccionado = null;
      }
    },
    mounted() {
      this.cargarDatos();
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
  
  .roles-admin {
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
  
  select {
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
  