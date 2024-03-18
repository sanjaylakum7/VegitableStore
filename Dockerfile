# ------------- 1 --------------
#FROM maven:3-openjdk-17 AS build
#COPY . .
#RUN mvn clean package -DskipTests
#
#FROM openjdk:17.0.2-jdk-slim
#COPY --from=build /target/vegitable-store.jar vegitable-store.jar
#EXPOSE 8888
#ENTRYPOINT ["java","-jar","vegitable-store.jar"]

#--------- 2 -----------

# Stage 1: Build the application
FROM maven:3-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests

# Stage 2: Create the final image
FROM openjdk:17.0.2-jdk-slim
COPY --from=build /target/vegitable-store.jar vegitable-store.jar

# Install MySQL client
RUN apt-get update && apt-get install -y mysql-client

# Expose the port your application runs on
EXPOSE 8888

# Define environment variables for MySQL connection
ENV SPRING_DATASOURCE_URL=jdbc:mysql://localhost:3306/collage
    SPRING_DATASOURCE_USERNAME=root
    SPRING_DATASOURCE_PASSWORD=sanjaylakum

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "vegitable-store.jar"]

#------ 3 ------

# Stage 1: Build the application
#FROM maven:3-openjdk-17 AS build
#COPY . .
#RUN mvn clean package -DskipTests
#
## Stage 2: Create the final image
#FROM openjdk:17.0.2-jdk-slim
#
## Copy the built JAR file from the build stage
#COPY --from=build /target/vegitable-store.jar app.jar
#
## Expose the application port
#EXPOSE 8888
#
## Set environment variables for MySQL configuration (to be provided externally)
#ENV SPRING_DATASOURCE_URL=jdbc:mysql://localhost:3306/collage
#ENV SPRING_DATASOURCE_USERNAME=root
#ENV SPRING_DATASOURCE_PASSWORD=sanjaylakum
#
## Run the Spring Boot application
#ENTRYPOINT ["java", "-jar", "app.jar"]

