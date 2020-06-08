package models;

public class Human {
	int id;
	int row;
	int column;
	
	public Human(int id, int row, int column) {
		this.id = id;
		this.row = row;
		this.column = column;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	
}
