import axios from "axios";
import { Link, useParams } from "react-router-dom";

function WelcomeComponent() {
  const { username } = useParams();

  return (
    <div className="welcome-comp">
      <h2>Welcome {username}</h2>

      <p>Manage your todos - <Link to="/todos">Go here</Link></p>

      <button onClick={() => {
        axios.get("http://localhost:8080/hello-world", {
          withCredentials: true,
        })
          .then((res) => {
            console.log(res.data);
          })
          .catch(e => console.error(e));
      }}>Call Hello World</button>
    </div>
  );
}

export default WelcomeComponent;