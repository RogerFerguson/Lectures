package package1;

import java.io.*;
import java.text.DateFormat;
import java.util.ArrayList;
import javax.swing.*;

/*****************************************************************
 * 
 * Maintains the list engine for the rental store 
 * 
 *****************************************************************/
public class ListEngine extends AbstractListModel{

	/** Boolean variable */
	private boolean filter;
	
	/** Holds list of DVDs */
	private ArrayList<DVD> listDVDs;
	private ArrayList<DVD> altListDVDs;
	
	/** Holds DVD object */
//	private DVD unit;
	
	/*****************************************************************
	 * 
	 * Maintains the list engine for the rental store 
	 * 
	 *****************************************************************/
	public ListEngine(){
		super();
		filter = false;
		listDVDs = new ArrayList<DVD>();

	}
	
	/*****************************************************************
	 * 
	 * Adds a DVD to the list
	 * 
	 *****************************************************************/
	public void add(DVD a){
		listDVDs.add(a);
		fireIntervalAdded(this, 0, listDVDs.size());
		return;
	}
	
	/*****************************************************************
	 * 
	 * Removes a DVD to the list
	 * 
	 *****************************************************************/
	public DVD removes(DVD a){
		listDVDs.remove(a);
		fireIntervalAdded(this, 0, listDVDs.size());
		return null;
	}
	
	/*****************************************************************
	 * 
	 * Gets the element at the specified location given
	 * 
	 * @param index - the location of the specified element
	 * @return object - the object at the specified location
	 *****************************************************************/
	public Object getElementAt(int index) {
		
		String line = "Name: " + index + " " +
				listDVDs.get(index).getRenter() + ", Title: " +
				listDVDs.get(index).getTitle() + ", Rented On: " +
				listDVDs.get(index).getBought() + ", Due Back On: " +
				listDVDs.get(index).getDueBack();
		//line += ", Game Player: " + listDVDs.get(index).getPlatform();
		return line;
	}

	/*****************************************************************
	 * 
	 * Returns the size as an integer
	 * 
	 * @return int - returns the size as an int 
	 *****************************************************************/
	public int getSize() {
		return listDVDs.size();
	}

	/*****************************************************************
	 * 
	 * Returns the index of DVD
	 * 
	 * @return int - returns the index of the DVD
	 *****************************************************************/
	public DVD getIndex(int i){
		return listDVDs.get(i);
	}
	
	/*****************************************************************
	 * 
	 * Saves the new DVD to the List Engine
	 * 
	 *****************************************************************/
	public void saveAsSerialized(String filename) throws IOException{
		FileOutputStream fos = new FileOutputStream(filename);
		ObjectOutputStream os = new ObjectOutputStream(fos);
		os.writeObject(listDVDs);
		os.close();
	}
	
	/*****************************************************************
	 * 
	 * Loads the new DVD to the List Engine
	 * 
	 *****************************************************************/
	public void loadFromSerialized(String filename) throws IOException{
		FileInputStream fis = new FileInputStream(filename);
		ObjectInputStream is = new ObjectInputStream(fis);
		try {
			listDVDs = (ArrayList<DVD>) is.readObject();
		} catch (ClassNotFoundException e) {
			System.out.println("Error, file not found");
		}
		is.close();
	}
}
