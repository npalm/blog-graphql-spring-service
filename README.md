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
