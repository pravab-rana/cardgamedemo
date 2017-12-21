package pjr.programmingchallenges.cardgame;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestCardCollisionStrategy 
{
	
	private static CardCollisionStrategy ThreeCardDrawStrategy;
	
	@Before
	public void setUp()
	{
		ThreeCardDrawStrategy = new CardCollisionStrategyThreeCardDrawImpl();
	}
	
	/**
	 * Testing collision with 2 players while 3 players are playing
	 * King's collide
	 */
	
	@Test
	public void testScenario1ThreeCardDrawStrategy()
	{
		Player p1 = new Player("PJR");
		Player p2 = new Player("Maya");
		Player p3 = new Player("J");
		
		Card card1 = new Card(CardSuit.DIAMOND,CardRank.KING); //collision card
		Card card2 = new Card(CardSuit.HEART,CardRank.FIVE);
		Card card3 = new Card(CardSuit.DIAMOND,CardRank.THREE);
		Card card4 = new Card(CardSuit.CLUB,CardRank.TEN);
		Card card5 = new Card(CardSuit.DIAMOND,CardRank.ACE);
		
		
		p1.getPlayingCard(card1);
		p1.getPlayingCard(card2);
		p1.getPlayingCard(card3);
		p1.getPlayingCard(card4);
		p1.getPlayingCard(card5);
		
		System.out.println(p1.toString());
		
		Card card6 =  new Card(CardSuit.HEART,CardRank.KING); //collision card
		Card card7 = new Card(CardSuit.CLUB,CardRank.TWO);
		Card card8 = new Card(CardSuit.DIAMOND,CardRank.ACE);
		Card card9 = new Card(CardSuit.SPADE,CardRank.SEVEN);
		Card card10 = new Card(CardSuit.DIAMOND,CardRank.QUEEN);
		
		p2.getPlayingCard(card6);
		p2.getPlayingCard(card7);
		p2.getPlayingCard(card8);
		p2.getPlayingCard(card9);
		p2.getPlayingCard(card10);
		
		System.out.println(p2.toString());
		
		Card card11 = new Card(CardSuit.HEART,CardRank.JACK);
		Card card12 = new Card(CardSuit.SPADE,CardRank.SIX);
		
		p3.getPlayingCard(card11);
		p3.getPlayingCard(card12);
		
		System.out.println(p3.toString());
		
		Card p1TopCard = p1.getTopCard();
		Card p2TopCard = p2.getTopCard();
		Card p3TopCard = p3.getTopCard();
		System.out.println("---------------------------------");
		System.out.println(p1.toString());
		System.out.println(p2.toString());
		System.out.println(p3.toString());
		System.out.println("---------------------------------");
		
		CardArrayList<Card> currentRoundCards = new CardArrayList<Card>();
		currentRoundCards.add(p1TopCard);
		currentRoundCards.add(p2TopCard);
		currentRoundCards.add(p3TopCard);
		
		ArrayList<Player>collisionPlayers = new ArrayList<Player>();
		collisionPlayers.add(p1);
		collisionPlayers.add(p2);
		
		Player winner = ThreeCardDrawStrategy.pickWinner(collisionPlayers, currentRoundCards);
		
		System.out.println("Winner Details");
		System.out.println(winner.toString());
		
		Assert.assertEquals("Player P1 should be the winner in this situation",p1.getName(),winner.getName());
		//Validating card counts for the winner and other players after the round
		
		/*The winner(P1) should get the 3 initial round cards+3 burned cards from p1+3 burned cards from p2+
		  top card for war from p1+top card for war from p2
		  Total = 3 + 3 + 3 + 2 = 11
		
		  Player P1 initially had 5 cards, showed top card, burned 3 cards, showed card for war
		  P1 should have 0 cards before winning and 11 after winning
		*/
		Assert.assertEquals("Player P1 after winning should have 11 cards",11, p1.getCurrentCardCount());
		Assert.assertEquals("Player P2 should have 0 cards currently",0, p2.getCurrentCardCount());
		Assert.assertEquals("Player P3 should have 1 card currently",1,p3.getCurrentCardCount());
	}
	
	/**
	 * Testing Collision with 3 players while 4 players are playing
	 * ACE's collide
	 */
	//@Test
	public void testScenario2ThreeCardDrawStrategy()
	{
		Player p1 = new Player("PJR2");
		Player p2 = new Player("Maya2");
		Player p3 = new Player("J2");
		Player p4 = new Player("S2");
		
		Card card1 = new Card(CardSuit.DIAMOND,CardRank.ACE); //collision card
		Card card2 = new Card(CardSuit.HEART,CardRank.FIVE);
		Card card3 = new Card(CardSuit.DIAMOND,CardRank.THREE);
		Card card4 = new Card(CardSuit.CLUB,CardRank.TEN);
		Card card5 = new Card(CardSuit.DIAMOND,CardRank.FOUR);
		
		
		p1.getPlayingCard(card1);
		p1.getPlayingCard(card2);
		p1.getPlayingCard(card3);
		p1.getPlayingCard(card4);
		p1.getPlayingCard(card5);
		
		//System.out.println(p1.toString());
		
		Card card6 =  new Card(CardSuit.HEART,CardRank.ACE); //collision card
		Card card7 = new Card(CardSuit.CLUB,CardRank.TWO);
		Card card8 = new Card(CardSuit.DIAMOND,CardRank.EIGHT);
		Card card9 = new Card(CardSuit.SPADE,CardRank.SEVEN);
		Card card10 = new Card(CardSuit.DIAMOND,CardRank.QUEEN);
		
		p2.getPlayingCard(card6);
		p2.getPlayingCard(card7);
		p2.getPlayingCard(card8);
		p2.getPlayingCard(card9);
		p2.getPlayingCard(card10);
		
		//System.out.println(p2.toString());
		
		Card card11 = new Card(CardSuit.CLUB,CardRank.ACE); 	//collision card
		Card card12 = new Card(CardSuit.DIAMOND,CardRank.JACK);
		Card card13 = new Card(CardSuit.SPADE,CardRank.FIVE);
		Card card14 = new Card(CardSuit.DIAMOND,CardRank.SEVEN);
		Card card15 = new Card(CardSuit.HEART,CardRank.TWO);
		Card card16 = new Card(CardSuit.CLUB,CardRank.FOUR);
	
		p3.getPlayingCard(card11);
		p3.getPlayingCard(card12);
		p3.getPlayingCard(card13);
		p3.getPlayingCard(card14);
		p3.getPlayingCard(card15);
		p3.getPlayingCard(card16);
		
		//System.out.println(p3.toString());
		
		Card card17 = new Card(CardSuit.HEART,CardRank.SEVEN);
		Card card18 = new Card(CardSuit.CLUB,CardRank.JACK);
		Card card19 = new Card(CardSuit.SPADE,CardRank.SIX);
		
		p4.getPlayingCard(card17);
		p4.getPlayingCard(card18);
		p4.getPlayingCard(card19);
		
		System.out.println("-----------Player Cards before drawing top cards----------------------");
		System.out.println(p1.toString());
		System.out.println(p2.toString());
		System.out.println(p3.toString());
		System.out.println(p4.toString());
		System.out.println("-----------XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX----------------------");
		
		Card p1TopCard = p1.getTopCard();
		Card p2TopCard = p2.getTopCard();
		Card p3TopCard = p3.getTopCard();
		Card p4TopCard = p4.getTopCard();
		
		System.out.println("-----------Player Cards after drawing top cards----------------------");
		
		System.out.println(p1.toString());
		System.out.println(p2.toString());
		System.out.println(p3.toString());
		System.out.println(p4.toString());
		System.out.println("-----------XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX---------------------");
		
		CardArrayList<Card> currentRoundCards = new CardArrayList<Card>();
		currentRoundCards.add(p1TopCard);
		currentRoundCards.add(p2TopCard);
		currentRoundCards.add(p3TopCard);
		currentRoundCards.add(p4TopCard);
		
		ArrayList<Player>collisionPlayers = new ArrayList<Player>();
		collisionPlayers.add(p1);
		collisionPlayers.add(p2);
		collisionPlayers.add(p3);
		
		Player winner = ThreeCardDrawStrategy.pickWinner(collisionPlayers, currentRoundCards);
		
		System.out.println("Winner Details");
		System.out.println(winner.toString());
		
		Assert.assertEquals("Player P2 should be the winner in this situation",p2.getName(),winner.getName());
		//Validating card counts after round
		
		/*The winner(P2) should get the 4 initial round cards+3 burned cards from p1+3 burned cards from p2+
		  +3 burned cards from p3+top card for war from p1+top card for war from p2+top card for war from p3
		  Total = 4 + 3 + 3 + 3 + 1 + 1 + 1 = 16
		
		  Player P2 initially had 5 cards, showed top card, burned 3 cards, showed card for war
		  P2 should have 0 cards before winning and 16 after winning
		*/
		Assert.assertEquals("Player P2 after winning should have 16 cards",16, p2.getCurrentCardCount());
		Assert.assertEquals("Player P1 should have 0 cards currently",0, p1.getCurrentCardCount());
		Assert.assertEquals("Player P3 should have 1 card currently",1,p3.getCurrentCardCount());
		Assert.assertEquals("Player P4 should have 2 card currently",2 ,p4.getCurrentCardCount());
	
	}
	
	
	/**
	 * Testing double collision with 2 players while 2 players are playing
	 * King's collide initially then ACE's collide
	 */
	//@Test
	public void testScenario3ThreeCardDrawStrategy()
	{
		Player p1 = new Player("PJR3");
		Player p2 = new Player("Maya3");
		
		Card card1 = new Card(CardSuit.DIAMOND,CardRank.KING);// collision card
		Card card2 = new Card(CardSuit.HEART,CardRank.FIVE);
		Card card3 = new Card(CardSuit.DIAMOND,CardRank.THREE);
		Card card4 = new Card(CardSuit.CLUB,CardRank.TEN);
		Card card5 = new Card(CardSuit.DIAMOND,CardRank.ACE); //2'nd collision card
		Card card6 =  new Card(CardSuit.HEART,CardRank.KING);
		Card card7 = new Card(CardSuit.CLUB,CardRank.TWO);
		Card card8 = new Card(CardSuit.DIAMOND,CardRank.TWO);
		Card card9 = new Card(CardSuit.SPADE,CardRank.SEVEN);
		Card card10 = new Card(CardSuit.DIAMOND,CardRank.QUEEN);
		
		p1.getPlayingCard(card1);
		p1.getPlayingCard(card2);
		p1.getPlayingCard(card3);
		p1.getPlayingCard(card4);
		p1.getPlayingCard(card5);
		p1.getPlayingCard(card6);
		p1.getPlayingCard(card7);
		p1.getPlayingCard(card8);
		p1.getPlayingCard(card9);
		p1.getPlayingCard(card10);
		
		Card card11 = new Card(CardSuit.CLUB,CardRank.KING); //collision card
		Card card12 = new Card(CardSuit.DIAMOND,CardRank.JACK);
		Card card13 = new Card(CardSuit.SPADE,CardRank.FIVE);
		Card card14 = new Card(CardSuit.DIAMOND,CardRank.SEVEN);
		Card card15 = new Card(CardSuit.HEART,CardRank.ACE); //2'nd collision card
		Card card16 = new Card(CardSuit.CLUB,CardRank.FOUR);
		Card card17 = new Card(CardSuit.HEART,CardRank.QUEEN);
		Card card18 = new Card(CardSuit.CLUB,CardRank.THREE);
		Card card19 = new Card(CardSuit.DIAMOND,CardRank.NINE);
		Card card20 = new Card(CardSuit.CLUB,CardRank.EIGHT);
		Card card21 = new Card(CardSuit.CLUB,CardRank.JACK);

		p2.getPlayingCard(card11);
		p2.getPlayingCard(card12);
		p2.getPlayingCard(card13);
		p2.getPlayingCard(card14);
		p2.getPlayingCard(card15);
		p2.getPlayingCard(card16);
		p2.getPlayingCard(card17);
		p2.getPlayingCard(card18);
		p2.getPlayingCard(card19);
		p2.getPlayingCard(card20);
		p2.getPlayingCard(card21);
		
		System.out.println("-----------Player Cards before drawing top cards----------------------");
		System.out.println(p1.toString());
		System.out.println(p2.toString());
		System.out.println("-----------XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX----------------------");
			
		Card p1TopCard = p1.getTopCard();
		Card p2TopCard = p2.getTopCard();
		
		System.out.println("-----------Player Cards after drawing top cards----------------------");
		System.out.println(p1.toString());
		System.out.println(p2.toString());
		System.out.println("---------------------------------");
		
		CardArrayList<Card> currentRoundCards = new CardArrayList<Card>();
		currentRoundCards.add(p1TopCard);
		currentRoundCards.add(p2TopCard);

		ArrayList<Player>collisionPlayers = new ArrayList<Player>();
		collisionPlayers.add(p1);
		collisionPlayers.add(p2);
		
		Player winner = ThreeCardDrawStrategy.pickWinner(collisionPlayers, currentRoundCards);
		
		System.out.println("Winner Details");
		System.out.println(winner.toString());
		
		Assert.assertEquals("Player P2 should be the winner in this situation",p2.getName(),winner.getName());
		//Validating card counts for the winner and other players after the round
		
		/*The winner(P2) should get the 2 initial round cards+3 burned cards from p1+3 burned cards from p2
		  +top card for war from p1 + top card for war from p2
		  +3 burned cards from p1(2'nd collision) + 3 burned cards from p2(2'nd collision)
		  +top card for war2 from p1 + top card for war2 from p2
		  Total = 2 + 3 + 3 + 2 + 3 + 3 + 2 = 18
		
		  Player P2 initially had 11 cards, showed top card, burned 3 cards, 
		  showed card for war, burned 3 cards again, showed top card again
		  P2 should have 2 cards before winning and 20 after winning
		  P1 should have 1 card after losing
		*/
		Assert.assertEquals("Player P1 should have 1 card",1, p1.getCurrentCardCount());
		Assert.assertEquals("Player P2 should have 20 cards after winning currently",20, p2.getCurrentCardCount());
	}
	
	/**
	 * Testing collision with 3 players while 3 players are playing 
	 * and one player does not have sufficient cards for war
	 * King's collide
	 */
	@Test
	public void testScenario4ThreeCardDrawStrategy()
	{
		Player p1 = new Player("PJR4");
		Player p2 = new Player("Maya4");
		Player p3 = new Player("J4");
		
		Card card1 = new Card(CardSuit.DIAMOND,CardRank.KING); //collision card
		Card card2 = new Card(CardSuit.HEART,CardRank.FIVE);
		Card card3 = new Card(CardSuit.DIAMOND,CardRank.THREE);
		Card card4 = new Card(CardSuit.CLUB,CardRank.TEN);
		Card card5 = new Card(CardSuit.SPADE,CardRank.FOUR);
		
		
		p1.getPlayingCard(card1);
		p1.getPlayingCard(card2);
		p1.getPlayingCard(card3);
		p1.getPlayingCard(card4);
		p1.getPlayingCard(card5);
		
		System.out.println(p1.toString());
		
		Card card6 =  new Card(CardSuit.HEART,CardRank.KING); //collision card
		Card card7 = new Card(CardSuit.CLUB,CardRank.TWO);
		Card card8 = new Card(CardSuit.DIAMOND,CardRank.ACE);
		Card card9 = new Card(CardSuit.SPADE,CardRank.SEVEN);
		Card card10 = new Card(CardSuit.DIAMOND,CardRank.QUEEN);
		
		p2.getPlayingCard(card6);
		p2.getPlayingCard(card7);
		p2.getPlayingCard(card8);
		p2.getPlayingCard(card9);
		p2.getPlayingCard(card10);
		
		System.out.println(p2.toString());
		
		Card card11 = new Card(CardSuit.CLUB,CardRank.KING);
		Card card12 = new Card(CardSuit.SPADE,CardRank.SIX);
		Card card13 = new Card(CardSuit.DIAMOND,CardRank.FIVE);
		p3.getPlayingCard(card11);
		p3.getPlayingCard(card12);
		p3.getPlayingCard(card13);
		
		System.out.println(p3.toString());
		
		Card p1TopCard = p1.getTopCard();
		Card p2TopCard = p2.getTopCard();
		Card p3TopCard = p3.getTopCard();
		System.out.println("---------------------------------");
		System.out.println(p1.toString());
		System.out.println(p2.toString());
		System.out.println(p3.toString());
		System.out.println("---------------------------------");
		
		CardArrayList<Card> currentRoundCards = new CardArrayList<Card>();
		currentRoundCards.add(p1TopCard);
		currentRoundCards.add(p2TopCard);
		currentRoundCards.add(p3TopCard);
		
		ArrayList<Player>collisionPlayers = new ArrayList<Player>();
		collisionPlayers.add(p1);
		collisionPlayers.add(p2);
		collisionPlayers.add(p3);
		
		Player winner = ThreeCardDrawStrategy.pickWinner(collisionPlayers, currentRoundCards);
		
		System.out.println("Winner Details");
		System.out.println(winner.toString());
		
		Assert.assertEquals("Player P2 should be the winner in this situation",p2.getName(),winner.getName());
		//Validating card counts for the winner and other players after the round
		
		/*The winner(P2) should get the 3 initial round cards+3 burned cards from p1+3 burned cards from p2
		  +2 remaining cards from P3(who loses directly) + top card for war from p1+top card for war from p2
		  Total = 3 + 3 + 3 + 2 + 1 + 1 = 13
		
		  Player P2 initially had 5 cards, showed top card, burned 3 cards, showed card for war
		  P2 should have 0 cards before winning and 13 after winning
		*/
		Assert.assertEquals("Player P1 should have 0 cards currently",0, p1.getCurrentCardCount());
		Assert.assertEquals("Player P2 should have 13 cards currently",13, p2.getCurrentCardCount());
		Assert.assertEquals("Player P3 should have 0 card currently",0,p3.getCurrentCardCount());
	}

}
