import React, { useEffect, useState } from 'react'

export const SimpleForm = () => {

  const [formState, setFormState] = useState({
    username: '',
    email: ''

  });

  const { username, email } = formState;

  const onInputChange = ({ target }) =>{

    const { name, value } = target;
    setFormState({ 
      ...formState, 
      //Cambiar name por el value
      [ name ]: value 
    
    });
 
  }

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
        <h1>Formulario simple</h1>
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

         {
        (username ===  'rigoberto') && <Message/>
      }

    </>
  )
}
