FROM openjdk:11-jdk-slim AS build

WORKDIR /build-env
ADD . /build-env
RUN ./gradlew build

FROM openjdk:11-jre-slim
COPY --from=build /build-env/build/libs/graphql-notes.jar /app/graphql-notes.jar

EXPOSE 8080
CMD java -jar /app/graphql-demo-service.jar
