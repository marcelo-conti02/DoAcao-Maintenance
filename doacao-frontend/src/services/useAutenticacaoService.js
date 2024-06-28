import axios from "axios";
import { useMemo } from "react";
import { strings } from "../assets/config"

/**
 * BASE URLS of the service used on UserService.
 */
const BASE_AUTH = "user/";

/**
 * URLS of the service used on UserService.
 */
const RESOURCES = {
  LOGIN: BASE_AUTH + 'login',
};

/**
 * Params used on services methods.
 */
const PARAMS = {
  LOGIN: 'login',
  PASSWORD: 'password'
};

const { errors } = strings
const { genericError } = errors

const useAutenticacaoService = () => {
  const login = async (login, password) => {
    return axios
      .post(RESOURCES.LOGIN, {
        [PARAMS.LOGIN]: login,
        [PARAMS.PASSWORD]: password,
      })
      .then(result => {
        return result;
      })
      .catch(error => {
        console.log(error);
        return genericError;
      });
  }

  return useMemo(() => ({
    login
  }), [])
}

export { useAutenticacaoService };
