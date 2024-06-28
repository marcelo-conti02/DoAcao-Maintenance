import { Divider } from '@material-ui/core';
import styled from 'styled-components';
import colors from '../../assets/colors';
import { BaseScreen, Button } from '../../components';

export const SolicitationsScreen = styled(BaseScreen)`
    display: flex;
    flex-direction: column;
    align-items: center;

`

export const PageContent = styled.div`
    display: flex;
    width: 100%;
    @media(max-width:1100px){
        justify-content: center;
    }
`

export const SolicitationList = styled.div`
    width: 50%;
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

export const SolicitationTitle = styled.h2`
    margin-top: 20px;
`

export const SolicitationDesc = styled.span`
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