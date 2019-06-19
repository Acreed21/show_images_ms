# Start with a base image containing Java runtime
# select image
FROM maven:3.5-jdk-8

# copy your source tree
COPY ./ ./

# build for release
RUN mvn clean package

# set the startup command to run your binary
CMD ["java", "-jar", "./target/easy-notes.jar"]

# FROM openjdk:8-jdk-alpine
# # Add a volume pointing to /tmp
# VOLUME /tmp

# # Make port 8080 available to the world outside this container
# EXPOSE 8080

# # The application's jar file
# #ARG JAR_FILE=target/websocket-demo-0.0.1-SNAPSHOT.jar
# ARG JAR_FILE=target/easy-notes-0.0.1-SNAPSHOT.jar

# # Add the application's jar to the container
# ADD ${JAR_FILE} easy-notes.jar
# #RUN sh -c 'touch /easy-notes.jar'
# # Run the jar file 
# ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/easy-notes.jar"]
# Start with a base image containing Java runtime

#FROM maven:3.6.0-jdk-11-slim

#FROM openjdk:8-jdk-alpine
#CMD mvn clean package

# Add a volume pointing to /tmp
#VOLUME /tmp

# Make port 8080 available to the world outside this container
#EXPOSE 8080

# The application's jar file
#ARG JAR_FILE=target/websocket-demo-0.0.1-SNAPSHOT.jar
#ARG JAR_FILE=target/easy-notes-0.0.1-SNAPSHOT.jar

# Add the application's jar to the container
#ADD ${JAR_FILE} easy-notes.jar
#RUN sh -c 'touch /easy-notes.jar'
# Run the jar file 
#ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/easy-notes.jar"]
