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

## Deploy to Kubernetes Cluster

## References

- [Dockering a Spring Boot Application](https://www.baeldung.com/dockerizing-spring-boot-application)