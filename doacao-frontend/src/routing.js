import React from 'react';
import { Switch, Route } from 'react-router-dom'

import { Login, Registration, HomeAdmin, Request, PreviewRequest, NewInstitutions, Home, Solicitations, Informations, UrgentOrders, RequestInfo, NewItem, NewService, InstitutionInterest } from './screens/'
import { ROUTES } from './enums'

const Router = () => {
	return (
		<Switch>
			<Route exact path={ROUTES.REQUEST.path} component={ Request } />
			<Route exact path={ROUTES.PREVIEW_REQUEST.path} component={ PreviewRequest } />
			<Route exact path={ROUTES.INTEREST.path} component={ InstitutionInterest} />
			<Route exact path={ROUTES.LOGIN.path} component={Login} />
			<Route exact path={ROUTES.SIGNUP.path} component={Registration} />
			<Route exact path={ROUTES.NEW_INSTITUTIONS.path} component={NewInstitutions} />
			<Route exact path={ROUTES.SOLICITATIONS.path} component={ Solicitations } />
			<Route exact path={ROUTES.INFORMATIONS.path} component={Informations} />
			<Route exact path={ROUTES.ADMIN.path} component={HomeAdmin} />
			<Route exact path={ROUTES.URGENT_ORDERS.path} component={UrgentOrders} />
			<Route exact path={ROUTES.REQUEST_INFO.path} component={ RequestInfo } />
			<Route exact path={ROUTES.HOME.path} component={Home} />
			<Route exact path={ROUTES.NEW_ITEM.path} component={NewItem} />
			<Route exact path={ROUTES.NEW_SERVICE.path} component={NewService} />

		</Switch>
	)
}

export { Router }
