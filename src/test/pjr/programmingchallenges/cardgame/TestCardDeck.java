package pjr.programmingchallenges.cardgame;

import org.junit.BeforeClass;
import org.junit.Test;

import pjr.programmingchallenges.cardgame.CardDeck;

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

}
