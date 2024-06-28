import styled from 'styled-components'
import colors from '../../../../assets/colors'
import { Button, Input } from '../../../../components'

const ModalStyled = styled.div`
    display: flex;
    flex-direction: column;
    background-color: ${colors.white};
    border-radius: 10px;
    padding: 30px;

    > :not(:first-child) {
        margin: 10px;
    }
`

const Description = styled.p`
    margin-bottom: 10px;

 `
const List = styled.ul`
    list-style-type: none;
    padding: 10px 15px;
    border-radius: 10px;
    background-color: ${({ isUrgent }) => isUrgent ? colors.pinkLight : colors.white};
    color: ${colors.secondary};
    border: solid 1px ${colors.borderGray};
    max-height: 200px;
    overflow-y: scroll;
 `

 const Text = styled.p`
    margin-bottom: 10px;
`

const ConfirmButton = styled(Button)`
`
const ListContent = styled.div`
    display: flex;
    flex-direction: column;
    @media(max-width:1100px){
        flex-direction: column;
        width: 90%;
    }
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

const ListItem = styled.li`
    display: flex;
 `

 const ListHeader = styled.header`
    margin-bottom: 20px;
    display: flex;
`

export { ModalStyled, Description, List, Text, ConfirmButton, ListContent, ColumnData, ColumnTitle, ListItem, ListHeader }
