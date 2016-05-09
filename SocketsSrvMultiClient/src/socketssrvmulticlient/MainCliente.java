
package socketssrvmulticlient;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dordonez@ute.edu.ec
 */
public class MainCliente {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 8888);
            Scanner in = new Scanner(socket.getInputStream());//lee del servidor
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);//escribe al servidor
            Scanner kb = new Scanner(System.in);//lee del teclado
            while(in.hasNextLine()) {
                String msg = in.nextLine();
                System.out.println(msg);
                if(!msg.contains("CLOSE:")) {
                    out.println(kb.nextLine());
                } else {
                    break;
                }
            }
        } catch (UnknownHostException ex) {
            Logger.getLogger(MainCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MainCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
}
