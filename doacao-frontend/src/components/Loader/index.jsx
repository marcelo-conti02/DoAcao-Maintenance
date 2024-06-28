import React, { useContext } from "react";

import { LoaderContext } from '../../contexts'

import { Background, LoaderStyled } from './styles'

const Loader = ({ children }) => {
    const { isLoading } = useContext(LoaderContext)

    return (
        <>
            {isLoading &&
                <Background>
                    <LoaderStyled />
                </Background>
            }
            {children}
        </>
    )
}

export { Loader }