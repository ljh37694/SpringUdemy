import { apiClient } from './ApiClient';

export function retrieveHelloWorld() {
    return apiClient.get(`/hello-world`);
}

export const retrieveHelloWorldBean = () => {
    return apiClient.get(`/hello-world-bean`);
}

export const retrieveHelloWorldPathVariable = (name) => {
    return apiClient.get(`/hello-world/path-variable/${name}`);
}

export const excuteBaiscAuthenticationService = (token) => {
    return apiClient.get(`/basicauth`, {
        headers: {
            'Authorization': token,
        },
    });
}