import colors from '../../assets/colors';
import styled from 'styled-components';
import { BaseScreen, Button, Input } from '../../components';

const InstitutionInterestScreen = styled(BaseScreen)`
    padding: 0;
    position: relative;
    height: 100%;
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

const InterestFormContainer = styled.div`
    display: flex;
    width: 100%;
    display: flex-row;
    justify-content: space-around;
    padding: 25px;
    margin-top: 120px;
    max-height: calc(100vh - 120px - 2*25px);
`

const InterestForm = styled.div`
    display: flex;
    flex-direction: column;
    align-items: center;
    width: 60%;
    background-color: ${colors.form};
    box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.25), 0px 4px 4px rgba(0, 0, 0, 0.25);
    border-radius: 24px;
    padding: 25px;
    max-height: 100%;
    overflow-y: scroll;
    overflow-x: hidden;

    @media screen and (max-width: 1100px){
        width: 80%;
    }
`

const InterestContainer = styled.div`
    width: 90%;
    background-color: ${colors.form};
    box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.25), 0px 4px 4px rgba(0, 0, 0, 0.25);
    border-radius:24px;
    padding: 25px;
    margin-top: 15px;
`

const Divider = styled.div`
    background-color: #BCBCBC;
    height: 2px;
    margin: 8px;
`

export { InstitutionInterestScreen, PageContent, InterestFormContainer, InterestContainer, InterestForm, Divider }
