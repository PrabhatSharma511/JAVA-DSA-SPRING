package com.in28minutes.learnspringframework.game;

public class SuperContraGame implements GamingConsole{

	public void up() {
		System.out.println("Up");
	}
	
	public void down() {
		System.out.println("Sit Doen");
	}
	
	public void left() {
		System.out.println("Go Back");
	}
	
	public void right() {
		System.out.println("Shoot a bullet");
	}
}
