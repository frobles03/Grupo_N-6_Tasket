<template>
  <div class="sidebar">
    <header>
      <h1 class="center-text">Tasket</h1>
    </header>
    
    <main class="main-content">
      <nav>
        <ul class="large-list">
          <li><router-link to="/"><font-awesome-icon icon="home" /> Inicio</router-link></li>      
          <br>
          <li><font-awesome-icon icon="bell" /> Notificaciones</li>
          <br>
          <li><router-link to="/perfil"><font-awesome-icon icon="user" /> Perfil</router-link></li>
          <br>
          <li><font-awesome-icon icon="cog" /> Configuración</li>         
          <br>     
        </ul>
        <h2 class="center-text">Grupos</h2>
    <nav>
      <ul class="scrollable-list">
        <li>Personal</li>
        <li>Grupo 1</li>
        <li>Grupo 2</li>
        <li>Grupo 3</li>
        <li>Grupo 4</li>
        <li>Grupo 5</li>
        <li>Grupo 6</li>
        <li>Grupo 7</li>
        <li>Grupo 8</li>
        <li>Grupo 9</li>
        <li>Grupo 10</li>

      </ul>
        </nav>
      </nav>
    </main>

 <footer class="footer-content">
    <button @click="login">Iniciar sesión</button>
    <br>
    <button @click="logout">Cerrar sesión</button>
  </footer>
  </div>
</template>

<script>
export default {
  methods: {
    login() {
      this.$router.push('/login');
    },
    logout() {
      this.$router.push('/');

    }
  }
}
</script>
<style scoped>
.sidebar {
  border: 3px solid #AF3800;
  background-color: #FE621D;
  width: 200px;
  min-width: 200px;
  position: fixed;
  height: 94%;
  overflow: auto;
  padding: 20px 0;
  display: flex;
  flex-direction: column;
  justify-content: space-between;
}

@media (max-width: 768px) {
  .sidebar {
    width: 50vw;
  }
}

.main-content {
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  height: 100%;
}

ul.large-list {
  font-size: 1.2em;
}

.footer-content {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
}

.center-text {
  text-align: center;
}
.scrollable-list {
  max-height: 200px; /* Ajusta este valor según tus necesidades */
  overflow-y: auto;
}
</style>