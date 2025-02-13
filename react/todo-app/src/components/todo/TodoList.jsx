import { useEffect, useState } from "react";
import { retrieveAllTodosForUsername } from "./api/TodoApiService";

function TodoListComponent() {
  const [todoList, setTodoList] = useState([]);

  useEffect(() => {
    retrieveAllTodosForUsername("Lee")
      .then((res) => { 
        setTodoList(res.data);
      })
      .catch(e => console.error(e));
  }, []);

  // const todoList = [
  //   { id: 1, description: "Learn React", done: false, targetDate: new Date() },
  // ];

  return (
    <div className="container">
      <h1>Todo List</h1>
      <table className="table">
        <thead>
          <tr>
            <th>Description</th>
            <th>Done</th>
            <th>Target Date</th>
          </tr>
        </thead>
        <tbody>
          {todoList.map(todo => (
            <tr key={todo.id}>
              <td>{todo.description}</td>
              <td>{todo.done.toString()}</td>
              <td>{todo.targetDate.toString()}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default TodoListComponent;