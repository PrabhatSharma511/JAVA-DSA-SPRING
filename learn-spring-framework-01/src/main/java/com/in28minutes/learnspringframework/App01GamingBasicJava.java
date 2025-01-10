package com.in28minutes.learnspringframework;

import com.in28minutes.learnspringframework.game.GameRunner;
import com.in28minutes.learnspringframework.game.MarioGame;
import com.in28minutes.learnspringframework.game.PacmanGame;
import com.in28minutes.learnspringframework.game.SuperContraGame;

public class App01GamingBasicJava {

	public static void main(String[] args) {

//		var game = new MarioGame();
//		var game = new SuperContraGame();
		var game = new PacmanGame(); //1: Object creation
		var gameRunner = new GameRunner(game);
		 //2: Object creation + wiring of dependencies(injecting dependency)
			// game is a dependency for gameRunner class
		gameRunner.run();
		
	}

}
