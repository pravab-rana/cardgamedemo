package pjr.programmingchallenges.cardgame;

import java.util.Collections;


public class CardDeck 
{
	//I started out with an array but then just felt that if I could restrict 
	//the size to 52,could leverage ArrayList hence extended ArrayList
	//overriding just the add method
	
	//Card cards[] = new Card[52];
	CardArrayList<Card> cards = new CardArrayList<Card>();
	
	int suffleCount;
	
	public CardDeck()
	{
		initializeCardDeck();
		suffleCount = 10;//setting a default shuffleCount;
	}

	private void initializeCardDeck() 
	{
		//int i = 0;
		for (CardSuit suit : CardSuit.values()) 
		{
		    for (CardRank rank : CardRank.values()) 
		    {
		      //cards[i]= new Card(suit,rank);
		      cards.add(new Card(suit,rank));
				 	
		      //i++;  
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
			//System.out.println("Move index:"+moveIndex);
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
		
		/*
		Card tempCard = cards[moveIndex];
		cards[moveIndex] = cards[moveIndex+2];
		cards[moveIndex+2] = tempCard;
		*/
		
		Card tempCard = cards.get(moveIndex);
		cards.set(moveIndex, cards.get(moveIndex+2));
		cards.set(moveIndex+2, tempCard);
	}
	
	public Card getTopCard()
	{
		Card topCard = cards.get(0);
		cards.remove(0);
		return (topCard);
	}
	
	public int cardDeckSize()
	{
		return(cards.size());
	}
	
	@Override
	public String toString()
	{
		String currentCards = "";
		/*
		for(int i=0;i<cards.length;i++)
		{
			currentCards=currentCards+" CardSuit:"+cards[i].getCardSuit()+" CardRank:"+cards[i].getCardRank();
		}*/
		for(int i=0;i<cards.size();i++)
		{
			currentCards = currentCards+" CardSuit:"+cards.get(i).getCardSuit()+" CardRank:"+cards.get(i).getCardRank();
		}

		
		return(currentCards);
	}
}
