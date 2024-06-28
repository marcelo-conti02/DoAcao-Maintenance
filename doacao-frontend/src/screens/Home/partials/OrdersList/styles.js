import styled from 'styled-components';
import colors from '../../../../assets/colors';
import { Button } from '../../../../components';

const cardWidth = '300px';
const mobileUrgentCardWidth = '250px';

const UrgentOrdersListStyled = styled.ul`
    list-style-type: none;
    margin: 0;
    padding: 30px;
    
    width: calc(100% - 60px);
    display: grid;
    overflow-x: scroll;
    
    grid-template-columns: repeat(auto-fill, ${cardWidth});
    grid-template-rows: 1fr;
    grid-auto-flow: column;
    grid-gap: 40px;
    
    @media screen and (max-width: 425px) {
        width: calc(100% - 20px);
        padding: 20px 10px;
        grid-template-columns: repeat(auto-fill, ${mobileUrgentCardWidth});
        grid-gap: 15px;
    }
    `

const RegularOrdersListStyled = styled.ul`
    list-style-type: none;
    margin: 0;
    padding: 30px;
    overflow-x: scroll;

    width: calc(100% - 60px);
    display: grid;
    justify-content: center;
    
    grid-template-columns: repeat(5, ${cardWidth});
    grid-template-rows: repeat(auto-fill, 1fr);
    grid-auto-flow: row;
    grid-gap: 40px;
    
    @media screen and (max-width: 1700px) {
        grid-template-columns: repeat(auto-fill, ${cardWidth});
    }
    @media screen and (max-width: 425px) {
        width: calc(100% - 20px);
        padding: 20px 10px;
        grid-template-columns: repeat(auto-fill, ${cardWidth});
        grid-gap: 15px;
    }
`

const horizontalPadding = '20px';
const mobileHorizontalPadding = '10px';

const OrderCardStyled = styled.li`
    width: calc(${cardWidth} - ${horizontalPadding} * 2);
    background-color: ${({ isUrgent }) => isUrgent ? colors.primary : colors.white};
    color: ${({ isUrgent }) => isUrgent ? colors.white : colors.secondary};
    padding: 30px ${horizontalPadding};
    border-radius: 10px;
    display: flex;
    flex-direction: column;
    align-items: stretch;
    justify-content: space-between;
    box-shadow: 0px 2px 10px 1px rgba(76,4,4, 0.3);
    
    @media screen and (max-width: 425px) {
        min-width: calc(${mobileUrgentCardWidth} - ${mobileHorizontalPadding} * 2);
        width: calc(100% - ${mobileHorizontalPadding} * 2);
        padding: 15px ${mobileHorizontalPadding};
    }
`
const CardTitle = styled.h3`
    margin: 0;
`
const CardDescription = styled.p`
    overflow: hidden;
    text-overflow: ellipsis;
    display: -webkit-box;
    -webkit-line-clamp: 2;
    -webkit-box-orient: vertical;
`

const CardMoreItemsMessage = styled.p`
    font-size: 12px;
    text-decoration: underline;
    margin: 0;
    height: 40px;
    display: flex;
    align-items: center;
`

const ItemsList = styled.ul`
    list-style-type: none;
    margin: 0;
    padding: 10px;

    background-color: ${({ isUrgent }) => isUrgent ? colors.pinkLight : colors.background};
    color: ${colors.secondary};
    border-radius: 10px;
`
const CardListItem = styled.li`
    display: flex;
`

const CardAction = styled(Button)`
    &&{
        width: 100%;
        align-self: flex-end;
    }
`

const GroupListContainer = styled.div`
    display: flex;
    flex-direction: column;
`

const ListName = styled.h2`
    color: ${colors.secondary};
    margin: 0;

    @media screen and (max-width: 570px) {
        margin-left: 10px;
    }
`

const ListContainer = styled.div`
    background-image: ${({ bgReversed }) => bgReversed ? 'linear-gradient(to top, ' + colors.pinkLight + ' 0%, ' + colors.background + ' 100%)'
        : 'linear-gradient(to bottom, ' + colors.pinkLight + ' 0%, ' + colors.background + ' 100%)'};

    padding: 30px 0 30px 30px;

    @media screen and (max-width: 570px) {
        padding-bottom: 0;
        padding-left: 0;
    }
`

const NoOrdersFoundText = styled.p`
    text-align: center;
    margin: 30px auto;
    font-size: 32px;
`

const ImageNoData = styled.img`
    max-width: 40%;
    min-width: 310px;
    margin: auto;
`

const ListHeader = styled.header`
    margin-bottom: 20px;
    display: flex;
`

const ColumnTitle = styled.div`
    font-size: 14px;
    text-align: left;
    font-weight: bold;
    width: ${({ width }) => width};
    
    &:not(:last-child) {
        margin-right: 10px;
    }
    `

const ColumnData = styled.div`
    font-size: 14px;
    text-align: left;
    width: ${({ width }) => width};

    &:not(:last-child) {
        margin-right: 10px;
    }
`

export {
    RegularOrdersListStyled, UrgentOrdersListStyled,
    OrderCardStyled, CardTitle, CardDescription, ItemsList, CardListItem,
    CardMoreItemsMessage, CardAction, GroupListContainer, ListContainer,
    ListName, NoOrdersFoundText, ImageNoData, ColumnTitle, ColumnData, ListHeader
}

