Desde este directorio...

Crear jar:
jar cvf TcpServer.jar *

Crear imagen:
docker build --tag tcp-server .

Ejecutar container:
docker run -p 8888:8888 tcp-server
