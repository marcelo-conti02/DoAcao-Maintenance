import React from 'react'

import { Header, ImageLogo } from '../../assets/styles.js'
import images from '../../assets/images'
import { PageContent, InformationsScreen, InformationsList, ButtonLink, Line, InformationsTitle, InformationsDesc, BoxModal, ModalCustom, ButtonAdd, ModalTitle, ModalDesc, Item, ButtonDesc, ItemName, ItemUnit, BoxContent, ItemLimit, AddItemSection, InputField, ButtonSection, ButtonToSvg, ItemList } from './styles';
import { HamburguerMenu, SideMenu } from '../../components'
import { useHistory } from 'react-router-dom';
import { useState, useEffect } from 'react';
import { useItemService, useServiceService } from '../../services'
import { Icon, InputLabel, MenuItem, Select, TextField } from '@material-ui/core';
import CheckCircleIcon from '@material-ui/icons/CheckCircle';
import DeleteIcon from '@material-ui/icons/Delete';
import { LOCAL_STORAGE_KEYS } from '../../enums'
import { useLocalStorage } from '../../services'

const Informations = () => {

  const { push } = useHistory()
  const { getItems, createItem } = useItemService()
  const { getServices, createService } = useServiceService()

  const [showItensInfo, setShowItensInfo] = useState(false)
  const [itens, setItens] = useState([])
  const [addItem, setAddItem] = useState(false)
  const [itemName, setItemName] = useState("")
  const [itemLimit, setItemLimit] = useState("")
  const [itemUnit, setItemUnit] = useState("")

  const [showServiceInfo, setShowServiceInfo] = useState(false)
  const [services, setServices] = useState([])
  const [addService, setAddService] = useState(false)
  const [serviceName, setServiceName] = useState("")
  const [serviceLimit, setServiceLimit] = useState("")

  const { getLocalStorageItem } = useLocalStorage()
  const [userInfo, setUserInfo] = useState({})

  useEffect(() => {
    getItems()
      .then(result => {
        setItens(result.data)
      })
  }, [])

  useEffect(()=> {
    getServices()
      .then(result => {
        setServices(result.data)
      })
  }, [])

  useEffect(() => {
    const getUserInfo = async () => {
      const userInfoOnStorage = await getLocalStorageItem(LOCAL_STORAGE_KEYS.USER_INFO)
      setUserInfo(userInfoOnStorage)
    }

    getUserInfo()
  }, [getLocalStorageItem])


  const handleChange = (event) => {
    setItemUnit(event.target.value);
  };

  const handleSubmitItem = () => {
    const item = {
      name: itemName,
      limitItens: itemLimit,
      unitMeasurement: itemUnit
    }

    createItem(item)
      .then(() => {
        cleanFields()
        setItens([...itens, item])
        setAddItem(false)
      })
  }

  const handleSubmitService = () => {
    const service = {
      name: serviceName,
      limitService: serviceLimit
    }

    createService(service)
      .then(() => {
        cleanFields()
        setServices([...services, service])
        setAddService(false)
      })
  }

  const cleanFields = () => {
    setItemLimit("")
    setItemName("")
    setItemUnit("")
    setServiceLimit("")
    setServiceName("")
  }

  return (
    <InformationsScreen>

      <PageContent >
        <SideMenu admin={userInfo} />
        <HamburguerMenu startOpen={true} admin={userInfo} />

        <InformationsList>
          <InformationsTitle>INFORMAÇÕES</InformationsTitle>
          <Line />

          <ButtonLink onClick={() => setShowItensInfo(true)} variant='outlined'>Itens para Pedidos</ButtonLink>
          <ButtonLink onClick={() => setShowServiceInfo(true)} variant='outlined'>Serviços para Pedidos</ButtonLink>
        </InformationsList>
      </PageContent>

      <ModalCustom open={showItensInfo} onClose={() => setShowItensInfo(false)} >
        <BoxModal>
          <BoxContent>

            <ModalTitle>ITENS</ModalTitle>
            <ModalDesc>Aqui você pode verificar e alterar a quantidade de itens fixos para as instituições</ModalDesc>
            <label>
              <ButtonAdd variant='outlined' onClick={() => setAddItem(true)}>+</ButtonAdd>
              <ButtonDesc>Adicionar item</ButtonDesc>
            </label>
            {
                addItem && (
                  <AddItemSection>
                    <InputField type="text" value={itemName} variant="outlined" placeholder='Nome do item' onChange={e => setItemName(e.target.value)} />
                    <InputField type="number" value={itemLimit} variant="outlined" placeholder='Limite do item' onChange={e => setItemLimit(e.target.value)} />
                    <InputLabel id='item'>Unidade do item</InputLabel>
                    <Select 
                      labelId='item'
                      value={itemUnit}
                      onChange={handleChange}
                    >
                      <MenuItem value='kg'>kg</MenuItem>
                      <MenuItem value='Unidade'>Unidade</MenuItem>
                    </Select>
                    <ButtonSection>
                      <ButtonToSvg disabled={!itemUnit || !itemLimit || !itemName} onClick={handleSubmitItem} >
                        <CheckCircleIcon />
                      </ButtonToSvg>
                      <ButtonToSvg>
                        <DeleteIcon onClick={cleanFields} />
                      </ButtonToSvg>
                    </ButtonSection>
                  </AddItemSection>
                )
            }
            
            <ItemList>
            {
              itens && itens.map(item => (
                <Item key={item.id}>
                  <ItemName>{item.name}</ItemName>
                  <ItemLimit>{item.limitItens}</ItemLimit>
                  <ItemUnit>{item.unitMeasurement}</ItemUnit>
                </Item>
              ))
            }
            </ItemList>

          </BoxContent>
        </BoxModal>
      </ModalCustom>
      
      <ModalCustom open={showServiceInfo} onClose={() => setShowServiceInfo(false)} >
        <BoxModal>
          <BoxContent>

            <ModalTitle>SERVIÇOS</ModalTitle>
            <ModalDesc>Aqui você pode verificar e alterar os serviços para as instituições</ModalDesc>
            <label>
              <ButtonAdd variant='outlined' onClick={() => setAddService(true)}>+</ButtonAdd>
              <ButtonDesc>Adicionar serviço</ButtonDesc>
            </label>
            {
                addService && (
                  <AddItemSection>
                    <InputField type="text" value={serviceName} variant="outlined" placeholder='Nome do serviço' onChange={e => setServiceName(e.target.value)} />
                    <InputField type="number" value={serviceLimit} variant="outlined" placeholder='Limite do serviço' onChange={e => setServiceLimit(e.target.value)} />
                    
                    <ButtonSection>
                      <ButtonToSvg disabled={!serviceName || !serviceLimit} onClick={handleSubmitService} >
                        <CheckCircleIcon />
                      </ButtonToSvg>
                      <ButtonToSvg>
                        <DeleteIcon onClick={cleanFields} />
                      </ButtonToSvg>
                    </ButtonSection>
                  </AddItemSection>
                )
            }
            <ItemList>

            {
              services && services.map(item => (
                <Item key={item.id}>
                  <ItemName>{item.name}</ItemName>
                  <ItemUnit>{item.limitService}</ItemUnit>
                </Item>
              ))
            }
            </ItemList>

          </BoxContent>
        </BoxModal>
      </ModalCustom>

    </InformationsScreen>
  )
}

export { Informations }
