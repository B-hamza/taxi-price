import axios from 'axios';
import Ride from "../models/Ride";

const base_url = "http://localhost:8080"

export function getRides(): Promise<Array<Ride>> {
  return axios.get(base_url + '/rides')
    .then(result => result.data)
}

export function getPrice(duration: number, startTime: string, distance: number): Promise<number> {
  return axios.get(
    base_url + '/price',{
      params: {
        duration: duration,
        startTime: startTime,
        distance: distance
      }
    })
    .then(result => result.data)
}
