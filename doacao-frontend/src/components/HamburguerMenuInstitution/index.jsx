import React from 'react'
import { Profile, Institution, MenuBox, ButtonMenu } from './styles'
import { useState } from 'react'
import { useHistory } from 'react-router-dom'

import { Close, Menu } from '@material-ui/icons'

const HamburguerMenuInstitution = ({ children, institution, ...rest }) => {
    const [showMenu, setShowMenu] = useState(false)

    const { push } = useHistory()

    const handleClick = (type) => {
        push("/previewrequest", { type: type })
        setShowMenu(false)
    }

    return (
        <>

            <MenuBox onClick={() => setShowMenu(!showMenu)}>
                {showMenu ? <Close /> : <Menu />}
            </MenuBox>
            {
                showMenu && <Profile>
                    <Institution>
                        <span>{institution.name}</span>
                    </Institution>

                    <ButtonMenu size="large" onClick={() => handleClick("produto")}>PEDIDOS DE PRODUTOS</ButtonMenu>
                    <ButtonMenu size="large" onClick={() => handleClick("serviço")}>PEDIDOS DE SERVIÇOS</ButtonMenu>
                </Profile>
            }
        </>
    )
}

export { HamburguerMenuInstitution }