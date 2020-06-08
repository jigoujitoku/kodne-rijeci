package models;

public class Robot {
	int id;
	int row;
	int column;
	
	public Robot(int id, int row, int column) {
		super();
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
