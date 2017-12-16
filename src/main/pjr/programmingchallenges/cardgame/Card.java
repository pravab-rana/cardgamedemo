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
	
	public CardSuit getCardSuit() {
		return cardSuit;
	}
	public void setCardSuit(CardSuit cardSuit) {
		this.cardSuit = cardSuit;
	}
	
	public CardRank getCardRank() {
		return cardRank;
	}
	public void setCardRank(CardRank cardRank) {
		this.cardRank = cardRank;
	}
	
	int compareCard(Card opponentCard)
	{
		if(opponentCard.getCardRank().getCardRank()>this.cardRank.getCardRank())
			return -1;
		else if(opponentCard.getCardRank().getCardRank()==this.cardRank.getCardRank())
			return 0;
		else
			return -1;
	}
	
	@Override
	public String toString()
	{
		return("CardSuit:"+cardSuit.name()+" CardRank:"+cardRank.name());
		
	}
}
