import React, { useState } from 'react'
import { StyledCounter, Button, Text } from './styles.js'
import { Input } from '../Input'

const Counter = ({...props}) => {
    const[count, setCount] = useState(0);
    const handleIncrement = () => {
        setCount(count + 1);
    }
    const handleDecrement = () => {
        setCount(count - 1);
    }
    
    return (
        <StyledCounter {...props}>
            <Button onClick={handleDecrement}>-</Button>
                <Text>{count}</Text>
            <Button onClick={handleIncrement}>+</Button>
        </StyledCounter>
    )

}

export { Counter }