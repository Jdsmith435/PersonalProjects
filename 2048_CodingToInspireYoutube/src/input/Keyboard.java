package input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener{
	
	public static boolean[] keys = new boolean[120];
	public static boolean[] lastKeys = new boolean[120];
	
	public void update() {
		for(int i = 0; i < keys.length; i++) {
			lastKeys[i] = keys[i];
		}
	}
	
	public static boolean key(int key) {
		return keys[key];
	}
	
	public static boolean keyDown(int key) {
		return keys[key] && !lastKeys[key];
	}

	public static boolean keyUp(int key) {
		return lastKeys[key] && !keys[key];
	}

	public Keyboard() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	//assigns true to the keys index 
	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}

}
