package week8;

public class SortingPlayerListB {


	//-----------------------------------------------------------------
	//  Creates an array of Contact objects, sorts them, then prints
	//  them.
	//-----------------------------------------------------------------
	public static void main (String[] args)
	{
		ContactB[] players = new ContactB[7];

		players[0] = new ContactB ("Rodger", "Federer", "610-555-7384");
		players[1] = new ContactB ("Andy", "Roddick", "215-555-3827");
		players[2] = new ContactB ("Maria", "Sharapova", "733-555-2969");
		players[3] = new ContactB ("Venus", "Williams", "663-555-3984");
		players[4] = new ContactB ("Lleyton", "Hewitt", "464-555-3489");
		players[5] = new ContactB ("Eleni", "Daniilidou", "322-555-2284");
		players[6] = new ContactB ("Serena", "Williams", "243-555-2837");

		SortingB.insertionSort(players);

		for (Comparable player : players)
			System.out.println (player);
	}
}
