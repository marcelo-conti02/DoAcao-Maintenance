import React, { useState } from 'react'

import { TabsContainer, OptionsContainer, TabOption } from './styles'

const Tabs = ({ tabsConfigList = [], ...props }) => {
    const [activeTabIndex, setActiveTabIndex] = useState(0)

    return tabsConfigList.length && (
        <TabsContainer {...props}>
            <OptionsContainer>
                {tabsConfigList.map(({ title }, index) => {
                    return (
                        <TabOption key={index} className={activeTabIndex === index ? '--active' : ''} onClick={() => setActiveTabIndex(index)}>{title}</TabOption>
                    )
                })}
            </OptionsContainer>
            {tabsConfigList[activeTabIndex].children}
        </TabsContainer>
    )
}

export { Tabs }