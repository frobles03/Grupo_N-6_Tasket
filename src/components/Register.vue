<template>
    <Sidebar/>
    <div class="register">
      <h2>Registrarse</h2>
      <form @submit="register">
        <label for="email">Correo electrónico:</label>
        <input type="email" id="email" v-model="email" required>
        <label for="password">Contraseña:</label>
        <input type="password" id="password" v-model="password" required>
        <label for="confirmPassword">Confirmar contraseña:</label>
        <input type="password" id="confirmPassword" v-model="confirmPassword" required>
        <button type="submit">Registrarse</button>
      </form>
      <div>
        <br><a href="#">¿Ya tienes una cuenta? Inicia sesión</a> <br>
      </div>
    </div>
  </template>
  
  <script>
  import Sidebar from './Sidebar.vue'
  
  export default {
    name: 'Register',
    components: {
      Sidebar
    },
    data() {
      return {
        email: '',
        password: '',
        confirmPassword: ''
      }
    },
    methods: {
      register() {
        console.log('Registrarse');
      }
    }
  }
  </script>
  
  <style scoped>
  .register {
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
  
  .register h2 {
    margin-bottom: 20px;
  }
  
  .register form {
    display: flex;
    flex-direction: column;
    width: 100%;
  }
  
  .register form label {
    margin-bottom: 5px;
  }
  
  .register form input {
    margin-bottom: 15px;
    padding: 10px;
    border-radius: 5px;
    border: 1px solid #ccc;
  }
  
  .register form button {
    padding: 10px;
    border-radius: 5px;
    border: none;
    background-color: #007BFF;
    color: white;
    cursor: pointer;
  }
  
  .register form button:hover {
    background-color: #0056b3;
  }
  
  .register a {
    color: #007BFF;
    text-decoration: none;
    display: block;
    text-align: center;
  }
  
  .register a:hover {
    text-decoration: underline;
  }
  </style>