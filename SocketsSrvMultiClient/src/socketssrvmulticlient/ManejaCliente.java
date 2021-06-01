
package socketssrvmulticlient;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author dordonez@ute.edu.ec
 */
public class ManejaCliente extends Thread {
    private Socket client;
    private Scanner in;
    private PrintWriter out;    

    public ManejaCliente(Socket client) {
        try {
            this.client = client;
            this.in = new Scanner(client.getInputStream());
            this.out = new PrintWriter(client.getOutputStream(), true);
        } catch (IOException ex) {
            Logger.getLogger(ManejaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }         
    }
    
    @Override
    public void run() {
        String msg;
        try {
            out.println("Finalice con EXIT");
            while(in.hasNextLine()) {
                msg = in.nextLine();
                System.out.println("Mensaje recibido: " + msg);
                out.println("ECHO: " + msg);
                if(msg.equalsIgnoreCase("exit")) {
                    break;
                }
            }
            client.close();
            System.out.println("Cliente desconectado: " + client.getRemoteSocketAddress());
        } catch (IOException ex) {
            Logger.getLogger(ManejaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
}
