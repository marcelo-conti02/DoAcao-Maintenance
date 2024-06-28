import { Checkbox } from '@material-ui/core'
import styled from 'styled-components'
import colors from '../../assets/colors'

const StyledCheckbox = styled(Checkbox)`
&& {
    &.Mui-checked {
        svg.MuiSvgIcon-root {
            color: ${colors.primary};
        }
    }
}
`

const ErrorText = styled.p`
  color: ${colors.danger};
  font-size: 12px;
`;

export { StyledCheckbox, ErrorText }
