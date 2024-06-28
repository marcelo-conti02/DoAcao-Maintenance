import axios from "axios";
import { useMemo } from "react";

const BASE_REQUEST = "order/";

const RESOURCES = {
    CREATE: BASE_REQUEST
}

const useProductRequestService = () => {
    const getProductRequest = async () => {
        return axios
            .post(RESOURCES.CREATE)
            .then(result => {
                return result;
            })
            .catch((response) => {
                console.log(response);
                return;
            });
    }

    return useMemo(() => ({
        getProductRequest
    }), [])
}

export { useProductRequestService }