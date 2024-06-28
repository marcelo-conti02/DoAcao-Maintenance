import axios from "axios";
import { useMemo } from "react";

const BASE_SERVICE_ORDER = '/serviceOrder/'

const RESOURCES = {
    GET_SERVICES_IN_ORDER: BASE_SERVICE_ORDER + 'interest/',
    EDIT_ORDER: BASE_SERVICE_ORDER + 'editServiceOrder/',
};

const useServiceOrderService = () => {

    const getServicesInOrder = async orderId => {
        return axios.get(RESOURCES.GET_SERVICES_IN_ORDER + orderId)
            .then(result => {
                return result;
            })
            .catch(error => {
                console.log(error);
                return error;
            });
    }

    const serviceUpdateStatus = async (status, orderId) => {
        return axios.patch(BASE_SERVICE_ORDER + "?" + "status=" + status + "&orderId=" + orderId)
        .then(result => {
            return result;
        })
        .catch(error => {
            console.log(error);
            return error;
        });
    }

    const editServiceOrder = async (editRequest) => {
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
        getServicesInOrder,
        serviceUpdateStatus,
        editServiceOrder,
    }), [])
}

export { useServiceOrderService }