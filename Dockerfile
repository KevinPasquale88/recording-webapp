FROM openjdk:21-ea-18-jdk-oracle
LABEL authors="robertopasquale"
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]