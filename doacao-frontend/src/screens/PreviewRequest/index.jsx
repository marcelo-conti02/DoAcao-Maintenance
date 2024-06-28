import React, { useCallback, useState } from 'react'
import { useHistory, useLocation } from 'react-router-dom'

import { PreviewFormContainer, RequestsContainer, PageContent, PreviewRequestScreen, CardTitleRegular, CardTitleUrgent, Card, Itens, ButtonEdit, CardUrgent, Item } from './styles'
import { FormTitle } from '../../assets/styles.js'
import { SideMenuInstitution } from '../../components/SideMenuInstitution'
import { HamburguerMenuInstitution } from '../../components/HamburguerMenuInstitution'
import { useEffect } from 'react'
import { useLocalStorage, useOrderService } from '../../services'

const PreviewRequest = () => {
    const { push } = useHistory()
    const { state } = useLocation()
    const { getActiveProductOrders, getActiveServiceOrders } = useOrderService()
    const { getLocalStorageItem } = useLocalStorage()
    const [regularProductOrders, setRegularProductOrders] = useState([])
    const [urgentProductOrders, setUrgentProductOrders] = useState([])
    const [regularServiceOrders, setRegularServiceOrders] = useState([])
    const [urgentServiceOrders, setUrgentServiceOrders] = useState([])
    const [userInfo, setUserInfo] = useState({})

    const handleClick = (type, urgency) => {
        switch (type) {
            case "produto": {
                if (urgency) push("/request", { type: type, isUrgent: urgency, toEdit: getToEdit(urgentProductOrders), order: urgentProductOrders })
                else push("/request", { type: type, isUrgent: urgency, toEdit: getToEdit(regularProductOrders), order: regularProductOrders })
                break
            }
            case "serviço": {
                if (urgency) push("/request", { type: type, isUrgent: urgency, toEdit: getToEdit(urgentServiceOrders), order: urgentServiceOrders })
                else push("/request", { type: type, isUrgent: urgency, toEdit: getToEdit(regularServiceOrders), order: regularServiceOrders })
                break
            }
            default: { }
        }
    }

    const getType = (plural) => {
        if (state === undefined || state.type === "produto") {
            if (plural) return "produtos"
            else return "produto"
        }
        if (state.type === "serviço") {
            if (plural) return "serviços"
            else return "serviço"
        }

    }

    const getToEdit = (list = []) => {
        return list.length > 0
    }
    const buttonText = (list) => {
        if (getToEdit(list)) return "Editar"
        else return "Criar"
    }

    useEffect(() => {
        const getOrders = async () => {

            if (state === undefined || state.type === "produto") {
                const userInfo = await getLocalStorageItem("user-info")
                const orders = await getActiveProductOrders(userInfo.id_institution)
                setRegularProductOrders(orders.data.filter(({ isUrgent }) => !isUrgent))
                setUrgentProductOrders(orders.data.filter(({ isUrgent }) => isUrgent))
            }
            else if (state.type === "serviço") {
                const userInfo = await getLocalStorageItem("user-info")
                const orders = await getActiveServiceOrders(userInfo.id_institution)
                setRegularServiceOrders(orders.data.filter(({ isUrgent }) => !isUrgent))
                setUrgentServiceOrders(orders.data.filter(({ isUrgent }) => isUrgent))
            }
        }
        getOrders()

    }, [])

    const renderItensNonUrgent = () => {
        const hasProductsToDisplay = getType(true) === "produtos" && regularProductOrders[0] && regularProductOrders[0].itens
        const hasServicesToDisplay = getType(true) === "serviços" && regularServiceOrders[0] && regularServiceOrders[0].services

        if (hasProductsToDisplay) {
            return (
                <Itens>
                    {
                        regularProductOrders[0].itens.map(item => (
                            <Item>{item.quantityProductsReceived} de {item.quantityProductsSolicited} {item.idItem.unitMeasurement} {item.idItem.name}</Item>
                        ))
                    }
                </Itens>
            )
        } else if (hasServicesToDisplay) {
            return (
                <Itens>
                    {
                        regularServiceOrders[0].services.map(item => (
                            <Item>{item.quantityServiceReceived} de {item.quantityServiceSolicited} {item.idService.name} </Item>
                        ))
                    }
                </Itens>
            )
        }
    }

    const renderItensUrgent = () => {
        const hasProductsToDisplay = getType(true) === "produtos" && urgentProductOrders[0] && urgentProductOrders[0].itens
        const hasServicesToDisplay = getType(true) === "serviços" && urgentServiceOrders[0] && urgentServiceOrders[0].services

        if (hasProductsToDisplay) {
            return (
                <Itens>
                    {
                        urgentProductOrders[0].itens.map(item => (
                            <Item>{item.quantityProductsReceived} de {item.quantityProductsSolicited} {item.idItem.unitMeasurement} {item.idItem.name}</Item>
                        ))
                    }
                </Itens>
            )
        } else if (hasServicesToDisplay) {
            return (
                <Itens>
                    {
                        urgentServiceOrders[0].services.map(item =>
                            <Item>{item.quantityServiceReceived} de {item.quantityServiceSolicited} {item.idService.name} </Item>
                        )

                    }
                </Itens>
            )
        }
    }

    const handleClickInterest = isUrgent => {
        let orderId
        const isProducOrder = getType(true) === "produtos"

        if (isProducOrder) {
            orderId = isUrgent ? urgentProductOrders[0].idProductOrder : regularProductOrders[0].idProductOrder
        } else {
            orderId = isUrgent ? urgentServiceOrders[0].idServiceOrder : regularServiceOrders[0].idServiceOrder
        }

        push("/interest", { orderId, isProducOrder })
    }

    return (
        <PreviewRequestScreen>
            <PageContent>
                <SideMenuInstitution institution={userInfo} />
                <HamburguerMenuInstitution institution={userInfo} />
                <PreviewFormContainer>
                    <FormTitle>Pedidos ativos de {getType(true)}</FormTitle>
                    <RequestsContainer>
                        <Card>
                            <CardTitleRegular>Pedido não-urgente de {getType(true)}</CardTitleRegular>
                            {renderItensNonUrgent()}
                            <ButtonEdit variant='contained' onClick={() => handleClick(getType(false), false)}>{buttonText(getType(true) === "produtos" ? regularProductOrders[0]?.itens : regularServiceOrders[0]?.services)}</ButtonEdit>
                            <ButtonEdit style={{ marginTop: '20px' }} size="large" onClick={() => handleClickInterest()}>INTERESSES</ButtonEdit>
                        </Card>
                        <CardUrgent>
                            <CardTitleUrgent>Pedido urgente de {getType(true)}</CardTitleUrgent>
                            {renderItensUrgent()}
                            <ButtonEdit variant='contained' onClick={() => handleClick(getType(false), true)}>{buttonText(getType(true) === "produtos" ? urgentProductOrders[0]?.itens : urgentServiceOrders[0]?.services)}</ButtonEdit>
                            <ButtonEdit style={{ color: 'white', marginTop: '20px' }} size="large" onClick={() => handleClickInterest(true)}>INTERESSES</ButtonEdit>
                        </CardUrgent>
                    </RequestsContainer>
                </PreviewFormContainer>
            </PageContent>
        </PreviewRequestScreen>
    )

}

export { PreviewRequest }