<template>
  <div></div>
       <div class="container">
   <div class="sidebar">
     <h1>Tasket</h1>
       <nav>
           <ul>
               <li @click="redirectTo('inicio')">Inicio</li>
               <li @click="redirectTo('notificaciones')">Notificaciones</li>
               <li @click="redirectTo('perfil')">Perfil</li>
               <li @click="redirectTo('configuracion')">Configuración</li>
               <li @click="redirectTo('tienda')">Tienda de canje</li>
           </ul>
       </nav>
       <div>
           <h2>Grupos</h2>
           
           <nav>
               <ul>
                   <li @click="redirectTo('personal')">Personal</li>
                   <li @click="redirectTo('grupo1')">Grupo 1</li>
                   <li @click="redirectTo('grupo2')">Grupo 2</li>
                   <li @click="redirectTo('grupo3')">Grupo 3</li>
               </ul>
           </nav>
       </div>
       <button @click="redirectTo('login')">Iniciar sesión</button>
       <button @click="redirectTo('profile')">Cerrar sesión</button>
   </div>
   </div>
</template>


<script>
import { useRouter } from 'vue-router';
import '@/assets/global.css';

export default {
 name: 'NavBar',
 setup() {
   const router = useRouter();

   const redirectTo = (routeName) => {
     router.push(`/${routeName}`);
   };

   return {
     redirectTo
   };
 }
}
</script>
<style scoped>
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

@media (max-width: 768px) {
 .sidebar {
   width: 100px;
 }
}
</style>