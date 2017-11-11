package socketServer;

import java.net.*;
import java.io.*;

public class DefaultSocketServer extends Thread implements SocketServerInterface, SocketServerConstants {

	protected BufferedReader br;
	private BufferedWriter bw;
	protected ServerSocket serverSock = null;
	protected Socket clientSocket = null;
	// protected String strHost;
	protected int port;

	public DefaultSocketServer(int port) {
		setPort(port);
	}// constructor

	public void run() {
		if (openConnection()) {
			handleSession();
			closeSession();
		}
	}// run

	public boolean openConnection() {

		try {
			serverSock = new ServerSocket(port);
		} catch (IOException e) {
			System.err.println("Could not listen on port: 1024.");
			System.exit(1);
		}
		try {
			System.out.println("Server is ready...");
			System.out.println("Server standing by...");
			clientSocket = serverSock.accept();
		} catch (IOException e) {
			System.err.println("Accept failed.");
			System.exit(1);
		}
		return true;
	}

	public void handleSession() {

	}

	public void output(String strOutput) {
		try {
			bw.write(strOutput, 0, strOutput.length());
		} catch (IOException e) {
			if (SWITCH)
				System.out.println("Writing error: " + "LocalHost");
		}
	}

	public void handleInput(String strInput) {
		System.out.println(strInput);
	}

	public void closeSession() {
		try {
			bw = null;
			br = null;
			clientSocket.close();
			serverSock.close();
		} catch (IOException e) {
			if (SWITCH)
				System.err.println("Closing socket error: " + "LocalHost");
		}
	}

	public void setHost(String strHost) {
		// this.strHost = strHost;
	}

	public void setPort(int port) {
		this.port = port;
	}
}
