package game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RockPaperScissors {

	public static void main(String[] args) throws InterruptedException {
		Player p1 = new Player("player1");
		Player p2 = new Player("player2");
		List<String> finalScore = new ArrayList<String>();

		for (int i = 0; i < 100; i++) {
			String p1Move = p1.playStaticChoice();
			String p2Move = p2.playDifferentChoices();

			String score = letsPlay(p1Move, p2Move);
			finalScore.add(score);
			Thread.sleep(1);
		}

		gameWinner(finalScore);
	}

	public static String letsPlay(String p1Move, String p2Move) {
		if (p2Move.equals("Paper")) {
			return ("p2");
		}
		if (p2Move.equals("Scissors")) {
			return ("p1");
		}
		return "Dray";
	}

	public static void gameWinner(List<String> finalScore) {
		int p1Winns = Collections.frequency(finalScore, "p1");
		int p2Winns = Collections.frequency(finalScore, "p2");

		if (p1Winns > p2Winns)
			System.out.println("p1 is the winner " + p1Winns);
		else if (p2Winns > p1Winns)
			System.out.println("p2 is the winner " + p2Winns);
		System.out.println(p1Winns + " " + p2Winns);
	}

}
