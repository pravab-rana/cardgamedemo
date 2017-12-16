package pjr.programmingchallenges.cardgame;

import java.util.ArrayList;
import java.util.Iterator;

public class CardGameController 
{
	ArrayList<Player> players;
	CardDeck cardDeck;
	
	CardGameController()
	{
		players = new ArrayList<Player>();
		cardDeck = new CardDeck();
	}
	
	public int playerCount()
	{
		return(players.size());
	}
	
	public void addPlayer(Player player)
	{
		players.add(player);
	}
	
	public boolean removePlayer(Player player)
	{
		Iterator<Player> playerIterator = players.iterator();
		while(playerIterator.hasNext())
		{
			if(playerIterator.next().equals(player))
			{
				playerIterator.remove();
				return true;
			}
		}
		return false;
	}
	
	public Player getPlayer(Player player)
	{
		Player desiredPlayer = null;
		Iterator<Player> playerIterator = players.iterator();
		while(playerIterator.hasNext())
		{
			if(playerIterator.next().equals(player))
			{
				desiredPlayer = player;
				break;
			}
		}
		return(desiredPlayer);
	}
	
	public boolean distributeDeck()  
	{
		boolean isDeckDistributed=false;
		if(players.size()<=0)
		{
			throw new RuntimeException("No active player found");
		}
		//we have different card distribution strategies
		while(cardDeck.cards.size()>0)
		{
			Iterator<Player> playerIterator = players.iterator();
			for(Player player:players)
			{
				//need to check if the deck is empty as we distribute
				//to each player as well
				if(cardDeck.cards.size()==0)
					break;
				player.getPlayingCard(cardDeck.getTopCard());
			}
		}
		isDeckDistributed=true;
		
		
		return(isDeckDistributed);
		
		
	}
	
	//public Player playRound()
	public void playRound()
	{
		//ArrayList<Card> roundCards = new ArrayList<Card>();
		ArrayList<CardRound> cardAndPlayers = new ArrayList<CardRound>();
		Iterator<Player> playerIterator = players.iterator();
		Player currentPlayer = null;
		while(playerIterator.hasNext())
		{
			currentPlayer = playerIterator.next();
			CardRound cardAndPlayer = new CardRound(currentPlayer,currentPlayer.showTopCard());
			cardAndPlayers.add(cardAndPlayer);
			//roundCards.add(playerIterator.next().showTopCard());
		}
		System.out.println("Round Details:");
		printRoundDetails(cardAndPlayers);
		
		CardRound winner = pickRoundWinner(cardAndPlayers);
		System.out.println("Round Winner");
		System.out.println(winner.toString());
		Player winningPlayer = winner.getPlayer();
		//add cards to the winner
		Player winnerP = getPlayer(winningPlayer);
		
		addCardsToWinner(winningPlayer,cardAndPlayers);
		//removeCardsFromLosers()
		
	}
	
	private void addCardsToWinner(Player winningPlayer, ArrayList<CardRound> cardAndPlayers) 
	{
		Player currentPlayer = null;
		for(CardRound cardAndPlayer:cardAndPlayers)
		{
			currentPlayer = cardAndPlayer.getPlayer();
			
			/*Need to remove winners card as well
			 if(currentPlayer.equals(winningPlayer))
			 	continue;
			*/
			
			//winningPlayer.getPlayingCard(cardAndPlayer.getCard());
			
			//There might be more than one more due to collision
			//winningPlayer.addRoundCards(cardAndPlayer.getCard());
			winningPlayer.addRoundCards(cardAndPlayer.getCards());
			
			/*removing card should happen automatically on the show of top card
			  currentPlayer.removeCard(cardAndPlayer.getCard());
			*/
		}
	}

	private void printRoundDetails(ArrayList<CardRound> cardAndPlayers)
	{
		String roundDetails = "\n";
		for(CardRound cardAndPlayer:cardAndPlayers)
		{
			roundDetails = roundDetails + cardAndPlayer.toString();
		}
		System.out.println(roundDetails);
	}
	
	//public int pickRoundWinner(ArrayList<Card> roundCards)
	public CardRound pickRoundWinner(ArrayList<CardRound> cardAndPlayers)
	{
		int winningCard = -1;
		int winningIndex = -1;
		
		//CardAndPlayer firstPlayer = null;
		//CardAndPlayer winner = null; 
		CardRound winner = cardAndPlayers.get(0);
		
		//firstPlayer = cardAndPlayers.get(0);
		//Card firstPlayerCard = firstPlayer.getCard();
		
		//for(CardAndPlayer cardAndPlayer:cardAndPlayers)
		for(int i=1;i<cardAndPlayers.size();i++)
		{
			
			//if(firstPlayerCard.compareCard(cardAndPlayers.get(i).getCard())>1)
			//if(winner.getCard().compareCard(cardAndPlayers.get(i).getCard())<1)
			if(winner.getTopCard().compareCard(cardAndPlayers.get(i).getTopCard())<1)
			{
				winner = cardAndPlayers.get(i);
			}
			//else if(winner.getCard().compareCard(cardAndPlayers.get(i).getCard())==0)
			else if(winner.getTopCard().compareCard(cardAndPlayers.get(i).getTopCard())==0)
			{
				//add collision logic
				System.out.println("Collision:for now continuing with original winner");
			}
		}
		
		return(winner);
		
		//Returning -1 to indicate collisions as discussed yesterday
		//where there would be need to get 3 further cards
		//return -1;
		
	}

}
