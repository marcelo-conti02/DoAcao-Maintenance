import axios from "axios";
import { useMemo } from "react";

/**
 * BASE URLS of the service used on UserService.
 */
const BASE_INSTITUTION = "urgent/";

/**
 * URLS of the service used on UserService.
 */
const RESOURCES = {
  CREATE: BASE_INSTITUTION,
};

const useUrgentOrders = () => {
  const getPendingUrgentOrders = async () => {
    return axios
      .get(BASE_INSTITUTION)
      .then(result => {
        return result;
      })
      .catch(({ response: { data } }) => {
        console.log(data.error);
        return data;
      });
  }

  return useMemo(() => ({
    getPendingUrgentOrders
  }), [])
}

export { useUrgentOrders }
