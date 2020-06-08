package logic;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Screenshot {

	public static void takeScreenshot() {
		try {
			BufferedImage image = new BufferedImage(398, 348, BufferedImage.TYPE_INT_RGB);
			Graphics2D g = image.createGraphics();
			gui.PlayingBoard.grid.paintAll(g);
			g.dispose();
			ImageIO.write(image, "png", new File(generateFilename()));
			System.out.println("Successfully captured.");
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public static String generateFilename() {
		// File theDir = new File("Codename Tiles");
		// String dirName = "/Codenames Tiles/";
		// if (!theDir.exists()) {
		// try {
		// theDir.mkdir();
		// } catch (SecurityException se) {
		// }
		// }
		int i = logic.RandomNum.getRandomInt(0, 9);
		int y = logic.RandomNum.getRandomInt(0, 9);
		int z = logic.RandomNum.getRandomInt(0, 9);
		String filename = "tile_" + i + y + z + ".png";
		return filename;
	}

}
