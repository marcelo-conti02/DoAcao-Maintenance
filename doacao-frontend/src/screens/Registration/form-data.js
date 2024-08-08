const minValidator = (val, min = 3) => {
    if (val.length < min) {
        return `O campo precisa ter ao menos ${min} caracteres`
    }
}

const confirmPassword = (val, form) => {
    if (val !== form.password.value) {
        return "Este campo precisa ser igual ao campo de senha"
    }
}

const FORM_DATA = {
    name: {
        name: 'name',
        label: 'Nome da Instituição',
        value: '',
        required: true,
        sendToBackend: true,
        maxLength: 50,
        validate: val => {
            return minValidator(val)
        }
    },
    login: {
        name: 'login',
        label: 'E-mail para login',
        value: '',
        required: true,
        sendToBackend: true,
        maxLength: 50,
        validate: val => {
            return minValidator(val)
        }
    },
    cnpj: {
        name: 'cnpj',
        label: 'CNPJ',
        value: '',
        required: true,
        sendToBackend: true,
        maxLength: 14,
        validate: val => {
            return minValidator(val, 14)
        }
    },
    password: {
        name: 'password',
        label: 'Senha para Cadastro',
        value: '',
        required: true,
        sendToBackend: true,
        validate: val => {
            return minValidator(val)
        }
    },
    confirmPassword: {
        name: 'confirmPassword',
        value: '',
        required: true,
        label: 'Confirme a Senha',
        validate: (val, form) => {
            return confirmPassword(val, form)
        }
    },
    checkboxRepresentation: {
        name: 'checkboxRepresentation',
        value: '',
        checked: false,
        label: 'Confirmo ter o direito legal de representar esta instituição e cadastrá-la nesta plataforma',
        validate: (_, __, checked) => {
            if (!checked) {
                return " Esta caixa precisa estar preenchida"
            }
        }
    },
    checkboxTerms: {
        name: 'checkboxTerms',
        value: '',
        checked: true,
        label: 'Concordo com os termos de uso e com a política de privacidade da plataforma',
        validate: (_, __, checked) => {
            if (!checked) {
                return " Esta caixa precisa estar preenchida"
            }
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
        maxLength: 50,
    },
    phone: {
        name: 'phone',
        label: 'Telefone',
        value: '',
        required: true,
        validate: val => {
            return minValidator(val)
        },
        sendToBackend: true,
        maxLength: 11,
    },
    whatsapp: {
        name: 'whatsapp',
        label: 'WhatsApp',
        value: '',
        required: false,
        sendToBackend: true,
        maxLength: 11,
    },
    cep: {
        name: 'cep',
        label: 'CEP',
        value: '',
        required: true,
        maxLength: 8,
        validate: val => {
            return minValidator(val, 8)
        },
        sendToBackend: true,
    },
    state: {
        name: 'state',
        label: 'UF',
        value: '',
        required: true,
        maxLength: 2,
        validate: val => {
            return minValidator(val, 2)
        },
        sendToBackend: true,
    },
    city: {
        name: 'city',
        label: 'Cidade',
        value: '',
        required: true,
        validate: val => {
            return minValidator(val)
        },
        sendToBackend: true,
    },
    district: {
        name: 'district',
        label: 'Bairro',
        value: '',
        required: true,
        validate: val => {
            return minValidator(val)
        },
        sendToBackend: true,
    },
    street: {
        name: 'street',
        label: 'Endereço',
        value: '',
        required: true,
        validate: val => {
            return minValidator(val)
        },
        sendToBackend: true,
    },
    complement: {
        name: 'complement',
        label: 'Complemento',
        value: '',
        required: false,
        sendToBackend: true,
    },
    website: {
        name: 'website',
        label: 'Site',
        value: '',
        required: false,
        sendToBackend: true,
        validate: (val, form) => {
            const { value: socialMedia } = form.socialMedia
            const isFilled = !!val
            const isSocialMediaFilled = !!socialMedia

            if (!isFilled && !isSocialMediaFilled) {
                return "Você precisa informar o site ou uma rede social da instituição"
            }

            return !!val && minValidator(val)
        }
    },
    socialMedia: {
        name: 'socialMedia',
        label: 'Rede Social',
        value: '',
        required: false,
        sendToBackend: true,
        validate: (val, form) => {
            const { value: website } = form.website
            const isFilled = !!val
            const isWebsiteFilled = !!website

            if (!isFilled && !isWebsiteFilled) {
                return "Você precisa informar o site ou uma rede social da instituição"
            }

            return !!val && minValidator(val)
        }
    },
    extraSocialMedia: {
        name: 'extraSocialMedia',
        label: 'Outra rede Social',
        value: '',
        required: false,
        sendToBackend: true,
    },
    description: {
        name: 'description',
        label: "Descrição",
        value: '',
        required: true,
        validate: val => {
            return minValidator(val)
        },
        sendToBackend: true,
        maxLength: 1000,
    },
}

export { FORM_DATA }