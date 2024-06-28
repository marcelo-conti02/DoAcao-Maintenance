import axios from "axios";
import { useMemo } from "react";

const BASE_SOLICITATION = "/serviceSolicitation";


const useServiceSolicitationService = () => {
    const serviceSolicitation = async item => {
        return axios.post(BASE_SOLICITATION, item)
            .then(result => result)
            .catch(({ response: { data } }) => {
                console.log(data.error)
                return data
            })
    }

    return useMemo(() => ({
        serviceSolicitation
    }), [])
}

export { useServiceSolicitationService }
