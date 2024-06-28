import axios from "axios";
import { useMemo } from "react";
import { strings } from "../assets/config"

const useServiceService = () => {
    const getServices = async () => {
        return axios
            .get('/service')
            .then(result => {
                return result;
            })
            .catch(error => {
                console.log(error);
                return strings.genericError;
            });
    }
    const createService = async (service) => {
        return axios
            .post('/service', service)
            .then(result => {
                return result;
            })
            .catch(error => {
                console.log(error);
                return strings.genericError;
            });
    }

    return useMemo(() => ({
        getServices,
        createService
    }), [])
}

export { useServiceService }
