import { useState } from "react";
import { useNavigate } from "react-router-dom";
import { useAuth } from "./security/AuthContext";

function LoginComponent() {
  const [username, setUsername] = useState("Lee");
  const [password, setPassword] = useState("");
  const [showError, setShowError] = useState(false);

  const navigate = useNavigate();

  const { login } = useAuth();

  const handleLogin = (e) => {
    e.preventDefault();
    if (login(username, password)) {
      navigate('/welcome/' + username);
    }

    else {
      setShowError(true);
    }
  }

  return (
    <form onSubmit={handleLogin} className="login-comp">
      <div>
        {
          showError &&
            <p className="text-danger">Authentication failed. Please check your credentials.</p>
        }
        <div>
          <label>Username:</label>
          <input type="text" value={username} onChange={(e) => setUsername(e.target.value)} />
        </div>
        <div>
          <label>Password:</label>
          <input type="password" value={password} onChange={(e) => setPassword(e.target.value)} />
        </div>

        <button type="submit">login</button>
      </div>
    </form>
  );
}

export default LoginComponent;