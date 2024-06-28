import React, { useState } from 'react'
import { useHistory } from 'react-router-dom'
import { ModalStyled, ConfirmButton, InputReq } from './styles'
import { FormTitle } from '../../../../assets/styles.js'
import { FORM_DATA } from './form-data'
import { Input, showNotification } from '../../../../components'
import { HTTP_STATUS_CODE } from '../../../../enums'
import { useItemSolicitationService, useServiceSolicitationService } from '../../../../services'
import { CodeSharp } from '@material-ui/icons'

const RequestModal = ({ closeModal, ...props }) => {
    const [form, setForm] = useState({ ...FORM_DATA })
    const type = props.type
    const idInstitution = props.idInstitution
    const { itemSolicitation } = useItemSolicitationService()
    const { serviceSolicitation } = useServiceSolicitationService()

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
        if (type(false) === "produto"){
            let { item } = Object.values(form).filter(({ sendToBackend }) => sendToBackend).reduce((acc, { name, value }) => ({ ...acc, [name]: value }), {})
            return {
                idInstitution,
                item,
            }
        }
        if (type(false) === "serviço"){
            let { item } = Object.values(form).filter(({ sendToBackend }) => sendToBackend).reduce((acc, { name, value }) => ({ ...acc, [name]: value }), {})
            let service  =  item    
             return {
                idInstitution,
                service,
            }
        }
    }

    const onSubmit = async () => {
        if (isFormValid()) {
             if (type(false) === "produto"){
                const { status } = await itemSolicitation(setupRequestData())
                console.log(status)
                if (status == HTTP_STATUS_CODE.OK) {
                    showNotification('Produto solicitado com sucesso!')
                    closeModal()
                }
                else {
                     showNotification('Revise os campos e tente novamente!', 'Falha na solicitação!', 'danger')
                    }
            }
            else if (type(false) === "serviço"){
                const { status } = await serviceSolicitation(setupRequestData())
                if (status == HTTP_STATUS_CODE.OK) {
                    showNotification('Serviço solicitado com sucesso!')
                    closeModal()
                }
                else{
                    showNotification('Revise os campos e tente novamente!', 'Falha na solicitação!', 'danger')
                }
            }
        } else {
            showNotification('Por favor, revise e preencha todos os campos.', '', 'danger')
        }
    }
    

    return (
        <ModalStyled >
            <FormTitle>Solicitação de {type(false)} não listado.</FormTitle>
           
            <Input onChange={onChange} {...form.item}  type="text" label="Nome"/>
            
             
            <ConfirmButton size="large" variant="contained"  onClick={onSubmit}> Solicitar </ConfirmButton>
        </ModalStyled>
    )
}

export { RequestModal }