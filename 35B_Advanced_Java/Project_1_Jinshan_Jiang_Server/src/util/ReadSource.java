package util;

import java.io.*;
import java.util.Properties;
import java.util.StringTokenizer;

import exceptions.ExceptionManager;
import model.Automobile;

public class ReadSource {
	public Automobile read(String filename) {
		do {
			Automobile auto = new Automobile();
			try {
				FileReader file = new FileReader(filename);
				BufferedReader buff = new BufferedReader(file);
				boolean eof = false;

				int counter = 0;
				// create new Automotive object
				String brand = buff.readLine();
				String modelname = buff.readLine();
				float baseprice = Float.parseFloat(buff.readLine());
				int optionSetNumber = Integer.parseInt(buff.readLine());
				do {
					try {
						// test if base price is not reasonable
						// if is not, throw exception 202 and fix it
						if (baseprice <= 100) {
							throw new ExceptionManager(202, "Missing Base Price!");
						} else {
							auto = new Automobile(brand, modelname, baseprice, optionSetNumber);
							System.out.println("*******************");
							System.out.println("~ Base Price Updated!");
							System.out.println("*******************");
							break;
						}
					} catch (ExceptionManager e) {
						// covert base price from string to float
						baseprice = Float.parseFloat(e.fix(202));
					}
				} while (true); // infinite loop until it breaks itself

				while (!eof) {
					String line = buff.readLine();
					if (line == null)
						eof = true;
					else {
						if (building(auto, line, counter, buff))
							counter++;
						else
							System.out.println("Building Error!");
					}
				}
				buff.close();
				return auto;
				// IOException for file and throw exception 201
			} catch (IOException f) {
				ExceptionManager e = new ExceptionManager(201, "File Not Found!");
				filename = e.fix(201); // calling fixing method for error 201
				System.out.println("*******************");
				System.out.println("~ File Name Updated!");
				System.out.println("*******************");
			}
		} while (true);
	}

	// **************************************
	// ** Helper Methods **
	// **************************************
	public boolean building(Automobile _auto, String _line, int _counter, BufferedReader _buff) {
		StringTokenizer st = new StringTokenizer(_line, ",");
		String tempOptName = st.nextToken();
		int tempOptSize = Integer.parseInt(st.nextToken());
		_auto.setValueofOptionSet(_counter, tempOptName, tempOptSize);
		if (buildingOptions(_auto, _counter, tempOptSize, _buff))
			return true;
		else
			return false;
	}

	public boolean buildingOptions(Automobile auto_, int counter_, int tempOptSize_, BufferedReader buff_) {
		try {
			for (int n = 0; n < tempOptSize_; n++) {
				String tempLine;

				tempLine = buff_.readLine(); // read in new lines for Options
				StringTokenizer _st = new StringTokenizer(tempLine, ",");
				String _tempname = _st.nextToken();
				int tempPrice = Integer.parseInt(_st.nextToken());
				auto_.setValueofOption(auto_.getOptionSet(counter_), n, _tempname, tempPrice);
			}
			return true;
		} catch (IOException e) {
			System.out.println("Setting Option Error reading line!");
			return false;
		}
	}
}