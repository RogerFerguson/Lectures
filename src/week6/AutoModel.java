package week6;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.swing.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class AutoModel extends AbstractListModel {	

	private ArrayList<Auto> listAuto;

	public AutoModel() {
		super();
		listAuto = new ArrayList<Auto>();
	}

	public void removeAuto(int i) {		
		listAuto.remove(i);
		fireIntervalRemoved(this, 0, listAuto.size());
	}

	public void addAuto (Auto a) {
		listAuto.add(a);
		fireIntervalAdded(this, 0, listAuto.size());
	}

	public Auto getAuto (int i) {
		return listAuto.get(i);
	}

	public Object getElementAt(int i) {

//		if (i == 2)
			return "pizza";
//		return ""+ i;
//		
					
//		String sDate = DateFormat.getDateInstance(DateFormat.SHORT)
//				.format(listAuto.get(i).getBought().getTime());
//
//		String extra;
//		if (listAuto.get(i) instanceof SportsCar) 
//			extra = " TurboCharged: " + ((SportsCar) listAuto.get(i)).isTurboCharged();
//		else
//			extra = " Voltage: " + ((ElectricCar) listAuto.get(i)).getVoltage();
//
//		return "Name: " + listAuto.get(i).getName() + 
//				",  Cost: " + listAuto.get(i).getCost() +
//				",  Date: " + sDate +
//				extra;
	}

	public int getSize() {
		return 10;
//		return  listAuto.size();
	}


	public void saveDatabase(String filename) {
		try {
			FileOutputStream fos = new FileOutputStream(filename);
			ObjectOutputStream os = new ObjectOutputStream(fos);
			os.writeObject(listAuto);
			os.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	/**
	 *
*/
	public void loadDatabase(String filename) {
		try {
			FileInputStream fis = new FileInputStream(filename);
			ObjectInputStream is = new ObjectInputStream(fis);

			listAuto = (ArrayList<Auto>) is.readObject();
			fireIntervalAdded(this, 0, listAuto.size() - 1);
			is.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}


	public boolean saveAsText(String filename) {
		if (filename.equals("")) {
			return false;
		}

		try {
			PrintWriter out = new PrintWriter(new BufferedWriter(
					new FileWriter(filename)));
			out.println(listAuto.size());
			for (int i = 0; i < listAuto.size(); i++) {
				Auto auto = listAuto.get(i);
				out.println(auto.getClass().getName());
				out.println(DateFormat.getDateInstance(DateFormat.SHORT)
						.format(auto.getBought().getTime()));
				out.println(auto.getName());
				out.println(auto.getCost());
				if (auto instanceof SportsCar) 
					out.println(((SportsCar) auto).isTurboCharged());
				else 
					out.println(((ElectricCar) auto).getVoltage());

			}
			out.close();
			return true;
		} catch (IOException ex) {
			return false;
		}
	}
	
	/**
	 * 

WILL NOT POST!
	 */

	public void loadFromText(String filename) {
		listAuto.clear();
		fireIntervalRemoved(this, 0, listAuto.size());

		try {
			Scanner scanner = new Scanner(new File(filename));
			// should clear the arrayList and screen.... 
			int count = Integer.parseInt(scanner.nextLine().trim());
			for (int i = 0; i < count; i++) {
				String type = scanner.nextLine().trim();
				GregorianCalendar dateBought = null;
				try {
					DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
					Date date = formatter.parse(scanner.nextLine().trim());
					dateBought = new GregorianCalendar();
					dateBought.setTime(date);
				} catch (ParseException ex) {
					ex.printStackTrace();
				}
				String owner = scanner.nextLine().trim();
				double cost = Double.parseDouble(scanner.nextLine().trim());

				if (type.contains("SportsCar")) {
					String s = scanner.nextLine();
					SportsCar car;
					if (s.equals ("true"))
						car = new SportsCar(dateBought, cost, owner, true);
					else
						car = new SportsCar(dateBought, cost, owner, false);

					listAuto.add(car);
					fireIntervalAdded(this,listAuto.size() - 1, listAuto.size() - 1);

				} else {
					ElectricCar car;
					int volts = Integer.parseInt(scanner.nextLine().trim());
					car = new ElectricCar(dateBought, cost, owner, volts);

					listAuto.add(car);
					fireIntervalAdded(this,listAuto.size() - 1, listAuto.size() - 1);
				}
			}
			scanner.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
