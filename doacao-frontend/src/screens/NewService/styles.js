import styled from 'styled-components';
import colors from '../../assets/colors';
import { BaseScreen } from '../../components';
import { TextField } from '@material-ui/core';

const PageContent = styled.div`
    display: flex;
    width: 100%;
    @media(max-width:1100px){
        justify-content: center;
    }
`

const NewServiceCard = styled(BaseScreen)`
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

const ServiceContent = styled.div`
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

const LitsNewService= styled.div`
    display: grid;
    grid-template-columns: 100%;
    border-style: solid;
    border-width: 2px;
    border-color: #BCBCBC;
    border-radius: 8px;
    padding: 15px;
    width: 90%;
    margin-bottom: 15px;

    @media(max-width:1100px){
        margin: 15px;
        width: 80%;
    }
`

const Buttons = styled.div`
    display: flex;
    flex-direction: row;
    column-gap: 15px;
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

const NewServiceRequest= styled.div`
    display: grid;
    grid-template-columns: 100%;
    padding: 15px;
    width: 90%;
`
export { PageContent, NewServiceCard, PageTitle, ServiceContent, LitsNewService, Buttons, ListContent, NewServiceRequest } 