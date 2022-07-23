FROM --platform=linux/amd64 adoptopenjdk/openjdk11:jdk-11.0.7_10-alpine-slim
USER root:root

WORKDIR /

ARG JAR_FILE=build/libs/spring-helloword-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} /app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]