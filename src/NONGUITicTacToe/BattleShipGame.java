package NONGUITicTacToe;

import java.util.*;

public class BattleShipGame {
	
	int size;
	
	boolean[][] ug1;		// user grid for recording guesses
	Ship[][] ug2;		// user grid for recording ship locations
	boolean[][] cg1;		// computer grid for recording guesses
	Ship[][] cg2;		// computer grid for recording ship locations
	
	Ship userAirCraftCarrier;
	Ship userBattleShip;
	Ship userSubmarine;
	
	Ship computerAirCraftCarrier;
	Ship computerBattleShip;
	Ship computerSubmarine;
	Random n;
	int row, col;
	
	boolean AI = false;   // turn on if a hit takes place
	int saveRow, saveCol;  // used to retain values for row and col when a hit occurs.
	
	
	public void reset(int size) {
		this.size = size;
		
		ug1 = new boolean[size][size];
		ug2 = new Ship[size][size];
		cg1 = new boolean[size][size];
		cg2 = new Ship[size][size];
		
		for (int i = 0; i < size; i++)
			for (int j = 0; j < size; j++) {
				ug1[i][j] = false;				// no guess yet
				ug2[i][j] = null;				// no ship yet
				cg1[i][j] = false; 
				cg2[i][j] = null; 
			}
		
		// computer sets ships
		
		n = new Random();
		
		// this sets an aircraft carrier in place
		int direction =  n.nextInt(2);
		if (direction == Ship.VERTICAL) {  // vertical 
			int r = n.nextInt(size - 4);
			int c = n.nextInt(size);
			computerAirCraftCarrier = new Ship (4, Ship.VERTICAL, "Air Craft Carrier", r,c);			// create one instance	
			System.out.println ("random1 r " + r + " c " + c + " o " + Ship.VERTICAL);
			for (int i = 0; i < 4; i++) 	// place ships
				cg2[r+i][c] = computerAirCraftCarrier;			// to save some space I point to same object
		}
		
		else  {
			int c = n.nextInt(size - 4);
			int r = n.nextInt(size);
			computerAirCraftCarrier = new Ship (4, Ship.HORIZONTAL, "Air Craft Carrier", r,c);			// create one instance	
			System.out.println ("random2 r" + r + "c" + c + " o " + Ship.HORIZONTAL) ;
			for (int i = 0; i < 4; i++) 
				cg2[r][c+i] = computerAirCraftCarrier;
		}
		
		
	}
	public BattleShipGame(int size) {
		reset(size);
	}
	
	
	
	public boolean setUserAirCraftShip(int r, int c, int orientation) {    // sets and validates placement of aircraft carrier. 
		
		if ((r < 0) || (c < 0)) 
			return false;
		
		if ((orientation == Ship.VERTICAL) && (r <= size - 4)) {					// vertical and will it go beyond bounds 
			userAirCraftCarrier = new Ship (4, Ship.VERTICAL, "Air Craft Carrier", r,c);	// create one instance	
			for (int i = 0; i < 4; i++) 
				ug2[r+i][c] = userAirCraftCarrier;
			return true;
		}
		
		if ((orientation == Ship.HORIZONTAL) && (c <= size - 4)) { 				// horizontal and will it go beyond bounds 
			userAirCraftCarrier = new Ship (4, Ship.HORIZONTAL, "Air Craft Carrier", r,c);			// create one instance	
			for (int i = 0; i < 4; i++) 
				ug2[r][c+i] = userAirCraftCarrier;
			return true;
		}
		
		return false;
	}
	
	public Ship getUserAirCraftShip() {
		return userAirCraftCarrier;		
	}
	
	public Ship getComputerAirCraft() {
		return computerAirCraftCarrier;
	}
	
	public Ship isComputerHit(int r, int c) {
		Ship s = cg2[r][c];
		if (cg2[r][c] != null) {
			cg2[r][c].beenHit();
			cg2[r][c] = null;
		}
		
		return s;
	}
	
	public Ship isUserHit(int r, int c) {
		Ship s = ug2[r][c];
		if (ug2[r][c] != null) {
			ug2[r][c].beenHit();
			ug2[r][c] = null;
			if (s.getSize() > 0) {
				AI = true;
				saveRow = row;
				saveCol = col;
			}
			else
				AI = false;
		}
		
		return s;
	}
	
	
	public void createComputerGuess() {
		boolean found = false;
		while (!found) {
			row = n.nextInt(size);
			col = n.nextInt(size);
			
			if (AI) {   // stay with in a hit region there are 4 possible cells; stay within rows or cols. 
				if ((row == saveRow) || (col == saveCol))  // this helps still not too bright. 
						if (cg1[row][col] == false)
							found = cg1[row][col] = true;
							
			}
			else if (cg1[row][col] == false)  // random guessing
				found = cg1[row][col] = true;

								
		}
	}
	
	public int getComputerRowGuess() {
		return row;
	}
	
	public int getComputerColGuess() {
		return col;
	}
	
	public String isWinner() {
		boolean found = false;
		
		for (int i = 0; i < size; i++)
			for (int j = 0; j < size; j++) {
				if (ug2[i][j] != null)
					found = true;	
			}
		
		if (!found)
			return "Computer";
		
		found = false;
		
		for (int i = 0; i < size; i++)
			for (int j = 0; j < size; j++) {
				if (cg2[i][j] != null)
					found = true;	
			}
		
		if (!found)
			return "User";
		
		return null;
	}
	
	
	
	
	
	
	
	
	
}
