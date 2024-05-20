<template>
  <div class="container">
    <Sidebar />
    <div class="perfil">
      <div class="perfil-box">
        <h1 class="welcome-text">Perfil</h1>
        <p class="user-info">Nombre: Fernando Robles</p>
        <p class="user-info">Alias: fernando03</p>
        <p class="user-info">Email: f.robles03@ufromail.cl</p>

        <!-- Sección de grupos que administras -->
        <div class="user-info">
          <h2 class="center-text">Grupos que administras</h2>
          <ul>
            <router-link to="/tareas-canjes-admin" class="router-link">Grupo 1</router-link>
          </ul>
        </div>

        <!-- Sección de grupos en los que participas -->
        <div class="user-info">
          <h2 class="center-text">Grupos en los que participas</h2>
          <ul>
            <li>Grupo 1, Grupo 2, Grupo 3, Grupo 4, Grupo 5</li>
          </ul>
        </div>

      </div>
    </div>
  </div>
</template>

<script>
import Sidebar from './Sidebar.vue';
import '@/assets/global.css';


export default {
  name: 'Perfil',
  components: {
    Sidebar
  }
};
</script>

<style scoped>
.perfil {
  flex: 3;
  display: flex;
  justify-content: center;
  align-items: center;
}

.perfil-box {
  border: 1px solid #000;
  padding: 2vh;
  width: 80vw;
  max-width: 600px;
  background-color: #fff;
  border-radius: 10px;
  box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
  margin: auto;
}

.welcome-text {
  background-color: orange;
  padding: 1vh;
  color: #fff;
  border-radius: 5px;
  text-align: center;
}

.user-info {
  margin-top: 1vh;
  font-size: 16px;
}

.router-link {
  color: blue;
  cursor: pointer;
}
</style>
