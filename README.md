# sockets-server-multiclient
Ejemplo de servidor Sockets TCP para múltiples clientes con varios hilos

Para crear una imagen Docker con el programa y ejecutar el servidor:

- en una consola vaya al subdirectorio bin (después de haber ejecutado el programa al menos una vez para tener ya las clases compiladas)
- cree el jar
--> jar cvf TcpServer.jar *
- cree el Dockerfile con:

# syntax=docker/dockerfile:1
FROM openjdk:16-alpine3.13
WORKDIR /app
COPY TcpServer.jar ./
CMD ["java", "-cp", "TcpServer.jar", "socketssrvmulticlient.MainServer"]

- cree la imagen:
--> docker build --tag tcp-server .
- ejecute el contenedor:
--> docker run -p 8888:8888 tcp-server
