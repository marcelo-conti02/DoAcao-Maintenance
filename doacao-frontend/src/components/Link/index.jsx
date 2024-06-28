import React from 'react'
import { StyledLink } from './styles'

const Link = ({ children, ...rest }) => {
    return (
        <StyledLink {...rest}>
            {children}
        </StyledLink>
    )
}

export { Link }