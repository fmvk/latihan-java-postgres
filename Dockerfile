FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/DIKA-1.0-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]

EXPOSE 8080