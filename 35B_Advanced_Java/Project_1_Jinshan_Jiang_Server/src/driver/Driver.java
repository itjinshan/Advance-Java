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
import model.Automobile;
import socketServer.SocketServer;

import java.util.LinkedHashMap;
import java.util.Scanner;
import util.ReadSource;
import util.Serial;
import adpter.*;

public class Driver {
	public static void main(String [] args) {
		
		//	********************************************
		//	**				  Assignment #1		               **
		//	********************************************
		/**
		//Build Automobile Object from a file.
		String nameOfFile;
		Scanner in= new Scanner(System.in);
		ReadSource readFromFile = new ReadSource();
		Automobile FordZTW = new Automobile();
		System.out.println("Please enter the name of the file:");
		nameOfFile = in.nextLine();
		in.close();
		FordZTW = readFromFile.read(nameOfFile);
		//Print attributes before serialization
		FordZTW.print();
		
		System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - -");
		System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - -");
		//Serialize the object
		Serial se = new Serial();
		Automobile newFordZTW = new Automobile();
		newFordZTW = se.serialize(FordZTW); 
		//Print new attributes.
		newFordZTW.print();
		
		System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - -");
		System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - -");
		*/
		
		//	********************************************
		//	**				  Assignment #2		               **
		//	********************************************
		/**
		//1. Are you able to create and print an Auto instance through CreateAuto interface?
		BuildAuto auto1 = new BuildAuto();
		auto1.buildAuto("Wrong File Name.txt");
		// -----------------^ Error File name to test exception handling
		//2. Are you able to update one of OptionSet’s name or Option Price for the Auto 
		//instance, created in the previous step.
		auto1.updateOptionSetName("Ford Focus Wagon ZTW", "WHAT IS TRANSMISSION", "Ford Transmission");
		// -----------------------------------------------------------------^  Error Option Set Name to test exception handling
		auto1.updateOptionPrice("Ford Focus Wagon ZTW", "Side Impact Air Bags", "HAHAHAHA", 450);
		// -----------------------------------------------------------------------------------------^ Error Option Name to test exception handling
		auto1.printAuto("Ford Focus Wagon ZTW");
		*/
		
		//	********************************************
		//	**				  Assignment #3		               **
		//	********************************************
		// Choosing random options to test the linked hash map and Choice ArrayList
		/**BuildAuto auto1 = new BuildAuto();
		auto1.buildAuto("Wrong File Name.txt");
		auto1.setChoice("Ford", "Color", "Pitch Black Clearcoat"); // Color Choice
		auto1.setChoice("Ford", "Transmission", "Standard");      // Transmission Choice
		auto1.setChoice("Ford", "Brakes/Traction Control", "ABS with Advance Trac"); // Brakes/Traction Control Choice
		auto1.setChoice("Ford", "Side Impact Air Bags", "Selected"); // Side Impact Air Bags Choice
		auto1.setChoice("Ford", "Power Moonroof", "Selected"); //Power Moonroof Choice
		auto1.printAuto("Ford", "Focus Wagon ZTW");*/
		
		//	********************************************
		//	**				  Assignment #4		               **
		//	********************************************
		/**BuildAuto auto1 = new BuildAuto();
		String nameD[] = new String [4]; 
		String priceD[] = new String [5];
		nameD[0] = "Ford";
		nameD[1] = "Focus Wagon ZTW";
		nameD[2] = "Transmission";
		nameD[3] = "Ford Transmission";
		
		priceD[0] = "Ford";
		priceD[1] = "Focus Wagon ZTW";
		priceD[2] = "Side Impact Air Bags";
		priceD[3] = "Selected";
		priceD[4] = "450";
		
		auto1.buildAuto("Wrong File Name.txt");
		// -----------------^ Error File name to test exception handling
		//2. Are you able to update one of OptionSet’s name or Option Price for the Auto 
		//instance, created in the previous step.
		//auto1.updateOptionSetName("Ford", "Focus Wagon ZTW", "WHAT IS TRANSMISSION", "Ford Transmission");
		// -----------------------------------------------------------------^  Error Option Set Name to test exception handling
		
		auto1.updateT(1, 2, nameD, priceD);
		
	
		
		//auto1.updateOptionPrice("Ford", "Focus Wagon ZTW", "Side Impact Air Bags", "HAHAHAHA", 450);
		// -----------------------------------------------------------------------------------------^ Error Option Name to test exception handling
		
		//auto1.updateT(2, priceD);
		
		auto1.printAuto("Ford" ,"Focus Wagon ZTW");
		*/
		
		
		//	********************************************
		//	**		         Assignment #5 Server	               **
		//	********************************************
		SocketServer sc1 = new SocketServer(1034);
		BuildAuto auto = new BuildAuto();
		sc1.run(auto,1);
		System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - -");
		sc1.handleSession(auto,2);
		sc1.closeSession();
	}
}

		
		/** Assignment #1 Test Result
		 * 	Please enter the name of the file:
		 *	Car Info.txt
		 *	Model: Ford Focus Wagon ZTW
		 *	Base Price: 18445.0
		 *	- - - - - - - - - - - - - - - - - - - - - - - - -
		 *	Color: 
		 * 	Fort Knox Gold Clearcoat Metallic with price: $0.0
		 * 	Liquid Grey Clearcoat Metallic with price: $0.0
		 *	Infra-Red Clearcoat with price: $0.0
		 *	Grabber Green Clearcoat Metallic with price: $0.0
		 *	Sangria Red Clearcoat Metallic with price: $0.0
		 *	French Blue Clearcoat Metallic with price: $0.0
		 *	Twilight Blue Clearcoat Metallic with price: $0.0
		 *	CD Silver Clearcoat Metallic with price: $0.0
		 *	Pitch Black Clearcoat with price: $0.0
		 *	Cloud 9 White Clearcoat with price: $0.0
		 *	- - - - - - - - - - - - - - - - - - - - - - - - -
		 *	Transmission: 
		 *	Automatic with price: $0.0
		 *	Standard with price: $-815.0
		 *	- - - - - - - - - - - - - - - - - - - - - - - - -
		 *	Brakes/Traction Control: 
		 *	Standard with price: $0.0
		 *	ABS with price: $400.0
		 *	ABS with Advance Trac with price: $1625.0
		 *	- - - - - - - - - - - - - - - - - - - - - - - - -
		 *	Side Impact Air Bags: 
		 *	None with price: $0.0
		 *	Selected with price: $350.0
		 *	- - - - - - - - - - - - - - - - - - - - - - - - -
		 *	Power Moonroof: 
		 *	None with price: $0.0
		 *	Selected with price: $595.0
		 *	- - - - - - - - - - - - - - - - - - - - - - - - -
		 *	- - - - - - - - - - - - - - - - - - - - - - - - -
		 *	Model: Ford Focus Wagon ZTW
		 * 	Base Price: 18445.0
		 *	- - - - - - - - - - - - - - - - - - - - - - - - -
		 *	Color: 
		 *	Fort Knox Gold Clearcoat Metallic with price: $0.0
		 *	Liquid Grey Clearcoat Metallic with price: $0.0
		 *	Infra-Red Clearcoat with price: $0.0
		 *	Grabber Green Clearcoat Metallic with price: $0.0
		 *	Sangria Red Clearcoat Metallic with price: $0.0
		 *	French Blue Clearcoat Metallic with price: $0.0
		 *	Twilight Blue Clearcoat Metallic with price: $0.0
		 *	CD Silver Clearcoat Metallic with price: $0.0
		 *	Pitch Black Clearcoat with price: $0.0
		 *	Cloud 9 White Clearcoat with price: $0.0
		 *	- - - - - - - - - - - - - - - - - - - - - - - - -
		 *	Transmission: 
		 *	Automatic with price: $0.0
		 *	Standard with price: $-815.0
		 *	- - - - - - - - - - - - - - - - - - - - - - - - -
		 *	Brakes/Traction Control: 
		 *	Standard with price: $0.0
		 *	ABS with price: $400.0
		 *	ABS with Advance Trac with price: $1625.0
		 *	- - - - - - - - - - - - - - - - - - - - - - - - -
		 *	Side Impact Air Bags: 
		 *	None with price: $0.0
		 *	Selected with price: $350.0
		 * - - - - - - - - - - - - - - - - - - - - - - - - -
		 *	Power Moonroof: 
		 *	None with price: $0.0
		 *	Selected with price: $595.0
		 *	- - - - - - - - - - - - - - - - - - - - - - - - -
 		 *	- - - - - - - - - - - - - - - - - - - - - - - - - 
 		 *	*/


		/** Assignment #2 STEP #1 Test Result (1/28/2016, 4:18 PM)
		 * 	*******************
		 * 	~ Option Set updated!
		 * 	*******************
		 * 	*******************
		 * 	~ Option Updated!
		 * 	*******************
		 * Model: Ford Focus Wagon ZTW
		 *	Base Price: 18445.0
		 *	- - - - - - - - - - - - - - - - - - - - - - - - -
		 *	Color: 
		 *	Fort Knox Gold Clearcoat Metallic with price: $0.0
		 *	Liquid Grey Clearcoat Metallic with price: $0.0
		 *	Infra-Red Clearcoat with price: $0.0
		 *	Grabber Green Clearcoat Metallic with price: $0.0
		 *	Sangria Red Clearcoat Metallic with price: $0.0
		 *	French Blue Clearcoat Metallic with price: $0.0
		 *	Twilight Blue Clearcoat Metallic with price: $0.0
		 *	CD Silver Clearcoat Metallic with price: $0.0
		 *	Pitch Black Clearcoat with price: $0.0
		 *	Cloud 9 White Clearcoat with price: $0.0
		 *	- - - - - - - - - - - - - - - - - - - - - - - - -
		 *	Ford Transmission: 
		 *	Automatic with price: $0.0
		 *	Standard with price: $-815.0
		 *	- - - - - - - - - - - - - - - - - - - - - - - - -
		 *	Brakes/Traction Control: 
		 *	Standard with price: $0.0
		 *	ABS with price: $400.0
		 *	ABS with Advance Trac with price: $1625.0
		 *	- - - - - - - - - - - - - - - - - - - - - - - - -
		 *	Side Impact Air Bags: 
		 *	None with price: $0.0
		 *	Selected with price: $450.0
		 *	- - - - - - - - - - - - - - - - - - - - - - - - -
		 *	Power Moonroof: 
		 *	None with price: $0.0
		 *	Selected with price: $595.0
		 */
		
		/** Assignment #2 STEP #2 Test Result (2/2/2016, 2:05 AM)
		 * FixProblems [errorno = 201, errormsg: File Not Found!
		 * 2016-02-01 02:05:15.72
		 * Exception Captured!
		 * Trying to fix exception #201...
		 * *******************
		 * ~ File Name Updated!
		 * *******************
		 * FixProblems [errorno = 202, errormsg: Missing Base Price!
		 * 2016-02-01 02:05:15.72
		 * Exception Captured!
		 * Trying to fix exception #202...
		 * *******************
		 * ~ Base Price Updated!
		 * *******************
		 * FixProblems [errorno = 101, errormsg: Option Set Not Found!
		 * 2016-02-01 02:05:15.721
		 * Exception Captured!
		 * Trying to fix exception #101...
		 * *******************
		 * ~ Option Set updated!
		 * *******************
		 * FixProblems [errorno = 102, errormsg: Option Not Found!
		 * 2016-02-01 02:05:15.722
		 * Exception Captured!
		 * Trying to fix exception #102...
		 * *******************
		 * ~ Option Updated!
		 * *******************
		 * Model: Ford Focus Wagon ZTW
		 * Base Price: 18445.0                              <------------ Base Price Updated
		 * - - - - - - - - - - - - - - - - - - - - - - - - -
		 * Color: 
		 * Fort Knox Gold Clearcoat Metallic with price: $0.0
		 * Liquid Grey Clearcoat Metallic with price: $0.0
		 * Infra-Red Clearcoat with price: $0.0
		 * Grabber Green Clearcoat Metallic with price: $0.0
		 * Sangria Red Clearcoat Metallic with price: $0.0
		 * French Blue Clearcoat Metallic with price: $0.0
		 * Twilight Blue Clearcoat Metallic with price: $0.0
		 * CD Silver Clearcoat Metallic with price: $0.0
		 * Pitch Black Clearcoat with price: $0.0
		 * Cloud 9 White Clearcoat with price: $0.0
		 * - - - - - - - - - - - - - - - - - - - - - - - - -
		 * Ford Transmission:                                 <--------- Option Name Updated
		 * Automatic with price: $0.0
		 * Standard with price: $-815.0
		 * - - - - - - - - - - - - - - - - - - - - - - - - -
		 * Brakes/Traction Control: 
		 * Standard with price: $0.0
		 * ABS with price: $400.0
		 * ABS with Advance Trac with price: $1625.0
		 * - - - - - - - - - - - - - - - - - - - - - - - - -
		 * Side Impact Air Bags: 
		 * None with price: $0.0
		 * Selected with price: $450.0                      <---------- Option Price Updated
		 * - - - - - - - - - - - - - - - - - - - - - - - - -
		 * Power Moonroof: 
		 * None with price: $0.0
		 * Selected with price: $595.0
		 */
		
		/** Assignment #3 STEP #1 Test Result (2/3/2016, 10:47 AM)
		 * Please enter the name of the file:
		 * Car Info.txt
		 * FixProblems [errorno = 202, errormsg: Missing Base Price!
		 * 2016-02-03 10:46:57.361
		 * Exception Captured!
		 * Trying to fix exception #202...
		 * *******************
		 * ~ Base Price Updated!
		 * *******************
		 * Model: Ford Focus Wagon ZTW
		 * Base Price: 18445.0
		 * - - - - - - - - - - - - - - - - - - - - - - - - -
		 * Color: 
		 * Fort Knox Gold Clearcoat Metallic with price: $0.0
		 * Liquid Grey Clearcoat Metallic with price: $0.0
		 * Infra-Red Clearcoat with price: $0.0
		 * Grabber Green Clearcoat Metallic with price: $0.0
		 * Sangria Red Clearcoat Metallic with price: $0.0
		 * French Blue Clearcoat Metallic with price: $0.0
		 * Twilight Blue Clearcoat Metallic with price: $0.0
		 * CD Silver Clearcoat Metallic with price: $0.0
		 * Pitch Black Clearcoat with price: $0.0
		 * Cloud 9 White Clearcoat with price: $0.0
		 * - - - - - - - - - - - - - - - - - - - - - - - - -
		 * Transmission: 
		 * Automatic with price: $0.0
		 * Standard with price: $-815.0
		 * - - - - - - - - - - - - - - - - - - - - - - - - -
		 * Brakes/Traction Control: 
		 * Standard with price: $0.0
		 * ABS with price: $400.0
		 * ABS with Advance Trac with price: $1625.0
		 * - - - - - - - - - - - - - - - - - - - - - - - - -
		 * Side Impact Air Bags: 
		 * None with price: $0.0
		 * Selected with price: $350.0
		 * - - - - - - - - - - - - - - - - - - - - - - - - -
		 * Power Moonroof: 
		 * None with price: $0.0
		 * Selected with price: $595.0
		 * - - - - - - - - - - - - - - - - - - - - - - - - -
		 * - - - - - - - - - - - - - - - - - - - - - - - - -
		 * Model: Ford Focus Wagon ZTW
		 * Base Price: 18445.0
		 * - - - - - - - - - - - - - - - - - - - - - - - - -
		 * Color: 
		 * Fort Knox Gold Clearcoat Metallic with price: $0.0
		 * Liquid Grey Clearcoat Metallic with price: $0.0
		 * Infra-Red Clearcoat with price: $0.0
		 * Grabber Green Clearcoat Metallic with price: $0.0
		 * Sangria Red Clearcoat Metallic with price: $0.0
		 * French Blue Clearcoat Metallic with price: $0.0
		 * Twilight Blue Clearcoat Metallic with price: $0.0
		 * CD Silver Clearcoat Metallic with price: $0.0
		 * Pitch Black Clearcoat with price: $0.0
		 * Cloud 9 White Clearcoat with price: $0.0
		 * - - - - - - - - - - - - - - - - - - - - - - - - -
		 * Transmission: 
		 * Automatic with price: $0.0
		 * Standard with price: $-815.0
		 * - - - - - - - - - - - - - - - - - - - - - - - - -
		 * Brakes/Traction Control: 
		 * Standard with price: $0.0
		 * ABS with price: $400.0
		 * ABS with Advance Trac with price: $1625.0
		 * - - - - - - - - - - - - - - - - - - - - - - - - -
		 * Side Impact Air Bags: 
		 * None with price: $0.0
		 * Selected with price: $350.0
		 * - - - - - - - - - - - - - - - - - - - - - - - - -
		 * Power Moonroof: 
		 * None with price: $0.0
		 * Selected with price: $595.0
		 * - - - - - - - - - - - - - - - - - - - - - - - - -
		 * - - - - - - - - - - - - - - - - - - - - - - - - -
		 * FixProblems [errorno = 201, errormsg: File Not Found!
		 * 2016-02-03 10:46:57.41
		 * Exception Captured!
		 * Trying to fix exception #201...
		 * *******************
		 * ~ File Name Updated!
		 * *******************
		 * FixProblems [errorno = 202, errormsg: Missing Base Price!
		 * 2016-02-03 10:46:57.41
		 * Exception Captured!
		 * Trying to fix exception #202...
		 * *******************
		 * ~ Base Price Updated!
		 * *******************
		 * FixProblems [errorno = 101, errormsg: Option Set Not Found!
		 * 2016-02-03 10:46:57.411
		 * Exception Captured!
		 * Trying to fix exception #101...
		 * *******************
		 * ~ Option Set updated!
		 * *******************
		 * FixProblems [errorno = 102, errormsg: Option Not Found!
		 * 2016-02-03 10:46:57.411
		 * Exception Captured!
		 * Trying to fix exception #102...
		 * *******************
		 * ~ Option Updated!
		 * *******************
		 * Model: Ford Focus Wagon ZTW
		 * Base Price: 18445.0
		 * - - - - - - - - - - - - - - - - - - - - - - - - -
		 * Color: 
		 * Fort Knox Gold Clearcoat Metallic with price: $0.0
		 * Liquid Grey Clearcoat Metallic with price: $0.0
		 * Infra-Red Clearcoat with price: $0.0
		 * Grabber Green Clearcoat Metallic with price: $0.0
		 * Sangria Red Clearcoat Metallic with price: $0.0
		 * French Blue Clearcoat Metallic with price: $0.0
		 * Twilight Blue Clearcoat Metallic with price: $0.0
		 * CD Silver Clearcoat Metallic with price: $0.0
		 * Pitch Black Clearcoat with price: $0.0
		 * Cloud 9 White Clearcoat with price: $0.0
		 *  - - - - - - - - - - - - - - - - - - - - - - - -
		 * Ford Transmission: 
		 * Automatic with price: $0.0
		 * Standard with price: $-815.0
		 * - - - - - - - - - - - - - - - - - - - - - - - - -
		 * Brakes/Traction Control: 
		 * Standard with price: $0.0
		 * ABS with price: $400.0
		 * ABS with Advance Trac with price: $1625.0
		 * - - - - - - - - - - - - - - - - - - - - - - - - -
		 * Side Impact Air Bags: 
		 * None with price: $0.0
		 * Selected with price: $450.0
		 * - - - - - - - - - - - - - - - - - - - - - - - - -
		 * Power Moonroof: 
		 * None with price: $0.0
		 * Selected with price: $595.0
		 */

		/**Assignment #3 STEP #3 Test Result (2/9/2016, 11:03 PM)
		 * *******************
		 * ~ File Name Updated!
		 * *******************
		 * *******************
		 * ~ Base Price Updated!
		 * *******************
		 * *******************
		 * ~ Option Set updated!
		 * *******************
		 * *******************
		 * ~ Option Updated!
		 * *******************
		 * Brand: Ford
		 * Model: Focus Wagon ZTW
		 * Base Price: 18445.0
		 * - - - - - - - - - - - - - - - - - - - - - - - - -
		 * Color: 
		 * Fort Knox Gold Clearcoat Metallic with price: $0.0
		 * Liquid Grey Clearcoat Metallic with price: $0.0
		 * Infra-Red Clearcoat with price: $0.0
		 * Grabber Green Clearcoat Metallic with price: $0.0
		 * Sangria Red Clearcoat Metallic with price: $0.0
		 * French Blue Clearcoat Metallic with price: $0.0
		 * Twilight Blue Clearcoat Metallic with price: $0.0
		 * CD Silver Clearcoat Metallic with price: $0.0
		 * Pitch Black Clearcoat with price: $0.0
		 * Cloud 9 White Clearcoat with price: $0.0
		 * - - - - - - - - - - - - - - - - - - - - - - - - -
		 * Ford Transmission: 
		 * Automatic with price: $0.0
		 * Standard with price: $-815.0
		 * - - - - - - - - - - - - - - - - - - - - - - - - -
		 * Brakes/Traction Control: 
		 * Standard with price: $0.0
		 * ABS with price: $400.0
		 * ABS with Advance Trac with price: $1625.0
		 * - - - - - - - - - - - - - - - - - - - - - - - - -
		 * Side Impact Air Bags: 
		 * None with price: $0.0
		 * Selected with price: $450.0
		 * - - - - - - - - - - - - - - - - - - - - - - - - -
		 * Power Moonroof: 
		 * None with price: $0.0
		 * Selected with price: $595.0
		 * - - - - - - - - - - - - - - - - - - - - - - - - -
		 * Total Price of Choices is: 1755.0
		 */

		/**Assignment #4 Test Result (2/25/2016, 15:15 PM)
		 * *******************
		 * ~ File Name Updated!
		 * *******************
		 * *******************
		 * ~ Base Price Updated!
		 * *******************
		 * Waiting to update Name...
		 * Brand: Ford
		 * Model: Focus Wagon ZTW
		 * **********************************************
		 * ~ Option Price updated with synchronized method!
		 * **********************************************
		 * *********************************************
		 * ~ Option Set updated with synchronized method!
		 * *********************************************
		 * Base Price: 18445.0
		 * - - - - - - - - - - - - - - - - - - - - - - - - -
		 * Color: 
		 * Fort Knox Gold Clearcoat Metallic with price: $0.0
		 * Liquid Grey Clearcoat Metallic with price: $0.0
		 * Infra-Red Clearcoat with price: $0.0
		 * Grabber Green Clearcoat Metallic with price: $0.0
		 * Sangria Red Clearcoat Metallic with price: $0.0
		 * French Blue Clearcoat Metallic with price: $0.0
		 * Twilight Blue Clearcoat Metallic with price: $0.0
		 * CD Silver Clearcoat Metallic with price: $0.0
		 * Pitch Black Clearcoat with price: $0.0
		 * Cloud 9 White Clearcoat with price: $0.0
		 * - - - - - - - - - - - - - - - - - - - - - - - - -
		 * Ford Transmission: 
		 * Automatic with price: $0.0
		 * Standard with price: $-815.0
		 * - - - - - - - - - - - - - - - - - - - - - - - - -
		 * Brakes/Traction Control: 
		 * Standard with price: $0.0
		 * ABS with price: $400.0
		 * ABS with Advance Trac with price: $1625.0
		 * - - - - - - - - - - - - - - - - - - - - - - - - -
		 * Side Impact Air Bags: 
		 * None with price: $0.0
		 * Selected with price: $450.0
		 * - - - - - - - - - - - - - - - - - - - - - - - - -
		 * Power Moonroof: 
		 * None with price: $0.0
		 * Selected with price: $595.0
		 * - - - - - - - - - - - - - - - - - - - - - - - - -
		 * Total Price of Choices is: 0.0
		 */
