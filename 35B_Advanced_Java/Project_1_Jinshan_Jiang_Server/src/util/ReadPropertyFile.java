package util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Properties;
import java.util.StringTokenizer;

import exceptions.ExceptionManager;
import model.Automobile;

public class ReadPropertyFile {
	public void readProFile(Properties props, LinkedHashMap<String, Automobile> a1) {
		String tempT = props.getProperty("Total");
		int totalCarModel = 0;
		int c = 1;
		Automobile auto = new Automobile();

		if (tempT != null)
			totalCarModel = Integer.parseInt(tempT);
		else
			System.out.println("READING ERROR");

		for (int i = 1; i <= totalCarModel; i++) {
			String brand = props.getProperty(i + "Brand");
			String modelname = props.getProperty(i + "ModelName");
			float baseprice = Float.parseFloat(props.getProperty(i + "BasePrice"));
			int optionSetNumber = Integer.parseInt(props.getProperty(i + "OptionSetNumber"));
			String options, info;
			
			do {
				try {
					// test if base price is not reasonable
					// if is not, throw exception 202 and fix it
					if (baseprice <= 100) {
						throw new ExceptionManager(202, "Missing Base Price!");
					} else {
						auto = new Automobile(brand, modelname, baseprice, optionSetNumber);
						break;
					}
				} catch (ExceptionManager e) {
					// covert base price from string to float
					baseprice = Float.parseFloat(e.fix(202));
				}
			} while (true); // infinite loop until it breaks itself

			for (int o = 1; o <= optionSetNumber; o++) {
				options = props.getProperty(i+"Option"+o);
				StringTokenizer st = new StringTokenizer(options, ",");
				String tempOptName = st.nextToken();
				int tempOptSize = Integer.parseInt(st.nextToken());
				auto.setValueofOptionSet(o-1, tempOptName, tempOptSize);
				
				for(int os = 1; os <= tempOptSize; os++)
				{
					info = props.getProperty(i+"OptionValue"+o+"*"+os);
					StringTokenizer _st = new StringTokenizer(info, ",");
					String tempname = _st.nextToken();
					int tempPrice = Integer.parseInt(_st.nextToken());
					auto.setValueofOption(auto.getOptionSet(o-1), os-1, tempname, tempPrice);
				}
			}
			a1.put(auto.getBrand(), auto);
		}
	}		
}
