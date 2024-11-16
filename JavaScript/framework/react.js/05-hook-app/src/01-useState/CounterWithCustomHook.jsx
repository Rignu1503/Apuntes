import React from 'react'
import { useCounter } from '../hooks/useCounter'

export const CounterWithCustomHook = () => {

    const { counter, increment, decrement, reset } = useCounter();

  
  return (

    <>
        <h1>Counter With Hook:  { counter }</h1>

        <hr />

        <button onClick={ (e) => increment(2)} className='btn btn-primary'>+1</button>
        <button onClick={ reset } className='btn btn-primary'>Reset</button>
        <button onClick={ (e) => decrement(2) } className='btn btn-primary'>-1</button>

    </>
  )
}
