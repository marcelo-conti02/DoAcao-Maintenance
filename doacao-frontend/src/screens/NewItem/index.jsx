import { NewItemCard, PageContent, PageTitle, ItemContent, LitsNewItem, Buttons, ListContent, NewItemRequest } from './styles'
import { Button, HamburguerMenu, SideMenu, Input, showNotification } from '../../components'
import { LOCAL_STORAGE_KEYS } from '../../enums'
import { useLocalStorage } from '../../services'
import { useEffect, useState, useCallback } from 'react'
import { Typography } from '@material-ui/core'
import { useNewItemSevice } from '../../services'

const NewItem = () => {
    const { getLocalStorageItem } = useLocalStorage()
    const [userInfo, setUserInfo] = useState({})
    const [newItem, setNewItem] = useState([])
    const { getPendingNewItem, editItemStatus } = useNewItemSevice()

    const getNewItem = useCallback(async () => {
        const response = await getPendingNewItem()
        setNewItem(response.data)
        console.log("Response: ", response.data)
    }, [getPendingNewItem])

    const handleSubmitItem = (newItem) => {
        const item = {
            name: newItem.item,
            id: newItem.idItemSolicitation,
            status: "A",
            limitItens: newItem.limitItens,
            unitMeasurement: newItem.unitMeasurement,
        }

        editItemStatus(item)
            .then(() => {
                showNotification('Novo item criado com sucesso!')
                getNewItem()
            })
    }

    const handleDeclineItem = (newItem) => {
        const item = {
            name: newItem.item,
            id: newItem.idItemSolicitation,
            status: "I",
        }

        editItemStatus(item)
            .then(() => {
                showNotification('Item recusado com sucesso!')
                getNewItem()
            })
    }

    const setItemLimit = (idItemSolicitation, limit) => {
        setNewItem(prev => {
            const itemIndex = prev.findIndex(solicitation => solicitation.idItemSolicitation === idItemSolicitation)
            prev[itemIndex].limitItens = limit

            return [...prev]

        })
    }

    const setItemUnit = (idItemSolicitation, unit) => {
        setNewItem(prev => {
            const itemIndex = prev.findIndex(solicitation => solicitation.idItemSolicitation === idItemSolicitation)
            prev[itemIndex].unitMeasurement = unit

            return [...prev]
        })
    }

    useEffect(() => {
        const getUserInfo = async () => {
            const userInfoOnStorage = await getLocalStorageItem(LOCAL_STORAGE_KEYS.USER_INFO)
            setUserInfo(userInfoOnStorage)
        }

        getUserInfo()
        getNewItem()
    }, [])

    return (
        <NewItemCard>
            <PageContent>
                <SideMenu admin={userInfo} />
                <HamburguerMenu startOpen={true} admin={userInfo} />
                <ItemContent>
                    <PageTitle>Solicitações de novos itens</PageTitle>
                    {
                        newItem && newItem.map((item, index) => (
                            <LitsNewItem key={index}>
                                <NewItemRequest>
                                    <Typography variant='body2'>
                                        Nome da Instituição: {item.idInstitution}
                                    </Typography>
                                    <Typography variant='body2'>
                                        Item: {item.item}
                                    </Typography>
                                    <ListContent>
                                    </ListContent>
                                    <Buttons>
                                        <Input type="text" value={item.itemUnit} size="small" variant="outlined" placeholder='Unidade de Medida' onChange={e => setItemUnit(item.idItemSolicitation, e.value)} style={{ marginTop: "10px" }} />
                                        <Input type="number" value={item.itemLimit} size="small" variant="outlined" placeholder='Limite do item' onChange={e => setItemLimit(item.idItemSolicitation, e.value)} style={{ marginTop: "10px", marginRight: "90px" }} />
                                        <Button variant='contained' onClick={() => handleSubmitItem(item)}>Aceitar</Button>
                                        <Button variant='outlined' onClick={() => handleDeclineItem(item)}>Recusar</Button>
                                    </Buttons>
                                </NewItemRequest>
                            </LitsNewItem>
                        ))
                    }
                </ItemContent>
            </PageContent>
        </NewItemCard>
    )
}
export { NewItem }           