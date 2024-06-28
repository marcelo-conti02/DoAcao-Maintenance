import axios from "axios";
import { useMemo } from "react";

const BASE_PRODUCT_ORDER = '/productOrder'

const RESOURCES = {
    GET_PRODUCTS_IN_ORDER: BASE_PRODUCT_ORDER + '/interest',
    EDIT_ORDER: BASE_PRODUCT_ORDER + '/editProductOrder',
};

const useProductOrderService = () => {
    const productsUpdateStatus = async (status, orderId) => {
        return axios.patch(BASE_PRODUCT_ORDER + "/?" + "status=" + status + "&orderId=" + orderId)
        .then(result => {
            return result;
        })
        .catch(error => {
            console.log(error);
            return error;
        });
    }

    const editProductOrder = async (editRequest) => {
        return axios.post(RESOURCES.EDIT_ORDER, editRequest)
        .then(result => {
            return result;
        })
        .catch(error => {
            console.log(error);
            return error;
        })
    }

    return useMemo(() => ({
        productsUpdateStatus,
        editProductOrder,
    }), [])
}



export { useProductOrderService }