package NONGUITicTacToe;

public class Ship {   
	public static final int VERTICAL = 1;
	public static final int HORIZONTAL = 0;	
	
	private int size;
	private int orientation;
	private String type;
	private int row;
	private int col;
	
	public Ship(int size, int orientation, String type, int r, int c) {
		this.size = size;
		this.orientation = orientation;
		this.type = type;
		this.row = r;
		this.col = c;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getOrientation() {
		return orientation;
	}
	public void setOrientation(int orientation) {
		this.orientation = orientation;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getCol() {
		return col;
	}
	public void setCol(int col) {
		this.col = col;
	}

	public void beenHit() {
		size = size - 1;
	}

}
