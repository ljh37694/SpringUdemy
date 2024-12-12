package com.in28minutes.learn_spring_framework;

import com.in28minutes.learn_spring_framework.game.GameRunner;
import com.in28minutes.learn_spring_framework.game.MarioGame;
import com.in28minutes.learn_spring_framework.game.PacManGame;
import com.in28minutes.learn_spring_framework.game.SuperContraGame;

public class AppGamingBasicJava {
	public static void main(String[] args) {
		MarioGame marioGame = new MarioGame();
		SuperContraGame superContraGame = new SuperContraGame();
		PacManGame pacManGame = new PacManGame();
		
		
		GameRunner gameRunner1 = new GameRunner(marioGame);
		GameRunner gameRunner2 = new GameRunner(superContraGame);
		GameRunner gameRunner3 = new GameRunner(pacManGame);
		
		gameRunner1.run();
		gameRunner2.run();
		gameRunner3.run();
	}
}
