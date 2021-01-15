package com.programming.main2048.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.programming.main2048.Main;
import com.programming.main2048.gameObject.GameObject;
import com.programming.main2048.grp.Renderer;
import input.Keyboard;

public class Game {

	public static List<GameObject> object;

	public static boolean moving = false, hasMoved = true, somethingIsMoving = false;
	public static int dir = 0;

	private Random rand = new Random();


	public Game() {
		init();
	}

	private void init() {	
		object = new ArrayList<GameObject>();
		moving = false;
		hasMoved = true;
		somethingIsMoving = false;
		spawn();
	}



	public void update() {
		
		//If R is pressed, the game resets by calling 
		if(Keyboard.keyUp(KeyEvent.VK_R)) {
			init();
		}

		for(int i = 0; i < object.size(); i++) {
			object.get(i).update();
		}

		checkForValueIncrease();

		movingLogic();
	}

	private void movingLogic() {
		somethingIsMoving = false;
		for(int i = 0; i < object.size(); i++) {
			if(object.get(i).moving) {
				somethingIsMoving = true;
			}
		}
		if(!somethingIsMoving) {
			moving = false;
			for(int i = 0; i < object.size(); i++) {
				object.get(i).hasMoved = false;
			}
		}
		if(!moving && hasMoved) {
			spawn();
			hasMoved = false;
		}
		
		//sets the direction based on keyAction 
		if(!moving && !hasMoved) {
			if(Keyboard.keyDown(KeyEvent.VK_A)) {
				hasMoved = true;
				moving = true;
				dir = 0; 
			}else if (Keyboard.keyDown(KeyEvent.VK_D)) {
				hasMoved = true;
				moving = true;
				dir = 1; 
			} else if(Keyboard.keyDown(KeyEvent.VK_W)) {
				hasMoved = true;
				moving = true;
				dir = 2; 
			} else if(Keyboard.keyDown(KeyEvent.VK_S)) {
				hasMoved = true;
				moving = true;
				dir = 3; 
			}
		}
	}	

	/**
	 * Iterates through columns and rows. If there are two objects whose values and location match, then
	 * the value is doubled and the createsprite() is called to get new color
	 */
	private void checkForValueIncrease() {
		for(int i = 0; i < object.size(); i++) {
			for(int j = 0; j < object.size(); j++) {
				if(i == j) continue;
				if(object.get(i).x == object.get(j).x && object.get(i).y == object.get(j).y && !object.get(i).remove && !object.get(j).remove) {
					object.get(j).remove = true;
					object.get(i).value *= 2;
					object.get(i).createSprite();
				}
			}
		}
		//if a gameObject remove is true, then the object is removed
		for(int i = 0; i < object.size(); i++) {
			if(object.get(i).remove) object.remove(i);
		}
	}

	private void spawn() {
		
		//There is no more space so no new object is spawned and the spawn() method is exited
		if(object.size() == 16) return;
		
		boolean available = false;
		int x = 0, y = 0;
		
		//While available is not true, a new 
		while(!available) {
			x = rand.nextInt(4);
			y = rand.nextInt(4);
			boolean isAvailable = true;
			for( int i = 0; i < object.size(); i++) {
				//Checks if the a spot if filled by checking the object list's index x and y
				if(object.get(i).x / 100 == x && object.get(i).y / 100 == y) {
					isAvailable = false;
				}
			}
			if(isAvailable) available = true;
		}
		object.add(new GameObject(x * 100 , y * 100));
	}

	public void render() {
		Renderer.renderBackground();

		for(int i = 0; i < object.size(); i++) {
			object.get(i).render();
		}
		
		for(int i = 0; i < Main.pixels.length; i++) {
			Main.pixels[i] = Renderer.pixels[i];
		}

	}

	public void renderText(Graphics2D g) {
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setFont(new Font("Verdana",0, 100));
		g.setColor(Color.BLACK);
		
		for(int i = 0; i < object.size(); i++) {
			GameObject o = object.get(i);
			String s = o.value + "";
			int sw = (int) (g.getFontMetrics().stringWidth(s) / 2 / Main.scale);
			g.drawString(s, (int) ((o.x+ o.width / 2 - sw)* Main.scale), (int)( o.y + o.height / 2 + 18) * Main.scale);
		}
	}
}
