import axios from "axios";
import { useMemo } from "react";
import { strings } from "../assets/config"

const useItemService = () => {
    const getItems = async () => {
        return axios
            .get('/item')  
            .then(result => {
                return result;
            })
            .catch(error => {
                console.log(error);
                return strings.genericError;
            });
    }

    const createItem = async (item) => {
        return axios
            .post('/item', item)
            .then(result => {
                return result;
            })
            .catch(error => {
                console.log(error);
                return strings.genericError;
            });
    }

    return useMemo(() => ({
        getItems,
        createItem
    }), [])
}

export { useItemService }
