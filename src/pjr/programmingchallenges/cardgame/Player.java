package pjr.programmingchallenges.cardgame;

import java.util.ArrayList;

public class Player {
	
	private String name;
	private ArrayList<Card> cards;

	Player()
	{
		cards = new ArrayList<Card>();
	}
	
	Player(String name)
	{
		this.name = name;
		cards = new ArrayList<Card>();
	}
	
	public String getName()
	{
		return(name);
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void getPlayingCard(Card card) throws CardException
	{
		if(card == null)
		{
			throw new CardException("Cannot get a null playing card");
		}
		cards.add(card);
	}
	
	public Card showTopCard()
	{
		return(cards.get(0));
	}
	
	public void collectRoundWinnerCards(Card roundCards[])
	{
		for(Card card:roundCards)
		{
			cards.add(card);
		}
	}
	
	@Override
	public boolean equals(Object obj)
	{
		if (obj == this) {
            return true;
        }
 
        if (!(obj instanceof Player)) {
            return false;
        }
		
        Player p = (Player)obj;
        if(this.getName().equals(p.getName()))
        	return true;
        
        return false;
	}
	
	@Override
	public String toString()
	{
		String playerDetails = "Player:"+name+"\n";
		playerDetails = playerDetails+"Current Number of Cards:"+cards.size()+"\n";
		playerDetails = playerDetails+"Card Details\n";
		for(Card card:cards)
		{
			playerDetails = playerDetails +card.toString()+" ";
		}
		
		return(playerDetails);
	}
	
}
