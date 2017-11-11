package model;

import java.io.Serializable;

public class Automotive implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private float baseprice;
	private OptionSet opset[];

	// **************************************
	// ** Constructors **
	// **************************************

	// default constructor
	public Automotive() {
	}

	// constructor
	// building new Automotive object
	public Automotive(String name, float baseprice, int optionSetSize) {
		this.name = name;
		this.baseprice = baseprice;
		opset = new OptionSet[optionSetSize];
	}

	// **************************************
	// ** Getters **
	// **************************************
	/*
	 * 1. Get Name of Automotive 2. Get Automotive Base Price 3. Get OptionSet
	 * (by index value)
	 */

	public String getName() {
		return name;
	}

	public float getBasePrice() {
		return baseprice;
	}

	public OptionSet getOptionSet(int pos) {
		return opset[pos];
	}
	
	public int getOptionSetSize()
	{
		return opset.length;
	}
	

	// **************************************
	// ** Find **
	// **************************************
	// finding the position of OptionSet
	// if not found! return -1
	public int findOptionSet(String name) {
		//using for loop to go through the whole array
		for (int i = 0; i < opset.length; i++) {
			if (name == opset[i].getName())
				return i;
		}
		return -1;
	}

	// finding the position of Option in the OptionSet
	// if not found! return -1
	public int findOption(OptionSet optSet, String nameOfOption) {
		// find optset passed into this function using findOptionSet class.
		// Then find option.
		return optSet._findOption(nameOfOption);
	}

	// **************************************
	// ** Setters **
	// **************************************
	/**
	 * i. SetName 
	 * ii. Set Base Price 
	 * iii. Set values of OptionSet 
	 * iv. Set values of Option (in context of OptionSet)
	 */
	public void setName(String _name) {
		_name = name;
	}

	public void setBasePrice(float _baseprice) {
		_baseprice = baseprice;
	}
	
	public void setOpset(int size)
	{
		opset = new OptionSet[size];
	}

	public void setValueofOptionSet(int i, String name, int size) {
		opset[i] = new OptionSet(name, size);
	}

	public void setValueofOption(OptionSet opst, int i, String name, int price) {
		// using inner class method to set value
		opst.setOption(i, name, price);
	}

	// **************************************
	// ** Delete **
	// **************************************
	public boolean deleteOption(OptionSet OptSet, int pos) {
		//using inner class method to delete value
		if (OptSet._deleteOption(pos))
			return true;
		else
			return false;
	}

	public boolean deleteOptionSet(int pos) {
		if (pos >= 0 && pos < opset.length) {
			opset[pos] = new OptionSet();
			return true;
		}
		return false;
	}

	// **************************************
	// ** Update **
	// **************************************
	public boolean updataOption(OptionSet OptSet, String newName, float newPrice)
	{
		// using inner class to update value
		int i = findOption(OptSet, OptSet.getName());
		if(OptSet._updateOption(i, newName, newPrice))
			return true;
		else
			return false;
	}
	
	public boolean updateOptionSet(String name, String newName, int newSize)
	{
		int i = findOptionSet(name);
		if(i >= 0 && 1 < opset.length){
			opset[i] = new OptionSet(newName, newSize);
			return true;
		}
		else
			return false;
	}
	
	// **************************************
	// ** Print **
	// **************************************
	public void print()
	{
		System.out.println("Model: " + getName());
		System.out.println("Base Price: " + getBasePrice());
		for(int i = 0; i < opset.length; i ++)
		{
			System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - -");
			System.out.println(opset[i].getName() + ": ");
			for(int c = 0; c < opset[i].getSize(); c++){
				opset[i]._print(c);
			}
		}
	}
}
