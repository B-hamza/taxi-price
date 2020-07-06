import React, { ReactNode } from 'react'
import { List } from 'antd';
import Ride from '../../models/Ride';

// normally we should be model agnostic in the UI. 

interface ListProps<T> {
  className?: string
  title: string
  list: Array<T>,
  childDisplay: (ride: T) => ReactNode
}

const RideList = ({className, title, list, childDisplay}: ListProps<any>) => (
  <List
    className={className}
    size="large"
    header={<div>{title}</div>}
    bordered
    dataSource={list}
    renderItem={item => childDisplay(item)}
  />
)

export default RideList
