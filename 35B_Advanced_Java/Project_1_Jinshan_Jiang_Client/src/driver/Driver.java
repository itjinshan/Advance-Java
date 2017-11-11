package driver;



import java.io.IOException;

import socketClient.SocketClient;

public class Driver {
	
	public static void main(String [] args) throws IOException {
			SocketClient clientS = new SocketClient("127.0.0.1", 1034);
			clientS.run("Property File.txt",1);

			clientS.handleSession("",2);
			clientS.closeSession();
		}
}
