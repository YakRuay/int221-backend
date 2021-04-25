FROM maven:3.6.0-jdk-11-slim AS build
WORKDIR /backend
COPY src ./src
COPY pom.xml ./
RUN mvn clean install

FROM adoptopenjdk/openjdk11:jdk-11.0.10_9-alpine
EXPOSE 5000
ARG JAR_FILE=./target/*.jar
COPY --from=build ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]