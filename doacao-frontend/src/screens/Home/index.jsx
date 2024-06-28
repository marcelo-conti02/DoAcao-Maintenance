import React, { useEffect, useState, useCallback } from 'react'

import { Input, Tabs } from '../../components'
import { useOrderService } from '../../services'
import { OrdersListGroup } from './partials'
import { MOCK_PRODUCT_ORDERS, MOCK_URGENT_PRODUCT_ORDERS, MOCK_SERVICE_ORDERS, MOCK_URGENT_SERVICE_ORDERS } from './mock'
import { HomeScreen, FiltersContainers } from './styles'

const Home = () => {
    const { getPublicProductOrders, getPublicServiceOrders } = useOrderService()
    const [tabsConfig, setTabsConfig] = useState([])
    const [regularProductOrders, setRegularProductOrders] = useState([])
    const [urgentProductOrders, setUrgentProductOrders] = useState([])
    const [regularServicesOrders, setRegularServicesOrders] = useState([])
    const [urgentServicesOrders, setUrgentServicesOrders] = useState([])
    const [showContent, setShowContent] = useState(false)

    const getProductOrders = async () => {
        const { data } = await getPublicProductOrders()

        const urgentOrders = data.filter(({ isUrgent }) => isUrgent)
        const regularOrders = data.filter(({ isUrgent }) => !isUrgent)

        setRegularProductOrders(regularOrders)
        setUrgentProductOrders(urgentOrders)
    }

    const getServiceOrders = async () => {
        const { data } = await getPublicServiceOrders()
        const urgentOrders = data.filter(({ isUrgent }) => isUrgent)
        const regularOrders = data.filter(({ isUrgent }) => !isUrgent)

        setRegularServicesOrders(regularOrders)
        setUrgentServicesOrders(urgentOrders)
    }

    const getData = useCallback(async () => {
        Promise.all([
            getProductOrders(),
            getServiceOrders(),
        ]).finally(() => setShowContent(true))
    }, [])

    useEffect(() => {
        getData()
    }, [getData])

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
        )
    }, [regularProductOrders,
        urgentProductOrders,
        regularServicesOrders,
        urgentServicesOrders])

    return (
        <HomeScreen isPublic={true}>
            {showContent &&
                (
                    <>
                        <FiltersContainers>
                        </FiltersContainers>
                        <Tabs tabsConfigList={tabsConfig} />
                    </>
                )}
        </HomeScreen>
    )
}

export { Home }