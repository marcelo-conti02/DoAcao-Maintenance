import axios from "axios";
import { strings } from "../assets/config"

/**
 * BASE URLS of the service used on UserService.
 */
const BASE_INSTITUTION = "institution/";

/**
 * URLS of the service used on UserService.
 */
const RESOURCES = {
  LOGIN: BASE_INSTITUTION + "login/",
  LOGOUT: BASE_INSTITUTION + "logout/",
  LIST_INSTITUTIONS: BASE_INSTITUTION + "newInstitutions/",
  CREATE_INSTITUTION: BASE_INSTITUTION + "createInstitution/",
  PENDING_INSTITUTIONS: BASE_INSTITUTION + "pendingInstitutions/",
  EDIT_STATUS_INSTITUTION: BASE_INSTITUTION + "solicitation/",
};

/**
 * Params used on services methods.
 */
const PARAMS = {
  ADDRESS: 'address',
  NAME: 'name'
};

const { errors } = strings
const { genericError } = errors

class InstitutionService {

  static createInstitution(address, name) {
    return axios
      .post(RESOURCES.CREATE_INSTITUTION, JSON.stringify({
        [PARAMS.ADDRESS]: address,
        [PARAMS.NAME]: name,
      }))
      .then(result => {
        return result;
      })
      .catch(error => {
        console.log(error);
        return genericError;
      });
  }

  static listInstitutions() {
    return axios
      .get(RESOURCES.LIST_INSTITUTIONS)
      .then(result => {
        return result;
      })
      .catch(error => {
        console.log(error);
        return genericError;
      });
  }

  static async listPendingInstitutions() {
    return axios
      .get(RESOURCES.PENDING_INSTITUTIONS)
      .then(result => {
        return result;
      })
      .catch(error => {
        console.log(error);
        return genericError;
      });
  }

  static async editStatusSolicition(data) {
    return axios
      .post(RESOURCES.EDIT_STATUS_INSTITUTION, data)
      .then(result => {
        return result;
      })
      .catch(error => {
        console.log(error);
        return genericError;
      });
  }
}

export default InstitutionService;
