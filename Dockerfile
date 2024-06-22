USER developer
FROM gradle:jdk21-alpine as builder
COPY --chown=gradle:gradle . /source
WORKDIR /source
RUN gradle clean build --no-daemon


FROM openjdk:21-ea-18-jdk-oracle
LABEL authors="robertopasquale"
LABEL version={project.version}
LABEL description="This is a Docker image for the Spring Boot application"
RUN mkdir /app

COPY --from=builder /source/build/libs/*.jar /app/app.jar

ENTRYPOINT ["java", "-jar","/app/app.jar"]