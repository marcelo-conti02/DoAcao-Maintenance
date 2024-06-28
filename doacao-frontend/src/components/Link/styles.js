import { colors } from '../../assets/config'
import styled from 'styled-components';
import { Link as MuiLink } from '@material-ui/core'

const StyledLink = styled(MuiLink)`
    && {
        color: ${colors.primary};
        text-decoration: underline ${colors.primary};
        cursor: pointer;
    }
`

export { StyledLink }