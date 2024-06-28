import React, { useEffect, useState } from 'react'
import { Profile, Person, Photo, LinkToPage, MenuBox } from './styles'
import images from '../../assets/images'
import { LOCAL_STORAGE_KEYS } from '../../enums'
import { useLocalStorage } from '../../services'

import { Close, Menu } from '@material-ui/icons'

const HamburguerMenu = ({ children, startOpen = false, ...rest }) => {
    const [showMenu, setShowMenu] = useState(startOpen)

    const { getLocalStorageItem } = useLocalStorage()
    const [userInfo, setUserInfo] = useState({})

    useEffect(() => {
        const getUserInfo = async () => {
            const userInfoOnStorage = await getLocalStorageItem(LOCAL_STORAGE_KEYS.USER_INFO)
            setUserInfo(userInfoOnStorage)
        }

        getUserInfo()
    }, [getLocalStorageItem])

    return (
        <>

            <MenuBox onClick={() => setShowMenu(!showMenu)}>
                {showMenu ? <Close /> : <Menu />}
            </MenuBox>
            {
                showMenu && <Profile>
                    <Person>
                        <Photo src={images.user} alt="user" />
                        <span>{userInfo.name}</span>
                    </Person>

                    <LinkToPage to="/solicitations">SOLICITAÇÕES</LinkToPage>
                    <LinkToPage to="/informations">INFORMAÇÕES</LinkToPage>
                </Profile>
            }
        </>
    )
}

export { HamburguerMenu }