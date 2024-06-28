import React, { useEffect, useState } from 'react';
import { BrowserRouter } from 'react-router-dom';
import ReactNotification from 'react-notifications-component'
import Axios from 'axios';

import { Router } from './routing';
import { GlobalStyle } from './assets/styles';
import { UserContext, LoaderContext, ModalContext } from './contexts'
import { LOCAL_STORAGE_KEYS } from './enums'
import { useLocalStorage } from './services'
import { Loader, BaseModal } from './components'

import 'react-notifications-component/dist/theme.css'

const App = () => {
  const { getLocalStorageItem, removeLocalStorageItem, setLocalStorageItem } = useLocalStorage()

  const [userInfo, setUserInfo] = useState({})
  const [isLoading, setIsLoading] = useState(false)
  const [showModal, setShowModal] = useState(false)
  const [modalChildren, setModalChildren] = useState(null)
  const [waitingUserLoggedConfirmation, setWaitingUserLoggedConfirmation] = useState(true)

  Axios.interceptors.request.use(requestConfig => {
    setIsLoading(true)
    return requestConfig
  }, error => {
    setIsLoading(false)
    return Promise.reject(error)
  })

  Axios.interceptors.response.use(response => {
    setIsLoading(false)
    return response
  }, error => {
    setIsLoading(false)
    return Promise.reject(error)
  })

  useEffect(() => {
    const getUserInfo = async () => {
      const userInfoOnStorage = await getLocalStorageItem(LOCAL_STORAGE_KEYS.USER_INFO)
      setUserInfo(userInfoOnStorage)
      setWaitingUserLoggedConfirmation(false)
    }

    getUserInfo()
  }, [getLocalStorageItem])

  const logout = () => {
    setUserInfo({})
    removeLocalStorageItem(LOCAL_STORAGE_KEYS.USER_INFO)
  }

  const saveUserLogin = (userInfo) => {
    setUserInfo(userInfo)
    setLocalStorageItem(LOCAL_STORAGE_KEYS.USER_INFO, userInfo)
  }

  const loaderProviderValue = { isLoading, setIsLoading }

  const userProviderValue = {
    userInfo, logout, saveUserLogin
  }

  const modalProviderValue = {
    openModal: children => {
      setModalChildren(children)
      setShowModal(true)
    },
    closeModal: () => {
      setShowModal(false)
      setModalChildren(null)
    },
  }

  return (
    <BrowserRouter>
      {
        !waitingUserLoggedConfirmation &&
        <LoaderContext.Provider value={loaderProviderValue}>
          <UserContext.Provider value={userProviderValue}>
            <ModalContext.Provider value={modalProviderValue} >
              <BaseModal children={modalChildren} open={showModal} onClose={modalProviderValue.closeModal} />
              <GlobalStyle />
              <ReactNotification />
              <Loader>
                <Router />
              </Loader>
            </ModalContext.Provider>
          </UserContext.Provider>
        </LoaderContext.Provider>
      }
    </BrowserRouter>
  );
}

export default App;