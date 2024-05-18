<template>
    <div class="sidebar">
      <h1>Tasket</h1>
      <nav>
        <ul>
            <li><router-link to="/">Inicio</router-link></li>
        <li>Notificaciones</li>
        <li><router-link to="/perfil">Perfil</router-link></li>
          <li>Configuración</li>
          <li>Tienda de canje</li>
        </ul>
      </nav>
      <div>
        <h2>Grupos</h2>
        <nav>
          <ul>
            <li>Personal</li>
            <li>Grupo 1</li>
            <li>Grupo 2</li>
            <li>Grupo 3</li>
          </ul>
        </nav>
      </div>
      <button><router-link to="/login">Iniciar sesión</router-link></button>
      <button>Cerrar sesión</button>
    </div>
  </template>
  
  <script>
  // Aquí puedes agregar cualquier lógica de JavaScript que necesites para el sidebar
  </script>
  
  <style scoped>
  .sidebar {
    border: 3px solid #AF3800;
    background-color: #FE621D;
    width: 250px;
    position: fixed;
    height: 90vh;
    overflow: auto;
    display: flex;
    align-items: center;
    justify-content: center;
    flex-direction: column;
    border-radius: 20px;
  }
  
  @media (max-width: 768px) {
    .sidebar {
      width: 100px;
    }
  }
  </style>