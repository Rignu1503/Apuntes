const mensaje = "Hola mundo"

// ##############################
// MOSTRAR INFORMACION EN CONSOLA
// ##############################

console.log(`console.log= ${mensaje}`);
console.log(`%cconsole.log con estilos= ${mensaje}`, "background-color: #D9CEFF; border-radius: 50px; font-weight: bold; padding-top: 5px; padding-right: 8px; padding-bottom: 5px; padding-left: 8px;");
console.info(`console.info= ${mensaje}`);
console.warn(`console.warn= ${mensaje}`);
console.error(`console.error= ${mensaje}`);
console.debug(`console.debug= ${mensaje}`);

// Mostrar informacion en consola pero agrupada
console.group()
console.log("item 1");
console.log("item 2");
console.groupEnd()

//console.group() se utilizar para abrir el grupo y colocar los item
console.group()
console.log("item 3");
console.log("item 4");
console.groupEnd()
//console.groupEnd() Se utilizar para cerrar el console.group()

// Mostrar informacion en consola pero en tablas
console.table([{
    "nombre": "Lucas",
    "ciudad": "medellin"
},
{
    "nombre": "Mario",
    "ciudad": "medellin"
},
{
    "nombre": "Paola",
    "ciudad": "medellin"
},
])

console.table([true, "uno", 2, "tres", 4, "cinco", false])