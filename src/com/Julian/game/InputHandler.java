package com.Julian.game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputHandler implements KeyListener {

	public InputHandler(Game game) {
		game.addKeyListener(this);
	}
	
	public class Key {
		public boolean pressed = false;
		
		public boolean isPressed() {
			return pressed;
		}
		
		public void toggle(boolean isPressed) {
			pressed = isPressed;
		}
	}
	
	public Key up = new Key();
	public Key down = new Key();
	public Key left = new Key();
	public Key right = new Key();
	// Replace tile with stone
	public Key Key1 = new Key();
	// Replace tile with water
	public Key Key2 = new Key();
	// Replace tile with grass
	public Key Key3 = new Key();
	// Replace tile with sand
	public Key Key4 = new Key();
	// Replace tile with stone ground
	public Key Key5 = new Key();
	// Replace tile with tree
	public Key Key6 = new Key();
	// Replace tile with bush
	public Key Key7 = new Key();
	// Saves the game
	public Key S = new Key();
	
	@Override
	public void keyPressed(KeyEvent e) {
		toggleKey(e.getKeyCode(), true);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		toggleKey(e.getKeyCode(), false);
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	
	public void toggleKey(int keyCode, boolean isPressed) {
		if (keyCode == KeyEvent.VK_UP) {
			up.toggle(isPressed); 
		}
		if (keyCode == KeyEvent.VK_DOWN) { 
			down.toggle(isPressed); 
		}
		if (keyCode == KeyEvent.VK_LEFT) {
			left.toggle(isPressed); 
		}
		if (keyCode == KeyEvent.VK_RIGHT) {
			right.toggle(isPressed);
		}
		if (keyCode == KeyEvent.VK_1) {
			Key1.toggle(isPressed);
		}
		if (keyCode == KeyEvent.VK_2) {
			Key2.toggle(isPressed);
		}
		if (keyCode == KeyEvent.VK_3) {
			Key3.toggle(isPressed);
		}
		if (keyCode == KeyEvent.VK_4) {
			Key4.toggle(isPressed);
		}
		if (keyCode == KeyEvent.VK_5) {
			Key5.toggle(isPressed);
		}
		if (keyCode == KeyEvent.VK_6) {
			Key6.toggle(isPressed);
		}
		if (keyCode == KeyEvent.VK_7) {
			Key7.toggle(isPressed);
		}
		if (keyCode == KeyEvent.VK_S) {
			S.toggle(isPressed);
		}
	}
	
}
