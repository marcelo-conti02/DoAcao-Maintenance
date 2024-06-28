import React, { Component} from 'react'

import { showNotification } from '../../components/Notification/index';
import { Container, Title, Paragraph, Button } from './styles';
import { strings } from '../../assets/config'

const { general } = strings
const { successLoaded, hello, buttonExample, loremIpsum, loremText } = general

class Welcome extends Component {
	constructor(props) {
		super(props);
		this.state = {
            //estados do componente...
            loadedMessage: successLoaded
		}
    }

    componentDidMount(){
        const { loadedMessage } = this.state

        showNotification(loadedMessage)
    }
    
    render(){
        return (
            <Container>
                <Title>{loremIpsum}</Title>
                <Paragraph>{loremText}</Paragraph>
                <Button onClick={() =>  showNotification(hello)}>{buttonExample}</Button>
            </Container>
        )
    }
}

export default Welcome;