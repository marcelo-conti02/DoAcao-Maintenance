import axios from "axios";
import { useMemo } from "react";

/**
 * BASE URLS of the service used on OrderService.
 */
const BASE_SERVICE_ORDER = "serviceOrder/";
const BASE_PRODUCT_ORDER = "productOrder/";

/**
 * URLS of the service used on OrderService.
 */
const RESOURCES = {
  SERVICE_ORDERS: BASE_SERVICE_ORDER,
  PRODUCT_ORDERS: BASE_PRODUCT_ORDER,
  SERVICE_URGENT_ORDERS: BASE_SERVICE_ORDER + 'urgent',
  PRODUCT_URGENT_ORDERS: BASE_PRODUCT_ORDER + 'urgent',
};

const useOrderService = () => {
  const createProductOrder = async order => {
    return axios.post(RESOURCES.PRODUCT_ORDERS, order)
      .then(result => result)
      .catch(({ response: { data } }) => {
        console.log(data.error)
        return data
      })
  }

  const createServiceOrder = async order => {
    return axios.post(RESOURCES.SERVICE_ORDERS, order)
      .then(result => result)
      .catch(({ response: { data } }) => {
        console.log(data.error)
        return data
      })
  }

  const getPublicProductOrders = async () => {
    return axios.get(RESOURCES.PRODUCT_ORDERS)
      .then(result => result)
      .catch(({ response: { data } }) => {
        console.log(data.error)
        return data
      })
  }

  const getPublicServiceOrders = async () => {
    return axios.get(RESOURCES.SERVICE_ORDERS)
      .then(result => result)
      .catch(({ response: { data } }) => {
        console.log(data.error)
        return data
      })
  }

  const createUrgentServiceOrder = async order => {
    return axios.post(RESOURCES.SERVICE_URGENT_ORDERS, order)
      .then(result => result)
      .catch(({ response: { data } }) => {
        console.log(data.error)
        return data
      })
  }

  const createUrgentProductOrder = async order => {
    return axios.post(RESOURCES.PRODUCT_URGENT_ORDERS, order)
      .then(result => result)
      .catch(({ response: { data } }) => {
        console.log(data.error)
        return data
      })
  }

  const getActiveProductOrders = async id => {
    return axios.get(RESOURCES.PRODUCT_ORDERS + "actives/institution/"+id)
      .then(res => res)
      .catch(err => {
        console.log(err)
        return err
      })
  }
  const getActiveServiceOrders = async id => {
    return axios.get(RESOURCES.SERVICE_ORDERS + "actives/institution/"+id)
      .then(res => res)
      .catch(err => {
        console.log(err)
        return err
      })
  }

  return useMemo(() => ({
    getPublicProductOrders,
    getPublicServiceOrders,
    createProductOrder,
    createServiceOrder,
    createUrgentServiceOrder,
    createUrgentProductOrder,
    getActiveProductOrders,
    getActiveServiceOrders
  }), [])
}

export { useOrderService }
