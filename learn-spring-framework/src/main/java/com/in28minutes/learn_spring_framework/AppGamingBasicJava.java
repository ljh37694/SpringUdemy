package com.in28minutes.learn_spring_framework;

import com.in28minutes.learn_spring_framework.game.GameRunner;
import com.in28minutes.learn_spring_framework.game.MarioGame;

public class AppGamingBasicJava {
	public static void main(String[] args) {
		MarioGame marioGame = new MarioGame();
		GameRunner gameRunner = new GameRunner(marioGame);
		
		gameRunner.run();
	}
}
