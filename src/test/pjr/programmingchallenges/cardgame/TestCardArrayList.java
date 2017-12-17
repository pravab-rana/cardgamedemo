package pjr.programmingchallenges.cardgame;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestCardArrayList 
{
	private static CardArrayList<Card> cards;
	
	@Before
	public void setUp()
	{
		cards = new CardArrayList<Card>();
	}
	
	@Test
	public void testSizeLimit()
	{
		for (CardSuit suit : CardSuit.values()) 
		{
		    for (CardRank rank : CardRank.values()) 
		    {
		      cards.add(new Card(suit,rank));
		    }
		}
		
		boolean isAdded = cards.add(new Card(CardSuit.CLUB,CardRank.ACE));
		Assert.assertEquals("As the limit to CardArrayList is 52, this should be false",false, isAdded);
	}
}
