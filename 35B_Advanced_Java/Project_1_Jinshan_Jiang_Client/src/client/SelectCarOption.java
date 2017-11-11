package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import model.Automobile;

public class SelectCarOption {
	public SelectCarOption(){}
	
	public void selectThenShow(ObjectOutputStream out,ObjectInputStream in)
	{
		String choice = null;
		Automobile auto = null;
		try {
			//System.out.println(in.readObject().getClass().getName());
			ArrayList<String> models = (ArrayList<String>) in.readObject();
			for(int i = 0;i< models.size();i++)
			{
				System.out.println(models.get(i));
			}
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			choice = br.readLine();
			out.writeObject(choice);
			auto = (Automobile)in.readObject();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		auto.print();
	}
}