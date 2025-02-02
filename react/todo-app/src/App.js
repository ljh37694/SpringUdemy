import { Component } from 'react';
import './App.css';

function App() {
  return (
    <div className="App">
      <FunctionComponent />
      <hr></hr>
      <ClassComponent />
    </div>
  );
}

function FunctionComponent() {
  return (
    <div className="function-component">
      <p>Function Component</p>
    </div>
  );
}

class ClassComponent extends Component {
  render() {
    return (
      <div className="class-component">
        <p>Class Component</p>
      </div>
    );
  }
}

export default App;
