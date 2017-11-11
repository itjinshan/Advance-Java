package util;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;

import model.Automobile;

public class Serial {
	public Automobile serialize(Automobile auto)
	{
		try{
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("auto.dat")); 
			out.writeObject(auto);
			out.close();
	
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("auto.dat"));
			Automobile newAuto = (Automobile) in.readObject();
			in.close();
			return newAuto;
		}catch(Exception e){ 
			System.out.print("Error:"+e);
			System.exit(1);
		}
		return auto;
	}
}
