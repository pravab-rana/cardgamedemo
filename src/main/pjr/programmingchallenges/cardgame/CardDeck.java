package pjr.programmingchallenges.cardgame;

import java.util.Collections;

public class CardDeck 
{
	//Card cards[] = new Card[52];
	CardArrayList<Card> cards = new CardArrayList<Card>();
	int suffleCount;
	boolean collectionShuffle;
	
	public CardDeck()
	{
		initializeCardDeck();
		suffleCount = 10;//setting a default shuffleCount;
	}

	public CardArrayList<Card> getCards() 
	{
		return cards;
	}

	public int getSuffleCount() 
	{
		return suffleCount;
	}
	
	public boolean getCollectionShuffle()
	{
		return(collectionShuffle);
	}
	
	public void setCollectionShuffle(boolean collectionShuffle)
	{
		this.collectionShuffle = collectionShuffle;
	}

	private void initializeCardDeck() 
	{
		for (CardSuit suit : CardSuit.values()) 
		{
		    for (CardRank rank : CardRank.values()) 
		    {
		      cards.add(new Card(suit,rank));
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
	
	/**
	 * Custom method to shuffle the cards. This method uses Math.random() to generate random indexes
	 * to swap within the collection.
	 * The class does provide an option to use the default Collection's shuffle by setting
	 * collectionShuffle as true
	 */
	public void shuffleDeck()
	{
		if(!collectionShuffle)
		{
			int moveIndex = -1;
			for(int move=0;move<suffleCount;move++)
			{
				moveIndex = (int) (Math.random()*51);
				//System.out.println("Move index:"+moveIndex);
				swapCards(moveIndex);
			}
		}
		else
			Collections.shuffle(cards);
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
	
	/**
	 * Method to return the top card from the card deck
	 * @return Card - top card
	 */
	public Card getTopDeckCard()
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
	public boolean equals(Object obj)
	{
		if(obj==this)
			return true;
		
		if(!(obj instanceof CardDeck))
			return false;
		
        CardDeck carddeck = (CardDeck)obj;
        CardArrayList<Card> carddeckcards = carddeck.getCards();
        for(int i=0;i<carddeckcards.size();i++)
        {
        	if(!(this.cards.get(i)).equals(carddeckcards.get(i)))
        		return false;
        }
        return true;
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
