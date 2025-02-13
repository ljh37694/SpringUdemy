import axios from "axios";
import { Link, useParams } from "react-router-dom";
import { retrieveHelloWorldBean } from "./api/HelloWorldApiService";

function WelcomeComponent() {
  const { username } = useParams();

  const callHelloWorldRestApi = () => {
    axios.get(`${process.env.REACT_APP_API_URL}/hello-world`, {
      withCredentials: true,
    })
      .then((res) => {
        console.log(res.data);
      })
      .catch(e => console.error(e));

    retrieveHelloWorldBean()
      .then((res) => {
        console.log(res.data);
      })
      .catch(e => console.error(e));
  }

  return (
    <div className="welcome-comp">
      <h2>Welcome {username}</h2>

      <p>Manage your todos - <Link to="/todos">Go here</Link></p>

      <button onClick={callHelloWorldRestApi}>Call Hello World</button>
    </div>
  );
}

export default WelcomeComponent;