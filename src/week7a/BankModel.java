package week7a;
import javax.swing.table.*;
import java.util.*;
import java.text.*;
import java.io.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;

/**
 * @author Nandigam
 */
public class BankModel extends AbstractTableModel {

	private ArrayList<Account> acts;

	private String[] columnNames = { "Number", "Date Opened", "Account Owner",
			"Current Balance" };

	public BankModel() {
		acts = new ArrayList<Account>();
	}

	public int getRowCount() {
		return acts.size();
	}

	public int getColumnCount() {
		return columnNames.length;
	}

	public String getColumnName(int col) {
		return columnNames[col];
	}

	public Object getValueAt(int row, int col) {
		Object val = null;
		switch (col) {
		case 0:
			val = acts.get(row).getNumber();
			break;

		case 1:
			val = DateFormat.getDateInstance(DateFormat.SHORT).format(
					acts.get(row).getDateOpened().getTime());
			break;

		case 2:
			val = acts.get(row).getOwner();
			break;

		case 3:
			val = NumberFormat.getCurrencyInstance().format(
					acts.get(row).getBalance());
			break;
		}
		return val;
	}

	public Account get(int index) {
		return acts.get(index);
	}

	public int indexOf(Account act) {
		return acts.indexOf(act);
	}

	public void add(Account act) {
		if (act != null) {
			acts.add(act);
			fireTableRowsInserted(acts.size() - 1, acts.size() - 1);
		}
	}

	public void add(int index, Account act) {
		if (act != null) {
			acts.add(index, act);
			fireTableRowsInserted(index, index);
		}
	}

	public void remove(int index) {
		acts.remove(index);
		fireTableRowsDeleted(index, index);
		return;
	}

	public void remove(Account act) {
		remove(indexOf(act));
	}

	public void update(Account act) {
		int index = indexOf(act);
		if (index != -1) {
			this.fireTableRowsUpdated(index, index);
		}
	}

	public void clear() {
		if (acts.size() > 0) {
			int size = acts.size();
			acts.clear();
			this.fireTableRowsDeleted(0, size - 1);
		}
	}

	public void sortByAccountNumber() {
		if (acts.size() > 1) {
			Collections.sort(acts, new AccountNumberComparator());
			this.fireTableRowsUpdated(0, acts.size() - 1);
		}
	}

	public void sortByAccountOwner() {
		if (acts.size() > 1) {
			Collections.sort(acts, new AccountOwnerComparator());
			this.fireTableRowsUpdated(0, acts.size() - 1);
		}
	}

	public void sortByAccountDateOpened() {
		if (acts.size() > 1) {
			Collections.sort(acts, new AccountDateOpenedComparator());
			this.fireTableRowsUpdated(0, acts.size() - 1);
		}
	}

	public boolean saveAsSerialized(String filename) {
		if (filename.equals("")) {
			return false;
		}

		try {
			FileOutputStream fos = new FileOutputStream(filename);
			ObjectOutputStream os = new ObjectOutputStream(fos);
			os.writeObject(acts);
			os.close();
			return true;
		} catch (IOException ex) {
			return false;
		}
	}

	public boolean saveAsText(String filename) {
		if (filename.equals("")) {
			return false;
		}

		try {
			PrintWriter out = new PrintWriter(new BufferedWriter(
					new FileWriter(filename)));
			out.println(acts.size());
			for (int i = 0; i < acts.size(); i++) {
				Account act = acts.get(i);
				out.println(act.getClass().getName());
				out.println(act.getNumber());
				out.println(DateFormat.getDateInstance(DateFormat.SHORT)
						.format(act.getDateOpened().getTime()));
				out.println(act.getOwner());
				out.println(act.getBalance());
//				if (act instanceof CheckingAccount) {
//					out.println(((CheckingAccount) act).getMonthlyFee());
//				} else {
//					out.println(((SavingsAccount) act).getMinBalance());
//					out.println(((SavingsAccount) act).getInterestRate());
//				}
			}
			out.close();
			return true;
		} catch (IOException ex) {
			return false;
		}
	}

