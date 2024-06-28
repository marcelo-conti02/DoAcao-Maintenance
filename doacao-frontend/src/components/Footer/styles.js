import styled from "styled-components"
import colors from '../../assets/colors'

export const StyledFooter = styled.footer`
    width: calc(100% - 40px);
    position: fixed;
    bottom: 0;
    height: 55px;
    display: flex;
    padding: 8px 20px;
    justify-content: center;
    flex: 1;
    align-items: center;
    background-color: ${colors.form};
    z-index: 1;

    @media (max-width: 700px) {
        height: 40px;
    }
`

export const JesusImage = styled.img`
    margin-right: 20px;
    border-radius: 14px;
    height: 55px;

    @media (max-width: 700px) {
        height: 40px;
    }
`

export const Text = styled.p`
    color: ${colors.primary};
    align-self: center;
    font-weight: 700;
`