import styled from 'styled-components';
import colors from '../../assets/colors';
import { Button, Link, BaseScreen } from '../../components';

const LoginScreen = styled(BaseScreen)`
`

const LoginFormContainer = styled.div`
    margin: auto;
    width: 70%;
    max-width: 1024px;
    display: flex;
    align-items: baseline;
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

const LoginForm = styled.div`
    flex: 3;
    display: flex;
    flex-direction: column;
    width: calc(100% - 4vw);
    padding: 2vw;

    > :not(:last-child) {
        margin-bottom: 20px;
    }

`

const SignUpBlock = styled.div`
    flex: 3;
    display: flex;
    flex-direction: column;
    align-items: flex-start;
    padding: 2vw;
`

const SignUpButton = styled(Button)`
    align-self: flex-end;
`

const LoginButton = styled(Button)`
    @media screen and (max-width: 500px) {
        width: 100%;
    }
`

const ForgotPasswordLink = styled(Link)`
    @media screen and (max-width: 500px) {
        width: 100%;
        text-align: center;
    }
`

export { LoginScreen, LoginFormContainer, LoginForm, SignUpBlock, SignUpButton, LoginButton,ForgotPasswordLink }