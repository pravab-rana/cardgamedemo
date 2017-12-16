package pjr.programmingchallenges.cardgame;

public class TestCardGame {
	
	public static void main(String args[])
	{
		CardDeck mydeck = new CardDeck();
		System.out.println("My deck:"+mydeck.toString());
		
		mydeck.shuffleDeck();
		
		System.out.println("My deck:"+mydeck.toString());
		
		Card myCard = mydeck.getTopCard();
		
		System.out.println("Card:"+myCard.toString());
		
		System.out.println("My Deck now:"+mydeck.toString());
		
		CardGameController mygame = new CardGameController();
		Player p1 = new Player("Pravab");
		Player p2 = new Player("Maya");
		Player p3 = new Player("Jay");
		mygame.addPlayer(p1);
		mygame.addPlayer(p2);
		mygame.addPlayer(p3);
		mygame.distributeDeck();
		
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);
		
		mygame.playRound();
		
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);
		
		
	}
}
