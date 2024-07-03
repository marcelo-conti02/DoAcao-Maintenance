import React, { useEffect, useState, useCallback } from 'react';
import { Input, Tabs } from '../../components';
import { useOrderService, useInstitutionService } from '../../services';
import { OrdersListGroup } from './partials';
import { HomeScreen, FiltersContainers } from './styles';

const Home = () => {
  const { getPublicProductOrders, getPublicServiceOrders, getCityByOrderId } = useOrderService();
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
    const { data } = await getPublicProductOrders();
    const filteredData = data.filter(({ orderId }) => !selectedCity || getCityByOrderId(orderId) === selectedCity);

    const urgentOrders = filteredData.filter(({ isUrgent }) => isUrgent);
    const regularOrders = filteredData.filter(({ isUrgent }) => !isUrgent);
    
    setRegularProductOrders(regularOrders);
    setUrgentProductOrders(urgentOrders);
  };

  const getServiceOrders = async () => {
    const { data } = await getPublicServiceOrders();
    const filteredData = data.filter(order => !selectedCity || order.city === selectedCity);

    const urgentOrders = filteredData.filter(({ isUrgent }) => isUrgent);
    const regularOrders = filteredData.filter(({ isUrgent }) => !isUrgent);

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
    const citiesData = await getCities();
    setCities(citiesData);
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
            <select onChange={handleCityChange} value={selectedCity}>
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
