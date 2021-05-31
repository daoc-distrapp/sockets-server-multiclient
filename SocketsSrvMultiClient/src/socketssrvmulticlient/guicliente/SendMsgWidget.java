package socketssrvmulticlient.guicliente;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.io.PrintWriter;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class SendMsgWidget extends JPanel {
	private JTextField outMsg;
	private JButton sendMsg;
	private PrintWriter write;
	
	public SendMsgWidget() {
		createGui();
	}
	
	public SendMsgWidget(PrintWriter write) {
		createGui();
		initGui(write);
	}
	
	private void createGui() {
		setLayout(new BorderLayout());
		outMsg = new JTextField();
		outMsg.setToolTipText("Escriba su mensaje...");
		outMsg.addActionListener(action);
		sendMsg = new JButton("Enviar");
		sendMsg.addActionListener(action);
		add(outMsg, BorderLayout.CENTER);
		add(sendMsg, BorderLayout.EAST);
	}
	
	public void initGui(PrintWriter write) {
		this.write = write;
	}
	
	private Action action = new AbstractAction() {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(write != null) {
				write.println(outMsg.getText());
			} else {
				JOptionPane.showMessageDialog(SendMsgWidget.this, "No está inicializado !!!");
			}
			outMsg.setText("");
			outMsg.grabFocus();
		}
	};
	
}
