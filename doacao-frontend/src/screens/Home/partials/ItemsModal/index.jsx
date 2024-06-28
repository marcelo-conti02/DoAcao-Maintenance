import { useContext, useMemo } from 'react'
import { useHistory } from 'react-router-dom'

import { ROUTES } from '../../../../enums'
import { ModalContext } from '../../../../contexts'

import {
    ModalStyled, InstitutionName, DescriptionContainer, Description, List, ListItem, Action,
    ColumnTitle, ColumnData, ListHeader
} from './styles'

const ItemsModal = ({ order, isUrgent, items }) => {
    const { institutionName, idInstitution, institutionDescription, idProductOrder, idServiceOrder } = order
    const { closeModal } = useContext(ModalContext)
    const { push } = useHistory()

    const orderId = useMemo(() => idProductOrder ? idProductOrder : idServiceOrder, [idProductOrder, idServiceOrder])
    const isProductOrder = useMemo(() => !idServiceOrder, [idServiceOrder])

    const goToOrderPage = () => {
        push(ROUTES.REQUEST_INFO.withParam(orderId), { isProductOrder, idInstitution })
        closeModal()
    }

    return (
        <ModalStyled isUrgent={isUrgent}>
            <InstitutionName isUrgent={isUrgent}>{institutionName}</InstitutionName>
            <DescriptionContainer isUrgent={isUrgent}>
                <Description isUrgent={isUrgent}>{institutionDescription}</Description>
            </DescriptionContainer>
            <List isUrgent={isUrgent}>
                <ListHeader key={"list-header"}>
                    <ColumnTitle width="60px">Recebido</ColumnTitle>
                    <ColumnTitle width="60px">Solicitado</ColumnTitle>
                    <ColumnTitle style={{ flex: 1 }}>Produto</ColumnTitle>
                    <ColumnTitle style={{ flex: 1 }}>Observações</ColumnTitle>
                </ListHeader>
                {items.map(({
                    quantitySolicited,
                    quantityReceived,
                    description,
                    item: {
                        name,
                        unitMeasurement = '',
                    }
                }, index) => (
                    <ListItem key={index} isUrgent={isUrgent}>
                        <ColumnData width="60px">{quantityReceived}</ColumnData>
                        <ColumnData width="60px">{quantitySolicited}</ColumnData>
                        <ColumnData style={{ flex: 1 }}>{unitMeasurement} {name}</ColumnData>
                        <ColumnData style={{ flex: 1 }}>{description ? description : '-'}</ColumnData>
                    </ListItem>
                ))}
            </List>
            <Action onClick={goToOrderPage} variant='contained'>Demonstrar interesse</Action>
        </ModalStyled>
    )
}

export { ItemsModal }