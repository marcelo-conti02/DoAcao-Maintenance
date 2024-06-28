import axios from "axios";
import { useMemo } from "react";
import { Institution } from "../components/SideMenuInstitution/styles";

const PRODUCT_ORDER_INTEREST = "productOrder/registerInterest/";
const SERVICE_ORDER_INTEREST = "serviceOrder/registerInterest/";
const LIST_PRODUCT_INTEREST = id => "productOrder/interest/" + id + "/details";
const LIST_SERVICE_INTEREST = id => "serviceOrder/interest/" + id + "/details";
const BASE_PRODUCT_ORDER = "/productOrder"

const RESOURCES = {
    INTEREST: BASE_PRODUCT_ORDER + "/interest",
    REGISTER_INTEREST: BASE_PRODUCT_ORDER + "/registerInterest"
}
const useInterestService = () => {
    const createInterestDemonstrationProductOrder = async interest => {
        return axios.post(PRODUCT_ORDER_INTEREST, interest)
            .then(result => result)
            .catch(({ response: { data } }) => {
                console.log(data.error)
                return data
            })
    }

    const createInterestDemonstrationServiceOrder = async interest => {
        return axios.post(SERVICE_ORDER_INTEREST, interest)
            .then(result => result)
            .catch(({ response: { data } }) => {
                console.log(data.error)
                return data
            })
    }

    const getInterestInProductOrder = async orderId => {
        return axios.get(LIST_PRODUCT_INTEREST(orderId))
        .then(result => {
            return result;
        })
        .catch(error => {
            console.log(error);
            return error;
        })
    }

    const getInterestInServiceOrder = async orderId => {
        return axios.get(LIST_SERVICE_INTEREST(orderId))
        .then(result => {
            return result;
        })
        .catch(error => {
            console.log(error);
            return error;
        })
    }

    return useMemo(() => ({
        createInterestDemonstrationProductOrder, createInterestDemonstrationServiceOrder, getInterestInProductOrder, getInterestInServiceOrder
    }), [])

}


export { useInterestService }