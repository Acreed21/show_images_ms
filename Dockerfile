# Start with a base image containing Java runtime

FROM maven:3.6.0-jdk-11-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package


FROM openjdk:8-jdk-alpine

# Add a volume pointing to /tmp
VOLUME /tmp

# Make port 8080 available to the world outside this container
EXPOSE 8080

# The application's jar file
#ARG JAR_FILE=target/websocket-demo-0.0.1-SNAPSHOT.jar
ARG JAR_FILE=target/easy-notes-0.0.1-SNAPSHOT.jar

# Add the application's jar to the container
ADD ${JAR_FILE} easy-notes.jar
#RUN sh -c 'touch /easy-notes.jar'
# Run the jar file 
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/easy-notes.jar"]