	public boolean saveAsXML(String filename) {
		if (filename.equals("")) {
			return false;
		}

		try {
			PrintWriter out = new PrintWriter(new BufferedWriter(
					new FileWriter(filename)));
			StringBuilder sb = new StringBuilder();
			sb.append("<?xml version=\"1.0\"?>\n");
			sb.append("<accounts>\n");
			for (int i = 0; i < acts.size(); i++) {
				Account act = acts.get(i);
				sb.append("<account>\n");
				sb.append("<type>" + act.getClass().getName() + "</type>\n");
				sb.append("<number>" + act.getNumber() + "</number>\n");
				sb.append("<owner>" + act.getOwner() + "</owner>\n");
				sb.append("<dateOpened>"
						+ DateFormat.getDateInstance(DateFormat.SHORT).format(
								act.getDateOpened().getTime())
						+ "</dateOpened>\n");
				sb.append("<balance>" + act.getBalance() + "</balance>\n");
//				if (act instanceof CheckingAccount) {
//					sb.append("<monthlyFee>"
//							+ ((CheckingAccount) act).getMonthlyFee()
//							+ "</monthlyFee>\n");
//				} else {
//					sb.append("<minBalance>"
//							+ ((SavingsAccount) act).getMinBalance()
//							+ "</minBalance>\n");
//					sb.append("<interestRate>"
//							+ ((SavingsAccount) act).getInterestRate()
//							+ "</interestRate>\n");
//				}
				sb.append("</account>\n");
			}
			sb.append("</accounts>\n");
			out.print(sb.toString());
			out.close();
			return true;
		} catch (IOException ex) {
			return false;
		}
	}

	public void loadFromSerialized(String filename) {
		try {
			FileInputStream fis = new FileInputStream(filename);
			ObjectInputStream is = new ObjectInputStream(fis);
			clear();
			acts = (ArrayList<Account>) is.readObject();
			this.fireTableRowsInserted(0, acts.size() - 1);
			is.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void loadFromText(String filename) {
		try {
			Scanner scanner = new Scanner(new File(filename));
			clear();
			int count = Integer.parseInt(scanner.nextLine().trim());
			for (int i = 0; i < count; i++) {
				String type = scanner.nextLine().trim();
				int actNumber = Integer.parseInt(scanner.nextLine().trim());
				GregorianCalendar dateOpened = null;
				try {
					DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
					Date date = formatter.parse(scanner.nextLine().trim());
					dateOpened = new GregorianCalendar();
					dateOpened.setTime(date);
				} catch (ParseException ex) {
					ex.printStackTrace();
				}
				String owner = scanner.nextLine().trim();
				double balance = Double.parseDouble(scanner.nextLine().trim());

				if (type.equals("CheckingAccount")) {
					double monthlyFee = Double.parseDouble(scanner.nextLine()
							.trim());
//					CheckingAccount act = new CheckingAccount(actNumber, owner,
//							dateOpened, balance, monthlyFee);
	//				add(act);
				} else {
					double minBalance = Double.parseDouble(scanner.nextLine()
							.trim());
					double interestRate = Double.parseDouble(scanner.nextLine()
							.trim());
//					SavingsAccount act = new SavingsAccount(actNumber, owner,
//							dateOpened, balance, minBalance, interestRate);
//					add(act);
				}
			}
			scanner.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void loadFromXML(String filename) {
		try {
			clear();
			
			File file = new File(filename);
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(file);
			doc.getDocumentElement().normalize();
			
			NodeList actLst = doc.getElementsByTagName("account");

			for (int i = 0; i < actLst.getLength(); i++) {

				Node actNode = actLst.item(i);

				if (actNode.getNodeType() == Node.ELEMENT_NODE) {

					Element element = (Element) actNode;

					int number = Integer.parseInt(element.getElementsByTagName("number").item(0).getChildNodes().item(0).getNodeValue());
					String owner = element.getElementsByTagName("owner").item(0).getChildNodes().item(0).getNodeValue();
					double balance = Double.parseDouble(element.getElementsByTagName("balance").item(0).getChildNodes().item(0).getNodeValue());
					GregorianCalendar dateOpened = null;
					
					try {
						DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
						Date date = formatter.parse(element.getElementsByTagName("dateOpened").item(0).getChildNodes().item(0).getNodeValue());
						dateOpened = new GregorianCalendar();
						dateOpened.setTime(date);
					} catch (ParseException ex) {
						ex.printStackTrace();
					}
					
					String type = element.getElementsByTagName("type").item(0).getChildNodes().item(0).getNodeValue();
//					if (type.equals("CheckingAccount")) {
//						double monthlyFee = Double.parseDouble(element.getElementsByTagName("monthlyFee").item(0).getChildNodes().item(0).getNodeValue());
//						CheckingAccount act = new CheckingAccount(number, owner, dateOpened, balance, monthlyFee);
//						add(act);
//					} else {
//						double minBalance = Double.parseDouble(element.getElementsByTagName("minBalance").item(0).getChildNodes().item(0).getNodeValue());
//						double interestRate = Double.parseDouble(element.getElementsByTagName("interestRate").item(0).getChildNodes().item(0).getNodeValue());
//						SavingsAccount act = new SavingsAccount(number, owner, dateOpened, balance, minBalance, interestRate);
//						add(act);
//					}
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
