import React, { useContext, useEffect } from 'react'
import { useHistory } from 'react-router-dom'

import { BaseScreenStyled } from './styles'
import { Header, Footer } from '../'
import { ROUTES } from '../../enums'
import { UserContext } from '../../contexts'

const BaseScreen = ({ children, isPublic = false, exclusiveToAdmin = false, ...props }) => {
    const { userInfo } = useContext(UserContext)
    const { push } = useHistory()

    useEffect(() => {
        if (!isPublic && !userInfo?.isLogged || exclusiveToAdmin && !userInfo.isAdmin) {
            push(ROUTES.HOME.path)
        }
    }, [userInfo, isPublic, push])

    return (
        <BaseScreenStyled {...props}>
            <Header />
            {children}
            <Footer/>
        </BaseScreenStyled>
    )
}

export { BaseScreen }