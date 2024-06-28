import styled from 'styled-components';
import colors from '../../assets/colors';
import { BaseScreen, Button } from '../../components';
import { ButtonContainer } from '../../assets/styles.js'
import { Input } from '@material-ui/core';

// inclui correção temporária das larguras de botões

const OrderScreen = styled(BaseScreen)`
    padding: 0;
    position: relative;
    min-height: 100vh;
    display: flex;
    align-items: center;
    background-color: ${colors.primary};
`
const OrderFormContainer = styled.div`
    margin: auto;
    width: 70%;
    max-width: 1024px;
    margin: 200px auto;
    display: flex column;
    align-items: center;
    justify-content: space-between;
    box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.25), 0px 4px 4px rgba(0, 0, 0, 0.25);
    border-radius: 8px;
    padding: 50px;
    background-color: ${colors.form};

    @media screen and (max-width: 1000px) {
        flex-direction: column;
        max-width: 800px;
    }


`
const OrderDashboard = styled.div`
    display: flex;
    flex-direction: row;
    align-items: flex-start;
    box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.25), 0px 4px 4px rgba(0, 0, 0, 0.25);
    border-radius: 8px;
    padding: 20px;
    //background-color: ${colors.form};
    
    @media screen and (max-width: 1000px) {
        max-width: 800px;
        flex-direction: column-reverse;
        align-items: center;
    }
`
const OrderItemContainer = styled.div`
    max-width: 1024px;
    width: calc(80% - 20px);
    display: flex column;
    align-items: center;
    justify-content: space-around;
    //box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.25), 0px 4px 4px rgba(0, 0, 0, 0.25);
    //border-radius: 8px;
    padding: 20px;
    //background-color: ${colors.form};

    @media screen and (max-width: 1000px) {
        max-width: 800px;
    }
`
const OrderItem = styled.div`
    margin: 10px;
    width: calc(100% - 60px);
    align-items: baseline;
    justify-content: space-between;
    box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.25), 0px 4px 4px rgba(0, 0, 0, 0.25);
    border-radius: 8px;
    padding: 20px;
    background-color: ${colors.form};
    min-height: 150px;

    @media screen and (max-width: 1000px) {
        max-width: 600px;
    }
`
const Popup = styled.div`
    margin: 10px;
    height: 50%;
    width: 25%;
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: space-around;
    box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.25), 0px 4px 4px rgba(0, 0, 0, 0.25);
    border-radius: 8px;
    padding: 20px;
    background-color: ${colors.background};

    @media screen and (max-width: 1000px) {
        max-width: 600px;
    }
`
const PopupButton = {
    fontSize: "1em",
    fontWeight: "550",
    width: "95%",
    padding: "5px",
    margin: "5px",
    textTransform: "none"
}
const ItemList = styled.div`
    height: 70%;
    width: 75%;
    background-color: ${colors.form};
    margin: 5px;
    //box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.25), 0px 4px 4px rgba(0, 0, 0, 0.25);
    border-radius: 8px;
    overflow-y: scroll;
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: flex-start;
`


const EditingButtonContainer = styled.div`
    display: flex;
    flex-direction: column;
    padding: 10px;
    margin: 10px;
    justify-content: space-between;
    height: 168.7766px;

    @media screen and (max-width: 1000px) {
        height: 136.1666px;
        width: 80%;
        max-width: 230px;
    }
`
const SaveOrCancelButtonContainer = styled.div`
    display: flex;
    flex-direction: row;
    padding: 10px;
    justify-content: space-around;
    margin: 10px;

    @media screen and (max-width: 1000px) {
        height: 83px;
        align-items: center;
        flex-direction: column;
        justify-content: space-between;
    }
`

const JustificationContainer = styled.div`
    width: 100%;

`

export { OrderScreen, OrderFormContainer, OrderDashboard, OrderItemContainer, OrderItem, Button, Popup, PopupButton, EditingButtonContainer, SaveOrCancelButtonContainer, ItemList, JustificationContainer }