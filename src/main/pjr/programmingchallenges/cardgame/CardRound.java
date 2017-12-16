package pjr.programmingchallenges.cardgame;

import java.util.ArrayList;

public class CardRound {
	Player player;
	//Card card;
	ArrayList<Card> roundCards;
	
	CardRound(Player player,Card card)
	{
		this.player = player;
		//this.card = card;
		roundCards = new ArrayList<Card>();
		roundCards.add(card);
	}
	
	public Player getPlayer() 
	{
		return player;
	}
	public void setPlayer(Player player)
	{
		this.player = player;
	}
	
	public ArrayList<Card> getCards() 
	{
		return roundCards;
	}
	
	public Card getTopCard() 
	{
		return roundCards.get(0);
	}
	
	public void setCard(Card card) 
	{
		roundCards.add(card);
	}
	
	@Override
	public String toString()
	{
		String SroundCards = "";
		for(Card card:roundCards)
		{
			SroundCards = SroundCards + ","+card.toString();
		}
		//return("Player:"+player.getName()+",Card:"+card.toString());
		return("Player:"+player.getName()+",Card:"+SroundCards);
	}

}
