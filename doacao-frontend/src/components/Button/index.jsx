import React from 'react'
import { StyledButton } from './styles'

const Button = ({ children, ...props }) => {
    return (
        <StyledButton {...props}>
            {children}
        </StyledButton>
    )
}

export { Button }