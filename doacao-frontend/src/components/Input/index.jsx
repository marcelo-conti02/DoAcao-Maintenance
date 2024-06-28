import React from 'react'
import { StyledInput } from './styles'

const STANDARD_MAX_LENGTH = 99

const Input = ({ sendToBackend, validate, onChange, ...rest }) => {
    const handleChange = (target) => {
        const { value, maxLength } = target

        if (value.length > maxLength) {
            target.value = value.substring(0, value.length - 1)
        }

        onChange(target)

    }
    return <StyledInput {...rest} onChange={({ target }) => handleChange(target)} inputProps={{ maxLength: rest.maxLength || STANDARD_MAX_LENGTH }} />
}

export { Input }