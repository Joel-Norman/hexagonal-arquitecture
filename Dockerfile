FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/product-0.0.1-SNAPSHOT.jar.jar /app/api.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "/app/api.jar"]