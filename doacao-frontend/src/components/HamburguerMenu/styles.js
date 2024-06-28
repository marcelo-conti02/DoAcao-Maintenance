import { Link } from 'react-router-dom';
import styled from 'styled-components';

export const MenuBox = styled.span`
    margin: 40px 0 92px 16px;
    z-index: 10;
    
    @media(min-width:1100px){
        display:none;
    }
    
    position: absolute;
    left: 0px;
`

export const Profile = styled.section`
    width: calc(100% - 20px);
    max-width: 380px;
    margin-top: 80px;
    background-color: #ECECEC;
    margin-right: 1px solid black;
    display:flex;
    flex-direction: column;
    box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
    position: absolute;
    top: 0;
    left: 0;
    z-index: 5;
    height: 100%;

    @media(min-width:1100px){
        display:none;
    }
`

export const Person = styled.div`
    display: flex;
    flex-direction: column;
    margin: 50px 0 92px 0;
    align-items: center;
    font-size: 20px;
`

export const Photo = styled.img`
    width: 108px;
    height: 108px;
    margin-bottom: 28px;
    border-radius: 5px;
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

