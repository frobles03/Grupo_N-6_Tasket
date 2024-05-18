<template>
  <MiNavBar />

  <div class="content">
    <nav>
      <h3>instrucciones:</h3>
      <h4>Si desea modificar el nombre de una tarea o de la lista de quehaceres, haga clic en ella. Seguido de esto
        aparecerá un evento "Dom" para modificar el texto seleccionado.</h4>
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
          <div class="item drag-el" v-for="item in board.items" :key="item.id">
            <div class="task-header">
              <span @click="renameTask(item)">{{ item.title }}</span>
              <button @click="removeTask(board, item)">Eliminar</button>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
 
</template>

<script setup>
import { ref, reactive } from "vue";
import { useRouter } from 'vue-router';
import MiNavBar from './navBar.vue'

const boards = reactive([
  {
    id: "1",
    name: "Personal",
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

const router = useRouter();

const redirectToLogin = () => {
  router.push('/login');
};
const redirectToProfile = () => {
  router.push('/profile');
};
</script>

<style scoped>
.boards {
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
}

.board {
  border: 1px solid #ccc;
  padding: 20px;
  background-color: #f5f5f5;
  margin: 20px;
  border-radius: 5px;
}

.content {
  flex-grow: 1;
  overflow: auto;
  margin-left: 270px;
  position: absolute;
  top: 0;
  left: 0;
}

@media (max-width: 768px) {
  .content {
    margin-left: 100px;
  }
}
</style>