import { apiClient } from "./ApiClient";


export const retrieveAllTodosForUsernameApi = (username) => {
    return apiClient.get(`/users/${username}/todo-list`);
}

export const retrieveTodoApi = (username, id) => {
    return apiClient.get(`/users/${username}/todo-list/${id}`);
}

export const addTodoApi = (username, todo) => {
    return apiClient.post(`/users/${username}/todo-list`, todo);
}

export const deleteTodoApi = (username, id) => {
    return apiClient.delete(`/users/${username}/todo-list/${id}`);
}

export const updateTodoApi = (username, id, todo) => {
    return apiClient.put(`/users/${username}/todo-list/${id}`, todo);
}