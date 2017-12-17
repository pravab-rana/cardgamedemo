package pjr.programmingchallenges.cardgame;

public class Card 
{
	CardSuit cardSuit;
	CardRank cardRank;
	
	Card(CardSuit cardSuit,CardRank cardRank)
	{
		this.cardSuit = cardSuit;
		this.cardRank = cardRank;
	}
	
	public CardSuit getCardSuit() 
	{
		return cardSuit;
	}
	
	public void setCardSuit(CardSuit cardSuit) 
	{
		this.cardSuit = cardSuit;
	}
	
	public CardRank getCardRank() 
	{
		return cardRank;
	}
	public void setCardRank(CardRank cardRank) 
	{
		this.cardRank = cardRank;
	}
	
	/**
	 * Method to compare two cards. This uses the CardRank value. 
	 * I am currently not using CardSuit during comparison
	 * @param opponentCard
	 * @return -1 if the opponentCard has higher Rank, 0 if they are equal, 1 if the current card has higher value
	 */
	int compareCard(Card opponentCard)
	{
		//System.out.println("Current Card Rank:"+this.cardRank.getCardRankValue());
		//System.out.println("Opponent Card Rank:"+opponentCard.getCardRank().getCardRankValue());
		if(opponentCard.getCardRank().getCardRankValue()>this.cardRank.getCardRankValue())
			return -1;
		else if(opponentCard.getCardRank().getCardRankValue()==this.cardRank.getCardRankValue())
		{
			//System.out.println("Returning 0");
			return 0;
		}
		else
			return 1;
	}
	
	@Override 
	public boolean equals(Object obj)
	{
		if (obj == this) 
		{
            return true;
        }
 
        if (!(obj instanceof Card)) 
        {
            return false;
        }
		
        Card card = (Card)obj;
        if((this.getCardSuit().name()).equals(card.getCardSuit().name()) &&
           (this.getCardRank().name()).equals(card.getCardRank().name()))
        	return true;
        
        return false;
	}
	
	@Override 
	public int hashCode()
	{
		return(this.getCardRank().hashCode()+this.getCardSuit().hashCode());
	}
	
	@Override
	public String toString()
	{
		return("CardSuit:"+cardSuit.name()+" CardRank:"+cardRank.name()+"|");
		
	}
}
