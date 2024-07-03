import React, { useEffect, useState, useCallback } from 'react';
import { Input, Tabs } from '../../components';
import { useOrderService, useInstitutionService } from '../../services';
import { OrdersListGroup } from './partials';
import { HomeScreen, FiltersContainers } from './styles';
import { CenterFocusStrong } from '@material-ui/icons';

const Home = () => {
  const { getPublicProductOrders, getPublicServiceOrders, getOrdersByCity, getServiceOrdersByCity } = useOrderService();
  const { getCities } = useInstitutionService();
  const [tabsConfig, setTabsConfig] = useState([]);
  const [regularProductOrders, setRegularProductOrders] = useState([]);
  const [urgentProductOrders, setUrgentProductOrders] = useState([]);
  const [regularServicesOrders, setRegularServicesOrders] = useState([]);
  const [urgentServicesOrders, setUrgentServicesOrders] = useState([]);
  const [showContent, setShowContent] = useState(false);
  const [cities, setCities] = useState([]);
  const [selectedCity, setSelectedCity] = useState('');

  const getProductOrders = async () => {
    let data;
    if (selectedCity) {
      const response = await getOrdersByCity(selectedCity);
      console.log(response);
      data = response.data;
    } else {
      const response = await getPublicProductOrders();
      console.log(response);
      data = response.data;
    }

    const urgentOrders = data.filter(({ isUrgent }) => isUrgent);
    const regularOrders = data.filter(({ isUrgent }) => !isUrgent);

    setRegularProductOrders(regularOrders);
    setUrgentProductOrders(urgentOrders);
  };

  const getServiceOrders = async () => {
    let data;
    if (selectedCity) {
      const response = await getServiceOrdersByCity(selectedCity);
      data = response.data;
    } else {
      const response = await getPublicServiceOrders();
      data = response.data;
    }

    const urgentOrders = data.filter(({ isUrgent }) => isUrgent);
    const regularOrders = data.filter(({ isUrgent }) => !isUrgent);

    setRegularServicesOrders(regularOrders);
    setUrgentServicesOrders(urgentOrders);
  };

  const getData = useCallback(async () => {
    Promise.all([
      getProductOrders(),
      getServiceOrders(),
    ]).finally(() => setShowContent(true));
  }, [selectedCity]);

  const loadCities = async () => {
    try {
      const response = await getCities();
      setCities(response);
    } catch (error) {
      console.error('Failed to load cities:', error);
      setCities([]);
    }
  };

  useEffect(() => {
    getData();
  }, [getData]);

  useEffect(() => {
    loadCities();
  }, []);

  useEffect(() => {
    setTabsConfig(
      [
        {
          children: <OrdersListGroup orders={regularProductOrders} urgentOrders={urgentProductOrders} />,
          title: 'Produtos',
        },
        {
          children: <OrdersListGroup orders={regularServicesOrders} urgentOrders={urgentServicesOrders} />,
          title: 'Voluntários',
        },
      ]
    );
  }, [regularProductOrders, urgentProductOrders, regularServicesOrders, urgentServicesOrders]);

  const handleCityChange = (event) => {
    setSelectedCity(event.target.value);
  };

  return (
    <HomeScreen isPublic={true}>
      {showContent && (
        <>
          <FiltersContainers>
            <h4 style={{margin:'15px'}}>Filtrar pedidos por cidade:</h4>
            <select style={{width:'10vw'}} onChange={handleCityChange} value={selectedCity}>
              <option value="">Todas as cidades</option>
              {cities.map((city, index) => (
                <option key={index} value={city}>
                  {city}
                </option>
              ))}
            </select>
          </FiltersContainers>
          <Tabs tabsConfigList={tabsConfig} />
        </>
      )}
    </HomeScreen>
  );
};

export { Home };
