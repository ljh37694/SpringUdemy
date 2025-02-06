import { useState } from "react";
import { BrowserRouter, Route, Routes, useNavigate } from "react-router-dom";

function TodoApp() {
  return (
    <div className="todo-app">
      <h1>Todo App</h1>
      
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<LoginComponent />} />
          <Route path="/login" element={<LoginComponent />} />
          <Route path="/welcome" element={<WelcomeComponent />} />
        </Routes>
      </BrowserRouter>
    </div>
  );
}

function LoginComponent() {
  const [username, setUsername] = useState("Lee");
  const [password, setPassword] = useState("");

  const navigate = useNavigate();

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

        <button onClick={() => navigate('/welcome')}>login</button>
      </div>
    </div>
  );
}

function WelcomeComponent() {
  return (
    <div className="welcome-comp">
      <h2>Welcome Lee</h2>
    </div>
  );
}

export default TodoApp;