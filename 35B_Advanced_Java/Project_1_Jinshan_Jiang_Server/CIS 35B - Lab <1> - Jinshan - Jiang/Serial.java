package util;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;

import model.Automotive;

public class Serial {
	public Automotive serialize(Automotive auto)
	{
		try{
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("auto.dat")); 
			out.writeObject(auto);
			out.close();
	
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("auto.dat"));
			Automotive newAuto = (Automotive) in.readObject();
			in.close();
			return newAuto;
		}catch(Exception e){ 
			System.out.print("Error:"+e);
			System.exit(1);
		}
		return auto;
	}
}
