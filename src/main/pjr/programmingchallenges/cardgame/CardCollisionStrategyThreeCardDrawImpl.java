package pjr.programmingchallenges.cardgame;

import java.util.ArrayList;
import java.util.Iterator;

public class CardCollisionStrategyThreeCardDrawImpl implements CardCollisionStrategy
{

	public final static int CARDS_TO_BURN_FOR_COLLISION = 3;
	
	@Override
	public Player pickWinner(ArrayList<Player> currentCollisionPlayers, CardArrayList<Card> currentRoundCards) 
	{
		boolean hasCollision = false;
		CardArrayList<Card> roundWarCards = new CardArrayList<Card>();
		//Adding current round cards to war cards
		roundWarCards.addAll(currentRoundCards);
		System.out.println("Initial round war cards:"+roundWarCards.toString());
		
		
		ArrayList<Player> tempCollisionPlayers = null;
		
		Player winner = null;
		
		
		do
		{
		
			Player currentPlayer = null;
			
			//if this is multiple war collision round, using the new tempCollsionPlayersObject
			
			if(hasCollision)
			{
				currentCollisionPlayers = tempCollisionPlayers;
				hasCollision = false;
				//tempCollisionPlayers = new ArrayList<Player>();
			}
			
			Iterator<Player> playerIterator = currentCollisionPlayers.iterator();
			//removing all players that might not have sufficient cards for war
			while(playerIterator.hasNext())
			{
				currentPlayer = playerIterator.next();
				
				//if the player does not have sufficient cards to war
				//he/she loses directly submitted the remaining cards to the round
				if(currentPlayer.currentCardCount()<=CARDS_TO_BURN_FOR_COLLISION)
				{
					roundWarCards.addAll(currentPlayer.addToRoundCards(currentPlayer.currentCardCount()));
					playerIterator.remove();
					continue;
				}
				
				roundWarCards.addAll(currentPlayer.addToRoundCards(CARDS_TO_BURN_FOR_COLLISION));

			}
			
			System.out.println("Current round war cards:"+roundWarCards.toString());
			
			System.out.println("Current Collision Player 0:"+currentCollisionPlayers.get(0));
			
			winner = currentCollisionPlayers.get(0);
			//roundWarCards.addAll(winner.addToRoundCards(CARDS_TO_BURN_FOR_COLLISION));
			
			Card currentWinningCard = null;
			Card cardToCompare = null;
			for(int i=1;i<currentCollisionPlayers.size();i++)
			{
				//checking if a default current winning card has been set
				if(currentWinningCard ==null)
				{
					currentWinningCard = winner.getTopCard();
					roundWarCards.add(currentWinningCard);
				}
				cardToCompare = currentCollisionPlayers.get(i).getTopCard();
				roundWarCards.add(cardToCompare);
				
				if(currentWinningCard.compareCard(cardToCompare)==0)
				{
					hasCollision = true;
					if(tempCollisionPlayers==null)
					{
						//currentCollisionPlayers = tempCollisionPlayers;
						tempCollisionPlayers = new ArrayList<Player>();
				
					}
					
					if(!(tempCollisionPlayers.contains(winner)))
					{
						tempCollisionPlayers.add(winner);
					}
					tempCollisionPlayers.add(currentCollisionPlayers.get(i));
					
				}
				else if(currentWinningCard.compareCard(cardToCompare)==-1)
				{
					winner = currentCollisionPlayers.get(i);
				}
				
				
			}
		}while((hasCollision)&&(currentCollisionPlayers.size()>1));
		
		winner.addFromRoundCards(roundWarCards);
		return(winner);
	}

}
