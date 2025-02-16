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

  const deleteTodo = (id) => {
    deleteTodoApi(auth.username, id)
      .then(() => {
        retrieveAllTodosForUsernameApi(auth.username)
          .then((res) => {
            setTodoList(res.data);
          })
          .catch(e => console.error(e));
      })
      .catch(e => console.error(e));
  }

  const updateTodo = (id) => {
    navigate(`/todo/${id}`);
  }

  const addTodo = () => {
    navigate("/todo/-1");
  }

  return (
    <div className="container">
      <h1>Todo List</h1>
      <table className="table">
        <thead>
          <tr>
            <th>Description</th>
            <th>Target Date</th>
            <th>Done</th>
            <th>Delete</th>
            <th>Update</th>
          </tr>
        </thead>
        <tbody>
          {todoList.map(todo => (
            <tr key={todo.id}>
              <td>{todo.description}</td>
              <td>{todo.targetDate}</td>
              <td>{todo.done ? "true" : "false"}</td>
              <td><button className="btn btn-warning" onClick={() => deleteTodo(todo.id)}>Delete</button></td>
              <td>
                <button className="btn btn-success" onClick={() => updateTodo(todo.id)}>Update</button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>

      <button className="btn btn-success" onClick={addTodo}>Add</button>
    </div>
  );
}

export default TodoListComponent;