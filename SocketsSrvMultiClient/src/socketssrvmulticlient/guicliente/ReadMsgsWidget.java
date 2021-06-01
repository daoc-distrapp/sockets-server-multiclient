package socketssrvmulticlient.guicliente;

import java.awt.BorderLayout;
import java.util.List;
import java.util.Scanner;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingWorker;

/**
* @author dordonez@ute.edu.ec
*/
@SuppressWarnings("serial")
public class ReadMsgsWidget extends JPanel {
	private JTextArea inMsgs;
	private Scanner read;
	
	public ReadMsgsWidget() {
		createGui();
	}
	
	public ReadMsgsWidget(Scanner read) {
		createGui();
		initGui(read);
	}
	
	private void createGui() {
    	inMsgs = new JTextArea();
    	inMsgs.setEditable(false);
    	inMsgs.setRows(10);
    	inMsgs.setColumns(20);
    	add(new JScrollPane(inMsgs), BorderLayout.CENTER);
	}
	
	public void initGui(Scanner read) {
		this.read = read;
		new ReadMsg().execute();
	}
	
	public void addMsg(String msg) {
		inMsgs.append(msg + "\n");
	}
	
    private class ReadMsg extends SwingWorker<Void, String> {	
		@Override
		protected Void doInBackground() {
			try {
				while(read.hasNextLine()) {
					String msg = read.nextLine();
					publish(msg);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
		@Override
		protected void process(List<String> chunks) {
			for(String line : chunks) {
				addMsg(line);
			}
		}  	
    }
}
