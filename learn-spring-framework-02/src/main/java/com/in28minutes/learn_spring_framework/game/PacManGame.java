package com.in28minutes.learn_spring_framework.game;

import org.springframework.stereotype.Component;

@Component
public class PacManGame implements GamingConsole {
	public void up() {
		System.out.println("eat up");
	}
	
	public void down() {
		System.out.println("eat down");
	}
	
	public void left() {
		System.out.println("eat left");
	}
	
	public void right() {
		System.out.println("eat right");
	}
}
