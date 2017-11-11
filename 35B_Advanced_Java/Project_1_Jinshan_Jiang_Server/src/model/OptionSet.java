package model;

import java.io.Serializable;
import java.util.ArrayList;

public class OptionSet implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Option choice;
	// **************************************
	// ** Inner Class **
	// **************************************
	// Option class
		class Option extends OptionSet{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private String nameOfOption;
		private float price;

		// **************************************
		// ** Option Constructors **
		// **************************************
		protected Option() {
		}

		// Constructor to generate new option object
		protected Option(String name, float price) {
			this.nameOfOption = name;
			this.price = price;
		}

		// **************************************
		// ** Option Getters **
		// **************************************
		/**
		 * i. Get Option Name
		 * ii. Get Option Price
		 */
		protected String getName() {
			return nameOfOption;
		}

		protected float getPrice() {
			return price;
		}
		
		// **************************************
		// ** Option Getters **
		// **************************************
		/**
		 * i. Set Name of Option
		 * ii. Set Price of Option
		 */
		protected void setOptName(String name)
		{
			this.nameOfOption = name;
		}
		
		protected void setOptPrice(float price){
			this.price = price;
		}
	}

	// ******** Inner class ends ********

	private ArrayList<Option> opt = new ArrayList<Option>(1);
	private String nameOfSet;

	// **************************************
	// ** Option Set Constructors **
	// **************************************
	protected OptionSet(){}
	
	//Constructor to generate new Option Set object
	protected OptionSet(String n, int size) {
		this.nameOfSet = n;
	}

	// **************************************
	// ** Option Set Getters **
	// **************************************
	/**
	 * i. Get Name of Option Set
	 * ii. Get Size of Option Array
	 * iii. Get User Choice
	 * iv. Get Option with Position
	 */
	protected String getName() {
		return nameOfSet;
	}
	
	protected int getSize(){
		return opt.size();
	}
	
	protected Option getChoice()
	{
		return choice;
	}
	
	protected Option getOption(int pos)
	{
		return opt.get(pos);
	}

	// **************************************
	// ** Option Set Setters **
	// **************************************
	/**
	 * i. Set Name of Option Set
	 * ii. Set Option with Name and Price
	 * iii. Set User Choice
	 */
	protected void setName(String name) {
		this.nameOfSet = name;
	}

	protected void setOption(int i, String name, int price) {
		opt.add(i, new Option(name, price));
	}

	protected Option setChoice(Option targetOption)
	{
		return choice = targetOption;
	}
	
	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
	// sub-methods to help methods in Automotive class
	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
	// **************************************
	// ** Option Set Delete **
	// **************************************
	protected boolean _deleteOption(int _pos) {
		if(_pos >= 0 && _pos < opt.size()){
			opt.remove(_pos);
			return true;
		}
		else
			return false;
	}
	
	// **************************************
	// ** Option Set Update **
	// **************************************
	protected void _updateOption(int pos, String _newName, float _newPrice)

	{
		if(pos >= 0){
			if(_newPrice == -1){	
				System.out.println(_newPrice);
				opt.get(pos).setOptName(_newName);
				opt.get(pos).setOptPrice(opt.get(pos).getPrice());
			}
			else
			{
				opt.get(pos).setOptName(_newName);
				opt.get(pos).setOptPrice(_newPrice);
			}
		}
	}
	
	// **************************************
	// ** Option Set Find **
	// **************************************
	protected int _findOption(String _nameOfOption) {
		int pos = 0;
		for (int i = 0; i < opt.size(); i++) 
		{
			if (_nameOfOption.equals(opt.get(i).getName())) 
			{
				pos = i;
				break;
			}
			else{
				pos = -1;
			}
		}
		return pos;
	}

	// **************************************
	// ** Option Set Print **
	// **************************************
	protected void _print(int pos)
	{
		if(pos >= 0 && pos < opt.size())
			System.out.println(opt.get(pos).getName() + " with price: $" + opt.get(pos).getPrice());
		else
			System.out.println("Position of Option is out of range!");
	}

	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
	// END sub-methods to help methods in Automotive class
	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
}