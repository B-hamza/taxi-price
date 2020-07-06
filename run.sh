#!/bin/bash

yarn install
yarn build
./gradlew clean build
./gradlew :taxi-ride-client:bootRun
