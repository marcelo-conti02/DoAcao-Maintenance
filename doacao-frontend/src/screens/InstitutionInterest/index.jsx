import React, { useState, useEffect } from 'react'
import { useLocation } from 'react-router-dom'

import { InstitutionInterestScreen, PageContent, InterestFormContainer, InterestContainer, Divider, InterestForm } from './styles'
import { SideMenuInstitution } from '../../components/SideMenuInstitution'
import { HamburguerMenuInstitution } from '../../components/HamburguerMenuInstitution'
import { FormTitle, ItemTitle, Paragraph, Explanation } from '../../assets/styles.js'
import { IconButton } from '@material-ui/core'
import { Delete } from '@material-ui/icons'
import { useInterestService } from '../../services/useInterestService'
import { useLocalStorage, useOrderService } from '../../services'
import { INTEREST } from './mock'

const InstitutionInterest = () => {
    const { getInterestInProductOrder, getInterestInServiceOrder } = useInterestService()
    const { getActiveProductOrders, getActiveServiceOrders } = useOrderService()
    const [userInfo, setUserInfo] = useState({})
    const [institutionId, setInstitutionId] = useState()
    const { getLocalStorageItem } = useLocalStorage()

    const [interests, setInterests] = useState([])

    const { state: { orderId, isProducOrder } } = useLocation()

    useEffect(() => {
        const getInterests = async () => {
            let response

            if (isProducOrder) {
                response = await getInterestInProductOrder(orderId)
            } else {
                response = await getInterestInServiceOrder(orderId)
            }

            setInterests(response.data)
        }

        getInterests()
    }, [])

    return (
        <InstitutionInterestScreen>
            <PageContent>
                <SideMenuInstitution institution={userInfo} />
                <HamburguerMenuInstitution />
                <InterestFormContainer>
                    <InterestForm>
                        <FormTitle>Doadores Interessados</FormTitle>
                        {
                            interests &&
                                interests.length > 0
                                ? interests.map((interest, index) => (
                                    <InterestContainer key={index}>
                                        <Paragraph style={{ border: "5px solid #00000000" }}>Número de identificação do pedido: {interest.orderId}</Paragraph>

                                        <ItemTitle>Informações de contato</ItemTitle>
                                        <div style={{ paddingLeft: "15px" }}>
                                            <Paragraph><strong>Nome:</strong> {interest.name}</Paragraph>
                                            <Paragraph><strong>Email:</strong> {interest.email}</Paragraph>
                                            <Paragraph><strong>Telefone:</strong> {interest.phone}</Paragraph>
                                        </div>

                                        <br />
                                        <br />
                                        <ItemTitle>{isProducOrder ? "Tem interesse em doar" : "Tem interesse em voluntariar:"}</ItemTitle>
                                        <div style={{ paddingLeft: "15px" }}>
                                            {
                                                interest.interests.map((object) => (
                                                    <Paragraph>{object.amount} de {object.itemName}</Paragraph>
                                                ))
                                            }
                                        </div>
                                        <IconButton aria-label="delete" style={{ display: 'box', marginLeft: '95%' }}>
                                            <Delete fontSize="large" />
                                        </IconButton>
                                    </InterestContainer>
                                ))
                                : <Explanation style={{ textAlign: "center", height: "100%" }}>Este pedido ainda não recebeu interesses de doação.</Explanation>
                        }
                    </InterestForm>
                </InterestFormContainer>
            </PageContent>
        </InstitutionInterestScreen>
    )
}

export { InstitutionInterest }