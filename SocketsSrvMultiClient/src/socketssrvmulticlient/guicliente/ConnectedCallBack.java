package socketssrvmulticlient.guicliente;

import java.net.Socket;

public interface ConnectedCallBack {
	void onSuccess(Socket socket);
	void onError(String error);
}
