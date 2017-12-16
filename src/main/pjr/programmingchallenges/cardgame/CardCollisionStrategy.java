package pjr.programmingchallenges.cardgame;

import java.util.ArrayList;

public interface CardCollisionStrategy 
{
	
	Player pickWinner(ArrayList<Player> currentPlayers,ArrayList<CardRound>currentRound);

}
