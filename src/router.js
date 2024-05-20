import { createRouter, createWebHistory } from 'vue-router'
import Perfil from './components/Perfil.vue'
import Todo from './components/Todo.vue' 
import Login from './components/Login.vue'
import Register from './components/Register.vue' 
import TiendaCanje from './components/TiendaCanje.vue'
import Home from './components/Home.vue'
const routes = [
  { path: '/', component: Home },
  { path: '/perfil', component: Perfil },
  { path: '/login', component: Login },
  { path: '/register', component: Register },
  { path: '/TiendaCanje', component: TiendaCanje },

]


const router = createRouter({
  history: createWebHistory(),
  routes,
})

export default router