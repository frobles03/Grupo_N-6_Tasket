import { createRouter, createWebHistory } from 'vue-router'
import Perfil from './components/Perfil.vue'
import Todo from './components/Todo.vue' 
import Login from './components/Login.vue'

const routes = [
    { path: '/', component: Todo },
    { path: '/perfil', component: Perfil },
    { path: '/login', component: Login }
]
const router = createRouter({
  history: createWebHistory(),
  routes,
})

export default router