import styled from 'styled-components';
import colors from '../../assets/colors'

const TabsContainer = styled.div`
    width: 100%;
`

const OptionsContainer = styled.div`
    display: flex;
    align-items: center;
    justify-content: center;
`

const TabOption = styled.button`
    background: none;
	color: inherit;
	border: none;
	padding: 0;
	font: inherit;
	cursor: pointer;
	outline: inherit;

    background-color: ${colors.form};
    box-shadow: 0px 2px 10px 0px rgb(0 0 0 / 50%) inset;
    padding: 10px;
    border-radius: 12px 12px 0 0;
    font-size: 18px;
    width: 300px;
    
    &.--active {
        background-color: ${colors.secondary};
        color: ${colors.white}
    }
`

export { TabsContainer, OptionsContainer, TabOption }