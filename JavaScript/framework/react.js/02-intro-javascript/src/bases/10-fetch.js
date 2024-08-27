const apiKey = 'FALVBxT6q0NIU2nq2U6wb2JkSjYfIEXD';

const peticion = fetch(`https://api.giphy.com/v1/gifs/random?api_key=${apiKey}`)

peticion
    .then( resp => resp.json())
    .then( ({ data }) => {

        const { url } = data.images.original.url;
        
        const img = document.createElement('img');
        img.src = url;
        
        document.body.append(img);
        
    })
    .catch( console.warn);
