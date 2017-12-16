package pjr.programmingchallenges.cardgame;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test; 

import org.junit.runners.MethodSorters;
import org.junit.FixMethodOrder;


//Setting an alphabetical ordering of tests so that adding player happens first
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestCardGameController 
{
	
	private static CardGameController cardGameController;
	private static Player p1;
	private static Player p2;
	
	@BeforeClass
	public static void setUp()
	{
		cardGameController = new CardGameController();
		
	}
	
	@Test
	public void TestAddPlayer()
	{
		p1 = new Player("Pravab");
		p2 = new Player("Maya");
		
		cardGameController.addPlayer(p1);
		cardGameController.addPlayer(p2);
		
		Assert.assertEquals("Game should have two players currently",2,cardGameController.getPlayerCount());
	
		
	}
	
	
	@Test
	public void TestDistributeCards()
	{
		cardGameController.distributeDeck();
		
		Assert.assertEquals("Player p1 should be 26 cards", 26, cardGameController.getPlayer(p1).currentCardCount());
		Assert.assertEquals("Player p2 should be 26 cards", 26, cardGameController.getPlayer(p2).currentCardCount());

	}

}
