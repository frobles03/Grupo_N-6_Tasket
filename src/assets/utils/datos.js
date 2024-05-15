const fs = require('fs');
const path = require('path');

// Ruta al archivo datos.json
const datosFilePath = path.resolve(__dirname, '../../public/datos.json');

const datos = {
    grupos: [],
    usuarios: [],
    tareas: [],
    canjes: []
};

function guardarDatos() {
    fs.writeFile(datosFilePath, JSON.stringify(datos, null, 2), 'utf8', (err) => {
        if (err) {
            console.error(err);
            return;
        }
        console.log('Datos guardados correctamente');
    });
}

function cargarDatos() {
    fs.readFile(datosFilePath, 'utf8', (err, data) => {
        if (err) {
            console.error(err);
            return;
        }
        Object.assign(datos, JSON.parse(data));
        console.log('Datos cargados correctamente');
    });
}

function crearUsuario(nombreUsuario, contraseña, email) {
    const nuevoUsuario = {
        id: datos.usuarios.length + 1,
        nombreUsuario,
        contraseña,
        email,
        puntaje: {}
    };
    datos.usuarios.push(nuevoUsuario);
    guardarDatos();
    return nuevoUsuario;
}

function crearGrupo(nombreGrupo, creadorId) {
    const nuevoGrupo = {
        id: datos.grupos.length + 1,
        nombre: nombreGrupo,
        creadorId,
        usuarios: [{ id: creadorId, rol: 'creador', puntaje: 0 }],
        tareas: [],
        canjes: []
    };
    datos.grupos.push(nuevoGrupo);
    guardarDatos();
    return nuevoGrupo;
}

function añadirUsuarioAGrupo(usuarioId, grupoId, rol = 'normal') {
    if (datos.usuarios[usuarioId - 1]) { // Comprobar si el usuario existe
        if (!datos.usuarios[usuarioId - 1].grupos) { // Comprobar si el usuario tiene la propiedad grupos definida
            datos.usuarios[usuarioId - 1].grupos = []; // Si no está definida, inicializarla como un array vacío
        }
        datos.usuarios[usuarioId - 1].grupos.push(grupoId);
        datos.usuarios[usuarioId - 1].puntaje[grupoId] = 0; // Inicializar puntaje de usuario para este grupo
    }
    datos.grupos[grupoId - 1].usuarios.push({ id: usuarioId, rol, puntaje: 0 }); // Inicializar puntaje de usuario para este grupo
    guardarDatos();
}

function crearTarea(nombreTarea, descripcion, puntos, grupoId) {
    const nuevaTarea = {
        id: datos.tareas.length + 1,
        nombre: nombreTarea,
        descripcion,
        puntos,
        estado: 'pendiente'
    };
    datos.tareas.push(nuevaTarea);
    datos.grupos[grupoId - 1].tareas.push(nuevaTarea);
    guardarDatos();
    return nuevaTarea;
}

function editarTarea(idTarea, nuevoNombre, nuevaDescripcion, nuevosPuntos) {
    const tarea = datos.tareas.find(t => t.id === idTarea);
    if (tarea) {
        tarea.nombre = nuevoNombre;
        tarea.descripcion = nuevaDescripcion;
        tarea.puntos = nuevosPuntos;
        guardarDatos();
        return tarea;
    } else {
        console.error('La tarea no existe.');
        return null;
    }
}

function crearCanje(nombreCanje, descripcion, puntosNecesarios, grupoId) {
    const nuevoCanje = {
        id: datos.canjes.length + 1,
        nombre: nombreCanje,
        descripcion,
        puntosNecesarios
    };
    datos.canjes.push(nuevoCanje);
    datos.grupos[grupoId - 1].canjes.push(nuevoCanje);
    guardarDatos();
    return nuevoCanje;
}

function editarCanje(idCanje, nuevoNombre, nuevaDescripcion, nuevosPuntos) {
    const canje = datos.canjes.find(c => c.id === idCanje);
    if (canje) {
        canje.nombre = nuevoNombre;
        canje.descripcion = nuevaDescripcion;
        canje.puntosNecesarios = nuevosPuntos;
        guardarDatos();
        return canje;
    } else {
        console.error('El canje no existe.');
        return null;
    }
}

function añadirPuntaje(usuarioId, grupoId, cantidad) {
    if (datos.usuarios[usuarioId - 1].puntaje.hasOwnProperty(grupoId)) {
        datos.usuarios[usuarioId - 1].puntaje[grupoId] += cantidad;
        guardarDatos();
    } else {
        console.error('El usuario no pertenece a este grupo.');
    }
}

function eliminarPuntaje(usuarioId, grupoId, cantidad) {
    if (datos.usuarios[usuarioId - 1].puntaje.hasOwnProperty(grupoId)) {
        if (datos.usuarios[usuarioId - 1].puntaje[grupoId] >= cantidad) {
            datos.usuarios[usuarioId - 1].puntaje[grupoId] -= cantidad;
            guardarDatos();
        } else {
            console.error('El usuario no tiene suficiente puntaje en este grupo.');
        }
    } else {
        console.error('El usuario no pertenece a este grupo.');
    }
}

module.exports = {
    cargarDatos,
    crearUsuario,
    crearGrupo,
    añadirUsuarioAGrupo,
    crearTarea,
    editarTarea,
    crearCanje,
    editarCanje,
    añadirPuntaje,
    eliminarPuntaje
};
