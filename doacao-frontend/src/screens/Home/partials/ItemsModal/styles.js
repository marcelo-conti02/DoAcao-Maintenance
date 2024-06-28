import styled from 'styled-components'
import colors from '../../../../assets/colors'
import { Button } from '../../../../components'

const ModalStyled = styled.div`
    width: 500px;
    padding: 30px;
    border-radius: 10px;

    background-color: ${({ isUrgent }) => isUrgent ? colors.primary : colors.white};
    color: ${({ isUrgent }) => isUrgent ? colors.white : colors.secondary};

    display: flex;
    flex-direction: column;

    @media screen and (max-width: 570px) {
        width: calc(100vw - 100px);
    }
`

const InstitutionName = styled.h3`

`
const DescriptionContainer = styled.div`
    border-radius: 10px;
    border: solid 1px ${colors.borderGray};
    padding: 10px 15px;
    background-color: ${({ isUrgent }) => isUrgent ? colors.pinkLight : colors.white};
    color: ${colors.secondary};
    max-height: 200px;
    overflow-y: scroll;
    `
const Description = styled.p`

 `
const List = styled.ul`
    list-style-type: none;
    margin: 30px 0;
    padding: 10px 15px;
    border-radius: 10px;
    background-color: ${({ isUrgent }) => isUrgent ? colors.pinkLight : colors.white};
    color: ${colors.secondary};
    border: solid 1px ${colors.borderGray};
    max-height: 200px;
    overflow-y: scroll;
 `
const ListItem = styled.li`
    display: flex;
    margin-bottom: 5px;
 `

const Action = styled(Button)`
    /* width: 100%; */
    align-self: flex-end;
`

const ListHeader = styled.header`
    margin-bottom: 20px;
    display: flex;
`

const ColumnTitle = styled.div`
    font-size: 14px;
    text-align: left;
    font-weight: bold;
    width: ${({ width }) => width};
    
    &:not(:last-child) {
        margin-right: 10px;
    }
    `

const ColumnData = styled.div`
    font-size: 14px;
    text-align: left;
    width: ${({ width }) => width};

    &:not(:last-child) {
        margin-right: 10px;
    }
`

export { ModalStyled, InstitutionName, DescriptionContainer, Description, List, ListItem, Action, ListHeader, ColumnData, ColumnTitle }