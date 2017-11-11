// ******************************************
// *                                About                            *
// ******************************************
/**
 ****************************************************************************
 **             Developer: Jinshan Jiang // Alex
 **                  Class: CIS 35B Advanced Java
 **            Instructor: Sukhjit Singh
 **      Quarter & Year: Winter 2016
 **                College: De Anza College
 ****************************************************************************
 */

package driver;
import model.Automotive;
import util.ReadSource;
import util.Serial;

public class Driver {
	public static void main(String [] args) {
		//Build Automobile Object from a file.
		ReadSource readFromFile = new ReadSource();
		Automotive FordZTW = new Automotive();
		FordZTW = readFromFile.read();
		//Print attributes before serialization
		FordZTW.print();
		
		System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - -");
		System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - -");
		//Serialize the object
		Serial se = new Serial();
		Automotive newFordZTW = new Automotive();
		newFordZTW = se.serialize(FordZTW); 
		//Print new attributes.
		newFordZTW.print();
	}
}
