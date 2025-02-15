import { BrowserRouter, Route, Routes } from "react-router-dom";
import LoginComponent from "./Login";
import LogoutComponent from "./Logout";
import WelcomeComponent from "./Welcome";
import TodoListComponent from "./TodoList";
import FooterComponent from "./Footer";
import HeaderComponent from "./Header";
import ErrorComponent from "./Error";
import AuthProvider from "./security/AuthContext";
import AuthenticatedRoute from "./security/AuthenticatedRoute";
import TodoDetail from "./TodoDetail";

function TodoApp() {
  return (
    <div className="todo-app">
      <AuthProvider>
        <BrowserRouter>
          <HeaderComponent />

          <Routes>
            <Route path="/" element={<LoginComponent />} />
            <Route path="/login" element={<LoginComponent />} />

            <Route path="/welcome/:username" element={
              <AuthenticatedRoute>
                <WelcomeComponent />
              </AuthenticatedRoute>
            } />

            <Route path="/todos" element={
              <AuthenticatedRoute>
                <TodoListComponent />
              </AuthenticatedRoute>
            } />

            <Route path="/logout" element={
              <AuthenticatedRoute>
                <LogoutComponent />
              </AuthenticatedRoute>
            } />

            <Route path="/todo/:id" element={
              <AuthenticatedRoute>
                <TodoDetail />
              </AuthenticatedRoute>
            } />
            
            <Route path="*" element={<ErrorComponent />} />
          </Routes>

          <FooterComponent />
        </BrowserRouter>
      </AuthProvider>
    </div>
  );
}

export default TodoApp;