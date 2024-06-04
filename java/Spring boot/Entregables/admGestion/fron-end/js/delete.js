
import { URL } from './app.js';

// Agrega un evento 'click' a todos los botones dentro de elementos .list
document.addEventListener('click', (event) => {
    // Verifica si el objetivo del evento es un botón de editar o eliminar
    if (event.target.matches('.list button')) {
        // Selecciona el data-id del botón actual
        const dataId = event.target.getAttribute('data-id');
        console.log('Data ID del botón:', dataId);
        
        eliminarEvento(dataId);

        location.reload();

    }
});

function eliminarEvento(dataId) {
    // URL del endpoint para eliminar el evento, reemplaza 'baseUrl' con la dirección de tu servidor
    const url = `${URL}/${dataId}`;

    // Configuración de la solicitud DELETE
    const options = {
        method: 'DELETE',
        headers: {
            'Content-Type': 'application/json' // Puedes ajustar los encabezados según lo que requiera tu servidor
        }
    };

    // Realizar la solicitud DELETE usando fetch
    fetch(url, options)
        .then(response => {
            if (response.ok) {
                // Si la respuesta es satisfactoria, puedes actualizar la interfaz de usuario para reflejar que el evento ha sido eliminado
                console.log("Evento eliminado exitosamente");
                // Aquí podrías actualizar la interfaz de usuario para reflejar el evento eliminado
            } else {
                // Si la respuesta no es satisfactoria, maneja el error adecuadamente
                console.error("Error al eliminar el evento:", response.statusText);
            }
        })
        .catch(error => {
            // Manejar errores de red u otros errores relacionados con la solicitud
            console.error("Error de red:", error);
        });
}
