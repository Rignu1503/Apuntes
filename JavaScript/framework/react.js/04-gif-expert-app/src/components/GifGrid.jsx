import { GifGridItem } from "./GifGridItem";
import { useFetchGifs } from "../hooks/useFetchGifs";

export const GifGrid = ({ category }) => {

  const { images, loading } = useFetchGifs ( category );
  console.log(images, loading);

  return (
  <>

      <h3>{ category }</h3>
      {
        loading && ( <p>Cargando...</p> ) 
      }

      <div className="card-grid">
        {
          images.map((image) => (
            <GifGridItem 
              key={image.id}
              { ...image }
            />
          ))
        }
      </div>

      
  </>
  )
}
