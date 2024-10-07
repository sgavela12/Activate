# Usa una imagen oficial de Java como base
FROM openjdk:17-jdk-alpine

# Configura el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia el archivo JAR de la aplicación a la imagen del contenedor
COPY target/tu-app-spring.jar /app/app.jar

# Expone el puerto en el que la aplicación escucha
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
