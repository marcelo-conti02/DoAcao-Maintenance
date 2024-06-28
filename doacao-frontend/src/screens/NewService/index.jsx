import { NewServiceCard, PageContent, PageTitle, ServiceContent, LitsNewService,  Buttons, ListContent, NewServiceRequest } from './styles'
import { Button, HamburguerMenu, SideMenu, Input, showNotification } from '../../components'
import { LOCAL_STORAGE_KEYS } from '../../enums'
import { useLocalStorage } from '../../services'
import { useEffect, useState, useCallback} from 'react'
import { Typography } from '@material-ui/core'
import { useNewItemSevice } from '../../services'

const NewService = () => {
    const { getLocalStorageItem } = useLocalStorage()
    const [userInfo, setUserInfo] = useState({})
    const [newService, setNewService] = useState([])
    const { editServiceStatus, getPendingNewService } = useNewItemSevice()

    const getNewService = useCallback(async () => {
        const response = await getPendingNewService()
        setNewService(response.data)
    }, [getPendingNewService])    

    const handleSubmitService = (newService) => {
        const service = {
            name: newService.service,
            id: newService.idServiceSolicitation,
            status: "A",
            limitService: ""
        }

        editServiceStatus(service)
        .then(() => {
            showNotification('Novo serviço criado com sucesso!')
            getNewService()
        })
    }

    const handleDeclineService = (newService) => {
        const service = {
            name: newService.service,
            id: newService.idServiceSolicitation,
            status: "I",            
        }

        editServiceStatus(service)
        .then(() => {
            showNotification('Serviço recusado com sucesso!')
            getNewService()
        })
    }

    const setServiceLimit = (service, limit) => {
        newService.forEach((check) => {
            if (check === service) check.LimitService = limit
        })
    }

    useEffect(() => {
        const getUserInfo = async () => {
        const userInfoOnStorage = await getLocalStorageItem(LOCAL_STORAGE_KEYS.USER_INFO)
        setUserInfo(userInfoOnStorage)
        }
        
        getUserInfo()
        getNewService()
        }, [] )
       
    return (
        <NewServiceCard>            
           <PageContent>
                <SideMenu admin={userInfo} />
                <HamburguerMenu startOpen={true} admin={userInfo}/>
                <ServiceContent>
                    <PageTitle>Solicitações de novos serviços</PageTitle> 
                    {                                 
                        newService && newService.map((service, index) => (
                            <LitsNewService key ={index}>  
                                <NewServiceRequest>
                                    <Typography variant='body2'> 
                                        Nome da Instituição: {service.idInstitution}                                         
                                    </Typography>  
                                    <Typography variant='body2'>
                                        Serviço: {service.service}
                                    </Typography>
                                    <ListContent>
                                    </ListContent>
                                        <Buttons>                                                                        
                                            <Input type="number" value={service.serviceLimit} size="small" variant="outlined" placeholder='Limite do item' onChange={e => setServiceLimit(e,e.value)} style={{ marginTop: "10px", marginRight:"90px" }} />
                                            <Button variant='contained' onClick={() => handleSubmitService(service) }>Aceitar</Button> 
                                            <Button variant='outlined' onClick={() => handleDeclineService(service) } >Recusar</Button>
                                        </Buttons>
                                </NewServiceRequest>
                            </LitsNewService>
                        ))
                    }                       
                </ServiceContent>
            </PageContent>
        </NewServiceCard>
    )
}
export { NewService }           