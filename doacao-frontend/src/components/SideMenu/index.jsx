import React, { useEffect, useState } from 'react'
import { Profile, Person, Photo, LinkToPage } from './styles'
import images from '../../assets/images'
import { LOCAL_STORAGE_KEYS } from '../../enums'
import { useLocalStorage } from '../../services'

const SideMenu = ({ children, ...rest }) => {
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
        <Profile>
            <Person>
                <Photo src={images.user} alt="user" />
                <span>{userInfo.name}</span>
            </Person>

            <LinkToPage to="/solicitations">SOLICITAÇÕES</LinkToPage>
            <LinkToPage to="/informations">INFORMAÇÕES</LinkToPage>
        </Profile>
    )
}

export { SideMenu }