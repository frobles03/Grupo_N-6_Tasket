<template>
    <div class="container">
      <Sidebar />
      <div class="usuarios-admin">
        <h1 class="welcome-text">Administración de Usuarios</h1>
        <h2 class="center-text">Usuarios del Grupo {{ nombreGrupo }}</h2>
        <div class="content">
          <ul>
            <li v-for="usuario in grupo.Usuarios" :key="usuario.ID">
              <div>
                <span>{{ usuario.Nombre }} - {{ usuario.Apodo }} - {{ usuario.Correo }}</span>
                <div class="buttons">
                  <button @click="iniciarEdicionUsuario(usuario)">Editar</button>
                  <button @click="confirmarEliminacion(() => eliminarUsuario(usuario.ID))">Eliminar</button>
                </div>
              </div>
            </li>
          </ul>
          <div v-if="usuarioEnEdicion">
            <h3>Editar Usuario</h3>
            <form @submit.prevent="guardarUsuarioEditado">
              <label>Nombre: <input v-model="usuarioEnEdicion.Nombre" /></label><br />
              <label>Apodo: <input v-model="usuarioEnEdicion.Apodo" /></label><br />
              <label>Correo: <input v-model="usuarioEnEdicion.Correo" /></label><br />
              <button type="submit">Guardar</button>
              <button @click="cancelarEdicionUsuario">Cancelar</button>
            </form>
          </div>
          <div>
            <h3>Agregar Nuevo Usuario</h3>
            <form @submit.prevent="agregarNuevoUsuario">
              <label>Nombre: <input v-model="nuevoUsuario.Nombre" /></label><br />
              <label>Apodo: <input v-model="nuevoUsuario.Apodo" /></label><br />
              <label>Correo: <input v-model="nuevoUsuario.Correo" /></label><br />
              <button type="submit">Agregar</button>
            </form>
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
    name: 'AdminUsuarios',
    components: {
      Sidebar
    },
    data() {
      return {
        grupo: {
          Nombre: '',
          Usuarios: []
        },
        usuarioEnEdicion: null,
        nuevoUsuario: {
          Nombre: '',
          Apodo: '',
          Correo: ''
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
      },
      async guardarUsuarioEditado() {
        try {
          const usuarioIndex = this.grupo.Usuarios.findIndex(u => u.ID === this.usuarioEnEdicion.ID);
          if (usuarioIndex !== -1) {
            this.grupo.Usuarios[usuarioIndex] = { ...this.usuarioEnEdicion };
          }
          await axios.put(`http://localhost:3000/grupos/${this.grupo.id}`, this.grupo);
        } catch (error) {
          console.error('Error al guardar usuario editado:', error);
        }
        this.usuarioEnEdicion = null;
      },
      async eliminarUsuario(id) {
        try {
          this.grupo.Usuarios = this.grupo.Usuarios.filter(u => u.ID !== id);
          await axios.put(`http://localhost:3000/grupos/${this.grupo.id}`, this.grupo);
        } catch (error) {
          console.error('Error al eliminar usuario:', error);
        }
      },
      iniciarEdicionUsuario(usuario) {
        this.usuarioEnEdicion = { ...usuario };
      },
      cancelarEdicionUsuario() {
        this.usuarioEnEdicion = null;
      },
      async agregarNuevoUsuario() {
        try {
          const nuevoUsuarioConID = { ...this.nuevoUsuario, ID: Date.now() };
          this.grupo.Usuarios.push(nuevoUsuarioConID);
          await axios.put(`http://localhost:3000/grupos/${this.grupo.id}`, this.grupo);
          this.nuevoUsuario = { Nombre: '', Apodo: '', Correo: '' };
        } catch (error) {
          console.error('Error al agregar nuevo usuario:', error);
        }
      },
      confirmarEliminacion(accion) {
        if (confirm('¿Estás seguro de que deseas eliminar esto?')) {
          accion();
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
  
  .usuarios-admin {
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
    display: flex;
    flex-direction: column;
  }
  
  li:last-child {
    border-bottom: none;
  }
  
  .buttons {
    margin-top: 10px;
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
  