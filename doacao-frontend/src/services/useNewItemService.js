import axios from "axios";
import { useMemo } from "react";
import { strings } from "../assets/config"

/**
 * BASE URLS of the service used on UserService.
 */
const BASE_INSTITUTION = "/itemSolicitation";

/**
 * URLS of the service used on UserService.
 */
const RESOURCES = {
    PENDING_ITEM: "/itemSolicitation",
    PENDING_SERVICE: "/serviceSolicitation",
    EDIT_ITEM_STATUS: "/itemSolicitation/editStatus",
    EDIT_SERVICE_STATUS: "/serviceSolicitation/editStatus"
};

const useNewItemSevice = () => {
  const getPendingNewItem= async () => {
    return axios
      .get(RESOURCES.PENDING_ITEM)
      .then(result => {
        return result;
      })
      .catch(({ response: { data } }) => {
        console.log(data.error);
        return data;
      });
  }

  const getPendingNewService= async () => {
    return axios
      .get(RESOURCES.PENDING_SERVICE)
      .then(result => {
        return result;
      })
      .catch(({ response: { data } }) => {
        console.log(data.error);
        return data;
      });
  }

  const editItemStatus = async (item) => {
    return axios
        .post(RESOURCES.EDIT_ITEM_STATUS, item)
        .then(result => {
            return result;
        })
        .catch(error => {
            console.log(error);
            return strings.genericError;
        });
  }

  const editServiceStatus = async (service) => {
    return axios
        .post(RESOURCES.EDIT_SERVICE_STATUS, service)
        .then(result => {
            return result;
        })
        .catch(error => {
            console.log(error);
            return strings.genericError;
        });
  }

  return useMemo(() => ({
    getPendingNewItem, getPendingNewService, editItemStatus, editServiceStatus
  }), [])
}

export { useNewItemSevice }
