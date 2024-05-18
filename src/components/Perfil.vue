<template>
  <div class="container">
    <Sidebar/>
    <div class="perfil">
      <div class="perfil-box">
        <h1 class="welcome-text">Bienvenido a tu perfil</h1>
        <p class="user-info">Nombre de usuario: Fernando Robles</p>
        <p class="user-info">Email: f.robles03@ufromail.cl</p>
      </div>
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
  height: 100vh;
  font-family: Arial, sans-serif;
}

.Sidebar {
  flex: 1;
}

.perfil {
  flex: 3;
  display: flex;
  justify-content: center;
  align-items: center;
}

.perfil-box {
  border: 1px solid #000;
  padding: 20px;
  width: 300px;
  background-color: #fff;
  border-radius: 10px;
  box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
}

.welcome-text {
  background-color: orange;
  padding: 10px;
  color: #fff;
  border-radius: 5px;
  text-align: center;
}

.user-info {
  margin-top: 10px;
  font-size: 16px;
}
</style>

<style>
body {
  background-color: #EDD2AC;
  margin: 0;
  padding: 0;
}
</style>