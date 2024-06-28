import { colors } from '../../assets/config'
import styled from 'styled-components';

const Container = styled.div`
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
`

const Title = styled.h2`
    width: 50%;
    text-align: center;
`

const Paragraph = styled.p`
    width: 50%;
    text-align: justify;
`

const Button = styled.button`
  background: transparent;
  border-radius: 3px;
  border: 2px solid ${colors.black};
  color: ${colors.black};
  margin: 0 1em;
  padding: 0.25em 1em;
`

export { Container, Title, Paragraph, Button }