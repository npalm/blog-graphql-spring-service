[![Build Status](https://travis-ci.com/npalm/notes-service-java.svg?branch=master)](https://travis-ci.com/npalm/notes-service-java)
[![Maintainability](https://api.codeclimate.com/v1/badges/42bf989099f64066b5d7/maintainability)](https://codeclimate.com/github/npalm/notes-service-java/maintainability)
[![Test Coverage](https://api.codeclimate.com/v1/badges/42bf989099f64066b5d7/test_coverage)](https://codeclimate.com/github/npalm/notes-service-java/test_coverage)

# GraphQL Spring Boot service


## Build and Run

### Gradle
```
./gradlew bootRun
```
Open en browser on http://localhost:8080/graphiql, for play around with GraphiQL interface.

### Docker
Build image
```
docker build -t grahpql .
```
Run
```
docker run -it --rm -p 8080:8080 graphql 
```
