package socketssrvmulticlient.guicliente;

import java.awt.BorderLayout;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class GuiCliente extends JFrame {

	private SendMsgWidget sendMsgW;
	private ReadMsgsWidget readMsgsW;
	private ConnectWidget connectW;
	
	final String SERVER = "localhost";
	final int PORT = 8888;
	
	public static void main(String[] args) {
		GuiCliente frame = new GuiCliente();
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                frame.createGui();
            }
        });
	}

	private void createGui() {
        this.setTitle("Cliente TCP");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	sendMsgW = new SendMsgWidget();
    	this.add(sendMsgW, BorderLayout.NORTH);
        readMsgsW = new ReadMsgsWidget();
        this.add(readMsgsW, BorderLayout.CENTER);
    	connectW = new ConnectWidget(this, SERVER, PORT); 	
    	this.add(connectW, BorderLayout.WEST);    	   	
        this.pack();
        this.setVisible(true);
	}		
    
	public void connectCallBack(Boolean ok, Socket socket) {
		try {
			if(ok) {
				sendMsgW.initGui(new PrintWriter(socket.getOutputStream(), true));
				readMsgsW.initGui(new Scanner(socket.getInputStream()));
				readMsgsW.addMsg("Conectado con server");
			} else {
				readMsgsW.addMsg("ERROR: no pudo conectarse");
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
