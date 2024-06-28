import { colors } from '../../assets/config'
import styled from 'styled-components'

import { CircularProgress } from '@material-ui/core'

const Background = styled.div`
    z-index: 100;
    height: 100vh;
    width: 100vw;
    position: fixed;
    background-color: ${colors.black};
    opacity: 0.5;
    display: flex;
    align-items: center;
    justify-content: center;
`

const LoaderStyled = styled(CircularProgress)`
    &&{
        color: ${colors.primary};
    }   
`

export { Background, LoaderStyled }