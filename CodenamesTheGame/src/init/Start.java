package init;

import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.UIManager;

import gui.Board;
import logic.ImportDictionary;
import models.Map;

public class Start {
	public static final int fieldNum = 5;
	public static String filename;
	public static String removed;

	public static void main(String[] args) throws IOException {

		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
		} catch (Exception ignored) {
		}

		if (models.Field.languageChange == 0) {
			filename = "eng_dictionary.txt";
			removed = "temp.txt";
		}
		ArrayList<String> dictionary = null;
		ImportDictionary imp = new ImportDictionary();
		dictionary = ImportDictionary.importDictionary(filename, removed);
		Map map = new Map(5, dictionary);
		Board board = new Board(map);
		JFrame frame = board.getFrame();

	}

}
