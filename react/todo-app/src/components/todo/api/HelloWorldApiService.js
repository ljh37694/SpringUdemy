import axios from "axios";

const API_URL = process.env.REACT_APP_API_URL;

export function retrieveHelloWorld() {
    return axios.get(`${API_URL}/hello-world`, {
        withCredentials: true,
    });
}

export const retrieveHelloWorldBean = () => {
    return axios.get(`${API_URL}/hello-world-bean`, {
        withCredentials: true,
    });
}