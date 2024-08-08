import React, { useState, useContext } from 'react'
import { useHistory } from 'react-router-dom'

import { Button, Input, Link, showNotification } from '../../components'
import images from '../../assets/images'
import colors from '../../assets/colors.js'
import { LoginScreen, LoginFormContainer, LoginForm, SignUpBlock, SignUpButton, LoginButton, ForgotPasswordLink } from './styles'
import { Header, ImageLogo, FormTitle, ActionsContainer, Description, DividerContainer, Divider } from '../../assets/styles.js'
import { ROUTES } from '../../enums'
import { useAutenticacaoService } from '../../services'
import { UserContext } from '../../contexts'

const Login = () => {
    const { saveUserLogin } = useContext(UserContext)
    const { push } = useHistory()
    const { login } = useAutenticacaoService()

    const [userData, setUserData] = useState({
        email: "",
        password: ""
    })

    const tryToLogin = async () => {
        const { email, password } = userData
        const { status, data } = await login(email, password)

        const isLoginSucessful = status === 200 && data.id_user

        if (isLoginSucessful) {
            const { isAdmin } = data
            saveUserLogin({ ...data, isLogged: true })

            showNotification('Sucesso')

            if (isAdmin) {
                push(ROUTES.ADMIN.path)
            } else {
                push(ROUTES.PREVIEW_REQUEST.path)
            }
        } else {
            showNotification('Email ou senha incorretos', '', 'danger')
        }

        return
    }

    const handleLoginRequest = async () => {
        const isFormValid = userData.email !== "" && userData.password !== ""
        if (isFormValid) {
            tryToLogin()
        } else {
            showNotification('Os campos não podem ficar vazios', '', 'danger')
        }
    }

    const goToRegistration = () => {
        push(ROUTES.SIGNUP.path)
    }

    const formTitleStyle = {
        color: colors.primary,
        textAlign: "left",
        fontSize: "1.25em",
        padding: "0"
    }

    return (
        <LoginScreen isPublic={true}>
            <LoginFormContainer>
                <LoginForm >
                    <FormTitle style={formTitleStyle}>Bem-vindo de volta!</FormTitle>
                    <Input type='text' label='E-mail' variant="outlined" placeholder="Insira seu email de cadastro" onChange={(target) => setUserData({ ...userData, email: target.value })} />
                    <Input type='password' label="Senha" variant="outlined" placeholder="Insira sua senha" onChange={(target) => setUserData({ ...userData, password: target.value })} />
                    <ActionsContainer>
                        <LoginButton variant='contained' onClick={handleLoginRequest}>Login</LoginButton>
                    </ActionsContainer>
                </LoginForm>
                <DividerContainer>
                    <Divider />
                </DividerContainer>
                <SignUpBlock>
                    <FormTitle style={formTitleStyle}>Cadastre sua instituição</FormTitle>
                    <Description>
                        A DoAção é uma plataforma onde instituições de caridade e entidades assistenciais podem anunciar de quais itens e serviços elas necessitam. Assim, os doadores ganham a liberdade de definir como irão ajudar, e ficam tranquilos com a certeza de que suas contribuições estão indo para o lugar certo.
                    </Description>
                    <Description style={{ fontWeight: 700 }}>
                        Além de preencher o formulário, é necessário o envio do estatuto da instiutição para o email: doacao.caridade.amor@gmail.com
                    </Description>
                    <Description style={{ fontWeight: 700 }}>
                        Obrigada. Gabriela
                    </Description>
                    <SignUpButton onClick={goToRegistration} variant='outlined'>Queremos uma conta</SignUpButton>
                </SignUpBlock>
            </LoginFormContainer>
        </LoginScreen>
    )
}

export { Login }