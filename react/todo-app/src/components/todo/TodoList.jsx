import { useEffect, useState } from "react";
import { deleteTodoApi, retrieveAllTodosForUsernameApi } from "./api/TodoApiService";
import { useAuth } from "./security/AuthContext";

function TodoListComponent() {
  const [todoList, setTodoList] = useState([]);
  const { auth } = useAuth();

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
          </tr>
        </thead>
        <tbody>
          {todoList.map(todo => (
            <tr key={todo.id}>
              <td>{todo.description}</td>
              <td>{todo.done}</td>
              <td>{todo.targetDate}</td>
              <td><button className="btn btn-warning" onClick={() => {
                deleteTodoApi("Lee", todo.id)
                  .then(() => {
                    retrieveAllTodosForUsernameApi(auth.username)
                      .then((res) => {
                        setTodoList(res.data);
                      })
                      .catch(e => console.error(e));
                  })
                  .catch(e => console.error(e));
              }}>Delete</button></td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default TodoListComponent;