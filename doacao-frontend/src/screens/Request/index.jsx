import React, { useState, useEffect, useContext } from 'react'
import { useHistory, useLocation } from 'react-router-dom'

import { useOrderService, useItemService, useServiceService, useProductOrderService, useServiceOrderService } from '../../services'
import { UserContext } from '../../contexts'
import { Button, Input, showNotification } from '../../components'
import { Modal } from '@material-ui/core'
import { OrderScreen, OrderFormContainer, OrderDashboard, OrderItemContainer, OrderItem, Popup } from './styles'
import { SaveButton, CancelButton, SecondaryButton } from '../../assets/styles.js'
import { FormTitle, FormSubtitle, ItemTitle, ItemSubtitle, Explanation, Paragraph } from '../../assets/styles.js'
import { EditingButtonContainer, SaveOrCancelButtonContainer, ItemList, PopupButton, JustificationContainer } from './styles'
import { HTTP_STATUS_CODE } from '../../enums'
import { RequestModal } from './partials'
import { ModalContext } from '../../contexts'

const Request = () => {
    const { push } = useHistory()
    const { userInfo } = useContext(UserContext)
    const { createProductOrder, createServiceOrder, createUrgentServiceOrder, createUrgentProductOrder } = useOrderService()
    const { editProductOrder } = useProductOrderService()
    const { editServiceOrder } = useServiceOrderService()
    const { getItems } = useItemService()
    const { getServices } = useServiceService()
    const [requestData, setRequestData] = useState({ items: [], justification: '' })
    const [requestAttributes, setRequestAttributes] = useState({})
    const [productAdditionOptions, setProductAdditionOptions] = useState([])
    const [serviceAdditionOptions, setServiceAdditionOptions] = useState([])
    const { state } = useLocation()
    const { openModal, closeModal} = useContext(ModalContext)
    

    let pos = 0;
    let itemCount = 0;

    useEffect(() => {
        const getPossibleItems = async () => {
            const possibleItems = await getItems()
            setProductAdditionOptions(possibleItems.data)
        }

        const getPossibleServices = async () => {
            const possibleServices = await getServices()
            setServiceAdditionOptions(possibleServices.data)
        }

        const getCurrentOrderItems = () => {
            if (state.type === "produto") setRequestData({ order: state.order[0], items: state.order[0].itens })
            else if (state.type === "serviço") setRequestData({ order: state.order[0], items: state.order[0].services })
        }

        const fetchRequestAttributes = () => { setRequestAttributes(state) }

        getPossibleItems()
        getPossibleServices()
        fetchRequestAttributes()
        if (state.toEdit) getCurrentOrderItems()
    }, [])


    const getItemTypeName = (plural) => {
        if (requestAttributes.type === "produto") {
            if (plural) return "produtos"
            return "produto"

        } else if (requestAttributes.type === "serviço") {
            if (plural) return "serviços"
            return "serviço"
        }
    }

    const getUrgency = () => {
        if (state.isUrgent) return "urgente"
        else return "não-urgente"
    }

    const notUrgentHelperText = (e) => {
        if (!state.isUrgent) {
            if (state.type === "produto") return "Você pode pedir, no máximo, " + e.idItem.limitItens + " ".concat(e.idItem.unitMeasurement)
            else if (state.type === "serviço") return "Você pode pedir, no máximo, " + e.idService.limitService
        }
    }


    const handleCancelChanges = () => {
        push("/previewrequest", { type: requestAttributes.type })
    }

    const handleSaveChanges = async () => {
        const description = requestData.justification
        let status
        let data

        if (state.toEdit === true) {
            let editRequest = {
                idInstitution: requestData.order.idInstitution,
                institutionDescription: requestData.order.institutionDescription,
                institutionName: requestData.order.institutionName,
                isUrgent: requestData.order.isUrgent,
                createdTime: requestData.order.createdTime,
                limitDate: requestData.order.limitDate,
            }

            if (state.type === "produto") {
                const products = requestData.items.map(
                    item => ({
                        idProductQuantityOrder: item.idProductQuantityOrder,
                        quantityProductsReceived: parseInt(item.quantityProductsReceived),
                        quantityProductsMissing: (parseInt(item.quantityProductsSolicited) - parseInt(item.quantityProductsReceived)),
                        quantityProductsSolicited: parseInt(item.quantityProductsSolicited),
                        idProductDetailsOrder: item.idProductDetailsOrder,
                        idItem: item.idItem,
                        description: item.description,
                    })
                )
                editRequest = { ...editRequest, idProductOrder: requestData.order.idProductOrder, itens: products }
                data = await editProductOrder(editRequest)

            } else if (state.type === "serviço") {
                const services = requestData.items.map(
                    item => ({
                        idServiceQuantityOrder: item.idServiceQuantityOrder,
                        quantityServiceReceived: parseInt(item.quantityServiceReceived),
                        quantityServiceMissing: (parseInt(item.quantityServiceSolicited) - parseInt(item.quantityServiceReceived)),
                        quantityServiceSolicited: parseInt(item.quantityServiceSolicited),
                        idService: item.idService,
                        idServiceDetailsOrder: item.idServiceDetailsOrder,
                        description: item.description,
                    })
                )
                editRequest = { ...editRequest, idServiceOrder: requestData.order.idServiceOrder, services: services }
                data = await editServiceOrder(editRequest)
            }

        } else if (state.toEdit === false) {
            if (state.type === 'produto') {
                const itens = requestData.items.map(item => ({ idItem: item.idItem.idItem, quantitySolicited: item.quantityProductsSolicited, description: item.description, unitMeasurement: item?.idItem?.unitMeasurement }))
                if (state.isUrgent) data = await createUrgentProductOrder({ items: itens, idInstitution: userInfo.id_institution, isUrgent: state.isUrgent })
                else data = await createProductOrder({ items: itens, idInstitution: userInfo.id_institution, isUrgent: state.isUrgent })

            } else if (state.type === "serviço") {
                const services = requestData.items.map(item => ({ idService: item.idService.id_Service, quantitySolicited: item.quantityServiceSolicited, description: item.description, unitMeasurement: item.unit }))
                if (state.isUrgent) data = await createUrgentServiceOrder({ services, idInstitution: userInfo.id_institution, isUrgent: state.isUrgent })
                else data = await createServiceOrder({ services, idInstitution: userInfo.id_institution, isUrgent: state.isUrgent })
            }
        }

        status = data.status

        if (HTTP_STATUS_CODE.OK === status) {
            const notificationText = state.isUrgent ? "Em breve um dos nossos administradores analisará o pedido e responderá a solicitação" : "Os doadores já podem visualizar e demonstrar interesse em doar para as suas necessidades"
            const notificationTitle = state.isUrgent ? "Pedido urgente pendente de análise" : "Pedido criado com sucesso"

            showNotification(notificationText, notificationTitle)
            push("/previewrequest", undefined)

        } else {
            showNotification("Revise os campos dos itens pedidos", "Falha na requisição", 'danger')
        }
    }


    const handleDeleteItem = (i) => {
        const items = []
        let aux = 0;
        requestData.items.map((e) => {
            if (aux !== i) items.push(e)
            aux++;
        })
        setRequestData({ ...requestData, items: items })
    }

    const handleDeleteAll = async () => {
        setRequestData({ ...requestData, items: [] })
    }

    const [renderPopUp, setRenderPopUp] = useState(false)

    const handleAddItem = () => {
        setRenderPopUp(true);
    }

    const finishAddingItem = (e) => {
        setRenderPopUp(false)

        if (state.type === "produto") {
            let idProductDetailsOrder
            let product = {
                idItem: {
                    idItem: e.idItem,
                    name: e.name,
                    limitItens: e.limitItens,
                    unitMeasurement: e.unitMeasurement
                },
                quantityProductsSolicited: 0,
                quantityProductsReceived: 0,
                quantityProductsMissing: 0,
                idProductDetailsOrder
            }

            if (state.toEdit) {
                idProductDetailsOrder = {
                    idProductDetailsOrder: requestData.order.idProductOrder,
                    isUrgent: requestData.order.isUrgent,
                    createdTime: requestData.order.createdTime,
                    limitDate: requestData.order.limitDate,
                    urgent: requestData.order.urgent
                }
                product = { ...product, idProductDetailsOrder }
            }

            const newItems = [product, ...requestData.items]
            setRequestData(prev => ({ ...prev, items: newItems }))

        } else if (state.type === "serviço") {
            let idServiceDetailsOrder
            let service = {
                idService: {
                    id_Service: e.id_Service,
                    name: e.name,
                    limitService: e.limitService
                },
                quantityServiceSolicited: 0,
                quantityServiceReceived: 0,
                quantityServiceMissing: 0
            }

            if (state.toEdit) {
                idServiceDetailsOrder = {
                    idServiceDetailsOrder: requestData.order.idServiceOrder,
                    isUrgent: requestData.order.isUrgent,
                    createdTime: requestData.order.createdTime,
                    limitDate: requestData.order.limitDate,
                    urgent: requestData.order.urgent
                }
                service = { ...service, idServiceDetailsOrder }
            }

            const newItems = [service, ...requestData.items]
            setRequestData(prev => ({ ...prev, items: newItems }))
        }
    }

    const renderJustificationField = () => {
        if (state.isUrgent) {
            return (
                <JustificationContainer>
                    <Input
                    style={{
                        width: "100%",
                        margin: "20px 0",
                    }} 
                    label="Justificativa da urgência" 
                    value={requestData.justification} 
                    onChange={target => setRequestData(prev => ({ ...prev, justification: target.value }))} 
                    type="text" 
                    variant="outlined" 
                    multiline 
                    minRows={5} />
                </JustificationContainer>
            )
        }
    }

    /* A FAZER
     * - Fazer popup fechar quando clica fora dele
     * - Impedir que itens já utilizados sejam adicionados novamente
     * - Notificar o usuário sobre quantidades inválidas (texto não-numérico, números não-inteiros para unidades, números negativos)
     * - Se sobrar tempo, fazer barra de pesquisa do popup funcionar
     */
    return (
        <OrderScreen>
            <Modal open={renderPopUp} style={{ display: "flex", justifyContent: "space-around", alignItems: "center" }}>
                <Popup>
                    <ItemTitle style={{ margin: "15px" }}>Escolha o {getItemTypeName(false)} que deseja adicionar</ItemTitle>
                    <Input
                        variant="outlined"
                        label="Pesquise aqui"
                        style={{ width: "75%", margin: "10px" }} />
                    <ItemList>{
                        requestAttributes.type === "produto"
                            ? productAdditionOptions.map((e) => {
                                return <Button
                                    style={PopupButton}
                                    onClick={() => finishAddingItem(e)}>
                                    {e.name}
                                </Button>
                            })
                            : requestAttributes.type === "serviço"
                            && serviceAdditionOptions.map((e) => {
                                return <Button
                                    style={PopupButton}
                                    onClick={() => finishAddingItem(e)}>
                                    {e.name}
                                </Button>
                            })
                    }</ItemList>
                    <Button
                        style={{ ...CancelButton, margin: "15px" }}
                        onClick={() => setRenderPopUp(false)}>Cancelar</Button>
                </Popup>
            </Modal>
            <OrderFormContainer>
                <FormTitle>Pedido {getUrgency()} de {getItemTypeName(true)}</FormTitle>
                <FormSubtitle>{state.toEdit ? "Editando" : "Criando"}</FormSubtitle>
                <SaveOrCancelButtonContainer>
                    <Button
                        style={{ ...SaveButton, width: "173.45px" }}
                        onClick={handleSaveChanges}>Salvar</Button>
                    <Button
                        style={CancelButton}
                        onClick={handleCancelChanges}>Cancelar alterações</Button>
                </SaveOrCancelButtonContainer>
                {renderJustificationField()}
                <OrderDashboard>
                    <OrderItemContainer>
                        {
                            requestData.items !== undefined && requestData.items.length > 0
                                ? requestData.items.map((e, index) => {
                                    itemCount++;
                                    pos = requestData.items.length - itemCount;
                                    return <OrderItem key={itemCount}>
                                        <ItemSubtitle>{getItemTypeName(false)} {pos + 1}</ItemSubtitle>
                                        <div style={{ display: "flex", flexDirection: "row", margin: "10px", alignItems: "center" }}>
                                            <ItemTitle style={{ width: "40%" }}>
                                                {
                                                    state.type === "produto"
                                                        ? e.name || e.idItem.name
                                                        : state.type === "serviço"
                                                            ? e.name || e.idService.name
                                                            : ""
                                                }
                                            </ItemTitle>
                                            <Input style={{ verticalAlign: "baseline", width: "50%" }}
                                                disabled={state.toEdit && state.isUrgent}
                                                type="text"
                                                label="Quantidade Solicitada"
                                                variant="outlined"
                                                value={requestAttributes.type === 'produto' ? e.quantityProductsSolicited : e.quantityServiceSolicited}
                                                helperText={notUrgentHelperText(e)}
                                                onChange={(target) => {
                                                    setRequestData(prev => {
                                                        const newItems = [...prev.items]
                                                        newItems[index] = { ...newItems[index], quantityProductsSolicited: target.value, quantityServiceSolicited: target.value }

                                                        return { ...prev, items: newItems }
                                                    })
                                                }} />
                                            <Paragraph style={{ padding: "5px 5px 4% 5px" }}> {e.unitMeasurement}</Paragraph>
                                        </div>
                                        <Input style={{ width: "calc(100% - 20px)", margin: "10px" }}
                                            disabled={state.toEdit && state.isUrgent}
                                            type="text"
                                            label="Observações"
                                            variant="outlined"
                                            value={e.description ? e.description : ""}
                                            helperText={"Inclua informações importantes, como tipos, tamanhos, ou gêneros."}
                                            onChange={(target) => {
                                                setRequestData(prev => {
                                                    const newItems = [...prev.items]
                                                    newItems[index] = { ...newItems[index], description: target.value }
                                                    return { ...prev, items: newItems }
                                                })
                                            }} />

                                        <div style={{ display: "flex", flexDirection: "row", margin: "10px", alignItems: "center" }}>
                                            <Input style={{ verticalAlign: "baseline", width: "50%" }}
                                                type="text"
                                                disabled={!e.idProductQuantityOrder && !e.idServiceQuantityOrder}//se não for ProductQuantityOrder e ServiceQuantityOrder então o disabled funciona(bloqueia texto)
                                                label="Quantidade Recebida"
                                                variant="outlined"
                                                value={requestAttributes.type === 'produto' ? e.quantityProductsReceived : e.quantityServiceReceived}
                                                helperText={""}
                                                onChange={(target) => {
                                                    setRequestData(prev => {
                                                        const newItems = [...prev.items]
                                                        newItems[index] = { ...newItems[index], quantityProductsReceived: target.value, quantityServiceReceived: target.value }

                                                        return { ...prev, items: newItems }
                                                    })
                                                }} />
                                        </div>
                                        <div style={{ textAlign: "right", padding: "10px" }}>
                                            <Button
                                                disabled={state.toEdit && state.isUrgent}
                                                style={{ border: "2px solid #353535" }}
                                                onClick={() => handleDeleteItem(pos)}>Deletar item
                                            </Button>
                                        </div>
                                    </OrderItem>
                                })
                                : <OrderItem>
                                    <Explanation style={{ textAlign: "center", height: "100%" }}>Você ainda não solicitou quaisquer {getItemTypeName(true)}.</Explanation>
                                </OrderItem>
                        }
                    </OrderItemContainer>
                    <EditingButtonContainer>
                        <Button style={{ border: "2px solid #0AD1A1" }}
                            disabled={state.toEdit && state.isUrgent}
                            onClick={handleAddItem}>Adicionar {getItemTypeName()}</Button>
                        <Button style={{ border: "2px solid #EF6B6B" }}
                            onClick={handleDeleteAll}>Excluir tudo</Button>
                        <Button style={SecondaryButton}
                            onClick={() => openModal(<RequestModal type={getItemTypeName} idInstitution= {userInfo.id_institution} closeModal={closeModal}/>)}>Solicitar {getItemTypeName()} não listado</Button>
                    </EditingButtonContainer>
                </OrderDashboard>
            </OrderFormContainer>
        </OrderScreen>
    )
}

export { Request }