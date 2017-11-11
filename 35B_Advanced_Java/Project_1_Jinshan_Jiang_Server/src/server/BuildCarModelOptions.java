package server;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;

import adpter.BuildAuto;
import model.Automobile;
import util.ReadPropertyFile;

public class BuildCarModelOptions implements AutoServer {
	public void recieve(PrintWriter outString, ObjectInputStream in, LinkedHashMap<String, Automobile> a) 
			throws IOException, ClassNotFoundException{
		ReadPropertyFile rpf = new ReadPropertyFile();
        rpf.readProFile((Properties) in.readObject(), a);
        outString.println("Success!! Ready to use!");
	}
	
	public void showOneCar(ObjectInputStream in, ObjectOutputStream out, BuildAuto datas)
	{
		String car = null;
		Automobile auto = null;
		try {
			out.writeObject(datas.giveAllCars());
			car = (String) in.readObject();
			auto = datas.findAuto(car);
			out.writeObject(auto);
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
