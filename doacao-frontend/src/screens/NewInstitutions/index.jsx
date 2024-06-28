import React, { useState } from 'react'

import { Typography } from '@material-ui/core'
import { PageContent, SolicitationsContent, NewInstitutionsScreen, ListContainer, PageTitle, InstitutionName, NewInstitution, Contact, Description, ListContent, Buttons, Divider } from './styles'
import { Button, HamburguerMenu, SideMenu } from '../../components'
import { useEffect } from 'react'
import service from '../../services/InstitutionService'

const NewInstitutions = () => {

    const [pendingSolicitations, setPendingSolicitations] = useState();

    const handleAccept = (institution) => {
        service.editStatusSolicition({
            id: institution.id_institution,
            status: 'A'
        }).then(res => {
            const newPendingSolicitations = pendingSolicitations.filter(inst => inst.id_institution !== institution.id_institution)
            setPendingSolicitations(newPendingSolicitations)
        })
    }
    const handleDecline = (institution) => {
        service.editStatusSolicition({
            id: institution.id_institution,
            status: 'I'
        }).then(res => {
            const newPendingSolicitations = pendingSolicitations.filter(inst => inst.id_institution !== institution.id_institution)
            setPendingSolicitations(newPendingSolicitations)
        })
    }

    useEffect(() => {
        service.listPendingInstitutions().then(response => {
            setPendingSolicitations(response.data)
        })
    }, [])

    return (
        <NewInstitutionsScreen exclusiveToAdmin={true}>
            <PageContent>
                <SideMenu />
                <HamburguerMenu />
                <SolicitationsContent>

                    <PageTitle>Novas Instituições</PageTitle>
                    {
                        pendingSolicitations && pendingSolicitations.map(institution => (
                            <ListContainer>
                                <NewInstitution>
                                    <InstitutionName>{institution.name}</InstitutionName>
                                    <Divider />
                                    <ListContent>
                                        <Contact>
                                            <Typography variant='body2'>
                                                {institution.email}
                                            </Typography>
                                            <Typography variant='body2'>
                                                {institution.socialMedia}
                                            </Typography>
                                            <Typography variant='body2'>
                                                {institution.phone}
                                            </Typography>
                                            <Typography variant='body2'>
                                                {institution.phone}
                                            </Typography>
                                        </Contact>
                                        <Description>
                                            <Typography component='body2' textAlign='left' variant='body2'>
                                                {institution.description}
                                            </Typography>
                                        </Description>
                                    </ListContent>
                                    <Buttons>
                                        <Button variant='contained' onClick={() => handleAccept(institution)}>Aceitar</Button>
                                        <Button variant='outlined' onClick={() => handleDecline(institution)}>Recusar</Button>
                                    </Buttons>
                                </NewInstitution>
                            </ListContainer>
                        ))
                    }
                </SolicitationsContent>
            </PageContent>
        </NewInstitutionsScreen>
    )
}

export { NewInstitutions }