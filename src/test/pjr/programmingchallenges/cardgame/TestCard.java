package pjr.programmingchallenges.cardgame;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestCard 
{
	
	private static Card card1;
	private static Card card2;
	
	@Before
	public void setUp()
	{
		card1 = new Card(CardSuit.DIAMOND,CardRank.ACE);
		card2 = new Card(CardSuit.HEART,CardRank.JACK);
	}
	
	@Test
	public void testCompareCard1Winner()
	{
		int result = card1.compareCard(card2);
		Assert.assertEquals("Card 1 should win",1,result);
	}
	
	@Test
	public void testCompareCard2Winner()
	{ 
		card1.setCardRank(CardRank.SIX);
		int result = card1.compareCard(card2);
		Assert.assertEquals("Card 2 should win",-1,result);
	}
	
	@Test
	public void testCompareCardEqualRank()
	{
		card1.setCardRank(CardRank.SIX);
		card2.setCardRank(CardRank.SIX);
		int result = card1.compareCard(card2);
		Assert.assertEquals("Equal cards, result should be 0",0,result);
	}
	
	@Test
	public void testCardEqualsMethodFalse()
	{
		card1.setCardRank(CardRank.TWO);
		card2.setCardRank(CardRank.TWO);
		card2.setCardSuit(CardSuit.DIAMOND);
		
		boolean isEqual = card1.equals(card2);
		Assert.assertEquals("The Suit and Rank are same so the cards should be equal", true,isEqual);

	}
	
	@Test
	public void testCardEqualsMethodTrue()
	{
		card1.setCardRank(CardRank.TWO);
		card2.setCardRank(CardRank.TWO);
		
		boolean isEqual = card1.equals(card2);
		Assert.assertEquals("The Suit are different so the cards should not be equal", false,isEqual);
	}
}
