package pjr.programmingchallenges.cardgame;

import java.util.ArrayList;

public class Player 
{
	
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
	
	/**
	 * Method to add playing cards to player's deck
	 * @param card
	 */
	public void getPlayingCard(Card card) //throws CardException
	{
		if(card == null)
		{
			//throw new CardException("Cannot get a null playing card");
			throw new RuntimeException("Cannot get a null playing card");
		}
		cards.add(card);
	}
	
	
	/**
	 * Method to add playing cards to player's deck
	 * @param card
	 */
	public void addRoundCards(ArrayList<Card> roundCards) //throws CardException
	{
		if(cards == null)
		{
			throw new RuntimeException("Cannot add null playing card");
		}
		cards.addAll(roundCards);
	}
	
	/**
	 * Method to remove a card from the player's deck, set as private as the only way to remove cards is via the top
	 */
	private void removeCard(Card card)
	{
		cards.remove(card);
	}
	
	/**
	 * Method to show the top card
	 * @return
	 */
	public Card showTopCard()
	{
		Card topCard = cards.get(0);
		removeCard(topCard);
		return(topCard);
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
