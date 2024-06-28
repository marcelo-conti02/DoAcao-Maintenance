import React, { useEffect, useState, useContext, Fragment, useCallback } from "react"
import { FormTitle, ItemTitle } from '../../assets/styles'
import { ModalInterest } from './partials'
import { ModalContext } from '../../contexts'
import { useParams, useLocation } from 'react-router-dom'
import { ORDER_ITENS_LIST } from "./mock"
import {
    RequestInfoScreen, RequestInfoContainer, InstitutionInfo, Donation, Text, ConfirmButton,
    Bubble, ItemsList, CardListItem, QuantityInput
} from './styles.js'

import { useItemOrderService, useServiceOrderService, useInstitutionService } from '../../services'

const RequestInfo = () => {
    const [OrderItensList, setOrderItensList] = useState([])
    const [institutionInfo, setInstitutionInfo] = useState({})
    const { getProductsInOrder } = useItemOrderService()
    const { getServicesInOrder } = useServiceOrderService()
    const { getInstitutionInfo } = useInstitutionService()

    const { openModal, closeModal } = useContext(ModalContext)
    
    const { orderId } = useParams()
    const { state: { isProductOrder, idInstitution } } = useLocation()

    const getItems = useCallback(async () => {
        let resposta

        if (isProductOrder) {
            resposta = await getProductsInOrder(orderId)
        } else {
            resposta = await getServicesInOrder(orderId)
        }

        const preparedItems = resposta.data.map(item => ({ name: item, quantity: 0 }))

        setOrderItensList(preparedItems)
    }, [getProductsInOrder, getServicesInOrder, orderId, isProductOrder])

    const getInfo = useCallback(async () => {
        const { data: { name, cep, city, district, state, street, complement, email, phone, description, whatsapp, website, socialMedia, otherSocialMedia } } = await getInstitutionInfo(idInstitution)

        const instInfo = {
            name,
            emails: [email],
            phones: [phone, whatsapp],
            addresses: [{
                cep, city, district, state, street, complement
            }],
            description,
            website,
            links: [
                socialMedia,
                otherSocialMedia,
            ],
        }

        setInstitutionInfo(instInfo)
    }, [getInstitutionInfo, idInstitution])

    useEffect(() => {
        getItems()
        getInfo()
    }, []) // O ESLint reclama desse arranjo vazio, mas a página não funciona com ele incluindo as dependências

    const handleChangeQuantity = (key, quantity) => {
        setOrderItensList(prev => {
            let aux = [...prev]
            aux[key] = { ...aux[key], quantity: quantity }
            return aux
        })
    }

    return (
        <RequestInfoScreen isPublic={true}>
            <RequestInfoContainer>
                {institutionInfo.name && (
                    <InstitutionInfo>
                        <FormTitle>{institutionInfo.name}</FormTitle>
                        <Bubble>
                            <Text>{institutionInfo.description}</Text>
                        </Bubble>
                        <ItemTitle>Email</ItemTitle>
                        <Bubble>
                            {
                                institutionInfo.emails.map((email, index) => { return <Text key={index}>{email}</Text> })
                            }
                        </Bubble>
                        <ItemTitle>Telefone</ItemTitle>
                        <Bubble>
                            {
                                institutionInfo.phones.map((phone, index) => { return <Text key={index}>{phone}</Text> })
                            }
                        </Bubble>
                        <ItemTitle>Endereço</ItemTitle>
                        <Bubble>
                            {
                                institutionInfo.addresses.map(({ street, district, city, state, cep, complement }, index) => {
                                    return (
                                        <Text key={index}>
                                            {street} - {district}
                                            <br />
                                            {city}/{state}
                                            <br />
                                            <br />
                                            Cep: {cep}
                                            {complement ? `Complemento: ${complement}` : ''}
                                        </Text>
                                    )
                                })
                            }
                        </Bubble>
                        <ItemTitle>Site</ItemTitle>
                        <Bubble>
                            <Text>{institutionInfo.website}</Text>
                        </Bubble>
                    </InstitutionInfo>
                )}
                {OrderItensList && (

                    <Donation>
                        { }
                        <FormTitle>Doação</FormTitle>
                        <Text>Selecione os itens e as quantidades que possui interesse em doar: </Text>
                        <ItemsList> {
                            OrderItensList.map((item, index) => {
                                return (
                                    <Fragment key={index}>
                                        <CardListItem>
                                            <QuantityInput type='number' onChange={(target) => handleChangeQuantity(index, target.value)} value={item.quantity} />
                                            <p>
                                                {item.unitMeasurement} {item.name}
                                            </p>
                                        </CardListItem>
                                    </Fragment>
                                )
                            })}
                        </ItemsList>

                        <ConfirmButton disabled={OrderItensList.every(item => item.quantity < 1)} onClick={() => openModal(< ModalInterest closeModal={closeModal} items={OrderItensList} orderId={orderId} isProductOrder={isProductOrder}/>)} variant='contained'>Confirmar interesse em doar ❤</ConfirmButton>
                        <Text>Após clicar em confirmar interesse você será direcionado para informar seus dados de contato.</Text>

                    </Donation>
                )}
            </RequestInfoContainer>
        </RequestInfoScreen>
    )
}

export { RequestInfo }