# syntax=docker/dockerfile:1
FROM openjdk:16-alpine3.13
WORKDIR /app
COPY TcpServer.jar ./
CMD ["java", "-cp", "TcpServer.jar", "socketssrvmulticlient.MainServer"]
