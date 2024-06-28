import { StyledFooter, JesusImage, Text } from './styles'
import images from '../../assets/images'

const Footer = ({ }) => {

    return (
        <StyledFooter>
            <JesusImage src={images.JESUS} alt=""/>
            <Text>“Onde sofre o teu irmão, Eu estou sofrendo nele”.</Text>
        </StyledFooter>
    )

}

export { Footer }