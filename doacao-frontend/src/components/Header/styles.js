import styled from 'styled-components';
import { Button } from '../'
import colors from '../../assets/colors';

const HeaderStyled = styled.header`
  height: 80px;
  width: 100%;
  position: fixed;
  z-index: 10;
  top: 0;
  width: 100%;
  display: flex;
  align-items: center;
  justify-content: center;
  padding: 20px;
  box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25), 0px 4px 4px rgba(0, 0, 0, 0.25);
  background-color: ${colors.form};
  
  @media screen and (max-width: 920px) {
    height: 40px;
    justify-content: flex-start;
  }

`

const ImageLogo = styled.img`
    cursor: pointer;
    width: 250px;


  @media screen and (max-width: 920px) {
      width: 150px;
      margin-left: 20px;
  } 
`

const HeaderAction = styled(Button)`
    && {
        min-width: fit-content;
        margin-right: 10px;
        position: absolute;
        right: 60px;
}
`

const HeaderActionSecondary = styled(Button)`
    && {
        min-width: fit-content;
        margin-right: 10px;
        position: absolute;
        right: 120px;
}
`

const ActionsContainer = styled.div`
  display: flex;
  align-items: center;
`

export { HeaderStyled, ImageLogo, HeaderAction, ActionsContainer, HeaderActionSecondary }