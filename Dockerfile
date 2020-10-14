# base image - JDK 8 Alpine
FROM openjdk:8-jdk-alpine

# Run as spring user for security
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring

# JAR location
ARG JAR_FILE=target/*.jar

# Copy JAR
COPY ${JAR_FILE} app.jar

# Set ENTRYPOINT
ENTRYPOINT ["java","-jar","/app.jar"]