import { Link, Redirect } from 'react-router-dom';
import styled from 'styled-components';
import { Button as MuiButton } from '@material-ui/core'
import { colors } from '../../assets/config'

export const MenuBox = styled.span`
    margin: 100px 0 92px 16px;
    z-index: 10;
    left: 0;
    align-self: initial;
    @media(min-width:900px){
        display:none;
    }
    position: absolute;
`

export const Profile = styled.section`
    width: 380px;
    background-color: #ECECEC;
    margin-right: 1px solid black;
    display:flex;
    flex-direction: column;
    box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
    position: absolute;
    top: 0;
    left: 0;
    z-index: 8;
    height: 100%;

    @media(min-width:900px){
        display:none;
    }
`

export const Institution = styled.div`
    display: flex;
    flex-direction: column;
    margin: 130px 0 92px 0;
    align-items: center;
    font-size: 20px;
`

export const LinkToPage = styled(Link)`
    font-size: 20px;
    color: #303030;
    margin-left: 54px;
    margin-bottom: 42px;
    text-decoration:none;
    font-weight: 700;

    &:hover {
        text-decoration:underline;
    }
`
export const ButtonMenu = styled(MuiButton)`
&& {
    min-width: 210px;

    &.MuiButton-text {
        color: ${colors.darkGrey};
        font-weight: 600;
    }
    &.MuiButton-contained {
        background-color: ${colors.secondary};
        color: ${colors.white};
    }
}
`
