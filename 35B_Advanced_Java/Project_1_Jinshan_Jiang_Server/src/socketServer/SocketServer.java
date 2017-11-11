package socketServer;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;

import adpter.BuildAuto;
import server.AutoServer;
import server.BuildCarModelOptions;

public class SocketServer extends DefaultSocketServer {
	
	public SocketServer(int port) {
		super(port);
		// TODO Auto-generated constructor stub
	}
	
	public void run(BuildAuto auto,int choice){
	       if (openConnection()){
	          handleSession(auto,choice);
	          //closeSession();
	       }
	    }//run
	
	public void handleSession(BuildAuto auto,int choice) {
  	  PrintWriter pw = null;
  	  ObjectInputStream in = null;
  	  ObjectOutputStream out = null;
  	  AutoServer print = null;
  	  if (SWITCH) System.out.println ("Handling session with "
  	            + "The Server" + ":" + port);
  	  try {
  		  if(choice == 1)
  		  {
  			  pw = new PrintWriter(clientSocket.getOutputStream(), true);
  			  in = new ObjectInputStream(clientSocket.getInputStream());
  			  auto.BuildAuto(pw, in);
  		  }
  		  else if(choice ==2)
  		  {
  			  //public void showOneCar(ObjectInputStream in,ObjectOutputStream out,BuildAuto allCars)
  			  in = new ObjectInputStream(clientSocket.getInputStream());
  			  out = new ObjectOutputStream(clientSocket.getOutputStream());
  			  print = new BuildCarModelOptions();
  			  print.showOneCar(in, out, auto);
  		  }
  	  }
  	  catch (IOException | ClassNotFoundException e){
  	  if (SWITCH) System.out.println ("Handling session with "
  	        + "The Server" + ":" + port);
  	  }
  	}       

}
