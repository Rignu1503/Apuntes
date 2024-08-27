
// Desestructuración
// Asignación Desestructurante
const persona = {
    nombre: 'Tony',
    edad: 45,
    clave: 'Ironman'
};

const { edad:edad2, clave, nombre, } = persona;
 
// console.log( nombre );
// console.log( edad2 );
// console.log( clave );

const userContext = ({ clave, nombre, edad, rango = 'Capitán' }) => {


    // console.log( nombre, edad, rango );
    
    return {
        nombreClave: clave,
        anios: edad,
        latlng: {
            lat: 14.1232,
            lng: -12.3232
        }
    }
}

const avenger = userContext(persona);

const { nombreClave, anios, latlng: { lat, lng } } = userContext( persona );

//console.log(nombreClave, anios);
// console.log( lat, lng );


