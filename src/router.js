import { createRouter, createWebHistory } from 'vue-router'
import Perfil from './components/Perfil.vue'
import Todo from './components/Todo.vue' 
import Login from './components/Login.vue'
import Register from './components/Register.vue' // Asegúrate de que esta ruta sea correcta

const routes = [
    { path: '/', component: Todo },
    { path: '/perfil', component: Perfil },
    { path: '/login', component: Login },
    { path: '/register', component: Register } // Agrega esta línea
]

const router = createRouter({
  history: createWebHistory(),
  routes,
})

export default router