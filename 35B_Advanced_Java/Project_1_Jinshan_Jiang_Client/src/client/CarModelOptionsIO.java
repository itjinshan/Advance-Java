package client;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Properties;

public class CarModelOptionsIO {
	public CarModelOptionsIO(){}

	public void readPropertiesAndTransfer(String filename, BufferedReader SeverStringIn,ObjectOutputStream out) throws IOException{
		FileInputStream in = new FileInputStream(filename);
		Properties props= new Properties();
		props.load(in);
		
        System.out.println("Client Finished Loading Property File To Property Obejct.");
        
        out.writeObject(props);
        String fromServer;
        if ((fromServer = SeverStringIn.readLine()) != null) 
        {
        		System.out.println("Server: " + fromServer);
        }
	}
}
