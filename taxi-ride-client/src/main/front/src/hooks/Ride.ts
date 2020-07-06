import React, { useEffect } from 'react'
import Ride from "../models/Ride";
import { useState } from "react";
import { getRides, getPrice } from '../api/RideApi';

export const useRides = (): Array<Ride> | undefined => {
  const [rides, setRides] = useState<Array<Ride> | undefined>(undefined)

  const fetchResources = async () => {
    const resources = await getRides()
    setRides(resources)
  }

  useEffect(
    () => {
      fetchResources()
    },
    []
  );
  return rides;
}

export const usePrice = (ride: Ride): number | undefined => {
  const [price, setPrice] = useState<number | undefined>(undefined)
  
  const fetchResources = async () => {
    const resources = await getPrice(ride.duration, ride.startTime, ride.distance)
    setPrice(resources)
  }

  useEffect(
    () => {
      fetchResources()
    },
    []
  );
  return price;
}
