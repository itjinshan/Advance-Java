package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.LinkedHashMap;

import adpter.BuildAuto;
import model.Automobile;

public interface AutoServer {
	public void recieve(PrintWriter outString, ObjectInputStream in, LinkedHashMap<String, Automobile> a)
			throws IOException, ClassNotFoundException;
	public void showOneCar(ObjectInputStream in, ObjectOutputStream out, BuildAuto allCars);
}
