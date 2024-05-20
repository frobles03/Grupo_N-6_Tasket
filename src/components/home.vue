<template>
  <div class="container">
    <Sidebar/>

    <div class="content">
      <nav>
        <h1 class="centered-text">"Tasket: Simplifica tus tareas, encesta tus objetivos" </h1>
      </nav>

      <div class="boards-container">
        <div class="boards">
          <div class="board" v-for="board in boards" :key="board.id" :class="{ minimized: board.isMinimized }">
            <div class="board-header" @click="toggleBoard(board.id)">
              <label for="board-name-{{board.id}}">
                <span>{{ board.name }}</span>
              </label>
              <span class="toggle-button">{{ board.isMinimized ? '▶' : '▼' }}</span>
            </div>
            <ul v-show="!board.isMinimized">
              <li v-for="item in board.items" :key="item.id">
                <div class="task-header" @click="openModal(item)">
                  <label for="task-title-{{item.id}}">
                    <span>{{ item.title }}</span>
                  </label>
                </div>
              </li>
              <li v-if="!board.items.length">
                <div class="empty-list-message">No hay tareas asignadas</div>
              </li>
            </ul>
          </div>
        </div>
      </div>
    </div>

    <div v-if="showModal" class="modal">
      <div class="modal-content">
        <span class="close-button" @click="showModal = false">&times;</span>
        <h2>{{ selectedItem.title }}</h2>
        <p>{{ selectedItem.description }}</p>
        <p>Points: {{ selectedItem.points }}</p>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref, reactive } from "vue";
import Sidebar from './Sidebar.vue';
import datosHome from './datosHome.js'; // Importa los datos
import '@/assets/global.css';

let boards = reactive(datosHome); // Asigna los datos a la variable boards
let showModal = ref(false);
let selectedItem = reactive({});

function openModal(item) {
  selectedItem = item;
  showModal.value = true;
}

function toggleBoard(boardId) {
  const board = boards.find(b => b.id === boardId);
  if (board) {
    board.isMinimized = !board.isMinimized;
  }
}

</script>

<style scoped>
.centered-text {
  text-align: center;
}

.empty-list-message {
  color: red;
  text-align: center;
}
.boards {
  display: flex;
  flex-wrap: wrap;
  gap: 10px;
}.board {
  background: #EF9E5F;
  padding: 15px;
  flex: 1 0 200px;
  transition: height 0.3s ease;
  border-radius: 10%;
}

.board ul {
  height: 200px; /* Establece la altura por defecto */
  max-height: 400px; /* Ajusta este valor según tus necesidades */
  overflow-y: auto; /* Agrega un scrollbar cuando el contenido excede la altura máxima */
}

.board.minimized {
  height:10px; /* Reduce el tamaño de la caja minimizada */
}


.board-header {
  display: flex;
  justify-content: space-between;
  cursor: pointer;
}

.toggle-button {
  font-size: 1.2em; /* Reduce el tamaño de la flecha */
  cursor: pointer;
  position: relative;
  top: -0.1em; /* Mueve la flecha un poco hacia arriba */
}
.content {
  padding-left: 250px;
}

.task-header {
  cursor: pointer;
}

.modal {
  position: fixed;
  z-index: 1;
  left: 0;
  top: 0;
  width: 100%;
  height: 100%;
  overflow: auto;
  background-color: rgba(0,0,0,0.4);
}

.modal-content {
  position: relative; /* Añade esta línea */
  background-color: #FFDAB9;
  margin: 15% auto;
  padding: 20px;
  border: 5px solid #888;
  width: 80%;
  border-radius: 20px;
}

.close-button {
  position: absolute;
  top: 5px;
  right: 10px;
  font-size: 1.5em;
  cursor: pointer;
}

/* Media queries para hacer que el diseño sea responsivo */
@media (max-width: 768px) {
  .content {
    padding-left: 0;
  }
}

@media (max-width: 480px) {
  .board {
    flex: 1 0 100%; /* En pantallas pequeñas, las tarjetas ocuparán todo el ancho */
  }
}
</style>