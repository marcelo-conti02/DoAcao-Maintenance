const minValidator = (val, min = 3) => {
    if (val.length < min) {
        return `O campo precisa ser preenchido`
    }
}
const FORM_DATA = {
    name: {
        name: 'name',
        label: 'Nome do doador',
        value: '',
        required: true,
        sendToBackend: true,
        validate: val => {
            return minValidator(val)
        }
    },
    email: {
        name: 'email',
        label: 'E-mail para contato',
        value: '',
        required: true,
        validate: val => {
            return minValidator(val)
        },
        sendToBackend: true,
    },
    phone: {
        name: 'phone',
        label: 'Telefone para contato',
        value: '',
        required: true,
        validate: val => {
            return minValidator(val)
        },
        sendToBackend: true,
    },    
}

export { FORM_DATA }