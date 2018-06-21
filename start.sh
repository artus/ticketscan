#!/bin/bash

# Build backend
cd ticketscan-backend;
chmod +x ./mvnw;
./mvnw package -Dmaven.test.skip=true;

# Start docker-compose
docker-compose build;
docker-compose up;
