
const getImage = async() => {

    try {

    const apiKey = 'FALVBxT6q0NIU2nq2U6wb2JkSjYfIEXD';
    const resp = await fetch(`https://api.giphy.com/v1/gifs/random?api_key=${apiKey}`)
    const { data } = await resp.json();

    console.log(data);
    
    const { url } = data.images.original.url;
        
    const img = document.createElement('img');
    img.src = url;    
    document.body.append(img);
        
    } catch (error) {
        //Manejo del error
        console.error(error);
    }

}

getImage();
