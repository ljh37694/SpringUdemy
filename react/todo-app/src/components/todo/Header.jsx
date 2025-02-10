import { Link } from "react-router-dom";

function HeaderComponent() {
  return (
    <div className="header border-bottom border-secondary navbar-expand">
      <nav className="navbar navbar-expand-lg navbar-light bg-light p-2 h-100 d-flex">
        <a href="https://google.com" className="navbar-brand">Todo</a>
        <ul className="navbar-nav flex-row justify-content-start collapse navbar-collapse">
          <li className="nav-item me-2">
            <Link to="/welcome/Lee" className="nav-link">Home</Link>
          </li>

          <li className="nav-item me-2">
            <Link to="/todos" className="nav-link">Todo</Link>
          </li>
        </ul>

        <ul className="navbar-nav flex-row justify-content-end">
          <li className="nav-item me-2">
            <Link to="/login" className="nav-link">Login</Link>
          </li>
          <li className="nav-item me-2">
            <Link to="/logout" className="nav-link">Logout</Link>
          </li>
        </ul>
      </nav>
    </div>
  );
}

export default HeaderComponent;