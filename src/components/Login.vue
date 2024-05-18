<template>
    <Sidebar/>
    <div class="login">
      <h2>Iniciar sesión</h2>
      <form @submit="login">
        <label for="email">Correo electrónico:</label>
        <input type="email" id="email" v-model="email" required>
        <label for="password">Contraseña:</label>
        <input type="password" id="password" v-model="password" required>
        <button type="submit">Iniciar sesión</button>
      </form>
      <div>
        <a href="#">¿Olvidaste tu contraseña?</a>
        <a href="#">Registrarse</a>
      </div>
    </div>
  </template>
  
  <script>
  import Sidebar from './Sidebar.vue'
  
  export default {
    name: 'Login',
    components: {
      Sidebar
    },
    data() {
      return {
        email: '',
        password: ''
      }
    },
    methods: {
      login() {
        // Aquí puedes agregar la lógica para iniciar la sesión
        console.log('Iniciar sesión');
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
  height: 100vh;
  margin-left: 500px; /* Ajusta este valor para mover el perfil hacia la izquierda */

}
</style>