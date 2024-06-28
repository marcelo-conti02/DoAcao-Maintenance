import colors from '../../assets/colors';
import styled from 'styled-components';
import { BaseScreen, Button, Input } from '../../components';
import { StyledButton } from '../../components/Button/styles';

const PreviewRequestScreen = styled(BaseScreen)`
    padding: 0;
    position: relative;
    height: 100vh;
    display: flex;
    flex-direction: column;
    align-items: center;
    background-color: ${colors.primary}
`
const PageContent = styled.div`
    display: flex;
    width: 100%;
    @media(max-width:1100px){
        justify-content: center;
    }

`
const PreviewFormContainer = styled.div`
    display:flex;
    flex-direction: column;
    align-items: center;
    width: 60%;
    background-color: ${colors.form};
    box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.25), 0px 4px 4px rgba(0, 0, 0, 0.25);
    border-radius:24px;
    margin-top: 155px;
    margin-left: 200px;
    margin-right: 200px;
    margin-bottom: 30px;
    padding-top: 15px;

    @media(max-width:1100px){
        width: 100%;
        margin-top: 155px;
        margin-left: 30px;
        margin-right: 30px;
        margin-bottom: 30px;
    }
`
export const RequestsContainer = styled.div`
    display: flex;
    flex-direction: row;
    width: auto;
    align-itens: Center;
    padding: 0 15px 0 15px;
    justify-content: space-between;

    @media(max-width:1150px){
        flex-direction: column;
        max-width: 800px;
        padding: 0;
    }
`
export const Card = styled.div`
    display: flex;
    width: 300px;
    flex-direction: column; 

    background-color: #F2F2F2;
    border-radius: 10px;
    box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.25), 0px 4px 4px rgba(0, 0, 0, 0.25);
    align-itens: center;
    margin: 15px;
    padding: 15px;

    @media(max-width: 360px){
        width: 80%;
        align-self: center;
        margin: 0;
    }

`
export const Itens = styled.div`
    display: flex;
    flex-direction: column;
    border-radius: 10px;
    width: 80%;
    justify-content: center;
    background-color: #dedede;
    padding: 15px;
    margin: 15px;

    @media(max-width: 350px){
        width: 80%;
        align-self: center;
    }
`

export const ButtonEdit = styled(Button)`
    display: flex;
    width: 90%;
    align-self: center;
`

export const CardUrgent = styled.div`
    display: flex;
    width: 300px;
    flex-direction: column; 
    background-color: ${colors.primary};
    border-radius: 10px;
    box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.25), 0px 4px 4px rgba(0, 0, 0, 0.25);
    align-items: center;
    margin: 15px;
    padding: 15px;
    justify-content: space-between;

    @media(max-width: 360px){
        width: 80%;
        align-self: center;
        margin-top:15 px;
    }
`

export const CardTitleRegular = styled.h3`
    align-self: center;
    margin-bottom: 0;
    color: ${colors.secondary};
`

export const CardTitleUrgent = styled.h3`
    align-self: center;
    margin-bottom: 0;
    margin-top: 15px;
    color: ${colors.white};
`

export const Item = styled.p`
    display: flex;
    margin: 0;
    color: ${colors.secondary}
`
/*
 *  Arrumar HamburguerMenu que fica no meio da tela
 *  Arrumar botões de editar que estão sobrepondo o hamburguerMenu expandido
 */

export { PreviewFormContainer, PageContent, PreviewRequestScreen }