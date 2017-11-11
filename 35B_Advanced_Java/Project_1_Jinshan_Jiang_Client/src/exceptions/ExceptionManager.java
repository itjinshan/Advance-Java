package exceptions;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;

public class ExceptionManager extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// properties
	// error number to log error number
	// string to store error message
	private int errorno;
	private String errormsg;
	
	// **************************************
	// ** Constructors **
	// **************************************
	public ExceptionManager() {
		super();
	}
	
	public ExceptionManager(String errormsg) {
		super();
		this.errormsg = errormsg;
	}
	
	public ExceptionManager(int errorno) {
		super();
		this.errorno = errorno;
	}
	
	public ExceptionManager(int errorno, String errormsg) {
		super();
		this.errorno = errorno;
		this.errormsg = errormsg;
	}
	
	// **************************************
	// ** Setters and getters **
	// **************************************
	public int getErrorno() {
		return errorno;
	}
	
	public void setErrorno(int errorno) {
		this.errorno = errorno;
	}
	
	public String getErrormsg() {
		return errormsg;
	}
	
	public void setErrormsg(String errormsg) {
		this.errormsg = errormsg;
	}
	
	// **************************************
	// ** Print Method **
	// **************************************
	public void printmyproblem() {
		System.out.println("FixProblems [errorno = " + errorno + ", errormsg: " + errormsg); 
	}
	
	public void writetofile(int errno)
	{
		try {
			java.util.Date date= new java.util.Date();
			File file = new File("Exception Log.txt");

			// if file doesn't exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}
			
			FileWriter fw = new FileWriter("Exception Log.txt", true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(String.valueOf(new Timestamp(date.getTime())));
			bw.newLine();
			bw.write("Exception " + errno + " Captured!");
			bw.newLine();
			bw.newLine();
			bw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// **************************************
	// ** Fix Method**
	// **************************************
	public String fix(int errno) {
		//declaring a Fix101to199 object to access to the class
		Fix101to199 f1 = new Fix101to199(); 
		//declaring a Fix201to299 object to access to the class
		Fix201to299 f2 = new Fix201to299();
		
		//using switch statement to chose right method to fix different problem
		switch(errno){
			case 101: 
			{
		        writetofile(errno);
				return f1.fix101();
			}
				
			case 102:
			{
				writetofile(errno);
				return f1.fix102();
			}
			
			case 201:
			{
				writetofile(errno);
				return f2.fix201();
			}
			
			case 202:
			{
				writetofile(errno);
				return f2.fix202();
			}
			
			default:
				return "This went into default!";
		}
	}
}
