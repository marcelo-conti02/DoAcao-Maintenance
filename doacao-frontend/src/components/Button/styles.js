import { colors } from '../../assets/config'
import styled from 'styled-components';
import { Button as MuiButton } from '@material-ui/core'

const StyledButton = styled(MuiButton)`
    && {
        min-width: max-content;
        border-radius: 24px;

        &.MuiButton-outlined {
            color: ${colors.secondary};
            border-color: ${colors.secondary};
        }

        &.MuiButton-text {
            color: ${colors.darkGrey};
            font-weight: 600;
        }

        &.MuiButton-contained {
            background-color: ${colors.secondary};
            color: ${colors.white};
        }

        &.Mui-disabled {
            background-color: ${colors.borderGray};
            color: ${colors.white};
        }
    }
`

export { StyledButton }