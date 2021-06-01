package socketssrvmulticlient.guicliente;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.Socket;
import java.util.concurrent.ExecutionException;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

@SuppressWarnings("serial")
public class ConnectWidget extends JPanel {
	private JButton connect;
	private Socket socket;
	private String server;
	private int port;
	private ConnectedCallBack callback;

	public ConnectWidget(ConnectedCallBack callback) {
		this.callback = callback;
		createGui();
	}

	public ConnectWidget(String server, int port, ConnectedCallBack callback) {
		this(callback);
		initGui(server, port);
	}

	private void createGui() {
		connect = new JButton("Conectar");
		connect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				connect.setEnabled(false);
				new Connect().execute();
			}
		});
		this.add(connect, BorderLayout.WEST);
	}

	public void initGui(String server, int port) {
		this.server = server;
		this.port = port;
	}

	private class Connect extends SwingWorker<Boolean, Void> {
		@Override
		protected Boolean doInBackground() {
			try {
				if (server != null && port > 0) {
					socket = new Socket(server, port);
					return true;
				} else {
					JOptionPane.showMessageDialog(ConnectWidget.this, "No está inicializado !!!");
					return false;
				}
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}

		@Override
		protected void done() {
			try {
				if (get()) {
					callback.onSuccess(socket);
				} else {
					callback.onError("ERROR: no pudo conectarse");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			connect.setEnabled(true);
		}
	}

}
