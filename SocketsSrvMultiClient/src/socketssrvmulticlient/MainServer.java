
package socketssrvmulticlient;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author dordonez@ute.edu.ec
 */
public class MainServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            ServerSocket server  = new ServerSocket(8888);
            
            while(true) {
                System.out.println("Esperando cliente...");
                Socket socket = server.accept();
                System.out.println("Cliente conectado...");
                new ManejaCliente(socket).start();
            }
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
}
