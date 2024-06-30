<template>
  <Sidebar/>
  <div class="login">
    <h2>Iniciar sesión</h2> <br><br><br>
    <form @submit="login">
      <label for="email">Correo electrónico:</label>
      <input type="email" id="email" v-model="email" required>
      <label for="password">Contraseña:</label>
      <input type="password" id="password" v-model="password" required>
      <button type="submit">Iniciar sesión</button>
    </form>
    <div>
      <br><a href="#" @click.prevent="forgotPassword">¿Olvidaste tu contraseña?</a> <br>
      <router-link to="/register">Registrarse</router-link>
    </div>


    <div>
      <h2>Usuarios:</h2>
      <ul>
        <li v-for="user in users" :key="user.id">{{ user.nombreCompleto }}</li>
      </ul>
    </div>
  </div>


</template>
<script>
import axios from 'axios';
import Sidebar from '../common/Sidebar.vue';
import '@/assets/global.css';

export default {
  name: 'Login',
  components: {
    Sidebar
  },
  data() {
    return {
      email: '',
      password: '',
      users: [] // Añade esto para almacenar los usuarios
    }
  },
  mounted() {
    this.fetchUsers(); // Llama a fetchUsers cuando el componente se monte
  },
  methods: {
    login() {
      console.log('Iniciar sesión');
    },
    forgotPassword() {
      window.alert('¡Qué pena! :(');
    },
    fetchUsers() {
      axios.get('http://localhost:8090/usuarios') // Asegúrate de usar tu URL correcta
        .then(response => {
          this.users = response.data; // Almacena los usuarios en la propiedad users
        })
        .catch(error => {
          console.error('Hubo un error al obtener los usuarios:', error);
        });
    }
  }
}
</script>
<style scoped>
.login {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  width: 60%; /* Reduce aún más el ancho de la caja a 60% del ancho del contenedor */
  height: 80vh;
  margin: auto auto auto 350px; /* Cambia el margen para mover la caja a la derecha */
  background-color: #FFB877;
  border-radius: 10px;
  padding: 20px;
  box-shadow: 0px 0px 10px 0px rgba(0,0,0,0.1);
}

/* Añade una consulta de medios para hacer que la clase .login sea responsiva */
@media (max-width: 768px) {
  .login {
    margin-left: 0; /* Elimina el margen izquierdo en pantallas pequeñas */
    padding: 10px; /* Reduce el padding en pantallas pequeñas */
  }
}
.login h2 {
  margin-bottom: 20px;
}

.login form {
  display: flex;
  flex-direction: column;
  width: 100%;
}

.login form label {
  margin-bottom: 5px;
}

.login form input {
  margin-bottom: 15px;
  padding: 10px;
  border-radius: 5px;
  border: 1px solid #ccc;
}

.login form button {
  padding: 10px;
  border-radius: 5px;
  border: none;
  background-color: #007BFF;
  color: white;
  cursor: pointer;
}

.login form button:hover {
  background-color: #0056b3;
}

.login a {
  color: #007BFF;
  text-decoration: none;
}

.login a:hover {
  text-decoration: underline;
}

.login a {
  color: #007BFF;
  text-decoration: none;
  display: block;
  text-align: center;
}

</style>