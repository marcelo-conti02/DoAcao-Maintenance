import React from 'react'
import { useHistory } from 'react-router-dom'

import { Profile, Institution, LinkToPage, ButtonMenu } from './styles'

const SideMenuInstitution = ({ children, institution, ...rest }) => {

    const { push } = useHistory()

    const handleClick = (type) => {
        push("/previewrequest", {type: type})
    }
    
    return (
        <Profile>
            <Institution>
                <span>{institution.name}</span>
            </Institution>
            <ButtonMenu size="large" onClick={ () => handleClick("produto") }>PEDIDOS DE PRODUTOS</ButtonMenu>
            <ButtonMenu size="large" onClick={ () => handleClick("serviço") }>PEDIDOS DE SERVIÇOS</ButtonMenu>
        </Profile>
    )
}
export { SideMenuInstitution }