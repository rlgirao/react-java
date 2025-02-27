import axios from 'axios';
import { VITE_APP_API } from '../constants/env';
const hostBackend = VITE_APP_API;

export const api = axios.create({
  baseURL: hostBackend,
  headers: {
    'Content-Type': 'application/json',
  },
});

api.interceptors.request.use((config) => {
  // config.headers.teste = 'InfoHeaders';
  return config;
});

