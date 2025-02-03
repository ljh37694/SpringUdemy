import { useState } from "react";

function Counter(props) {
  const [count, setCount] = useState(0);

  const incrementCount = () => {
    setCount(count + 1);
  }

  const decreaseCount = () => {
    if (count !== 0) {
      setCount(count - 1);
    }
  }

  return (
    <div className="counter">
      <span className="count">{count}</span>
      <button className="counter-button" onClick={incrementCount}>+</button>
      <button className="counter-button" onClick={decreaseCount}>-</button>
    </div>
  );
}

export default Counter;