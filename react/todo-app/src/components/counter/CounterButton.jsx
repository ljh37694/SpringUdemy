function CounterButton(props) {
  const { by, addFunction } = props;

  return (
    <button className="counter-button" onClick={() => addFunction(by)}>{by}</button>
  );
}

export default CounterButton;