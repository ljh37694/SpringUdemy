import { Link, useParams } from "react-router-dom";

function WelcomeComponent() {
  const { username } = useParams();

  return (
    <div className="welcome-comp">
      <h2>Welcome {username}</h2>

      <p>Manage your todos - <Link to="/todos">Go here</Link></p>
    </div>
  );
}

export default WelcomeComponent;