package game;

import java.util.Random;

public class Player {
	
	private String name;
	
	public Player(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public String playStaticChoice() {
		return "Rock";
	}
	
	public String playDifferentChoices() {
		
		String[] choices = {"Rock", "Paper", "Scissors"};
		String randomChoice = choices[new Random().nextInt(choices.length)];
		return randomChoice;
	}

}
