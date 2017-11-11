package model;

import java.io.Serializable;

public class OptionSet implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// **************************************
	// ** Inner Class **
	// **************************************
	// Option class
	private class Option extends OptionSet{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private String nameOfOption;
		private float price;

		// Constructors
		protected Option() {
		}

		// Constructor to generate new option object
		protected Option(String name, float price) {
			this.nameOfOption = name;
			this.price = price;
		}

		// Getters
		protected String getName() {
			return nameOfOption;
		}

		protected float getPrice() {
			return price;
		}
	}

	// ******** Inner class ends ********

	private Option opt[];
	private String nameOfSet;

	// **************************************
	// ** Constructors **
	// **************************************
	protected OptionSet(){}
	
	//Constructor to generate new Option Set object
	protected OptionSet(String n, int size) {
		opt = new Option[size];
		this.nameOfSet = n;
	}

	// **************************************
	// ** Getters **
	// **************************************
	protected String getName() {
		return nameOfSet;
	}
	protected int getSize(){
		return opt.length;
	}
	
	// **************************************
	// ** Find **
	// **************************************
	protected int _findOption(String _nameOfOption) {
		for (int i = 0; i < opt.length; i++) {
			if (opt[i].getName() == _nameOfOption) {
				return i;
			}
		}
		return -1;
	}

	// **************************************
	// ** Setters **
	// **************************************
	protected void setName(String name) {
		this.nameOfSet = name;
	}
	protected void setOption(int i, String name, int price) {
		opt[i] = new Option(name, price);
	}

	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
	// sub-methods to help methods in Automotive class
	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
	// **************************************
	// ** Delete **
	// **************************************
	protected boolean _deleteOption(int _pos) {
		if(_pos >= 0 && _pos < opt.length){
			opt[_pos] = new Option();
			return true;
		}
		else
			return false;
	}
	
	// **************************************
	// ** Update **
	// **************************************
	protected boolean _updateOption(int pos, String _newName, float _newPrice)
	{
		if(pos >= 0 && pos < opt.length){
			opt[pos] = new Option(_newName, _newPrice);
			return true;
		}
		else
			return false;
	}
	// **************************************
	// ** Print **
	// **************************************
	protected void _print(int pos)
	{
		if(pos >= 0 && pos < opt.length)
			System.out.println(opt[pos].getName() + " with price: $" + opt[pos].getPrice());
		else
			System.out.println("Position of Option is out of range!");
	}
}