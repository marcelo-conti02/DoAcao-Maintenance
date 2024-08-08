import React, { useState } from 'react'
import { useHistory } from 'react-router-dom'

import { Input, Checkbox, showNotification } from '../../components'
import {
    RegistrationSubmitButton,
    FormSubtitle, Spacer, RegInputCEP, RegInputUF, RegInputCity, RegInputDistrict, Container, Paragraph, ContainerCentered,
    RegistrationScreen, RegistrationFormContainer, RegistrationForm, RegistrationContainerTitle, ContainerChildrenMargin,
    RegistrationCancelButton, RegistrationTitle, RegistrationFormFieldSet, RegistrationFormPasswordGroup, RegistrationFormPasswordParagraph
} from './styles'
import { FormTitle } from '../../assets/styles.js'
import { FORM_DATA } from './form-data'
import { useInstitutionService } from '../../services'
import { HTTP_STATUS_CODE, ROUTES } from '../../enums'

const PASSWORD_REQUIREMENTS = [
    "6 caracteres",
    "Letras maiúsculas e minúsculas",
    "Um dígito",
    "Símbolo especiais como: ‘%’, ‘$’, '!’, ‘?’, ‘&’ ou ‘#’; são opcionais"
]

const Registration = () => {
    const [form, setForm] = useState({ ...FORM_DATA })

    const { goBack, push } = useHistory()
    const { signup } = useInstitutionService()

    const validateField = ({ name, value, checked }) => {
        if (form[name].validate instanceof Function) {
            const error = form[name].validate(value, form, checked)

            return { error: !!error, helperText: error }
        } else {
            return {}
        }
    }

    const onChange = field => {
        const { value, name, checked } = field
        const { error, helperText } = validateField(field)

        setForm(prev => {
            const novoForm = {
                ...prev,
                [name]: { ...prev[name], value, checked, error, helperText },
            }

            if (name === form.website.name) {
                if (!error) {
                    novoForm.socialMedia.error = false
                    novoForm.socialMedia.helperText = ''
                } else if (value == null) {

                }
            } else if (name === form.socialMedia.name) {
                if (!error) {
                    novoForm.website.error = false
                    novoForm.website.helperText = ''
                }
            }

            return novoForm
        })
    }

    const isFormValid = () => {
        let isValid = true
        Object.values(form).filter(({ validate }) => validate instanceof Function).forEach(field => {
            const { error, helperText } = validateField(field)

            setForm(prev => ({ ...prev, [field.name]: { ...field, error, helperText } }))

            if (error) {
                isValid = false
            }
        })

        return isValid
    }

    const setupRequestData = () => {
        return Object.values(form).filter(({ sendToBackend }) => sendToBackend).reduce((acc, { name, value }) => ({ ...acc, [name]: value }), {})
    }

    const onSubmit = async () => {
        if (isFormValid()) {
            const requestData = setupRequestData()

            const { status } = await signup(requestData)

            if (status === HTTP_STATUS_CODE.CREATED) {
                showNotification("Espere receber o e-mail de confirmação de aceite do seu cadastro para acessar sua conta. \n Não esqueça de enviar o estatuto da sua instituição para doacao.caridade.amor@gmail.com", "Solicitação feita com sucesso!")
                push(ROUTES.HOME.path)
            } else {
                showNotification('Revise os campos do formulário e tente novamente!', 'Falha na solicitação!', 'danger')
            }
        } else {
            showNotification('Alguns campos parecem estar com erro!', 'Erro no formulário!', 'danger')
        }

    }

    return (
        <RegistrationScreen isPublic={true}>
            <RegistrationContainerTitle>
                <RegistrationTitle>Bem-vindo à DoAção</RegistrationTitle>
                <RegistrationCancelButton onClick={goBack} variant='contained'>Cancelar Cadastro</RegistrationCancelButton>
            </RegistrationContainerTitle>
            <RegistrationFormContainer>
                <FormTitle>Cadastro da Instituição</FormTitle>
                <RegistrationForm>
                    <RegistrationFormFieldSet>
                        <Input onChange={onChange} {...form.name} type='text' variant="outlined" />
                        <Input onChange={onChange} {...form.login} type='email' variant="outlined" />
                    </RegistrationFormFieldSet>
                    <RegistrationFormFieldSet>
                        <Input onChange={onChange} {...form.cnpj} type='number' variant="outlined" />
                        <Spacer />
                    </RegistrationFormFieldSet>
                    <RegistrationFormFieldSet>
                        <RegistrationFormPasswordGroup>
                            <Input onChange={onChange} {...form.password} type='password' variant="outlined" />
                            <RegistrationFormPasswordParagraph>
                                Recomenda-se que esta não seja uma que você já use.
                                Também recomenda-se que a senha tenha, no mínimo:
                            </RegistrationFormPasswordParagraph>
                            <ul>
                                {PASSWORD_REQUIREMENTS.map((requirement, index) => (<li key={index}>{requirement}</li>))}
                            </ul>
                        </RegistrationFormPasswordGroup>

                        <RegistrationFormPasswordGroup>
                            <Input onChange={onChange} {...form.confirmPassword} type='password' variant="outlined" />
                            <RegistrationFormPasswordParagraph>
                                <Checkbox onChange={onChange} {...form.checkboxRepresentation} id='checkbox-representacao' />
                            </RegistrationFormPasswordParagraph>

                            {/* <RegistrationFormPasswordParagraph>
                                <Checkbox onChange={onChange} {...form.checkboxTerms} id='checkbox-termos' />
                            </RegistrationFormPasswordParagraph>*/}

                        </RegistrationFormPasswordGroup>
                    </RegistrationFormFieldSet>
                </RegistrationForm>

            </RegistrationFormContainer>

            <RegistrationFormContainer>
                <FormTitle>Informações para os doadores</FormTitle>
                <FormSubtitle>Contato</FormSubtitle>
                <RegistrationForm>
                    <RegistrationFormFieldSet>
                        <Input onChange={onChange} {...form.email} type='email' variant="outlined" />
                        <Input onChange={onChange} {...form.phone} type='number' variant="outlined" />
                    </RegistrationFormFieldSet>
                    <RegistrationFormFieldSet>
                        <Input onChange={onChange} {...form.whatsapp} type='number' variant="outlined" />
                        <Spacer />
                    </RegistrationFormFieldSet>
                </RegistrationForm>
                <FormSubtitle>Endereço</FormSubtitle>
                <RegistrationForm>
                    <RegistrationFormFieldSet>
                        <RegInputCEP onChange={onChange} {...form.cep} type='number' variant="outlined" />
                        <RegInputUF onChange={onChange} {...form.state} type='text' variant="outlined" />
                        <RegInputCity onChange={onChange} {...form.city} type='text' variant="outlined" />
                        <RegInputDistrict onChange={onChange} {...form.district} type='text' variant="outlined" />
                    </RegistrationFormFieldSet>
                    <RegistrationFormFieldSet>
                        <Input onChange={onChange} {...form.street} type='text' variant="outlined" />
                        <Input onChange={onChange} {...form.complement} type='text' variant="outlined" />
                    </RegistrationFormFieldSet>

                </RegistrationForm>
                <FormSubtitle>Sobre a instituição</FormSubtitle>
                <Paragraph>Informe um Site ou uma Rede Social de sua instituição:</Paragraph>
                <RegistrationForm>
                    <RegistrationFormFieldSet flex="1">
                        <ContainerChildrenMargin flex="1" direction="column">
                            <Input onChange={onChange} {...form.website} type='text' variant="outlined" />
                            <Input onChange={onChange} {...form.socialMedia} type='text' variant="outlined" />
                            <Input onChange={onChange} {...form.extraSocialMedia} type='text' variant="outlined" />
                        </ContainerChildrenMargin>
                        <Container flex="1" direction="column">
                            <Input onChange={onChange} {...form.description} type="text" variant="outlined" multiline minRows={9} />
                            <Paragraph>Descreva aqui brevemente sua instituição.</Paragraph>
                        </Container>
                    </RegistrationFormFieldSet>
                </RegistrationForm>
                <Container>
                    <Spacer />
                    <ContainerCentered flex="2">
                        <Paragraph align="right">
                            Solicitações de cadastro são sujeitas a triagem não-robotizada. Você será notificado, através do email de cadastro escolhido, sobre o resultado.
                        </Paragraph>
                        <RegistrationSubmitButton onClick={onSubmit} size="large" variant="contained">
                            Solicitar cadastro
                        </RegistrationSubmitButton>
                    </ContainerCentered>
                </Container>
            </RegistrationFormContainer>

        </RegistrationScreen>
    )
}

export { Registration }