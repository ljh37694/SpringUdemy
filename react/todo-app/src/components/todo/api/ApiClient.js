import axios from "axios";

const API_URL = process.env.REACT_APP_API_URL;

export const apiClient = axios.create({
    baseURL: API_URL,
    withCredentials: true,
    headers: {
        "Content-type": "application/json",
    },
});