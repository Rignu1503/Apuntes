// template string

const nombre = 'Rigoberto';
const apellido = 'Miranda';


// const nombreCompleto = nombre + ' ' + apellido;
const nombreCompleto = ` ${nombre} ${apellido} ${10 + 10}`

console.log(nombreCompleto);

function getSaludo(nombre) {
    return 'Holaaaaaaaa ' + nombre;
}

//Los template string recibe codigo javascript
console.log(`Este es un texto: ${ getSaludo(nombre)}`);
