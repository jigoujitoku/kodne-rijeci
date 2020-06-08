package models;

public class Field {
	boolean occupied;
	int row;
	int column;
	String word;
	public static int languageChange;

	public Field(int row, int column, boolean occupied, String word) {
		this.occupied = occupied;
		this.row = row;
		this.column = column;
		this.word = word;
	}

	public boolean isOccupied() {
		return occupied;
	}

	public void setOccupied(boolean occupied) {
		this.occupied = occupied;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

}
