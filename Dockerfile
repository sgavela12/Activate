# Usamos una imagen base de OpenJDK 17, ya que estás usando Java 17
FROM openjdk:17-jdk-slim

# Establecemos un directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiamos el archivo JAR de la aplicación al contenedor
COPY target/activate-0.0.1-SNAPSHOT.jar app.jar

# Exponemos el puerto 8080 para el acceso externo
EXPOSE 8080

# Ejecutamos la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
