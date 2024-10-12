
# Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
# Click nbfs://nbhost/SystemFileSystem/Templates/Other/Dockerfile to edit this template

# Step 1: Use the official OpenJDK image as the base
FROM openjdk:17-jdk-alpine

# Step 2: Set the working directory inside the container
WORKDIR /app

# Step 3: Copy the JAR file (from target/ directory) into the container
COPY target/SpringWithDb-0.0.1-SNAPSHOT.jar app.jar

# Step 4: Expose the port on which the Spring Boot app listens
EXPOSE 8080

# Step 5: Command to run the Spring Boot app
ENTRYPOINT ["java", "-jar", "app.jar"]
