import { Link } from 'react-router-dom';
import styled from 'styled-components';

export const Profile = styled.section`
    width: 380px;
    height: 100vh;
    background-color: #ECECEC;
    display:flex;
    flex-direction: column;
    box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
    position: fixed;
    
    @media(max-width:1100px){
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

