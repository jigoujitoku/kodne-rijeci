package logic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import gui.Board;

public class ImportDictionary {

	private static BufferedReader br;

	public static ArrayList<String> importDictionary(String filename, String removed) throws IOException {
		String line;
		ArrayList<String> dictionary = new ArrayList<String>();
		br = new BufferedReader(new InputStreamReader(Board.class.getResourceAsStream("/" + filename), "UTF-8"));
		while ((line = br.readLine()) != null) {
			line.trim();
			dictionary.add(line);
		}
		br = new BufferedReader(new InputStreamReader(Board.class.getResourceAsStream("/" + removed), "UTF-8"));
		while ((line = br.readLine()) != null) {
			line.trim();
			dictionary.remove(line);
		}
		return dictionary;
	}
}
