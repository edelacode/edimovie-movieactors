# Usa una imagen base de Java 21
FROM openjdk:21-jdk

# Define el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia el archivo JAR generado por Maven al contenedor
COPY target/EdiMovie-MovieActors-0.0.1-SNAPSHOT.jar app.jar

# Expone el puerto en el que corre tu aplicación Spring Boot
EXPOSE 8092

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]