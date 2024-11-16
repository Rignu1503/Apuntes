import React, { useState } from 'react'

export const useFrom = ( initalForm = {} ) => {
  
    
  const [formState, setFormState] = useState(initalForm);

  const onInputChange = ({ target }) =>{

    const { name, value } = target;
    setFormState({ 
        ...formState, 
        //Cambiar name por el value
        [ name ]: value 
    
    }); 
  }

  const onResetForm = () => {
    setFormState(initalForm);
  }


    return {
        ...formState,
        formState,
        onInputChange,
        onResetForm
    }

}
