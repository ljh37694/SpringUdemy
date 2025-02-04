import { useState } from "react";
import './counter.css';
import CounterButton from "./CounterButton";
import ResetButton from "./ResetButton";

function Counter(props) {
  const [count, setCount] = useState(0);

  const incrementCount = (num) => {
    setCount(count + num);
  }

  return (
    <div className="counter">
      <span className="count">{count}</span>
      <div className="button-container">
        <CounterButton by={-1} addFunction={incrementCount} />
        <CounterButton by={1} addFunction={incrementCount} />
      </div>
      <div className="button-container">
        <CounterButton by={-2} addFunction={incrementCount} />
        <CounterButton by={2} addFunction={incrementCount} />
      </div>
      <div className="button-container">
        <CounterButton by={-3} addFunction={incrementCount} />
        <CounterButton by={3} addFunction={incrementCount} />
      </div>

      <div className="button-container">
        <ResetButton onClick={() => setCount(0)} />
      </div>
    </div>
  );
}

export default Counter;