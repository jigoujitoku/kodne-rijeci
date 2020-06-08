package models;

import java.util.ArrayList;

import logic.RandomNum;

public class RobotFactory {
	public ArrayList<Robot> robots = new ArrayList<Robot>();

	public Robot findRobot(int id) {
		for(Robot robot: robots) {
			if(robot.getId()==id) return robot;
		}
		return null;
	}

	public Map initializeRobot(Map map, int id) {
		int row;
		int column;
		do{
			row = RandomNum.getRandomInt(0, map.fieldNum);
			column = RandomNum.getRandomInt(0, map.fieldNum);
		} while(map.fieldFind(row, column).isOccupied());

		Robot robot = new Robot(id,row, column);
		robots.add(robot);
		map.fieldFind(robot.getRow(), robot.getColumn()).setOccupied(true);
		map.fieldFind(robot.getRow(), robot.getColumn()).setOccupationType(1);
		return map;
	}
}
