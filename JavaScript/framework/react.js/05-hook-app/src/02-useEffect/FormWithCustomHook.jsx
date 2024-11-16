import React, { useEffect, useState } from 'react'
import { useFrom } from '../hooks/useFrom';

export const FormWithCustomHook = () => {

  const { formState, onInputChange, onResetForm, username, email, password } = useFrom({
    username: '',
    email: '',
    password: ''

  });


  // const { username, email, password } = formState;


  useEffect( () =>{
      // console.log('useEffect called');
  }, [formState]);

  useEffect( () =>{
      // console.log('forms state changed');
  }, [formState]);

  useEffect( () =>{
      // console.log('email state changed');
  }, [email]);


  return (
    <>
        <h1>Formulario con custom Hook</h1>
        <hr />

        <input 
            type="text" 
            name="username"
            className='form-control' 
            placeholder='USername'
            value={ username }
            onChange={ onInputChange }
        />

        
        <input 
            type="email" 
            name="email"
            className='form-control mt-2' 
            placeholder='rifo@google.com'
            value={ email }
            onChange={ onInputChange }
        />

        <input 
            type="password" 
            name="password"
            className='form-control mt-2' 
            placeholder='Contraseña'
            value={ password }
            onChange={ onInputChange }
        />

        <button onClick={ onResetForm } className='btn btn-primary mt-2'>Borrar</button>

    </>
  )
}
