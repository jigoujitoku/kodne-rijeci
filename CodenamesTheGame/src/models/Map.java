package models;

import java.util.ArrayList;
import java.util.List;
import logic.RandomNum;

public class Map {
	public ArrayList<Field> fields = new ArrayList<Field>();
	int fieldNum;
	public Character character;
	String word;
	List<String> usedWords = new ArrayList<String>();

	public Map(int fieldNum,List<String> dictionary) {
		this.fieldNum=fieldNum;
		for(int i=0; i<fieldNum;i++) {
			for(int j=0; j<fieldNum;j++) {
				do{
					word = dictionary.get(RandomNum.getRandomInt(dictionary.size()));
				}while(usedWords.contains(word));
				usedWords.add(word);
				Field field = new Field(i, j, false,word);
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
