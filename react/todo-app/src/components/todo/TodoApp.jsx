import { useState } from "react";
import { BrowserRouter, Link, Route, Routes, useNavigate, useParams } from "react-router-dom";

function TodoApp() {
  return (
    <div className="todo-app">
      <BrowserRouter>
        <HeaderComponent />

        <Routes>
          <Route path="/" element={<LoginComponent />} />
          <Route path="/login" element={<LoginComponent />} />
          <Route path="/logout" element={<LogoutComponent />} />
          <Route path="/welcome/:username" element={<WelcomeComponent />} />
          <Route path="/todos" element={<TodoListComponent />} />

          <Route path="*" element={<ErrorComponent />} />
        </Routes>

        <FooterComponent />
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
    <div className="container">
      <h1>Todo List</h1>
      <table className="table">
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
  );
}

function HeaderComponent() {
  return (
    <div className="header border-bottom border-secondary navbar-expand">
      <nav className="navbar navbar-expand-lg navbar-light bg-light p-2 h-100 d-flex">
        <a href="https://google.com" className="navbar-brand">Todo</a>
        <ul className="navbar-nav flex-row justify-content-start collapse navbar-collapse">
          <li className="nav-item me-2">
            <Link to="/welcome/Lee" className="nav-link">Home</Link>
          </li>

          <li className="nav-item me-2">
            <Link to="/todos" className="nav-link">Todo</Link>
          </li>
        </ul>

        <ul className="navbar-nav flex-row justify-content-end">
          <li className="nav-item me-2">
            <Link to="/login" className="nav-link">Login</Link>
          </li>
          <li className="nav-item me-2">
            <Link to="/logout" className="nav-link">Logout</Link>
          </li>
        </ul>
      </nav>
    </div>
  );
}

function FooterComponent() {
  return (
    <div className="footer">
      <hr />
      <h1>Footer</h1>
    </div>
  );
}

function LogoutComponent() {
  return (
    <div className="logout-comp">
      <h2>You are logged out</h2>
      <div className="container">
        Thank you for using our application.
      </div>
    </div>
  );
}

export default TodoApp;