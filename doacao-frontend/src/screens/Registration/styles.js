import colors from '../../assets/colors';
import styled from 'styled-components';
import { Button, Input, BaseScreen } from '../../components';

const RegistrationScreen = styled(BaseScreen)`
    flex-direction: column;
`
const RegistrationFormContainer = styled.div`
    max-width: 1440px;
    width: 80%;
    display: flex;
    flex-direction: column;
    background-color:#ECECEC;
    align-items: baseline;
    justify-content: space-between;
    box-shadow: inset 0px 4px 10px rgba(0, 0, 0, 0.25), 0px 4px 4px rgba(0, 0, 0, 0.25);
    border-radius: 8px;
    padding: 50px;
    margin-top: 50px;
    background-color: ${colors.white};
    
    @media (max-width: 768px) {
        padding: 15px;
        width: 90%;
    }
    `
const RegistrationForm = styled.div`
    flex: 3;
    display: flex;
    flex-wrap: wrap;
    margin: 20px 0;
    width: 100%;

    > :not(:last-child) {
        margin-bottom:20px;
    }   
`
const RegistrationFormFieldSet = styled.fieldset`
    flex: ${props => props.flex ? props.flex : 'unset'};
    display: flex;
    width: 100%;
    justify-content: space-between;
    border: none;
    padding: 0;
    margin: 0;
    
    > * {
        flex: 1;
    }
    
    > :not(:first-child) {
        margin-left: 5%;
    }

    @media (max-width: 768px) {
        flex-direction: column;

        > :not(:first-child) {
        margin-left: 0;
        margin-top: 20px;
    }
    }
    `

const Spacer = styled.span`
    flex: 1;

    @media (max-width: 768px) {
        display: none;
        }
`

const RegistrationFormPasswordGroup = styled.fieldset`
    display:flex;
    flex-direction: column;
    border: none;
    padding: 0;
    margin: 0;
`

const RegistrationFormPasswordParagraph = styled.div`
    margin-bottom: 10px;

`
const RegistrationContainerTitle = styled.div`
    max-width: 1540px;
    width: calc(80% + 100px);
    display: flex;
    align-items: center;
    flex-direction: column;
    color: ${colors.white};
    font-family: 'Montserrat', sans-serif;
    font-weight: 300;
    
    @media (max-width: 768px) {
        width: calc(90% + 30px);
    }
`
const RegistrationCancelButton = styled(Button)`
    align-self: flex-end;
`
const RegistrationTitle = styled.h2`
    font-family: 'Montserrat', sans-serif;
    font-weight: 300;

`

const FormSubtitle = styled.h3`
    font-family: 'Montserrat', sans-serif;
    font-weight: 400;

`

const RegInputCEP = styled(Input)`
    flex: 2;
`
const RegInputUF = styled(Input)`
    flex: 1;

`
const RegInputCity = styled(Input)`
    flex: 4;

`
const RegInputDistrict = styled(Input)`
    flex: 3;
`

const Container = styled.div`
    margin: 0;
    display: flex;
    flex-direction: ${({ direction }) => direction ? direction : 'row'};
    flex: ${props => props.flex ? props.flex : 'unset'};

`;

const ContainerChildrenMargin = styled(Container)`
    > :not(:first-child) {
        margin-top: 20px;
    }
`;

const ContainerCentered = styled(Container)`
    align-items: center;
  
  
    @media (max-width: 768px) {
        flex-direction: column;
    }
`;

const Paragraph = styled.p`
    text-align: ${({ align }) => align ? align : 'left'};

    @media (max-width: 768px) {
        text-align: left;
    }
`

const RegistrationSubmitButton = styled(Button)`
   && {
       margin-left: 20px;
       
       @media (max-width: 768px) {
        margin-left: 0;
        margin-top: 20px;
        width: 100%;
    }
   } 
`

export {
    RegistrationSubmitButton,
    FormSubtitle, Spacer, RegInputCEP, RegInputUF, RegInputCity, RegInputDistrict, Container, ContainerCentered, Paragraph,
    RegistrationScreen, RegistrationFormContainer, RegistrationForm, RegistrationContainerTitle, ContainerChildrenMargin,
    RegistrationCancelButton, RegistrationTitle, RegistrationFormFieldSet, RegistrationFormPasswordParagraph, RegistrationFormPasswordGroup
}