import React from 'react'

import { HomeAdminScreen, HomeAdminContent } from './styles'
import { SideMenu } from '../../components/SideMenu'
import { HamburguerMenu } from '../../components/HamburguerMenu'

const HomeAdmin = () => {

    return (
        <HomeAdminScreen exclusiveToAdmin={true}>
            <HomeAdminContent>
                <SideMenu />
                <HamburguerMenu startOpen={true} />
            </HomeAdminContent>
        </HomeAdminScreen>
    )
}

export { HomeAdmin }