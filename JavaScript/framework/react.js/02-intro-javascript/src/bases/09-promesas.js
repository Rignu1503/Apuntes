import { getHeroeById } from './bases/08-import-export';
import { heroes } from './data/heroes';

/**
const promesa = new Promise( (resolve, reject) => {

    setTimeout(() => {
       const p1 = getHeroeById(6);

       //Envia al then
        resolve(p1);
        reject('No se pudo encoontrar el heroe')
        
    }, 2000);
});

promesa.then( (heroe) => {
    console.log('heroe', heroe);
    
} )
.catch( err => console.log(err));

 */

const getHeroeByIdAsync = (id) => {

    return new Promise( (resolve, reject) => {

        setTimeout(() => {

            const p1 = getHeroeById(id);
            if (p1){

                //Envia al then
                resolve(p1);
            }else{

                //Envia al catch
                reject('No se pudo encoontrar el heroe')
            }

        }, 2000);
    });
    

}

getHeroeByIdAsync(4)
    .then( heroe => console.log('Heroe', heroe))
    .catch(err => console.log( err  )) 


getHeroeByIdAsync(6)
    .then( console.log)
    .catch(console.warn)
    