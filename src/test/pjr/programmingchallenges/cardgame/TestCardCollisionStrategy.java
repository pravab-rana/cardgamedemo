package pjr.programmingchallenges.cardgame;

import java.util.ArrayList;

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
	
	
	@Test
	public void TestThreeCardDrawStrategy()
	{
		Player p1 = new Player("PJR");
		Player p2 = new Player("Maya");
		Player p3 = new Player("J");
		
		Card card1 = new Card(CardSuit.DIAMOND,CardRank.KING);
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
		
		Card card6 =  new Card(CardSuit.HEART,CardRank.KING);
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
		
		Card card11 = new Card(CardSuit.HEART,CardRank.KING);
		p3.getPlayingCard(card11);
		
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
		currentRoundCards.add(p2TopCard);
		
		ArrayList<Player>collisionPlayers = new ArrayList<Player>();
		collisionPlayers.add(p1);
		collisionPlayers.add(p2);
		
		Player winner = ThreeCardDrawStrategy.pickWinner(collisionPlayers, currentRoundCards);
		
		System.out.println("Winner Details");
		System.out.println(winner.toString());
		
		//System.out.println(p1.toString());
		

	}

}
