import { useState } from "react";
import PropTypes from 'prop-types'

export const CounterApp = ({value}) => {

    //Desestructruracion del primer valor
    const [counter, setCounter] = useState( value )

    const handleApp = () => {
        //setCounter( counter + 1 );
        // c => es el valor actual de counter
        setCounter( (c) => c + 1);
    }
    const handleReset = () => {
        setCounter(value);
    }
    const handleSubtract = () => {
        setCounter( (c) => c - 1 );
    }
    
  return (
    <>
        <h1>CounterApp</h1>
        <h2>{ counter }</h2>

        <button onClick={ handleApp }> +1 </button>
        <button onClick={ handleSubtract }> -1 </button>
        <button onClick={ handleReset }> Reset </button>
    </>
  )
}
 
CounterApp.propTypes = {
    value: PropTypes.number.isRequired
}

CounterApp.defaultProps = {
    value: 0
}

