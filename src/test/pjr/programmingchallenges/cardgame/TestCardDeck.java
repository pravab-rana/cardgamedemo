package pjr.programmingchallenges.cardgame;

import org.junit.BeforeClass;
import org.junit.Test;

import pjr.programmingchallenges.cardgame.CardDeck;
import pjr.programmingchallenges.cardgame.Player;

import org.junit.Assert;


public class TestCardDeck {
	
	private static CardDeck cardDeck;
	
	@BeforeClass
	public static void setup()
	{
		cardDeck = new CardDeck();
	}
	
	@Test
	public void TestInitalizeCardCound()
	{
		Assert.assertEquals("CardDeck should have 52 cards initially",52, cardDeck.cardDeckSize());
	}
	
	@Test
	public void TestCardDeckShuffle()
	{
		CardDeck cardDeck2 = new CardDeck();
		cardDeck2 = cardDeck;
		
		cardDeck.shuffleDeck();
		
		Assert.assertEquals("Card deck should not be same after shuffle" ,false, cardDeck.equals(cardDeck2));
		
		
		
		
	}

}
