<template>
  <Sidebar/>
  <div class="register">
    <h2>Registrarse</h2> <br><br><br>
    <form @submit="register">
      <label for="fullName">Nombre completo:</label>
      <input type="text" id="fullName" v-model="fullName" required>
      <label for="email">Correo electrónico:</label>
      <input type="email" id="email" v-model="email" required>
      <label for="password">Contraseña:</label>
      <input type="password" id="password" v-model="password" required>
      <label for="confirmPassword">Confirmar contraseña:</label>
      <input type="password" id="confirmPassword" v-model="confirmPassword" required>
      <label for="birthDate">Fecha de nacimiento:</label>
      <input type="date" id="birthDate" v-model="birthDate" required>
      <label for="gender">Género:</label>
      <select id="gender" v-model="gender" required>
        <option disabled value="">Por favor selecciona un género</option>
        <option>Masculino</option>
        <option>Femenino</option>
        <option>Otro</option>
      </select>
      <button type="submit">Registrarse</button>
    </form>
    <div>
   
    </div>
  </div>
</template>

<script>
import Sidebar from './Sidebar.vue'
import '@/assets/global.css';

export default {
  name: 'Register',
  components: {
    Sidebar
  },
  data() {
    return {
      fullName: '',
      email: '',
      password: '',
      confirmPassword: '',
      birthDate: '',
      gender: ''
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
  width: 60%;
  min-height: 80vh; /* Cambia 'height' a 'min-height' */
  margin: auto auto auto 350px;
  background-color: #FFB877;
  border-radius: 10px;
  padding: 20px;
  box-shadow: 0px 0px 10px 0px rgba(0,0,0,0.1);
}

@media (max-width: 768px) {
  .register {
    margin-left: 0;
    padding: 10px;
  }
}

.register form button {
  padding: 10px;
  border-radius: 5px;
  border: none;
  background-color: #AF3800 !important; /* Añade !important para asegurarte de que este estilo se aplique */
  color: white;
  cursor: pointer;
}

.register form button:hover {
  background-color: #8C2E00 !important; /* Añade !important para asegurarte de que este estilo se aplique */
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

.register form input, .register form select {
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