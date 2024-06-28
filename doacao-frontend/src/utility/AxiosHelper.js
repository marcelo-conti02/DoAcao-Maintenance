import axios from 'axios';
import { server } from '../assets/config'

const { url } = server

export const configureAxios = () => {
    axios.defaults.baseURL = url
    axios.defaults.headers.common['Access-Control-Allow-Origin'] = '*'
    axios.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest'
};
