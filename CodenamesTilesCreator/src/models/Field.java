package models;

public class Field {
	boolean occupied;
	int row;
	int column;
	int occupationType;
	
	public Field(int row, int column, boolean occupied, int occupationType) {
		this.occupied = occupied;
		this.row=row;
		this.column=column;
		this.occupationType=occupationType;
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

	public int getOccupationType() {
		return occupationType;
	}

	public void setOccupationType(int occupationType) {
		this.occupationType = occupationType;
	}
	
	
}
