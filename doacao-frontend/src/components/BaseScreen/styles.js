import styled from 'styled-components';
import colors from '../../assets/colors';

const headerHeight = 120
const mobileHeaderHeight = 80
const footerHeight = 56
const mobileFooterHeight = 86

const BaseScreenStyled = styled.main`
    position: relative;
    padding-top: ${headerHeight}px;
    padding-bottom: ${footerHeight}px;
    min-height: calc(100vh - ${headerHeight}px - ${footerHeight}px);
    display: flex;
    align-items: center;
    background-color: ${colors.primary};
    
    @media (max-width: 1000px) {
        padding-top: 130px;
    }

    @media (max-width: 550px) {
        padding-top: ${mobileHeaderHeight}px;
        padding-bottom: ${mobileFooterHeight}px;
        min-height: calc(100vh - ${mobileHeaderHeight}px - ${mobileFooterHeight}px);
    }
`

export { BaseScreenStyled }