package util;

import java.io.*;
import java.util.StringTokenizer;

import model.Automotive;

public class ReadSource
{
	public Automotive read(){
		Automotive auto = new Automotive();
		try {
			FileReader file = new FileReader("Car Info.txt");
			BufferedReader buff = new BufferedReader(file);
			boolean eof = false;

			int counter = 0;
			// create new Automotive object
			auto = new Automotive(buff.readLine(), Float.parseFloat(buff.readLine()), Integer.parseInt(buff.readLine()));
		
			while (!eof) {
				String line = buff.readLine();
				if (line == null)
					eof = true;
				else
				{	
					if(building(auto, line, counter, buff))
						counter ++;
					else
						System.out.println("Building Error!");
				}
			}
			buff.close();
		} catch (IOException e) {
			System.out.println("Error ­­ " + e.toString());
		}
		return auto;
	}
	
	// **************************************
	// ** Helper Methods **
	// **************************************
	public boolean building(Automotive _auto, String _line, int _counter, BufferedReader _buff){
		StringTokenizer st = new StringTokenizer(_line,",");
		String tempOptName = st.nextToken();
		int tempOptSize = Integer.parseInt(st.nextToken());
		_auto.setValueofOptionSet(_counter, tempOptName, tempOptSize);
		if(buildingOptions(_auto, _counter, tempOptSize, _buff))
			return true;
		else
			return false;
	}
	
	public boolean buildingOptions(Automotive auto_, int counter_, int tempOptSize_, BufferedReader buff_){
		try {
		for(int n = 0; n < tempOptSize_; n++)
		{
			String tempLine;
			
				tempLine = buff_.readLine(); // read in new lines for Options
			StringTokenizer _st = new StringTokenizer(tempLine, ",");
			String _tempname = _st.nextToken();
			int tempPrice = Integer.parseInt(_st.nextToken());
			auto_.setValueofOption(auto_.getOptionSet(counter_), n, _tempname, tempPrice);
		}
		return true;
	}catch (IOException e) {
		System.out.println("Setting Option Error reading line!");
		return false;
	}
}}