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
      <br><a href="#" @click.prevent="forgotPassword">¿Olvidaste tu contraseña?</a> <br>
      <router-link to="/register">Registrarse</router-link>
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
    console.log('Iniciar sesión');
  },
  forgotPassword() {
    window.alert('¡Qué pena! :(');
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
  margin-left: 250px; 
  background-color: #f2f2f2;
  border-radius: 5px;
  padding: 20px;
  box-shadow: 0px 0px 10px 0px rgba(0,0,0,0.1);
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