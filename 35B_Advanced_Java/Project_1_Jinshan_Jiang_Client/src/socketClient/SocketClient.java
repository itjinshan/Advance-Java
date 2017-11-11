package socketClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import client.CarModelOptionsIO;
import client.SelectCarOption;

public class SocketClient extends DefaultSocketClient {

	public SocketClient(String strHost, int port) {
		super(strHost, port);
		// TODO Auto-generated constructor stub
	}
	 public void run(String filename,int choice){
	       if (openConnection()){
	    	   handleSession(filename, choice);
	    	   //closeSession();
	       }
	    }//run
	public void handleSession(String filename,int choice){
  	  BufferedReader brIn = null;
  	  ObjectInputStream in = null;
  	  ObjectOutputStream out = null;
  	  CarModelOptionsIO upload = new CarModelOptionsIO();
  	  SelectCarOption choosenCar = new SelectCarOption();
  	  if (SWITCH) System.out.println ("Handling session with "
  	            + strHost + ":" + port);
  	  try {
  		  if(choice == 1)
  		  {
  			 out = new ObjectOutputStream(sock.getOutputStream()); 
  			 brIn = new BufferedReader(new InputStreamReader(sock.getInputStream()));
  			 upload.readPropertiesAndTransfer(filename, brIn, out);
  		  }
  		  else if(choice == 2)
  		  {
  			  //public void selectThenShow(ObjectOutputStream out,ObjectInputStream in)
  			  
  			  out = new ObjectOutputStream(sock.getOutputStream());
  			  in = new ObjectInputStream(sock.getInputStream());
  			  choosenCar.selectThenShow(out, in);
  		  }
  	  }
  	  catch (IOException e){
  	  if (SWITCH) System.out.println ("Handling session with "
  	        + strHost + ":" + port);
  	  }

  	
	
	}
}
