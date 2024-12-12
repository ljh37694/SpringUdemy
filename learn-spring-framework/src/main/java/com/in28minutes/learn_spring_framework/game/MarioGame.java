package com.in28minutes.learn_spring_framework.game;

public class MarioGame implements GamingConsole {
	public void up() {
		System.out.println("Jump");
	}
	
	public void down() {
		System.out.println("down");
	}
	
	public void left() {
		System.out.println("left");
	}
	
	public void right() {
		System.out.println("right");
	}
}
