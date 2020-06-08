package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.io.IOException;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import init.Start;
import logic.KeyListenerCD;
import logic.MouseListenerCD;
import models.Map;

public class Board {

	static JFrame frame;
	public static JPanel grid;
	public JPanel squares[][];
	public JLabel picLabel;
	public static JButton button;

	public Board(Map map) throws IOException {
		int fieldNum = map.getFieldNum();
		frame = new JFrame("Codenames || コードネーム");
		URL url = Board.class.getResource("/icon.png");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(url));
		frame.setSize(fieldNum * 190, fieldNum * 160);

		JMenuBar menu = new JMenuBar();
		JMenu jezik = new JMenu("Jezik");
		jezik.setMnemonic('J');
		JCheckBoxMenuItem eng = new JCheckBoxMenuItem("Engleski");
		JCheckBoxMenuItem jap = new JCheckBoxMenuItem("Japanski - easy");
		JCheckBoxMenuItem japK = new JCheckBoxMenuItem("Japanski - kanji");
		JCheckBoxMenuItem hr = new JCheckBoxMenuItem("Hrvatski");
		eng.setAccelerator(KeyStroke.getKeyStroke('E', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
		eng.addActionListener(l -> {
			eng.setSelected(true);
			if (models.Field.languageChange != 0) {
				try {
					models.Field.languageChange = 0;
					Start.removed = Start.filename;
					Start.filename = "eng_dictionary.txt";
					Board.closeWindow();
					Start.main(null);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				jap.setSelected(false);
				japK.setSelected(false);
				hr.setSelected(false);
			}
		});
		jap.setAccelerator(KeyStroke.getKeyStroke('J', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
		jap.addActionListener(l -> {
			jap.setSelected(true);
			if (models.Field.languageChange != 1) {
				try {
					models.Field.languageChange = 1;
					Start.removed = Start.filename;
					Start.filename = "jap_dictionary_01.txt";
					Board.closeWindow();
					Start.main(null);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				eng.setSelected(false);
				hr.setSelected(false);
				japK.setSelected(false);
			}
		});
		japK.setAccelerator(KeyStroke.getKeyStroke('K', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
		japK.addActionListener(l -> {
			japK.setSelected(true);
			if (models.Field.languageChange != 2) {
				try {
					models.Field.languageChange = 2;
					Start.removed = Start.filename;
					Start.filename = "jap_dictionary_02.txt";
					Board.closeWindow();
					Start.main(null);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				eng.setSelected(false);
				hr.setSelected(false);
				jap.setSelected(false);
			}
		});
		hr.setAccelerator(KeyStroke.getKeyStroke('H', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
		hr.addActionListener(l -> {
			hr.setSelected(true);
			if (models.Field.languageChange != 3) {
				try {
					models.Field.languageChange = 3;
					Start.removed = Start.filename;
					Start.filename = "hr_dictionary.txt";
					Board.closeWindow();
					Start.main(null);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				eng.setSelected(false);
				jap.setSelected(false);
				japK.setSelected(false);
			}
		});
		jezik.add(eng);
		jezik.add(hr);
		jezik.add(jap);
		jezik.add(japK);
		JMenu game = new JMenu("Igra");
		game.setMnemonic('I');
		JMenuItem refresh = new JMenuItem("Osvježi riječi");
		refresh.setAccelerator(KeyStroke.getKeyStroke('R', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
		refresh.addActionListener(l -> {
			try {
				Board.closeWindow();
				Start.main(null);
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
		JMenuItem help = new JMenuItem("Uputa");
		help.setAccelerator(KeyStroke.getKeyStroke('U', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
		help.addActionListener(l -> {
			JOptionPane.showMessageDialog(frame,
					"Igra se igra ovako:\n\n" + "" + "Postoje crveni i plavi tim s igračima i spymasterima.\n"
							+ "Spymasteri vide koja polja su crvena, koja plava, koja neutralna te gdje je ubojica.\n"
							+ "(Za to postoje posebne kartice te se ne vidi u aplikaciji.)\n"
							+ "Spymaster tima na redu zadaje JEDNU riječ i broj.\n"
							+ "Broj znači broj kartica na koje se asocijacija odnosi.\n"
							+ "Članovi tima moraju pogoditi na koje je kartice mislio. Imaju broj pogodaka jednak zadanom broju plus jedan.\n"
							+ "Njihov red završava kad nalete na boju koja nije njihova.\n"
							+ "Ako nalete na ubojicu (crno), izgubili su.\n",
					"Codenames uputa", JOptionPane.INFORMATION_MESSAGE);
		});
		game.add(refresh);
		game.add(help);
		menu.add(jezik);
		menu.add(game);

		frame.setJMenuBar(menu);

		grid = new JPanel();
		frame.add(grid);

		squares = new JPanel[fieldNum][fieldNum];

		grid.setLayout(new GridLayout(fieldNum, fieldNum));

		for (int i = 0; i < fieldNum; i++) {
			for (int j = 0; j < fieldNum; j++) {
				squares[i][j] = new JPanel();
				picLabel = new JLabel();
				button = new JButton(map.fieldFind(i, j).getWord().toUpperCase());
				button.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 18));
				button.setBackground(new Color(230, 230, 230));
				button.setBorder(null);
				button.addActionListener(new MouseListenerCD(button, squares[i][j], picLabel));
				// int z = i;
				// int y = j;
				// squares[z][y].addMouseListener(new MouseAdapter() {
				// public void mouseClicked(MouseEvent e) {
				// button.addActionListener(new MouseListenerCD(button,
				// squares[z][y], picLabel));
				// button.doClick();
				// };
				// });
				squares[i][j].add(button);
				squares[i][j].add(picLabel);
				squares[i][j].setBackground(Color.white);
				squares[i][j].setBorder(BorderFactory.createLineBorder(Color.black, 1));
				grid.addKeyListener(new KeyListenerCD());
				grid.add(squares[i][j]);
			}
		}

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setFocusable(true);
		frame.addKeyListener(new KeyListenerCD());
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public static void closeWindow() {
		frame.setVisible(false);
	}

}
