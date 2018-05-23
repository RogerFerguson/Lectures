package week6a;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;

public class autoEngine extends AbstractTableModel {	

	private ArrayList<Auto> listAuto;
	private String[] columnNames = {"Name", "Cost", "Date", "Info"};


	@Override
	public int getColumnCount() {
		return  columnNames.length;  // 4
	}

	@Override
	public int getRowCount() {
		return listAuto.size();     // returns number of items in the arraylist
	}

	@Override
	public Object getValueAt(int row, int col) {
		//return row + ";"+ col;
		//		return "hello";

		//		if (i == 2)
		//			return "pizza";

		//		return "Name: " + listAuto.get(i).getName() + 
		//				",  Cost: " + listAuto.get(i).getCost();
		//				
		//	

		switch (col) {
		case 0: 
			return (listAuto.get(row).getName());

		case 1: 
			return (listAuto.get(row).getCost());

		case 2:
			return (DateFormat.getDateInstance(DateFormat.SHORT)
					.format(listAuto.get(row).getBought().getTime()));

		case 3:
			if (listAuto.get(row) instanceof SportsCar) 
				return (" TurboCharged: " + ((SportsCar) listAuto.get(row)).isTurboCharged());
			else
				return (" Voltage: " + ((ElectricCar) listAuto.get(row)).getVoltage());

		default:
			return null;
		}

	}

	@Override
	public String getColumnName(int col) {
		return columnNames[col];
	}


	public autoEngine() {
		super();
		listAuto = new ArrayList<Auto>();
	}

	public void removeAuto(int i) {		
		listAuto.remove(i);
		fireTableRowsDeleted(0, listAuto.size());
	}

	public void addAuto (Auto a) {
		listAuto.add(a);
		if (a.getCost() > 1000)
			fireTableRowsInserted( 0, listAuto.size());
	}

	public Auto getAuto (int i) {
		return listAuto.get(i);
	}

	public int getSize() {
		return listAuto.size();
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


	public void loadDatabase(String filename) {
		try {
			FileInputStream fis = new FileInputStream(filename);
			ObjectInputStream is = new ObjectInputStream(fis);

			listAuto = (ArrayList<Auto>) is.readObject();
			fireTableRowsInserted(0, listAuto.size() - 1);
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



	public void loadFromText(String filename) {
		listAuto.clear();
		fireTableRowsDeleted( 0, listAuto.size());

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
					fireTableRowsInserted(listAuto.size() - 1, listAuto.size() - 1);

				} else {
					ElectricCar car;
					int volts = Integer.parseInt(scanner.nextLine().trim());
					car = new ElectricCar(dateBought, cost, owner, volts);

					listAuto.add(car);
					fireTableRowsInserted(listAuto.size() - 1, listAuto.size() - 1);
				}
			}
			scanner.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}



}
