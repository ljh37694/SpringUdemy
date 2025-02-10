import { BrowserRouter, Route, Routes } from "react-router-dom";
import LoginComponent from "./Login";
import LogoutComponent from "./Logout";
import WelcomeComponent from "./Welcome";
import TodoListComponent from "./TodoList";
import FooterComponent from "./Footer";
import HeaderComponent from "./Header";
import ErrorComponent from "./Error";

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

export default TodoApp;