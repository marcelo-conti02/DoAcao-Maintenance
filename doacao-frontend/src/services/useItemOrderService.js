import axios from "axios";
import { useMemo } from "react";
import { strings } from "../assets/config"

const BASE_ITEM_ORDER = '/productOrder/'

const RESOURCES = {
    GET_PRODUCTS_IN_ORDER: BASE_ITEM_ORDER + 'interest/',
};

const useItemOrderService = () => {
    const getItemOrder = async (orderId) => {
        return axios
            .post(orderId, {

            })
            .then(result => {
                return result;
            })
            .catch(error => {
                console.log(error);
                return strings.genericError;
            });
    }

    const getProductsInOrder = async orderId => {
        return axios.get(RESOURCES.GET_PRODUCTS_IN_ORDER + orderId)
            .then(result => {
                return result;
            })
            .catch(error => {
                console.log(error);
                return error;
            });
    }

    return useMemo(() => ({
        getItemOrder,
        getProductsInOrder
    }), [])
}

export { useItemOrderService }