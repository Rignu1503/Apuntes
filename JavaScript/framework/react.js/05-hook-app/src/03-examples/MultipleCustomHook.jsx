import React from 'react'
import { useFetch } from '../hooks/useFetch'

export const MultipleCustomHook = (  ) => {

    
    const {} = useCouter();
    const {data, hasError, isLoading } = useFetch('https://pokeapi.co/api/v2/pokemon/2');

  return (
    <>
        <h1>Informacion de Pokemon</h1>
        <hr />

        {
            isLoading && <p>Cargando</p>
        }

        {/* <pre>{JSON.stringify(data, null, 2) }</pre> */}

        <h2>{data?.name}</h2>

        <button 
            className='btn btn-primary'
        >
            anterior
        </button>
        <button
            className='btn btn-primary'
        >
            siguiente
        </button>
        

    </>
  )
}
