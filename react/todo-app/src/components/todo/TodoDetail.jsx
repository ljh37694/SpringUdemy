import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import { useAuth } from "./security/AuthContext";
import { retrieveTodoApi } from "./api/TodoApiService";

function TodoDetail() {
  const [todo, setTodo] = useState({});
  const { id } = useParams();
  const { auth } = useAuth();

  const [description, setDescription] = useState("");
  const [targetDate, setTargetDate] = useState("");

  useEffect(() => {
    retrieveTodoApi(auth.username, id)
      .then((res) => {
        setTodo(res.data);

        setDescription(res.data.description);
        setTargetDate(res.data.targetDate);
      })
      .catch(e => console.error(e));
  }, [auth, id]);

  return (
    <div>
      <h1>Todo Detail</h1>
      <div>
        <label>Description: </label>
        <span>{description}</span>
      </div>
      <div>
        <label>Done: </label>
        <span>{todo.done}</span>
      </div>
      <div>
        <label>Target Date: </label>
        <span>{targetDate}</span>
      </div>
    </div>
  );
}

export default TodoDetail;