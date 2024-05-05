<template>
  <div class="container">
    <div class="sidebar">
      <h1>Tasket</h1>
        <nav>
            <ul>
                <li>Inicio</li>
                <li>Notificaciones</li>
                <li>Perfil</li>
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
        <button>Inicar sesión</button>
        <button>Cerrar sesión</button>
      





    </div>

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
  </div>
</template>

<script setup>
import { ref, reactive } from "vue";

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