<template>
  <div class="container">
    <Sidebar/>

    <div class="content">
      <nav>
        <h4>Tasket un lugar para organizar tus cosas.. o algo asi  </h4>
      </nav>

      <div class="boards-container">
        <button @click="createNewBoard">Añadir una lista</button>
        <div class="boards">
          <div class="board" v-for="board in boards" :key="board.id">
            <div class="board-header">
              <label for="board-name-{{board.id}}">
                <span @click="renameBoard(board)">{{ board.name }}</span>
              </label>
            </div>
            <div class="input">
              <label for="new-item-{{board.id}}">
                <input id="new-item-{{board.id}}" v-model="board.newItemText" @keydown.enter="handleNewItem(board)" autocomplete="off" />
              </label>
            </div>
            <ul>
              <li v-for="item in board.items" :key="item.id">
                <div class="task-header">
                  <label for="task-title-{{item.id}}">
                    <span @click="renameTask(item)">{{ item.title }}</span>
                  </label>
                  <button @click="removeTask(board, item)">Eliminar</button>
                </div>
              </li>
            </ul>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref, reactive } from "vue";
import Sidebar from './Sidebar.vue';

let boards = reactive([
  {
    id: generateId(),
    name: "board-1",
    items: [{ id: generateId(), title: "Hola a todos" }],
    newItemText: "", 
  },
]);

function handleNewItem(board) {
  const text = board.newItemText.trim();
  if (text !== "") {
    board.items.push({ id: generateId(), title: text });
    board.newItemText = "";
  }
}

function createNewBoard() {
  const name = prompt("Name of board");
  if (name) {
    const board = {
      id: generateId(),
      name: name,
      items: [],
      newItemText: "", 
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

// Función para generar un identificador único
function generateId() {
  return Math.random().toString(36).substr(2, 9);
}

</script>


<style scoped>


.boards {
  display: flex;
  gap: 10px;
}

.board {
  background: #ccc;
  padding: 15px;
}

.board-header {
  cursor: pointer;
}
.content {
  
  padding-left: 250px; /* Ajusta este valor según el ancho de tu barra lateral */
}
.task-header {
  cursor: pointer;
}
</style>