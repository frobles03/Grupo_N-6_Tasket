<template>
  <div class="container">
    <Sidebar/>

    <div class="content">
      <nav>
  
        <h4>para agreagar una tarea a la lista deve escribir en el recuadro blanco y luego precionar la tacla "Enter"
        </h4>
      </nav>

      <div class="boards-container">
        <a href="#" @click="createNewBoard">Añadir una lista</a>
        <div class="boards">
          <div class="board" v-for="board in boards" :key="board.id">
            <div class="board-header">
              <span @click="renameBoard(board)">{{ board.name }}</span>
            </div>
            <div class="input">
              <input v-model="board.newItemText" @keydown.enter="handleNewItem(board)" />
            </div>
            <!-- Asegúrate de cerrar todos los divs y otros elementos aquí -->
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref, reactive } from "vue";
import Sidebar from './Sidebar.vue';

const boards = reactive([
  {
    id: "1",
    name: "tablero 1",
    newItemText: "",
    items: [{ id: "1", title: "primera tarea" }],
  },
  {
    id: "2",
    name: "tablero 2",
    newItemText: "",
    items: [{ id: "1", title: "primera tarea" }],
  }
]);

function handleNewItem(board) {
  const text = board.newItemText.trim();
  if (text !== "") {
    board.items.push({ id: Math.random().toString(36).substr(2, 9), title: text });
    board.newItemText = "";
  }
}

function createNewBoard() {
  const name = prompt("nombre del tablero");
  if (name) {
    const board = {
      id: Math.random().toString(36).substr(2, 9),
      name: name,
      newItemText: "",
      items: [],
    };
    boards.push(board);
  }
}

function renameBoard(board) {
  const newName = prompt("Escriba el nuevo nombre del tablero", board.name);
  if (newName && newName !== board.name) {
    board.name = newName;
  }
}

function renameTask(task) {
  const newName = prompt("Escriba el nuevo nombre de la tarea", task.title);
  if (newName && newName !== task.title) {
    task.title = newName;
  }
}

function removeTask(board, task) {
  const index = board.items.indexOf(task);
  if (index !== -1) {
    board.items.splice(index, 1);
  }
}
</script>


<style scoped>
.boards {
  display: flex;
  flex-wrap: wrap;
  justify-content: space-between;
}

.board {
  border: 1px solid #ccc;
  padding: 20px;
  background-color: #f5f5f5;
  margin: 20px;
  border-radius: 5px;
}

.container {
  display: flex;
  height: 100vh;
}


.content {
  flex-grow: 1;
  overflow: auto;
  margin-left: 270px; /* Añadido para compensar el espacio de la barra lateral */
}

@media (max-width: 768px) {
  .sidebar {
    width: 100px;
  }
  .content {
    margin-left: 100px; /* Ajustado para compensar el espacio de la barra lateral en pantallas pequeñas */
  }
}
</style>