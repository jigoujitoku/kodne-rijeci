package logic;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import gui.Board;
import init.Start;

public class KeyListenerCD implements KeyListener {

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		 if(arg0.getKeyCode() == KeyEvent.VK_F5){
			 try {
				Board.closeWindow();
				Start.main(null);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 }
		 
		 if(arg0.getKeyCode() == KeyEvent.VK_R){
			 try {
				Board.closeWindow();
				Start.main(null);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
