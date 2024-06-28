import styled from 'styled-components'
import colors from '../../assets/colors'

const Text = styled.p`
    height: 16px;
    text-align: center;
    font-size: 12px;
    min-width: 20px;
    margin: 4px;
    font-weight: 600;
    background-color: ${colors.transparent};
`
const Button = styled.button`
    height: 16px;
    border-radius: 8px;
    width: 16px;
    font-weight: 600;
    font-size: 12px;
    text-align: center;
    background-color: ${colors.buttonGrey};
    border: 0px;
`

const StyledCounter = styled.div`
    display: flex;
    flex-direction: row;
    align-items: center;
    padding: 4px;
    height: 20px;
    width: fit-content;
    max-width: 20%;
    border-radius: 8px;
    background-color: ${colors.background};
    box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.25), 0px 4px 4px rgba(0, 0, 0, 0.25);
`

export { StyledCounter, Button, Text }