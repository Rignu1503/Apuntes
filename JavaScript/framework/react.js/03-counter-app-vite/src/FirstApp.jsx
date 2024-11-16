import PropTypes from 'prop-types'

const newMessage = {
  name: "Rigo",
  age: 20

};



export const FirstApp = ({ title, subTitle, name}) => {

  return (
    <>
    <h1> { title } </h1>
      {/* <code>{ JSON.stringify(newMessage) }</code> */}
      <p>{ subTitle }</p>
    </>
  )
}

FirstApp.propTypes = {
  subTitle: PropTypes.number.isRequired,
  title: PropTypes.string.isRequired,
}

FirstApp.defaultProps = {
  name: 'rigo',
  subTitle: 0,
  title: 'No hay titulo',
  
}