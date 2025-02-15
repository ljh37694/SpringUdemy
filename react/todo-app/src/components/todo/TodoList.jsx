import { useEffect, useState } from "react";
import { deleteTodoApi, retrieveAllTodosForUsernameApi } from "./api/TodoApiService";
import { useAuth } from "./security/AuthContext";
import { useNavigate } from "react-router-dom";

function TodoListComponent() {
  const [todoList, setTodoList] = useState([]);
  const { auth } = useAuth();

  const navigate = useNavigate();

  useEffect(() => {
    retrieveAllTodosForUsernameApi(auth.username)
      .then((res) => {
        setTodoList(res.data);
      })
      .catch(e => console.error(e));
  }, [auth]);

  return (
    <div className="container">
      <h1>Todo List</h1>
      <table className="table">
        <thead>
          <tr>
            <th>Description</th>
            <th>Done</th>
            <th>Target Date</th>
            <th>Delete</th>
            <th>Update</th>
          </tr>
        </thead>
        <tbody>
          {todoList.map(todo => (
            <tr key={todo.id}>
              <td>{todo.description}</td>
              <td>{todo.done}</td>
              <td>{todo.targetDate}</td>
              <td><button className="btn btn-warning" onClick={() => {
                deleteTodoApi(auth.username, todo.id)
                  .then(() => {
                    retrieveAllTodosForUsernameApi(auth.username)
                      .then((res) => {
                        setTodoList(res.data);
                      })
                      .catch(e => console.error(e));
                  })
                  .catch(e => console.error(e));
              }}>Delete</button></td>
              <td>
                <button className="btn btn-success" onClick={() => {
                  navigate(`/todo/${todo.id}`);
                }}>Update</button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default TodoListComponent;