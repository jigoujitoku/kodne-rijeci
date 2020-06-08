package gui;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

import init.Start;
import logic.KeyListenerCD;
import models.Map;

public class PlayingBoard {
	static JFrame frame;
	JPanel squares[][];
	public static JPanel grid;
	JButton button;
	JButton refresh;

	public PlayingBoard(Map map) {
		int fieldNum = map.getFieldNum();
		frame = new JFrame("Codenamezz");
		frame.setSize(fieldNum * 80, fieldNum * 80);

		grid = new JPanel();
		grid.setSize(400, 400);
		frame.add(grid);
		squares = new JPanel[fieldNum][fieldNum];

		grid.setLayout(new GridLayout(fieldNum, fieldNum));

		for (int i = 0; i < fieldNum; i++) {
			for (int j = 0; j < fieldNum; j++) {
				squares[i][j] = new JPanel();

				switch (map.fieldFind(i, j).getOccupationType()) {
				case 1:
					squares[i][j].setBackground(Color.red);
					break;
				case 2:
					squares[i][j].setBackground(Color.black);
					break;
				case 3:
					squares[i][j].setBackground(Color.blue);
					break;
				case 5:
					squares[i][j].setBackground(Color.white);
					break;
				default:
					squares[i][j].setBackground(Color.white);
					break;
				}

				squares[i][j].setBorder(BorderFactory.createLineBorder(Color.black, 2));

				grid.add(squares[i][j]);
			}
		}

		// frame.setUndecorated(true);
		if (init.Start.n == 9)
			gui.PlayingBoard.grid.setBorder(BorderFactory.createLineBorder(Color.red, 4));
		else
			gui.PlayingBoard.grid.setBorder(BorderFactory.createLineBorder(Color.blue, 4));

		JMenuBar menubar = new JMenuBar();
		button = new JButton("Screenshot");
		refresh = new JButton("Refresh");
		frame.setJMenuBar(menubar);
		menubar.add(button);
		menubar.add(refresh);
		button.addActionListener(e -> logic.Screenshot.takeScreenshot());
		refresh.addActionListener(e -> {
			PlayingBoard.closeWindow();
			Start.main(null);
		});

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.addKeyListener(new KeyListenerCD());
	}

	public static void closeWindow() {
		frame.setVisible(false);
	}

}
