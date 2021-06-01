
package socketssrvmulticlient;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author dordonez@ute.edu.ec
 */
public class MainServer {

	public static void main(String[] args) {
		try (ServerSocket server = new ServerSocket(8888)) {
			while (true) {
				System.out.println("Esperando cliente...");
				Socket socket = server.accept();
				System.out.println("Cliente conectado: "+ socket.getRemoteSocketAddress());
				new ManejaCliente(socket).start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
    
}
