import { createContext, useContext, useState } from "react";

export const AuthContext = createContext();

export const useAuth = () => useContext(AuthContext);

export default function AuthProvider({ children }) {
  const [auth, setAuth] = useState({
    username: "Lee",
    password: "password",
    isLoggedIn: false
  });

  const login = (username, password) => {
    if (username === "Lee" && password === "password") {
      setAuth({ username, password, isLoggedIn: true });

      return true;
    }

    else {
      setAuth({ username: "", password: "", isLoggedIn: false });

      return false;
    }
  }

  const logout = () => { 
    setAuth({ username: "", password: "", isLoggedIn: false });
  }

  return (
    <AuthContext.Provider value={{ auth, login, logout }}>
      {children}
    </AuthContext.Provider>
  );
}