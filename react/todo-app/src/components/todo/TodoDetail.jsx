import { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";
import { useAuth } from "./security/AuthContext";
import { retrieveTodoApi, updateTodoApi } from "./api/TodoApiService";
import { ErrorMessage, Field, Form, Formik } from "formik";

function TodoDetail() {
  const [todo, setTodo] = useState({});
  const { id } = useParams();
  const { auth } = useAuth();

  const [description, setDescription] = useState("");
  const [targetDate, setTargetDate] = useState("");

  const navigate = useNavigate();

  useEffect(() => {
    retrieveTodoApi(auth.username, id)
      .then((res) => {
        setTodo(res.data);

        setDescription(res.data.description);
        setTargetDate(res.data.targetDate);
      })
      .catch(e => console.error(e));
  }, [auth, id]);

  const onSubmit = (values) => {
    updateTodoApi(auth.username, id, { ...todo, ...values })
      .then(() => {
        navigate("/todos");
      })
      .catch(e => console.error(e));

    console.log("values: ", values);
  }

  const validate = (values) => {
    let errors = {};

    if (!values.description) {
      errors.description = "Enter a description";
    } else if (values.description.length < 5) {
      errors.description = "Enter at least 5 characters in the description";
    }

    if (!values.targetDate) {
      errors.targetDate = "Enter a target date";
    }

    return errors;
  }

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
      <Formik
        initialValues={{ description, targetDate }}
        onSubmit={onSubmit}
        enableReinitialize={true}
        validate={validate}
        validateOnChange={false}
        validateOnBlur={false}
      >
        {
          (props) => (
            <Form>
              <ErrorMessage
                name="description"
                component="div"
                className="alert alert-warning"
              />

              <ErrorMessage
                name="targetDate"
                component="div"
                className="alert alert-warning"
              />

              <fieldset>
                <label>Description: </label>
                <Field type="text" name="description" />

                <label>Target Date: </label>
                <Field type="date" name="targetDate" />

                <button type="submit" className="btn btn-success">Save</button>
              </fieldset>
            </Form>
          )
        }
      </Formik>
    </div>
  );
}

export default TodoDetail;