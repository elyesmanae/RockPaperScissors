package testMain;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import game.Player;
import game.RockPaperScissors;

public class testGame {
	Player p1;
	Player p2;
	String p1Move;
	String p2Move;
	List<String> finalScore;

	@Before
	public void setUp() throws Exception {
	    p1 = new Player("player1");
		p2 = new Player("player2");
		p1Move = p1.playStaticChoice();
		p2Move = p2.playDifferentChoices();
		finalScore = new ArrayList<String>();
	}

	@After
	public void tearDown() throws Exception {
		p1 = null;
		p2 = null; 
		p1Move = null;
		p2Move = null;
		finalScore = null;
	}

	@Test
	public void testLetsPlayPaper() {
		if (p2Move.contentEquals("Paper")) {
			System.out.println("pap" + p2Move);
			assertEquals("p2",RockPaperScissors.letsPlay(p1Move,p2Move));
		}
		else testLetsPlayPaper();
	}
	
	@Test
	public void testLetsPlayScissors() {
		if (p2Move.contentEquals("Scissors")) {
			assertEquals("p1",RockPaperScissors.letsPlay(p1Move,p2Move));
		}
		else testLetsPlayPaper();
	}
	
	@Test
	public void testLetsPlayRock() {
		if (p2Move.contentEquals("Rock")) {
			assertEquals("draw",RockPaperScissors.letsPlay(p1Move,p2Move));
		}
		else testLetsPlayPaper();
	}

	@Test
	public void testGameWinnerP1() {
		for (int i = 0; i < 60; i++) {
			finalScore.add("p1");
		}
		for (int i = 0; i < 40; i++) {
			finalScore.add("p2");
		}
		assertEquals("player 1",RockPaperScissors.gameWinner(finalScore));	
	}
	
	@Test
	public void testGameWinnerP2() {
		for (int i = 0; i < 30; i++) {
			finalScore.add("p1");
		}
		for (int i = 0; i < 70; i++) {
			finalScore.add("p2");
		}
		assertEquals("player 2",RockPaperScissors.gameWinner(finalScore));	
	}
	
	@Test
	public void testGameWinnerDaw() {
		for (int i = 0; i < 50; i++) {
			finalScore.add("p1");
		}
		for (int i = 0; i < 50; i++) {
			finalScore.add("p2");
		}
		assertEquals("draw",RockPaperScissors.gameWinner(finalScore));	
	}
 
}
