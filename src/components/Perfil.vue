<template>
    <div class="container">
      <Sidebar/>
      <div class="perfil">
        <h1>Bienvenido a tu perfil</h1>
        <p>Nombre de usuario: Fernando Robles</p>
        <p>Email: f.robles03@ufromail.cl</p>
      
      </div>
    </div>
  </template>
  
  <script>
  import Sidebar from './Sidebar.vue'
  
  export default {
    name: 'Perfil',
    components: {
      Sidebar
    }
  }
  </script>
  
  <style scoped>
  .container {
    display: flex;
  }
  
  .perfil {
    margin-left: 500px; /* Ajusta este valor para mover el perfil hacia la izquierda */
  }
  </style>