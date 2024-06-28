import styled from 'styled-components'
import colors from '../../assets/colors'
import { BaseScreen, Button, Input } from '../../components'

const RequestInfoScreen = styled(BaseScreen)`
    background-color: ${colors.primary};
`

const QuantityInput = styled(Input)`
    text-align: center;
    width: 40px;
`
const RequestInfoContainer = styled.div`
    width: 70%;
    max-width: 1024px;
    margin: 20px auto;
    display: flex;
    flex-direction: row;
    align-items: flex-start;
    justify-content: space-between;
    box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.25), 0px 4px 4px rgba(0, 0, 0, 0.25);
    border-radius: 8px;
    padding: 50px;
    background-color: ${colors.background};

    @media screen and (max-width: 920px) {
        flex-direction: column;
        max-width: 800px;
        justify-content: center;
        
    }
`

const Bubble = styled.div`
    display: flex;
    flex-direction: column;
    padding: 20px;
    background-color: ${colors.form};
    border-radius: 8px;
    width: calc(100% - 2 (20px - 5px));
    margin: 5px;

    @media screen and (max-width: 920px){
        display: flex;
        flex-direction: column;
    }
`

const InstitutionInfo = styled.div`
    background-color: ${colors.background};
    width: 37.5%;
    padding: 50px;
    margin-right: 25px;
    border-radius: 8px;
    box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.25), 0px 4px 4px rgba(0, 0, 0, 0.25);

    @media screen and (max-width: 920px){
        display: flex;
        flex-direction: column;
        margin-bottom: 20px;
        margin-right: 0px;
        width: calc(100% - (50px * 2));
    }
`

const Donation = styled.div`
    background-color: ${colors.background};
    width: 37.5%;
    height: 600px;
    padding: 50px;
    margin-left:25px;
    border-radius: 8px;
    box-shadow: 0px 4px 14px rgba(0, 0, 0, 0.25), 0px 4px 4px rgba(0, 0, 0, 0.25);
    text-align: center;
    
    @media screen and (max-width: 920px){
        display: flex;
        flex-direction: column;
        text-align: center;
        margin-left: 0px;
        width: calc(100% - (50px * 2));
    }
`
const Text = styled.p`
    margin: 2px;
`
const ConfirmButton = styled(Button)`
    @media screen and (max-width: 920px){
        flex-direction: column;
        max-width: 450px;
        margin: 50px;
        align-self: center;
    }
`

const ItemsList = styled.ul`
    list-style-type: none;
    height: 60%;
    overflow-y: scroll;
    margin: 0;
    padding: 10px;
    background-color: ${({ isUrgent }) => isUrgent ? colors.pinkLight : colors.background};
    color: ${colors.secondary};
    border-radius: 10px;

`

const CardListItem = styled.li`
    display: flex;
    width: 100%;
    justify-content: space-between;

    @media screen and (max-width: 920px){
        width: 95%;
    }
`


export { RequestInfoScreen, RequestInfoContainer, InstitutionInfo, Donation, Text, ConfirmButton, ItemsList, Bubble, CardListItem, QuantityInput}