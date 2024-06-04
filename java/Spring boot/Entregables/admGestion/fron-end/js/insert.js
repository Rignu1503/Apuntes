const URl = "http://localhost:8080/api/v1/events";

const form = document.getElementById("form"); 

form.addEventListener("submit", (e) => {
    e.preventDefault();

    const name = document.getElementById("name").value;
    const date = document.getElementById("date").value;
    const ubication = document.getElementById("ubication").value;
    const capacity = document.getElementById("capacity").value;


    fechaFormateada = new Date(date).toISOString().split('T')[0];

    const formData = {
        name: name,
        date: fechaFormateada,
        ubication: ubication,
        capacity: capacity
    };

    console.log(formData);
    
    fetch(URl, { 
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(formData)
    })
    .then(response => response.json())
    .then(data => {
        console.log('Respuesta del servidor:', data);
    })
    .catch(error => {
        console.error('Error al enviar los datos:', error);
    });

    form.reset();
});