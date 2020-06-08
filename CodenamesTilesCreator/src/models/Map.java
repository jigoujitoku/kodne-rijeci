package models;

import java.util.ArrayList;
import java.util.Random;

import logic.RandomNum;

public class Map {
	public ArrayList<Field> fields = new ArrayList<Field>();
	int fieldNum;
	public Character character;
	
	public Map(int fieldNum) {
		this.fieldNum=fieldNum;
		for(int i=0; i<fieldNum;i++) {
			for(int j=0; j<fieldNum;j++) {
				Field field = new Field(i, j, false, 0);
				fields.add(field);
			}
		}
		
	}
	
	public Field fieldFind(int row, int column) {
		for(Field field: fields) {
			if(field.getRow()==row && field.getColumn()==column) return field;
		}
		return null;
	}
	
	public Map initializeCharacter(Map map) {
		int row;
		int column;
		do{
			row = RandomNum.getRandomInt(0, fieldNum);
			column = RandomNum.getRandomInt(0, fieldNum);
		} while(fieldFind(row, column).isOccupied());
		character = new Character(row, column);
		fieldFind(character.getRow(), character.getColumn()).setOccupied(true);
		fieldFind(character.getRow(), character.getColumn()).setOccupationType(5);
		return map;
	}

	public ArrayList<Field> getFields() {
		return fields;
	}


	public int getFieldNum() {
		return fieldNum;
	}

	public Character getCharacter() {
		return character;
	}
	
	
	
}
