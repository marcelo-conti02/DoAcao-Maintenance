import { createGlobalStyle } from 'styled-components'
import styled from 'styled-components';
import colors from './colors';
import { Button } from '../components';
import { StylesProvider } from '@material-ui/core';

const GlobalStyle = createGlobalStyle`
body {
  margin: 0;
  height: 100vh;
  font-family: Roboto, Helvetica, sans-serif;
  background-color: ${colors.background};
}

.root {
  height: 100%;
}

* {
        ::-webkit-scrollbar {
          height: 4px;
          height: 4px;
        }

      /* Track */
        ::-webkit-scrollbar-track {
          background: ${colors.softWhite};
        }

      /* Handle */
        ::-webkit-scrollbar-thumb {
          background: #c9c9c9;
          box-shadow: 0px 0px 3px 0px rgba(0,0,0,0.6) inset;
          border-radius: 10px;
        }
        
        /* Handle on hover */
        ::-webkit-scrollbar-thumb:hover {
          background: #a5a3a3;
        }
  }


`

const Header = styled.header`
  position: fixed;
  z-index: 10;
  top: 0;
  width: 100%;
  display: flex;
  align-items: center;
  justify-content: center;
  padding: 20px 0;
  box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25), 0px 4px 4px rgba(0, 0, 0, 0.25);
  background-color: ${colors.form};
`
const ImageLogo = styled.img`
`
const HomeButton = styled(Button)`
float: left;
`

/*const FormTitle = styled.h2`
  margin: 0;
  color: ${colors.primary};
`*/

const ActionsContainer = styled.div`
  display: flex;
  justify-content: flex-end;
  align-items: center;
  gap: 10px;

  @media (max-width: 500px) {
    flex-direction: column-reverse;
  }
`

const DividerContainer = styled.div`
  flex: 1;
  display: flex;
  align-items: center;
  justify-content: center;
  align-self: center;
`

const Divider = styled.div`
  background-color: ${colors.secondary};
  width: 1px;
  height: 250px;
  margin: 25px;

  @media (max-width: 1000px) {
    background-color: ${colors.black};
    width: 60vw;
    height: 1px;
    
  }
`

const Description = styled.p`
`

const PrimaryButton = styled(Button)({})

const SecondaryButton = {
  textTransform: "none",
  textTdecoration: "underline"
}

const SaveButton = {
  color: colors.darkGrey,
  fontWeight: 600,
  backgroundColor: "#0AD1A1"
}

const CancelButton = {
  color: colors.darkGrey,
  fontWeight: 600,
  backgroundColor: "#EF6B6B"
}

const ButtonContainer = styled.div`
  display: flex;
  flex-direction: row;
  padding: 2%;
  justify-content: space-around;

  @media screen and (max-width: 1000px) {
    flex-direction: column;
  }
`

const PageTitle = styled.h1`
`
const PageSubtitle = styled.h2`
  
`
const FormTitle = styled.h3`
  font-size: 1.5em;
  font-weight: 600;
  color: ${colors.darkGrey};
  padding: 8px;
  margin: 0;
  text-align: center;
`
const FormSubtitle = styled.h4`
  font-size: 1.25em;
  font-weight: 500;
  color: ${colors.mediumGrey};
  padding: 6px;
  margin: 0;
  text-align: center;
`
const ItemTitle = styled.h5`
  font-size: 1.2em;
  color: ${colors.darkGrey};
  padding: 5px;
  margin: 0;
  font-weight: 600;
`
const ItemSubtitle = styled.h6`
  font-size: 1em;
  color: ${colors.mediumGrey};
  padding: 2.5px;
  margin: 0;
  font-weight: 500;
`
const Paragraph = styled.p`
font-size: 1em;
  color: ${colors.darkGrey};
  padding: 1px;
  margin: 0;
  font-weight: 500;
`
const Observation = styled.p``
const Explanation = styled.p`
  font-size: 1.2em;
  color: ${colors.mediumGrey};
  padding: 5px;
  margin: 0;
  font-weight: 600;
`

export { GlobalStyle, Header, ImageLogo, FormTitle, ActionsContainer, Description, DividerContainer, Divider }
export { ButtonContainer, HomeButton, PrimaryButton, SecondaryButton, SaveButton, CancelButton }
export { PageTitle, PageSubtitle, FormSubtitle, ItemTitle, ItemSubtitle, Paragraph, Observation, Explanation }