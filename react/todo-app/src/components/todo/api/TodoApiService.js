import axios from "axios";

const API_URL = process.env.REACT_APP_API_URL;

console.log("API_URL: ", API_URL);

const apiClient = axios.create({ 
    baseURL: API_URL, 
    withCredentials: true, 
    headers: {
        "Content-type": "application/json",
    },
});

export const retrieveAllTodosForUsernameApi = (username) => {
    return apiClient.get(`/users/${username}/todo-list`);
}

export const retrieveTodoApi = (username, id) => {
    return apiClient.get(`/users/${username}/todo-list/${id}`);
}

export const deleteTodoApi = (username, id) => {
    return apiClient.delete(`/users/${username}/todo-list/${id}`);
}

export const updateTodoApi = (username, id, todo) => {
    return apiClient.put(`/users/${username}/todo-list/${id}`, todo);
}