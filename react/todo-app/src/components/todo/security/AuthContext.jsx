import { createContext, useContext, useState } from "react";
import { excuteBaiscAuthenticationService } from "../api/HelloWorldApiService";
import { apiClient } from "../api/ApiClient";

export const AuthContext = createContext();

export const useAuth = () => useContext(AuthContext);

export default function AuthProvider({ children }) {
  const [auth, setAuth] = useState({
    username: "Lee",
    password: "password",
    isLoggedIn: false
  });

  const [token, setToken] = useState(null);

  const login = async (username, password) => {
    const token = "Basic " + btoa(username + ":" + password);

    try {
      const response = await excuteBaiscAuthenticationService(token);

      if (response.status === 200) {
        setAuth({ username, password, isLoggedIn: true });
        setToken(token);

        apiClient.interceptors.request.use((config) => {
          config.headers.Authorization = token;

          return config;
        });

        return true;
      } else {
        logout();

        return false;
      }
    } catch (e) {
      console.error(e);
      logout();

      return false;
    }
  }

  const logout = () => { 
    setAuth({ username: "", password: "", isLoggedIn: false });
    setToken(null);
  }

  return (
    <AuthContext.Provider value={{ auth, login, logout, token }}>
      {children}
    </AuthContext.Provider>
  );
}