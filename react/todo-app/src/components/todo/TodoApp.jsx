import { BrowserRouter, Route, Routes } from "react-router-dom";
import LoginComponent from "./Login";
import LogoutComponent from "./Logout";
import WelcomeComponent from "./Welcome";
import TodoListComponent from "./TodoList";
import FooterComponent from "./Footer";
import HeaderComponent from "./Header";
import ErrorComponent from "./Error";
import AuthProvider from "./security/AuthContext";

function TodoApp() {
  return (
    <div className="todo-app">
      <AuthProvider>
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
      </AuthProvider>
    </div>
  );
}

export default TodoApp;