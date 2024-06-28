import React, { useState, useCallback } from 'react'
import { useUrgentOrders, useServiceOrderService, useProductOrderService } from '../../services'

import { Typography } from '@material-ui/core'

import { UrgentOrderCard, PageContent, PageTitle, UrgentOrderContent, ListContainer, NewUrgentOrder, InstitutionName, ListContent, Divider, Contact, Buttons, Justification, Item, List, ItemTitle } from './styles'
import { Button, HamburguerMenu, SideMenu } from '../../components'
import { useEffect } from 'react'
import { DescriptionContainer, Description } from '../Home/partials/ItemsModal/styles'

const UrgentOrders = () => {
    const [urgentOrders, setUrgentOrders] = useState([])

    const {
        serviceUpdateStatus
    } = useServiceOrderService()

    const {
        productsUpdateStatus
    } = useProductOrderService()

    const handleAccept = async (urgentOrder) => {
        if (urgentOrder.service) {
            await serviceUpdateStatus('A', urgentOrder.id)
        }
        else {
            await productsUpdateStatus('A', urgentOrder.id)
        }

        getUrgentOrders()
    }

    const handleDecline = async (urgentOrder) => {
        if (urgentOrder.service) {
            await serviceUpdateStatus('I', urgentOrder.id)
        }
        else {
            await productsUpdateStatus('I', urgentOrder.id)
        }

        getUrgentOrders()
    }

    const {
        getPendingUrgentOrders
    } = useUrgentOrders()

    const getUrgentOrders = useCallback(async () => {
        const response = await getPendingUrgentOrders()
        setUrgentOrders(response.data)
    }, [getPendingUrgentOrders])

    useEffect(() => {
        getUrgentOrders()
    }, [])

    return (
        <UrgentOrderCard>
            <PageContent>
                <SideMenu />
                <HamburguerMenu />
                <UrgentOrderContent>

                    <PageTitle>Solicitações de Pedidos Urgentes</PageTitle>
                    {
                        urgentOrders && urgentOrders.map((urgentOrder, index) => (
                            <ListContainer key={index}>
                                <NewUrgentOrder>
                                    <InstitutionName>{urgentOrder.institution.name}</InstitutionName>
                                    <Divider />
                                    <ListContent>
                                        <Contact>
                                            <Typography variant='body2'>
                                                {urgentOrder.institution.email}
                                            </Typography>
                                            <Typography variant='body2'>
                                                {urgentOrder.institution.phone}
                                            </Typography>
                                            <Typography variant='body2'>
                                                {urgentOrder.institution.street} - {urgentOrder.institution.district}
                                                <br />
                                                {urgentOrder.institution.city}/{urgentOrder.institution.state}
                                                <br />
                                                Cep: {urgentOrder.institution.cep}
                                                {urgentOrder.institution.complement ? ` Complemento: ${urgentOrder.institution.complement}` : ''}
                                            </Typography>
                                        </Contact>
                                    </ListContent>
                                    <ListContent>
                                        <Justification>
                                            <ItemTitle>Justificativa</ItemTitle>
                                            <DescriptionContainer>
                                                <Description>{urgentOrder.description}</Description>
                                            </DescriptionContainer>
                                        </Justification>
                                    </ListContent>

                                    <ListContent>
                                        <ItemTitle>Itens</ItemTitle>
                                        <List>
                                            {
                                                urgentOrder.orderComponents.map((item, index) => (
                                                    <Item key={index}>
                                                        <Typography variant='body2'>
                                                            {item.componentName}
                                                        </Typography>
                                                        <Typography variant='body2'>
                                                            {item.componentAmount}
                                                        </Typography>
                                                        <Typography variant='body2'>
                                                            {item.componentMeasurementUnity}
                                                        </Typography>
                                                    </Item>
                                                ))
                                            }
                                        </List>

                                    </ListContent>
                                    <Buttons>
                                        <Button variant='contained' onClick={() => handleAccept(urgentOrder)}>Aceitar</Button>
                                        <Button variant='outlined' onClick={() => handleDecline(urgentOrder)}>Recusar</Button>
                                    </Buttons>
                                </NewUrgentOrder>
                            </ListContainer>
                        ))
                    }
                </UrgentOrderContent>
            </PageContent>
        </UrgentOrderCard>
    )
}
export { UrgentOrders }           