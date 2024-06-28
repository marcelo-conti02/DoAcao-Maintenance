const ROUTES = {
    LOGIN: {
        path: '/login',
    },
    SIGNUP: {
        path: '/signup',
    },
    HOME: {
        path: '/',
    },
    ADMIN: {
        path: '/admin',
    },
    SOLICITATIONS: {
        path: '/solicitations'
    },
    INFORMATIONS: {
        path: '/informations'
    },
    NEW_INSTITUTIONS: {
        path: '/new-institutions',
    },
    PREVIEW_REQUEST: {
        path: '/previewrequest',
    },
    REQUEST: {
        path: '/request',
    },
    URGENT_ORDERS: {
        path: '/urgent-orders',
    },
    REQUEST_INFO: {
        path: '/request-info/:orderId',
        withParam: param => `/request-info/${param}`
    },
    NEW_ITEM: {
        path: '/new-item',
    },
    NEW_SERVICE: {
        path: '/new-service',
    },
    INTEREST: {
        path: '/interest'
    }
}

export { ROUTES }