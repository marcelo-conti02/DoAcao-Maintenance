import React, { useContext } from 'react'
import { useHistory } from 'react-router-dom'

import images from '../../assets/images'
import { HeaderStyled, ImageLogo, HeaderAction, ActionsContainer, HeaderActionSecondary } from './styles'
import { ROUTES } from '../../enums'
import { UserContext } from '../../contexts'

const Header = () => {
    const { userInfo, logout } = useContext(UserContext)
    const { push, location } = useHistory()

    const canDisplayLoginButton = () => {
        const nonDisplayblePages = [ROUTES.LOGIN.path, ROUTES.SIGNUP.path]

        return !nonDisplayblePages.includes(location.pathname)
    }

    const redirectMyScreen = () => {
        if (userInfo.isAdmin) {
            push(ROUTES.ADMIN.path)
        } else {

            push(ROUTES.PREVIEW_REQUEST.path)
        }
    }

    const renderActions = () => {
        if (userInfo?.isLogged) {
            return (
                <ActionsContainer >
                    <HeaderActionSecondary onClick={redirectMyScreen}>Minha tela</HeaderActionSecondary>
                    <HeaderAction onClick={logout}>Sair</HeaderAction>
                </ActionsContainer>
            )
        } else if (canDisplayLoginButton()) {
            return <HeaderAction onClick={() => push(ROUTES.LOGIN.path)}>Sou uma instituição</HeaderAction>
        }

        return null
    }

    return (
        <HeaderStyled>
            <ImageLogo onClick={() => push(ROUTES.HOME.path)} src={images.logo} />
            {renderActions()}
        </HeaderStyled>
    )
}

export { Header }