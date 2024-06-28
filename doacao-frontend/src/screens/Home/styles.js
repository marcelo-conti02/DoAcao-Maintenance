import styled from 'styled-components';
import { BaseScreen } from '../../components';

const HomeScreen = styled(BaseScreen)`
    && {
        flex-direction: column;
        justify-content: flex-start;
    }
`

const FiltersContainers = styled.div`
    width: calc(100% - 60px);
    padding: 30px;
    display: flex;
    align-items: center;
    justify-content: flex-start;
    
    @media screen and (max-width: 700px) {
        align-items: center;
        justify-content: center;
    }
`

export { HomeScreen, FiltersContainers }

