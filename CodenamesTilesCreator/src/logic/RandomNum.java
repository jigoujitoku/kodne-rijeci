package logic;

import java.util.Random;

public class RandomNum {
	public static int getRandomInt(int min, int max) {
		Random rand = new Random();
		int i = min + rand.nextInt(max);
		return i;
	}

	public static int getRandomColor(int crveni, int plavi) {
		Random rand = new Random();
		return rand.nextBoolean() ? crveni : plavi;
	}

}
