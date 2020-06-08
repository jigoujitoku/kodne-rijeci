package logic;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import gui.PlayingBoard;
import init.Start;

public class KeyListenerCD implements KeyListener {

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getKeyCode() == KeyEvent.VK_F5) {
			PlayingBoard.closeWindow();
			Start.main(null);
		}

		if (arg0.getKeyCode() == KeyEvent.VK_R) {
			PlayingBoard.closeWindow();
			Start.main(null);
		}

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
	}
}
