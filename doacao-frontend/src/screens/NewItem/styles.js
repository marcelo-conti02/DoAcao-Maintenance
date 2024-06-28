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

const NewItemCard = styled(BaseScreen)`
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

const ItemContent = styled.div`
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

const LitsNewItem= styled.div`
    display: grid;
    grid-template-columns: 100%;
    border-style: solid;
    border-width: 2px;
    border-color: #BCBCBC;
    border-radius: 8px;
    padding: 15px;
    margin-bottom: 15px;
    width: 90%;

    @media(max-width:1100px){
        margin: 15px;
        width: 80%;
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

const ListContent = styled.div`
    display: flex;
    flex-direction: column;
    padding-bottom: 10px;
    @media(max-width:1100px){
        flex-direction: column;
        width: 90%;
    }
`

const NewItemRequest= styled.div`
    display: grid;
    grid-template-columns: 100%;
    padding: 15px;
    width: 90%;
`
const Inputs = styled.div`
    display: flex;
    flex-direction: column;
`

export { PageContent, NewItemCard, PageTitle, ItemContent, LitsNewItem, Buttons, ListContent, NewItemRequest, Inputs } 