import axios from "axios";

const API_URL = process.env.REACT_APP_API_URL;

const apiClient = axios.create({
    baseURL: API_URL,
    withCredentials: true,
    headers: {
        "Content-type": "application/json",
    },
});

export function retrieveHelloWorld() {
    return apiClient.get(`/hello-world`, {
        withCredentials: true,
    });
}

export const retrieveHelloWorldBean = () => {
    return apiClient.get(`/hello-world-bean`, {
        withCredentials: true,
    });
}

export const retrieveHelloWorldPathVariable = (name) => {
    return apiClient.get(`/hello-world/path-variable/${name}`, {
        withCredentials: true,
    });
}