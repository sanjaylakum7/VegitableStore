FROM openjdk:21
EXPOSE 8080
ADD target/vegitable-store.jar vegitable-store.jar
ENTRYPOINT ["java","-jar","/vegitable-store.jar"]