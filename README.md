[![Build Status](https://travis-ci.com/npalm/notes-service-java.svg?branch=master)](https://travis-ci.com/npalm/notes-service-java)
[![Maintainability](https://api.codeclimate.com/v1/badges/42bf989099f64066b5d7/maintainability)](https://codeclimate.com/github/npalm/notes-service-java/maintainability)
[![Test Coverage](https://api.codeclimate.com/v1/badges/42bf989099f64066b5d7/test_coverage)](https://codeclimate.com/github/npalm/notes-service-java/test_coverage)

# GraphQL Spring Boot Blog

## Introduction

This repo contains a simple Spring Boot (2.x) service that implements  [GraphQL](https://graphql.org/) API. The implementation is based on graphql-java-tools a GraphQL java library inspired by Apollo.

![graphql-and-spring](./doc/spring-and-graphql.png)

- [graphql-java-common](https://github.com/graphql-java/graphql-java-tools) - GraphQL implementation which is a schema first implementation of GraphQL.
- [graphql-spring-boot](https://github.com/graphql-java/graphql-spring-boot) - A Sprinb Boot Starter for GraphQL.
- Spring Boot 2.x

## Application
The application implements GraphQL on top of JPA repositories. The application provides basic functionality to store Person and Notes.

![model](https://www.plantuml.com/plantuml/proxy?cache=no&src=https://raw.githubusercontent.com/npalm/notes-service-java/master/doc/demo-model.plantuml&counter=1)

The graphQL API contains *queries*, *mutations* and *subscriptions*. For more details have a look at the [schema](src/main/resources/demo.graphqls)

## Run with docker
Pull and run the image.

```
docker run -d --name grapql-demo -p 8088:8080 npalm/graphql-java-demo
```

The following endpoints are now available:
- http://localhost:8080/graphiql - A graphical interactive in-browser GraphQL IDE.
- http://localhost:8080/ - A simple reacte
- ws://localhost:8080/subscriptions


## Example usages

Once the application is running point a browser to [http://localhost:8080/graphiql](http://localhost:8080/graphiql). Which will open the GraphQL IDE. Here you can simple enter GraphQL queries. Since GraphQL is based on a schema you have completion features and documentation directly available in the browser.
![](doc/graphiql.png)

The response should like as follow.
```
"Your subscription data will appear here after server publication!"
```

Finally make a comment via a mutation in a *new* browser window. Find a talkId in the result of the first query.
```graphql

```
Have now a look on the subscription window, here the update should be visible.

## Build and Run

Be aware that the React app is not part of this repo but linked as a GIT submodule. Either clone the repo with `--recurse-submodules` or after checkout run `git submodule update --init --recursive` to update the module.

### Gradle

To build the Java application just run:
```
./gradlew build
```

To run the application run.
```
./gradlew bootRun
```

To run the React app:
```
cd react-web
yarn && yarn start
```

### Docker
The Docker file build both the Java and React app to a single Jar and package the in a docker image.

Build image
```
docker build -t grahpql-demo .
```
Run the container
```
docker run -it --rm -p 8080:8080 graphql-demo
```

Now the container should be running and you can play around with GraphQL.
