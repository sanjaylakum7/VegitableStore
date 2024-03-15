FROM maven:3-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17.0.2-jdk-slim
COPY --from=build /target/vegitable-store.jar vegitable-store.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","vegitable-store.jar"]