import { useState } from "react";
import { BrowserRouter, Link, Route, Routes, useNavigate, useParams } from "react-router-dom";

function TodoApp() {
  return (
    <div className="todo-app">
      <h1>Todo App</h1>
      
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<LoginComponent />} />
          <Route path="/login" element={<LoginComponent />} />
          <Route path="/welcome/:username" element={<WelcomeComponent />} />
          <Route path="/todos" element={<TodoListComponent />} />

          <Route path="*" element={<ErrorComponent />} />
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

        <button onClick={() => navigate('/welcome/' + username)}>login</button>
      </div>
    </div>
  );
}

function WelcomeComponent() {
  const { username } = useParams();

  return (
    <div className="welcome-comp">
      <h2>Welcome {username}</h2>
      
      <p>Manage your todos - <Link to="/todos">Go here</Link></p>
    </div>
  );
}

function ErrorComponent() {
  return (
    <div className="error-comp">
      <h2>404 - Page not found</h2>
    </div>
  );
}

function TodoListComponent() {
  const todoList = [
    { id: 1, description: "Learn React", done: false, targetDate: new Date() },
  ];

  return (
    <div>
      <h1>Todo List</h1>
      <table>
        <thead>
          <tr>
            <th>Description</th>
            <th>Done</th>
            <th>Target Date</th>
          </tr>
        </thead>
        <tbody>
          {todoList.map(todo => (
            <tr key={todo.id}>
              <td>{todo.description}</td>
              <td>{todo.done.toString()}</td>
              <td>{todo.targetDate.toString()}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  )
}

export default TodoApp;