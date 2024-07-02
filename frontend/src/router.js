import { createRouter, createWebHistory } from 'vue-router'
import Perfil from './components/user/Perfil.vue'
import TareasCanjesAdmin from './components/admin/TareasCanjesAdmin.vue'
import Login from './components/auth/Login.vue'
import Register from './components/auth/Register.vue'
import TiendaCanje from './components/user/TiendaCanje.vue'
import Home from './components/home.vue'
import AdminUsuarios from './components/admin/AdminUsuarios.vue'
import AdminEstadisticas from './components/admin/AdminEstadisticas.vue'
import AdminRoles from './components/admin/AdminRoles.vue'
import AdminReportes from './components/admin/AdminReportes.vue'

const routes = [
  { path: '/', component: Home },
  { path: '/perfil', component: Perfil },
  { path: '/login', component: Login },
  { path: '/tareas-canjes-admin', component: TareasCanjesAdmin },
  { path: '/register', component: Register },
  { path: '/tienda-canje', component: TiendaCanje },
  { path: '/admin-usuarios', component: AdminUsuarios },
  { path: '/admin-estadisticas', component: AdminEstadisticas },
  { path: '/admin-roles', component: AdminRoles },
  { path: '/admin-reportes', component: AdminReportes }
]

const router = createRouter({
  history: createWebHistory(),
  routes,
})

export default router
