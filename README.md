# Passenger Checkin  Demo App

## Overview
The purpose of this application is to be an artifact for deployment to a kubernetes cluster.

# Development and Architecture

The entry points for the application are two RESTful endpoints

- The greeting `/welcome`
- The checkin `/checkin`

## Dockerize

There is a `files/` directory at the root of this project which contains the Java Cryptography extension.

Run the following docker build command to build the interim image.

```cmd
docker build --tag=alpine-java11:base --rm=true .
```

Create the final image

```cmd
docker build --file=Dockerfile.server --tag=passenger-checkin-server:latest --rm=true .
```

Login to your an accessible docker repository if applicable or use a local repository.  Create a public or accessible private repository and tag the imnage

```cmd
docker image ls

REPOSITORY                 TAG                 IMAGE ID            CREATED             SIZE
passenger-checkin-server   latest              03c00fede53e        23 hours ago        302MB
alpine-java11              base                8ee0cc7a7db8        25 hours ago        272MB


docker tag 03c00fede53e jbraypvtl/passenger-checkin-server:latest
```

Push the new tag to the repository

```cmd
docker push jbraypvtl/passenger-checkin-server:latest
```
## Deploy to Kubernetes Cluster

### Setup Cluster

Start by setting up the master node.
Install docker on the master node:

```cmd
sudo apt-get install docker.io
sudo systemctl enable docker                
```

## References

- [Dockering a Spring Boot Application](https://www.baeldung.com/dockerizing-spring-boot-application)