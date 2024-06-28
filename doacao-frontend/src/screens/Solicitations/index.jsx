import React from 'react'

import { Header, ImageLogo } from '../../assets/styles.js'
import images from '../../assets/images'
import { PageContent, SolicitationsScreen, SolicitationList, ButtonLink, Line, SolicitationTitle, SolicitationDesc } from './styles';
import { HamburguerMenu, SideMenu } from '../../components'
import { useHistory } from 'react-router-dom';
import { ROUTES } from '../../enums/routes.js';
import { LOCAL_STORAGE_KEYS } from '../../enums'
import { useLocalStorage } from '../../services'
import { useEffect, useState } from 'react'

const Solicitations = () => {

    const { push } = useHistory()
    const { getLocalStorageItem } = useLocalStorage()
    const [userInfo, setUserInfo] = useState({})

    useEffect(() => {
        const getUserInfo = async () => {
          const userInfoOnStorage = await getLocalStorageItem(LOCAL_STORAGE_KEYS.USER_INFO)
          setUserInfo(userInfoOnStorage)
        }
    
        getUserInfo()
      }, [getLocalStorageItem])

    const redirectTo = (url) => {
        push(url)
    }

    return (
        <SolicitationsScreen>
            <PageContent >
                <SideMenu admin={userInfo} />
                <HamburguerMenu startOpen={true} admin={userInfo}/>

                <SolicitationList>
                    <SolicitationTitle>SOLICITAÇÕES</SolicitationTitle>
                    <SolicitationDesc>Gerencie solicitações pendentes feitas por instituições</SolicitationDesc>
                    <Line />

                    <ButtonLink onClick={() => redirectTo(ROUTES.NEW_INSTITUTIONS.path)} variant='outlined'>Novas instituições</ButtonLink>
                    <ButtonLink onClick={() => redirectTo(ROUTES.NEW_ITEM.path)} variant='outlined'>Itens para Pedidos</ButtonLink>
                    <ButtonLink onClick={() => redirectTo(ROUTES.NEW_SERVICE.path)} variant='outlined'>Serviços para Pedidos</ButtonLink>
                    <ButtonLink onClick={() => redirectTo(ROUTES.URGENT_ORDERS.path)} variant='outlined'>Pedidos Urgentes</ButtonLink>
                </SolicitationList>
            </PageContent>
        </SolicitationsScreen>
    )
}

export { Solicitations }