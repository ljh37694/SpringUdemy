import { useState } from "react";
import { useNavigate } from "react-router-dom";

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

export default LoginComponent;