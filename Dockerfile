# Use an official OpenJDK 17 runtime as a parent image
FROM openjdk:17-jdk-alpine

# Argument for the JAR file location
ARG JAR_FILE=target/*.jar

# Copy the JAR file to the container
COPY ${JAR_FILE} app.jar

# Specify the entry point to run the JAR file
ENTRYPOINT ["java","-jar","/app.jar"]
