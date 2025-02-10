import { useState } from "react";
import { useNavigate } from "react-router-dom";
import { useAuth } from "./security/AuthContext";

function LoginComponent() {
  const [username, setUsername] = useState("Lee");
  const [password, setPassword] = useState("");

  const navigate = useNavigate();

  const { setAuth } = useAuth();

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

        <button onClick={() => {
          navigate('/welcome/' + username);
          setAuth({ username, password, isLoggedIn: true });
        }}>login</button>
      </div>
    </div>
  );
}

export default LoginComponent;