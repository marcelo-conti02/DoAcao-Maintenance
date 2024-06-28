import { Box, Divider, Modal, TextField } from '@material-ui/core';
import styled from 'styled-components';
import colors from '../../assets/colors';
import { BaseScreen, Button } from '../../components';

export const InformationsScreen = styled(BaseScreen)`
    /* padding: 0; */
    /* position: relative; */
    /* height: 100vh; */
    display: flex;
    flex-direction: column;
    align-items: center; 
    /* background-color: ${colors.background}; */

    /* @media (max-width: 1100px) {
        padding: 0
    } */
`

export const PageContent = styled.div`
    display: flex;
    width: 100%;
    @media(max-width:1100px){
        justify-content: center;
    }
`

export const InformationsList = styled.div`
    width: 50%;
    /* height: calc(100% - 120px); */
    margin-top: 20px;
    margin-left: 516px;
    background-color: ${colors.white};
    display: flex;
    flex-direction: column;
    align-items: center;
    border-radius: 10px;

    @media(max-width:1100px){
        margin-left: 0;
        margin-top: 120px;
        min-width: 100%;
    }
    
`

export const InformationsTitle = styled.h2`
    margin-top: 20%;
`

export const InformationsDesc = styled.span`
    color: ${colors.subtitle};
    
    @media(max-width:1100px){
        text-align: center;
    }
`

export const ButtonLink = styled(Button)`
    &&{
        &.MuiButton-outlined {
            color: ${colors.black};
            border-color: ${colors.buttonGrey};
            width: 480px;
            margin-bottom: 24px;
            @media(max-width:1100px){
                width: 50%;
            }
        }
    }
`

export const Line = styled(Divider)`
    && {
        margin: 50px 0;
        width: 100%;
    }
`

export const ModalCustom = styled(Modal)`
    display: flex;
    width: 100%;
    height: 100%;
    align-items: center;
    justify-content: center;
`

export const BoxModal = styled(Box)`
    width: 850px;
    height: 90%;
    background-color: ${colors.white};
    border-radius: 24px;
    display: flex;
    flex-direction: column;
    align-items: center;

    @media(max-width:1100px){
        width: 100%;
    }
`

export const BoxContent = styled.div`
    width: 80%;
    display: flex;
    flex-direction: column;
`

export const ButtonAdd = styled(Button)`
  &&{
    &.MuiButton-outlined {
        color: ${colors.black};
        border-color: ${colors.black};
        min-width: 60px;
        margin-right: 8px;
    }
  }
`

export const ModalTitle = styled.h3`
  font-size: 25px;
  font-weight: bold;
  align-self: center;
`

export const ModalDesc = styled.span`
  font-size: 15px;
  color: #060606;
  width: 100%;
  align-self: center;
  margin-bottom: 40px;
`

export const ButtonDesc = styled.span`
    font-size: 15px;
`

export const Item = styled.label`
  margin: 12px 0;
  width: 100%;
  display: flex;
`

export const ItemName = styled.span`
    border: 1px solid #B3B3B3;
    border-radius: 24px;
    width: 360px;
    min-height: 40px;
    display: flex;
    align-items: center;
    padding-left: 32px;
    margin-right: 16px;
    @media(max-width:1100px){
        width: 200px;
        padding-left: 16px
    }
`

export const ItemLimit = styled.span`
    border: 1px solid #B3B3B3;
    border-radius: 24px;
    width: 110px;
    min-height: 40px;
    display: flex;
    align-items: center;
    justify-content: center;
    margin-right: 16px;
`

export const ItemUnit = styled.span`
    border: 1px solid #B3B3B3;
    border-radius: 24px;
    width: 110px;
    padding: 0;
    min-height: 40px;
    display: flex;
    align-items: center;
    justify-content: center;
`

export const AddItemSection = styled.section`
    display: flex;
    margin: 20px 0;
    align-items: center;

    && div {
        // width: 200px;
        margin-right: 8px;
        border-radius: 16px;
    }

    @media(max-width:1100px){
        flex-direction: column;
        && div { 
            width: 100%;
            margin-bottom: 8px;
        }
    }
`

export const InputField = styled(TextField)`
    &&{
        &.MuiOutlinedInput-input {
            // border-radius: 16px;
            border: none;
        }
    }
`

export const ButtonSection = styled.section`
    display: flex;
`

export const ButtonToSvg = styled.button`
    cursor: pointer;
    background: none;
    border:none;

`

export const ItemList = styled.div`
    overflow-y: scroll;
    height: 400px;
`