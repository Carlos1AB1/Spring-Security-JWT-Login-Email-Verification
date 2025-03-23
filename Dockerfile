# Etapa 1: Construcción del .jar
FROM gradle:8.5-jdk17 AS build
WORKDIR /app
COPY . .
WORKDIR /app/demo
RUN gradle build --no-daemon --stacktrace

# Etapa 2: Contenedor final para ejecutar la app
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /app/demo/build/libs/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
