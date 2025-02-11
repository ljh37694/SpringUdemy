import { Navigate } from "react-router-dom";
import { useAuth } from "./AuthContext";

function AuthenticatedRoute({ children }) {
  const { auth } = useAuth();

  return (
    auth.isLoggedIn ? children : <Navigate to="/login" />
  );
}

export default AuthenticatedRoute;