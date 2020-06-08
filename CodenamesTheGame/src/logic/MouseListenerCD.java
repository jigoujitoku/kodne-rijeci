package logic;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MouseListenerCD implements ActionListener {

	JButton label;
	JPanel panel;
	JLabel picLabel;
	int counter = 0;
	ImageIcon icon;

	public MouseListenerCD(JButton label, JPanel panel, JLabel picLabel) {
		this.label = label;
		this.panel = panel;
		this.picLabel = picLabel;
	}

	protected ImageIcon createImageIcon(String path, String description) {
		java.net.URL imgURL = getClass().getResource(path);
		// java.net.URL imgURL = getClass().getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL, description);
		} else {
			System.err.println("Couldn't find file: " + path);
			return null;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (counter) {
		case 0:
			label.setBackground(new Color(130, 31, 23));
			panel.setBackground(new Color(130, 31, 23));
			icon = createImageIcon("/crveni.png", "Crveni");
			picLabel.setIcon(icon);
			break;
		case 1:
			label.setBackground(new Color(24, 62, 105));
			panel.setBackground(new Color(24, 62, 105));
			icon = createImageIcon("/plavi.png", "Plavi");
			picLabel.setIcon(icon);
			break;
		case 2:
			label.setBackground(new Color(163, 163, 163));
			panel.setBackground(new Color(163, 163, 163));
			icon = createImageIcon("/neutral.png", "Neutralni");
			picLabel.setIcon(icon);
			break;
		case 3:
			label.setBackground(new Color(64, 43, 36));
			panel.setBackground(new Color(64, 43, 36));
			icon = createImageIcon("/assasin.png", "Assasin");
			picLabel.setIcon(icon);
			break;
		case 4:
			label.setBackground(Color.white);
			panel.setBackground(Color.white);
			picLabel.setIcon(null);
			counter = -1;
			break;
		}
		counter++;

	}

	// public static void actionPerformed(MouseEvent e) {
	// switch (counter) {
	// case 0:
	// Board.button.setBackground(new Color(130, 31, 23));
	// Board.grid.setBackground(new Color(130, 31, 23));
	// icon = createImageIcon("/crveni.png", "Crveni");
	// Board.picLabel.setIcon(icon);
	// break;
	// case 1:
	// Board.button.setBackground(new Color(24, 62, 105));
	// Board.grid.setBackground(new Color(24, 62, 105));
	// icon = createImageIcon("/plavi.png", "Plavi");
	// Board.picLabel.setIcon(icon);
	// break;
	// case 2:
	// Board.button.setBackground(new Color(163, 163, 163));
	// Board.grid.setBackground(new Color(163, 163, 163));
	// icon = createImageIcon("/neutral.png", "Neutralni");
	// Board.picLabel.setIcon(icon);
	// break;
	// case 3:
	// Board.button.setBackground(new Color(64, 43, 36));
	// Board.grid.setBackground(new Color(64, 43, 36));
	// icon = createImageIcon("/assasin.png", "Assasin");
	// Board.picLabel.setIcon(icon);
	// break;
	// case 4:
	// Board.button.setBackground(Color.white);
	// Board.grid.setBackground(Color.white);
	// Board.picLabel.setIcon(null);
	// counter = -1;
	// break;
	// }
	// counter++;
	//
	// }

}
