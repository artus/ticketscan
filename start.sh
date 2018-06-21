#!/bin/bash

# Build backend
cd ticketscan-backend;
chmod +x ./mvnw;
./mvnw package -Dmaven.test.skip=true;
cd ..;

#build frontend
cd ticketscan-frontend;
npm install;
npm run build;
cd ..;

# Start docker-compose
docker-compose build;
docker-compose up;
