FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/mi-aplicacion.jar /app/api.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "/app/api.jar"]