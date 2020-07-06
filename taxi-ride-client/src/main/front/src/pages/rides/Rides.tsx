import React from 'react'
import styled from '@emotion/styled'

import { useRides, usePrice } from '../../hooks/Ride'

import { RideList, Loading } from '../../ui';
import Ride from '../../models/Ride';

const Rides = () => {
  const rides = useRides();

  return (
    rides === undefined ?
    <Loading/> :
    <div>
      <RideList title={"Rides"} list={rides} childDisplay={ride => <RideItem ride={ride}/>} />
    </div>
  )
}

const RideItem = ({ride} : {ride: Ride}) => {
  const price = usePrice(ride)
  return (
    <Ride distance={ride.distance}>
        <div>
          {ride.id}
        </div>
      {
        price === undefined ?
        <Loading/> :
        <div>
          {price}
        </div>
      }
    </Ride>
  )
}

const Ride = styled.div<{distance: number}>((props) => ({
  display: 'flex',
  justifyContent: 'space-around',
  alignItems: 'center',
  borderStyle: 'solid',
  borderWidth: '1px',
  backgroundColor: props.distance > 2 ? 'red' : 'white',
  height: '50px'
}))

export default Rides
