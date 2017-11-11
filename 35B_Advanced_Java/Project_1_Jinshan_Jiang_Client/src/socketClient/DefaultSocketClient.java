package socketClient;

import java.net.*;
import java.io.*;
public class DefaultSocketClient  extends Thread implements SocketClientInterface, SocketClientConstants {

    protected BufferedReader reader;
    private BufferedWriter writer;
    protected Socket sock;
    protected String strHost;
    protected int port;

    public DefaultSocketClient(String strHost, int port) {       
            setPort (port);
            setHost (strHost);
    }//constructor

    public void run(){
       if (openConnection()){
          handleSession();
          closeSession();
       }
    }//run
    public boolean openConnection(){

    	   try {
    	     sock = new Socket(strHost, port);                    
    	   }
    	   catch(IOException socketError){
    	     if (SWITCH) System.err.println
    	        ("Unable to connect to " + strHost);
    	     return false;
    	   }
    	   try {
    	     reader = new BufferedReader
    	      (new InputStreamReader(sock.getInputStream()));
    	     writer = new BufferedWriter
    	      (new OutputStreamWriter (sock.getOutputStream()));
    	   }
    	  catch (Exception e){
    	     if (SWITCH) System.err.println
    	       ("Unable to obtain stream to/from " + strHost);
    	     return false;
    	  }
    	  return true;
    	}
    public void handleSession(){
    	  String strInput = "";
    	  if (SWITCH) System.out.println ("Handling session with "
    	            + strHost + ":" + port);
    	  try {
    	    while ( (strInput = reader.readLine()) != null)
    	    handleInput (strInput);
    	  }
    	  catch (IOException e){
    	  if (SWITCH) System.out.println ("Handling session with "
    	        + strHost + ":" + port);
    	  }
    	}       

    	public void sendOutput(String strOutput){
    	  try {
    	    writer.write(strOutput, 0, strOutput.length());
    	  }
    	  catch (IOException e){
    	    if (SWITCH) System.out.println 
    	               ("Error writing to " + strHost);
    	  }
    	}
        public void handleInput(String strInput){
            System.out.println(strInput);
    }       

    public void closeSession(){
       try {
          writer = null;
          reader = null;
          sock.close();
       }
       catch (IOException e){
         if (SWITCH) System.err.println
          ("Error closing socket to " + strHost);
       }       
    }

    public void setHost(String strHost){
            this.strHost = strHost;
    }

    public void setPort(int port){
            this.port = port;
    }
}// class DefaultSocketClient