import React, { useEffect, useState } from 'react'
import { useHistory } from 'react-router-dom'
import { ModalStyled, Description, Text, ConfirmButton, ListContent, List, ColumnData, ListItem, ListHeader, ColumnTitle } from './styles'
import { FORM_DATA } from './form-data'
import { Input, showNotification } from '../../../../components'
import { useInterestService } from '../../../../services'
import { HTTP_STATUS_CODE, ROUTES } from '../../../../enums'

const ModalInterest = ({ closeModal, ...props }) => {
    const [form, setForm] = useState({ ...FORM_DATA })
    const { goBack, push } = useHistory()
    const { createInterestDemonstrationServiceOrder, createInterestDemonstrationProductOrder } = useInterestService()

    const orderItensList = props.items
    const orderId = props.orderId

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

    const isSelected = () => {
        let selected = false
        let list = []
        orderItensList.forEach(item => {
            if (item.quantity > 0) {
                list.push(item)
            }
        })
        if (list.length > 0) {
            selected = true
        }
        return selected
    }

    const itemsSelected = () => {
        let list = []
        orderItensList.forEach(item => {
            if (item.quantity > 0) {
                list.push({ interestName: item.name, amount: item.quantity })
            }
        })

        return list
    }

    const setupRequestData = () => {
        let selectedItems = itemsSelected()
        let { name, email, phone } = Object.values(form).filter(({ sendToBackend }) => sendToBackend).reduce((acc, { name, value }) => ({ ...acc, [name]: value }), {})

        return {
            itemsAndQuantities: selectedItems,
            orderId,
            name,
            email,
            phone,
        }
    }

    const onSubmitProductOrder = async () => {
        if (isFormValid() && isSelected()) {
            const { status } = await createInterestDemonstrationProductOrder(setupRequestData())

            if (status == HTTP_STATUS_CODE.OK) {
                showNotification('A instituição foi notificada sobre o seu interesse em doar.')
                push(ROUTES.HOME.path)
                closeModal()

            } else {
                showNotification('Revise os campos e tente novamente!', 'Falha na solicitação!', 'danger')
            }

        } else {
            showNotification('Por favor, revise e preencha todos os campos.', '', 'danger')
        }
    }

    const onSubmitServiceOrder = async () => {
        if (isFormValid() && isSelected()) {
            const { status } = await createInterestDemonstrationServiceOrder(setupRequestData())

            if (status == HTTP_STATUS_CODE.OK) {
                showNotification('A instituição foi notificada sobre o seu interesse em doar.')
                push(ROUTES.HOME.path)
                closeModal()

            } else {
                showNotification('Revise os campos e tente novamente!', 'Falha na solicitação!', 'danger')
            }

        } else {
            showNotification('Por favor, revise e preencha todos os campos.', '', 'danger')
        }
    }

    return (
        <ModalStyled >
            <Description>Confira os itens selecionados:</Description>
            <ListContent>
                <List>
                    <ListHeader>
                        <ColumnTitle width="80px">Quantidade</ColumnTitle>
                        <ColumnTitle style={{ flex: 1 }}>Produto</ColumnTitle>
                    </ListHeader>
                    {
                        orderItensList &&
                        orderItensList.filter((item) => {
                            if (item.quantity > 0) {
                                return item
                            }
                        }).map((item, index) => {
                            return <ListItem key={index}>
                                <ColumnData width="80px">{item.quantity} </ColumnData>
                                <ColumnData width="200px"> {item.unitMeasurement} de {item.name}</ColumnData>
                            </ListItem>
                        })

                    }
                </List>
            </ListContent>
            <Description>Preencha suas informações de contato e clique em confirmar para notificar a instituição:</Description>

            <Text>Nome*: </Text>
            <Input onChange={onChange} {...form.name} type='text' variant="outlined" placeholder='Informe seu nome' />
            <Text>Email*: </Text>
            <Input onChange={onChange} {...form.email} type='email' variant="outlined" placeholder='Informe seu email' />
            <Text>Telefone*: </Text>
            <Input onChange={onChange} {...form.phone} type='number' variant="outlined" placeholder='DDD + telefone' />

            <Description>Após clicar em "confirmar", a instituição receberá uma notificação sobre o seu interesse em doar os itens selecionados.</Description>
            <ConfirmButton onClick={props.isProductOrder ? onSubmitProductOrder : onSubmitServiceOrder} size="large" variant="contained">Confirmar </ConfirmButton>
        </ModalStyled>
    )
}

export { ModalInterest }