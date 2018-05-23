package week4;
//********************************************************************
//  Dictionary.java       Author: Lewis/Loftus
//
//  Represents a dictionary, which is a book. Used to demonstrate
//  inheritance.
//********************************************************************

public class Dictionary extends Book
{
	protected int definitions = 52500;
	//private int pages;
	
	public Dictionary (int def) {
		super(def);
		definitions = def;
		pages = 12;
		super.pages = 12;
		super.setPages(12);
	}

	public Dictionary() {
		super();
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	//}
	//-----------------------------------------------------------------
	//  Prints a message using both local and inherited values.
	//-----------------------------------------------------------------
	public double computeRatio ()
	{
		return definitions/getPages();
	}

	//----------------------------------------------------------------
	//  Definitions mutator.
	//----------------------------------------------------------------
	public void setDefinitions (int numDefinitions)
	{
		definitions = numDefinitions;
	}

	//----------------------------------------------------------------
	//  Definitions accessor.
	//----------------------------------------------------------------
	public int getDefinitions ()
	{
		return definitions;
	}
}
