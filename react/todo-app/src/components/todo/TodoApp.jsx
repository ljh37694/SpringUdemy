import { useState } from "react";

function TodoApp() {
  return (
    <div className="todo-app">
      <h1>Todo App</h1>
      <LoginComp />
    </div>
  );
}

function LoginComp() {
  const [username, setUsername] = useState("Lee");
  const [password, setPassword] = useState("");

  return (
    <div className="login-comp">
      <div>
        <div>
          <label>Username:</label>
          <input type="text" value={username} onChange={(e) => setUsername(e.target.value)} />
        </div>
        <div>
          <label>Password:</label>
          <input type="password" value={password} onChange={(e) => setPassword(e.target.value)} />
        </div>

        <button>login</button>
      </div>
    </div>
  );
}

export default TodoApp;