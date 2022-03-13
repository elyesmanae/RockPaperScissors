package game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RockPaperScissors {

	public static void main(String[] args) throws InterruptedException {
		Player p1 = new Player("player1");
		Player p2 = new Player("player2");
		List<String> finalScore = new ArrayList<String>();

		// creating 100 round to get the game winner
		for (int i = 0; i < 100; i++) {
			String p1Move = p1.playStaticChoice();
			String p2Move = p2.playDifferentChoices();

			String scoreOneRound = letsPlay(p1Move, p2Move);
			finalScore.add(scoreOneRound);
		}

		System.out.println("The winner is : " + gameWinner(finalScore));
	}

	// get a player2 move and compare it with the player 1 move
	// it will return who wins this round 
	public static String letsPlay(String p1Move, String p2Move) {
		if (p2Move.contentEquals("Paper")) {
			return ("p2");
		}
		if (p2Move.contentEquals("Scissors")) {
			return ("p1");
		}
		return "draw";
	}

	
	// after finish playing 100 rounds, we calculate the occurrences to see who won the game
	public static String gameWinner(List<String> finalScore) {
		
		String winner = "";
		int p1Winns = Collections.frequency(finalScore, "p1");
		int p2Winns = Collections.frequency(finalScore, "p2");

		if (p1Winns > p2Winns)
			winner  = "player 1";
		else if (p2Winns > p1Winns)
			winner  = "player 2";
		else winner = "draw";
		
		int draw = 100 - (p1Winns + p2Winns);
		System.out.println("player 1 won : " + p1Winns + " rounds");
		System.out.println("player 2 won : " + p2Winns + " rounds");
		System.out.println("draw : " + draw);
		
		return winner;
	}

}
