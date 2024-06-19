# Use an official OpenJDK runtime as a parent image
FROM openjdk:22-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the project's pom.xml and source code into the container
COPY pom.xml .
COPY src ./src

# Install Maven and build the application
RUN apt-get update && \
    apt-get install -y maven && \
    mvn clean package

# Run the application
CMD ["java", "-jar", "target/iniflex-1.0-SNAPSHOT.jar"]
