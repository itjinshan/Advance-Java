package model;

import model.OptionSet.Option;
import java.io.Serializable;
import java.util.ArrayList;
import exceptions.*;

public class Automobile  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String brand;
	private String name;
	private float baseprice;
	private ArrayList<Option> choice = new ArrayList<Option>(1);
	private ArrayList<OptionSet> opset = new ArrayList<OptionSet>(1);

	// **************************************
	// ** Constructors **
	// **************************************

	// default constructor
	public Automobile() {
	}

	// constructor
	// building new Automotive object
	public Automobile(String brand, String name, float baseprice, int optionSetSize) {
		this.brand = brand;
		this.name = name;
		this.baseprice = baseprice;
		opset = new ArrayList<OptionSet>(optionSetSize);
		for(int i=0;i<this.getOptionSetSize();i++) 
			{
				OptionSet tempOpset = new OptionSet();
				opset.add(tempOpset);
			}
	}

	// **************************************
	// ** Getters **
	// **************************************
	/*
	 * i. Get Name of Automotive 
	 * ii. Get Automotive Base Price 
	 * iii. Get OptionSet (by index value)
	 * iv. Get Size of Option Set
	 * v. Get Brand
	 * vi. Get Choice of Option
	 * vii. Get Price of Choice
	 * viii. Get Total Price for All the Choices have been made
	 */

	public String getName() {
		return name;
	}

	public float getBasePrice() {
		return baseprice;
	}

	public OptionSet getOptionSet(int pos) {
		//System.out.println(opset[pos].getName());
		return opset.get(pos);
	}
	
	public int getOptionSetSize()
	{
		return opset.size();
	}
	
	public String getBrand()
	{
		return this.brand;
	}
	
	public Option getOptionChoice(String setName)
	{
		return this.opset.get(this.findOptionSet(setName)).getChoice();
	}
	
	public float getOptionChoicePrice(String setName)
	{
		return this.opset.get(this.findOptionSet(setName)).getChoice().getPrice();
	}
	
	public float getTotalPrice()
	{
		float sum = 0;
		for(int i = 0; i < choice.size(); i++)
		{
			sum += choice.get(i).getPrice();
		}
		return sum;
	}
	
	// **************************************
	// ** Find **
	// **************************************
	// finding the position of OptionSet
	// if not found! return -1
	public int findOptionSet(String name) {
		//using for loop to go through the whole array
		int pos = 0;
		for (int i = 0; i < opset.size(); i++) {
			if (name.equals(opset.get(i).getName()))
			{
				pos = i;
				break;
			}
			else
				pos = -1;
		}
		return pos;
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
	 * v. Set Option Choice to user choice
	 */
	public void setName(String _name) {
		_name = name;
	}

	public void setBasePrice(float _baseprice) {
		_baseprice = baseprice;
	}

	public void setValueofOptionSet(int i, String name, int size) {
		opset.add(i, new OptionSet(name, size));
	}

	public void setValueofOption(OptionSet opst, int i, String name, int price) {
		// using inner class method to set value
		opst.setOption(i, name, price);
	}

	public void setOptionChoice(String setName, String optionName)
	{
		if(findOptionSet(setName) != -1)
		{
			if(findOption(opset.get(findOptionSet(setName)), optionName) != -1)
			{
				Option temp = (this.opset.get(this.findOptionSet(setName))).setChoice(this.opset.get(this.findOptionSet(setName))
						.getOption(this.findOption(this.opset.get(this.findOptionSet(setName)), optionName)));
				choice.add(temp);
			}
			else
				System.out.println("Option Not Found!");
		}
		else
			System.out.println("Option Set Not Found!");
	}
	
	// **************************************
	// ** Delete **
	// **************************************
	/**
	 * i. Delete Option
	 * ii. Delete Option Set
	 * iii. remove a Automobile Object
	 */
	public boolean deleteOption(OptionSet OptSet, int pos) {
		//using inner class method to delete value
		if (OptSet._deleteOption(pos))
			return true;
		else
			return false;
	}

	public boolean deleteOptionSet(int pos) {
		if (pos >= 0 && pos < opset.size()) {
			opset.remove(pos);
			return true;
		}
		return false;
	}

	public void removeAuto(Automobile a)
	{
		a = null;
	}
	
	// **************************************
	// ** Update **
	// **************************************
	/**
	 * i. Update a Option with New Price
	 * ii. Update a Option Set with New Name
	 * iii. Update the Linked Hash Map, Add One More Automobile to it
	 */
	public void updateOption(OptionSet OptSet, String name, float newPrice)
	{
		// using inner class to update value
		//int i = findOption(OptSet, newName);
		do{
			try{
				int i = findOption(OptSet, name);
				if(i == -1)
					throw new ExceptionManager(102, "Option Not Found!");
				else{
						OptSet._updateOption(i, name, newPrice);
						break;
					}
			}catch(ExceptionManager e) {
				name = e.fix(102);
			}
		}while(true);
	}
	
	public void updateOptionSet(String name, String newName)
	{
		do{
			try{
				int i = findOptionSet(name);
				if(i == -1)
					throw new ExceptionManager(101, "Option Set Not Found!");
				else{
					//System.out.println(newName);
					if(i >= 0 && i < opset.size())
						opset.get(i).setName(newName);
					break;
					//switcher = true;
					}
			}catch(ExceptionManager e) {
				name = e.fix(101);
			}
		}while(true);

	}
	
	public Automobile addAuto(String brand, String autoName, float bprice, int size)
	{
		Automobile a = new Automobile(brand, autoName, bprice, size);
		return a;
	}

	// **************************************
	// ** Print **
	// **************************************
	public void print()
	{
		System.out.println("Brand: " + getBrand());
		System.out.println("Model: " + getName());
		System.out.println("Base Price: " + getBasePrice());
		for(int i = 0; i < opset.size(); i ++)
		{
			System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - -");
			System.out.println(opset.get(i).getName() + ": ");
			for(int c = 0; c < opset.get(i).getSize(); c++){
				opset.get(i)._print(c);
			}
		}
		System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - -");
		System.out.println("Total Price of Choices is: " + getTotalPrice());
	}
}
