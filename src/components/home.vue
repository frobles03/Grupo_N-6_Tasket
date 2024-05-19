<template>
  <div class="container">
    <Sidebar/>

    <div class="content">
      <nav>
        <h4>"Tasket: Simplifica tus tareas, encesta tus objetivos" </h4>
      </nav>

      <div class="boards-container">
        <div class="boards">
          <div class="board" v-for="board in boards" :key="board.id">
            <div class="board-header">
              <label for="board-name-{{board.id}}">
                <span>{{ board.name }}</span>
              </label>
            </div>
            <ul>
              <li v-for="item in board.items" :key="item.id">
                <div class="task-header">
                  <label for="task-title-{{item.id}}">
                    <span>{{ item.title }}</span>
                  </label>
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
import datosHome from './datosHome.js'; // Importa los datos

let boards = reactive(datosHome); // Asigna los datos a la variable boards

</script>

<style scoped>
.boards {
  display: flex;
  flex-wrap: wrap;
  gap: 10px;
}

.board {
  background: #ccc;
  padding: 15px;
  flex: 1 0 200px; /* Esto hará que las tarjetas sean responsivas */
}

.board-header {
  cursor: pointer;
}

.content {
  padding-left: 250px;
}

.task-header {
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