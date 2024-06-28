import { TextField } from '@material-ui/core'
import styled from 'styled-components'
import colors from '../../assets/colors'

const StyledInput = styled(TextField)`
&& {

    input::-webkit-outer-spin-button,
    input::-webkit-inner-spin-button {
    -webkit-appearance: none;
}

    input[type=number] {
        -moz-appearance:textfield;
    }

    fieldset {
        border-radius: 10px;
    }

    label.Mui-focused{
        color: ${colors.primary};
    }
    
    .MuiOutlinedInput-root:hover {
        fieldset {
            border-color: ${colors.primary};
        }
    }
    
    .Mui-focused {
        fieldset {
            border-color: ${colors.primary};
        }
    }
}
`

export { StyledInput }
