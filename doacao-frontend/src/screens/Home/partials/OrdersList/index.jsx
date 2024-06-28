import React, { useContext, Fragment } from 'react'

import { ModalContext } from '../../../../contexts'
import { ItemsModal } from '../'
import images from '../../../../assets/images'

import {
    UrgentOrdersListStyled, RegularOrdersListStyled, OrderCardStyled,
    CardTitle, CardDescription, ItemsList, CardListItem, CardMoreItemsMessage, CardAction,
    GroupListContainer, ListContainer, ListName, NoOrdersFoundText, ImageNoData,
    ColumnTitle, ColumnData, ListHeader
} from './styles'

const OrderCard = ({ order, isUrgent }) => {
    const { openModal } = useContext(ModalContext)

    const { institutionName, institutionDescription, itens: products, services } = order
    const itens = products != undefined ?
        products.map(({ idItem, quantityProductsReceived, quantityProductsSolicited, ...rest }) =>
            ({ ...rest, item: { ...idItem }, quantityReceived: quantityProductsReceived, quantitySolicited: quantityProductsSolicited })) :
        services.map(({ idService, quantityServiceReceived, quantityServiceSolicited, ...rest }) =>
            ({ ...rest, item: { ...idService }, quantityReceived: quantityServiceReceived, quantitySolicited: quantityServiceSolicited }))

    const croppedItems = itens.sort((itemA, itemB) => {
        const diffA = itemA.requestedAmount - itemA.currentAmout
        const diffB = itemB.requestedAmount - itemB.currentAmout

        return diffA > diffB ? 1 : -1
    }).slice(0, 3)

    const getFooterMessage = () => {
        const nonVisibleItemsCount = itens.length - croppedItems.length

        if (nonVisibleItemsCount > 1) {
            return <CardMoreItemsMessage>e outros {nonVisibleItemsCount} itens</CardMoreItemsMessage>
        } else if (nonVisibleItemsCount > 0) {
            return <CardMoreItemsMessage>e outro item</CardMoreItemsMessage>
        }
        else {
            return <CardMoreItemsMessage></CardMoreItemsMessage>
        }
    }

    return (
        <OrderCardStyled isUrgent={isUrgent}>
            <CardTitle isUrgent={isUrgent}>{institutionName}</CardTitle>
            <CardDescription isUrgent={isUrgent}>{institutionDescription}</CardDescription>


            <ItemsList isUrgent={isUrgent}>
                <ListHeader>
                    <ColumnTitle width="60px">Recebido</ColumnTitle>
                    <ColumnTitle width="60px">Solicitado</ColumnTitle>
                    <ColumnTitle style={{ flex: 1 }}>Produto</ColumnTitle>
                </ListHeader>
                {croppedItems.map(({
                    quantitySolicited,
                    quantityReceived,
                    item: {
                        name,
                        unitMeasurement = '',
                    }
                }, index) => {
                    return (
                        <Fragment key={index}>
                            <CardListItem isUrgent={isUrgent}>
                                <ColumnData width="60px">{quantityReceived}</ColumnData>
                                <ColumnData width="60px">{quantitySolicited}</ColumnData>
                                <ColumnData style={{ flex: 1 }}>{unitMeasurement} {name}</ColumnData>
                            </CardListItem>
                        </Fragment>
                    )
                })}
            </ItemsList>
            {getFooterMessage()}
            <CardAction onClick={() => openModal(<ItemsModal order={order} items={itens} isUrgent={isUrgent} />)} variant="contained">Saber mais</CardAction>
        </OrderCardStyled>
    )
}

const UrgentOrdersList = ({ orders = [] }) => {

    return !!orders.length && (
        <ListContainer>
            <ListName>Pedidos Urgentes</ListName>
            <UrgentOrdersListStyled>
                {orders.map((order, index) => {
                    return (
                        <Fragment key={index}>
                            <OrderCard order={order} isUrgent={true} />
                        </Fragment>
                    )
                })}
            </UrgentOrdersListStyled>
        </ListContainer>
    )
}

const RegularOrdersList = ({ orders = [] }) => {

    return !!orders.length && (
        <ListContainer bgReversed={true}>
            <ListName>Pedidos</ListName>
            <RegularOrdersListStyled>
                {orders.map((order, index) => {
                    return (
                        <Fragment key={index}>
                            <OrderCard orderIndex={index} order={order} isUrgent={false} />
                        </Fragment>
                    )
                })}
            </RegularOrdersListStyled>
        </ListContainer>
    )
}

const OrdersListGroup = ({ orders = [], urgentOrders = [] }) => {
    if (orders.length || urgentOrders.length) {

        return (
            <GroupListContainer>
                <UrgentOrdersList orders={urgentOrders} />
                <RegularOrdersList orders={orders} />
            </GroupListContainer>
        )
    } else {
        return (
            <GroupListContainer>
                <NoOrdersFoundText>Nenhum pedido de doação encontrado</NoOrdersFoundText>
                <ImageNoData src={images.noDataFound} />
            </GroupListContainer>
        )
    }
}

export { OrdersListGroup }