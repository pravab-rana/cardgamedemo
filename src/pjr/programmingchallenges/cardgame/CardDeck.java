package pjr.programmingchallenges.cardgame;

import java.util.Collections;

public class CardDeck 
{
	
	Card cards[] = new Card[52];
	int suffleCount;
	
	CardDeck()
	{
		initializeCardDeck();
		suffleCount = 10;//setting a default shuffleCount;
	}

	private void initializeCardDeck() 
	{
		int i = 0;
		for (CardSuit suit : CardSuit.values()) 
		{
		    for (CardRank rank : CardRank.values()) 
		    {
		      cards[i]= new Card(suit,rank);
		      i++;  
		    }
		  }
	}
	
	public void setShuffleCount(int suffleCount)
	{
		this.suffleCount = suffleCount;	
	}
	
	public int getShuffleCount()
	{
		return(suffleCount);
	}
	
	public void shuffleDeck()
	{
		int moveIndex = -1;
		for(int move=0;move<suffleCount;move++)
		{
			moveIndex = (int) (Math.random()*51);
			System.out.println("Move index:"+moveIndex);
			swapCards(moveIndex);
		}
	}
	
	private void swapCards(int moveIndex)
	{
		//just to take care of a potential situation where the moveIndex would
		//be the last index and as we are swapping it with the next index+2
		//just making sure we do not get an exception
		if(moveIndex==50)
			moveIndex--;
		
		Card tempCard = cards[moveIndex];
		cards[moveIndex] = cards[moveIndex+2];
		cards[moveIndex+2] = tempCard;
	}
	
	
	@Override
	public String toString()
	{
		String currentCards = "";
		for(int i=0;i<cards.length;i++)
		{
			currentCards=currentCards+" CardSuit:"+cards[i].getCardSuit()+" CardRank:"+cards[i].getCardRank();
		}
		
		return(currentCards);
	}
}
