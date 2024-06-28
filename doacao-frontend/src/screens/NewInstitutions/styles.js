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

const NewInstitutionsScreen = styled(BaseScreen)`
    &&{
        align-items: flex-start;
    }
`

const SolicitationsContent = styled.div`
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
`


const ListContainer = styled.div`
    width: 90%;
    max-width: 1024px;
    align-items: center;
    border-radius: 8px;
    background-color: ${colors.white};
    display: flex;
    flex-direction: column;
    flex-wrap: wrap;
    @media(max-width:1100px){
        width: 90%;
    }
`
const PageTitle = styled.h2`
    width: 100%;
    text-align: center;
    margin: 0;
`
const InstitutionName = styled.h2`
    display: block;
`
const Contact = styled.div`
    display: flex;
    flex-direction: column;
    width: 50%;
    gap: 15px;
    @media(max-width:1100px){
        width: 100%;
    }
`
const Description = styled.div`
    width: 50%;
    @media(max-width:1100px){
        width: 100%;
    }
`
const NewInstitution = styled.div`
    display: grid;
    grid-template-columns: 100%;
    border-style: solid;
    border-width: 2px;
    border-color: #BCBCBC;
    border-radius: 8px;
    padding: 15px;
    width: 90%;
`
const ListContent = styled.div`
    display: flex;
    flex-direction: row;
    padding-bottom: 10px;
    @media(max-width:1100px){
        flex-direction: column;
        width: 90%;
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
const Divider = styled.div`
    background-color: #BCBCBC;
    height: 2px;
`
export {
    PageContent, SolicitationsContent, NewInstitutionsScreen, ListContainer, PageTitle, InstitutionName, Contact, Description, NewInstitution,
    ListContent, Buttons, Divider
}