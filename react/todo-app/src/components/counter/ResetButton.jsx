function ResetButton(props) {
  const { onClick } = props;

  return (
    <button className="counter-button reset-button" onClick={onClick}>
      Reset
    </button>
  );
}

export default ResetButton;