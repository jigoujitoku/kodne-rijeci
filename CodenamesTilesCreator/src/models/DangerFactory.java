package models;

import java.util.ArrayList;
import logic.RandomNum;

public class DangerFactory {
	public ArrayList<Danger> dangers = new ArrayList<Danger>();

	public Danger findDanger(int id) {
		for(Danger danger: dangers) {
			if(danger.getId()==id) return danger;
		}
		return null;
	}

	public Map initializeDanger(Map map, int id) {
		int row;
		int column;
		do{
			row = RandomNum.getRandomInt(0, map.fieldNum);
			column = RandomNum.getRandomInt(0, map.fieldNum);
		} while(map.fieldFind(row, column).isOccupied());


		Danger danger = new Danger(id,row, column);
		dangers.add(danger);
		map.fieldFind(danger.getRow(), danger.getColumn()).setOccupied(true);
		map.fieldFind(danger.getRow(), danger.getColumn()).setOccupationType(3);
		return map;
	}
}
