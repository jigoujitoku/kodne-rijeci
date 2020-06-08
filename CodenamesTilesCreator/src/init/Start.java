package init;

import gui.PlayingBoard;
import models.DangerFactory;
import models.HumanFactory;
import models.Map;
import models.RobotFactory;

public class Start {
	public static final int fieldNum = 5;
	public static int n;
	public static int m;

	public static void main(String[] args) {
		int id;
		n = logic.RandomNum.getRandomColor(8, 9);
		m = 17 - n;
		Map map = new Map(fieldNum);
		RobotFactory robotFactory = new RobotFactory();
		HumanFactory humanFactory = new HumanFactory();
		DangerFactory dangerFactory = new DangerFactory();
		map.initializeCharacter(map);
		for (id = 0; id < n; id++) {
			robotFactory.initializeRobot(map, id);
		}

		for (id = 0; id < 1; id++) {
			humanFactory.initializeHuman(map, id);
		}
		for (id = 0; id < m; id++) {
			dangerFactory.initializeDanger(map, id);
		}

		PlayingBoard board = new PlayingBoard(map);

		// gui.PlayingBoard.takeScreenshot();

		// System.out.println("Character: "+ map.character.getRow()+"
		// "+map.character.getColumn());
		// for(Human human: humanFactory.humans) {
		// System.out.println("human: "+human.getRow()+" "+human.getColumn());
		// }
		// for(Robot robot: robotFactory.robots) {
		// System.out.println("robot: "+robot.getRow()+" "+robot.getColumn());
		// }
		// for(Danger danger: dangerFactory.dangers) {
		// System.out.println("danger: "+danger.getRow()+"
		// "+danger.getColumn());
		// }
		//
		// int counter=0;
		// for(Field field : map.fields) {
		// counter++;
		// System.out.printf("%b ",field.isOccupied());
		// if(counter%fieldNum==0) System.out.printf("%n");
		// }
		// counter=0;
		// for(Field field : map.fields) {
		// counter++;
		// System.out.printf("%d ",field.getOccupationType());
		// if(counter%fieldNum==0) System.out.printf("%n");
		// }

	}

}
