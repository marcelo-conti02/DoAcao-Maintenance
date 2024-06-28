import styled from 'styled-components';
import colors from '../../assets/colors';
import { BaseScreen } from '../../components';

const PageContent = styled.div`
    display: flex;
    width: 100%;
    @media(max-width:1100px){
        justify-content: center;
    }
`

const UrgentOrderCard = styled(BaseScreen)`
    &&{
        align-items: flex-start;
    }
`
const PageTitle = styled.h2`
    width: 100%;
    text-align: center;
    @media(max-width:320px){
        width: 90%;
    }
`

const UrgentOrderContent = styled.div`
    display:flex;
    flex-direction: column;
    align-items: center;
    width: 60%;
    background-color: ${colors.white};
    border-radius:24px;
    margin-top: 20px;
    margin-left: 406px;
    margin-bottom: 8px;

    @media(max-width:1100px){
        margin-left: 0;
        width: 80%;
    }
    @media(max-width:320px){
        padding-right: 10px;
    }
`

const ListContainer = styled.div`
    width: 90%;
    max-width: 1024px;
    align-items: center;
    border-radius: 8px;
    padding: 20px 10px;
    background-color: ${colors.white};
    display: flex;
    flex-direction: column;
    flex-wrap: wrap;
    @media(max-width:1100px){
        width: 90%;
    }
`

const NewUrgentOrder= styled.div`
    display: grid;
    grid-template-columns: 100%;
    border-style: solid;
    border-width: 2px;
    border-color: #BCBCBC;
    border-radius: 8px;
    padding: 15px;
    width: 90%;
`

const InstitutionName = styled.h2`
    display: block;
`

const ListContent = styled.div`
    display: flex;
    flex-direction: column;
    padding-bottom: 10px;
    @media(max-width:1100px){
        flex-direction: column;
        width: 90%;
    }
`
const Divider = styled.div`
    background-color: #BCBCBC;
    height: 2px;
`

const Contact = styled.div`
    display: flex;
    flex-direction: row;
    gap: 15px;
    @media(max-width:802px){
        flex-direction: column;
    }
`

const Buttons = styled.div`
    display: flex;
    flex-direction: row;
    column-gap: 20px;
    button {
        margin-top:8px;
    }
    @media(max-width:1100px){
        flex-direction: column;
    }
`
const Justification = styled.div`
    @media(max-width:1100px){
        width: 100%;
    }
`

const Item = styled.div`
    display: flex;
    flex-direction: row;
    gap: 15px;
    @media(max-width:1100px){
        width: 100%;

    }
`
const List = styled.ul`
    list-style-type: none;
    margin: 0;
    padding: 10px 15px;
    border-radius: 10px;
    background-color: ${({ isUrgent }) => isUrgent ? colors.pinkLight : colors.white};
    color: ${colors.secondary};
    border: solid 1px ${colors.borderGray};
    max-height: 200px;
    overflow-y: scroll;
 `
 const ItemTitle = styled.h5`
  font-size: 1.2em;
  color: ${colors.darkGrey};
  margin: 0;
  font-weight: 600;
`
export { PageContent, UrgentOrderCard, PageTitle, UrgentOrderContent, ListContainer, NewUrgentOrder, InstitutionName, ListContent, Divider, Contact, Buttons, Justification, Item, List, ItemTitle } 