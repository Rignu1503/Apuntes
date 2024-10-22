

export const URL = "http://localhost:8080/api/v1/events"
const container = document.getElementById("container")

getAll()




function getAll(){

    fetch(URL)
    .then(response => response.json())
    .then(data => {
        let html = ""; 

        
        data.forEach(event => {
            html += `
            <div class="list" >
                <h3 class="nombre">${event.name}</h3>
                <p class="ubicacion">${event.ubication}</p>
                <p class="fecha">${event.date}</p>
                <p class="capacidad">${event.capacity}</p>
                <div class="container_button">
                    <button data-id=${event.id}>
                        Editar
                    </button>
                    <button data-id=${event.id}>
                        Eliminar
                    </button>
                </div>
            </div>`;
        });

        
        container.innerHTML = html;
    })
    .catch(error => {
        console.error('Error al obtener los datos:', error);
    });

}

