package models;

import java.util.ArrayList;

import logic.RandomNum;

public class HumanFactory {
	public ArrayList<Human> humans = new ArrayList<Human>();

	public Human findHuman(int id) {
		for(Human human: humans) {
			if(human.getId()==id) return human;
		}
		return null;
	}

	public Map initializeHuman(Map map, int id) {
		int row;
		int column;
		do{
			row = RandomNum.getRandomInt(0, map.fieldNum);
			column = RandomNum.getRandomInt(0, map.fieldNum);
		} while(map.fieldFind(row, column).isOccupied());
		
		Human human = new Human(id,row, column);
		humans.add(human);
		map.fieldFind(human.getRow(), human.getColumn()).setOccupied(true);
		map.fieldFind(human.getRow(), human.getColumn()).setOccupationType(2);
		return map;
	}
}
