import axios from "axios";
import { useMemo } from "react";

/**
 * BASE URLS of the service used on UserService.
 */
const BASE_INSTITUTION = "institution/";

/**
 * URLS of the service used on UserService.
 */
const RESOURCES = {
  CREATE: BASE_INSTITUTION,
  INST_INFO: BASE_INSTITUTION,
  CITIES: BASE_INSTITUTION + "cities"
};

const useInstitutionService = () => {
  const signup = async (data) => {
    return axios
      .post(RESOURCES.CREATE, data)
      .then(result => {
        return result;
      })
      .catch(({ response: { data } }) => {
        console.log(data.error);
        return data;
      });
  }

  const getInstitutionInfo = async institutionId => {
    return axios.get(RESOURCES.INST_INFO + institutionId)
      .then(result => {
        return result;
      })
      .catch(error => {
        console.log(error);
        return error;
      })
  }

  const getCities = async () => {
    return axios.get(RESOURCES.CITIES)
      .then(result => { return result.data })
      .catch(error => {
        console.log(error);
        return error;
      })
  }

  return useMemo(() => ({
    signup,
    getInstitutionInfo,
    getCities,
  }), [])
}

export { useInstitutionService }
