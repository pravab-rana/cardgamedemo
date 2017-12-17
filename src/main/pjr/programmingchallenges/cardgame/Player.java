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
	
	public Player(String name)
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
	public void addFromRoundCards(ArrayList<Card> roundCards) //throws CardException
	{
		if(cards == null)
		{
			throw new RuntimeException("Cannot add null playing card");
		}
		cards.addAll(roundCards);
	}
	
	/**
	 * Method to add player's deck cards to the round
	 * @param int number of cards to put to the round
	 */
	public CardArrayList<Card> addToRoundCards(int cardToAddToRound) 
	{
		if(cardToAddToRound<=0)
		{
			throw new RuntimeException("Need a positive number as the number of cards to add to the round");
		}
		CardArrayList<Card> roundCards = new CardArrayList<Card>();
		Card currentCard = null;
		for(int i=0;i<cardToAddToRound;i++)
		{
			currentCard = cards.get(0);
			roundCards.add(currentCard);
			removeCard(currentCard);
		}
		return(roundCards);
	}
	
	/**
	 * Method to remove a card from the player's deck, set as private as the only way to remove cards is via the top
	 */
	private void removeCard(Card card)
	{
		cards.remove(card);
	}
	
	/**
	 * Method to retrieve the top card, removes the card from player's deck
	 * @return
	 */
	public Card getTopCard()
	{
		Card topCard = cards.get(0);
		removeCard(topCard);
		return(topCard);
	}
	
	public int getCurrentCardCount()
	{
		return(cards.size());
	}
		
	@Override
	public boolean equals(Object obj)
	{
		if (obj == this) 
		{
            return true;
        }
 
        if (!(obj instanceof Player)) 
        {
            return false;
        }
		
        Player p = (Player)obj;
        if(this.getName().equals(p.getName()))
        	return true;
        
        return false;
	}
	
	@Override
	public int hashCode()
	{
		return(this.getName().hashCode()+this.cards.hashCode());
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
