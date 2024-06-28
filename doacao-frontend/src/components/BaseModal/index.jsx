import { Modal } from "@material-ui/core";
import { BaseModalStyled } from "./styles"

const BaseModal = ({ children, ...props }) => {
    return (
        <Modal {...props} style={{ zIndex: 20 }}>
            <BaseModalStyled>{children}</BaseModalStyled>
        </Modal>
    )
}

export { BaseModal }