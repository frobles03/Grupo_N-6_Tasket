<template>

    <li v-for="canje in Canjes" :key="canje.id">
        <div class="imagen">
            <img  alt="" src="../assets/imagen.png">
            <p class="nombre">{{ canje.nombre }}</p>
            <p class="descripcion">{{ canje.descripcion }}</p>
            <p class="puntos">Puntos: {{ canje.puntos }}</p>
            <button class="btn" @click="canjear">Canjear</button>
        </div>
    </li>
        
        </template>
        
        <script>
        import axios from 'axios';
    
        export default{
            
    
            data() {
                return {
                    Canjes:[]
    
                }
            },
    
            mounted() {
                this.fetchCanjes();
            },
        
            methods:{
                canjear(){
        
                    alert('El canjeo se ha realizado con exito')
                },
                fetchCanjes(){
                    axios.get('http://localhost:8080/api/canjes')
                    .then(response => {
                        this.Canjes = response.data
                    })
                    .catch(error => console.error('Error:', error)) 
                }
        
            }
        }
        
        </script>
        
        <style>
        
        img{
            width: 25%;
        }
    
        .nombre{
            color: black;
        }
        
        .descripcion{
            color: black;
        }
        
        .puntos{
            color: black;
        }
        
        .imagen{
            border: solid;
            border-radius: 15px;
            box-shadow: 0px 4px 4px 0px rgba(0, 0, 0, 0.25);
            background: #FFF8F1;
            margin: 10px;
        }
        
        .btn{
            border-radius: 25px;
            margin: 10px;
            padding: 5px;
            background: bisque;
            font-family:'Times New Roman', Times, serif
        }
        
        </style>