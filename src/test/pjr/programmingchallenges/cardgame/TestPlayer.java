package pjr.programmingchallenges.cardgame;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;


public class TestPlayer 
{
	private static Player player;
	
	@BeforeClass
	public static void setUp()
	{
		player = new Player();
	}
	
	@Test
	public void testSetName()
	{
		player.setName("PJR");
		Assert.assertEquals("Name should be PJR","PJR",player.getName());
	}
	
	@Test
	public void testCurrentCardCount()
	{
		player.getPlayingCard(new Card(CardSuit.CLUB,CardRank.ACE));
		player.getPlayingCard(new Card(CardSuit.DIAMOND,CardRank.FIVE));
		player.getPlayingCard(new Card(CardSuit.DIAMOND,CardRank.SIX));
		
		int currentCardCount = player.getCurrentCardCount();
		Assert.assertEquals("Player should currently have 3 cards",3, currentCardCount);
	}
	
	@Test
	public void testShowingTopCard()
	{
		player.getPlayingCard(new Card(CardSuit.CLUB,CardRank.ACE));
		player.getPlayingCard(new Card(CardSuit.DIAMOND,CardRank.FIVE));
		
		Card topCard = player.getTopCard();
		Assert.assertEquals("Current top card should be ACE of CLUB",new Card(CardSuit.CLUB,CardRank.ACE), topCard);
	}
	
	@Test
	public void testAddFromRoundCards()
	{
		CardArrayList<Card> roundCards = new CardArrayList<Card>();
		roundCards.add(new Card(CardSuit.CLUB,CardRank.EIGHT));
		roundCards.add(new Card(CardSuit.HEART,CardRank.KING));
		roundCards.add(new Card(CardSuit.SPADE,CardRank.QUEEN));
		player.addFromRoundCards(roundCards);
		
		Assert.assertEquals("Currently 6 cards should be present",6,player.getCurrentCardCount());
	}
}
