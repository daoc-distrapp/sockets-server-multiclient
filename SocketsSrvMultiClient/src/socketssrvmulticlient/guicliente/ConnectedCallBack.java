package socketssrvmulticlient.guicliente;

import java.net.Socket;

/**
* @author dordonez@ute.edu.ec
*/
public interface ConnectedCallBack {
	void onSuccess(Socket socket);
	void onError(String error);
}
