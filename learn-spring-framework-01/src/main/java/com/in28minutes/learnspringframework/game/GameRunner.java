package com.in28minutes.learnspringframework.game;

public class GameRunner {
	private GamingConsole game;
	
	public GameRunner(GamingConsole game) {
		this.game = game;
	}
	
	public void run() {
		System.out.println("Game running "+ game);
		game.down();
		game.up();
		game.left();
		game.right();
	}
}
