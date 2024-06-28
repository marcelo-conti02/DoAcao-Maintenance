const minValidator = (val, min = 3) => {
    if (val.length < min) {
        return `O campo nome precisa ser preenchido`
    }
}
const FORM_DATA = {
    item: {
        name: 'item',
        label: 'Nome',
        value: '',
        required: true,
        sendToBackend: true,
        validate: val => {
            return minValidator(val)
        }
    },  
}

export { FORM_DATA }