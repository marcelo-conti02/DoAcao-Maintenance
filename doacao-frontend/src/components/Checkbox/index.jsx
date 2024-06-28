import React from 'react'
import { StyledCheckbox, ErrorText } from './styles'

const ErrorMessage = ({ error, helperText }) => {
    if (error) {
        return <ErrorText>{helperText}</ErrorText>
    } else {
        return null
    }
}

const Checkbox = ({ validate, error, helperText, onChange, id, label, ...rest }) => {
    return (
        <div>
            <div>
                <StyledCheckbox id={id} {...rest} onChange={({ target }) => onChange(target)} />
                <label htmlFor={id}>
                    {label}
                </label>
            </div>
            <ErrorMessage error={error} helperText={helperText} />
        </div>
    )
}

export { Checkbox }