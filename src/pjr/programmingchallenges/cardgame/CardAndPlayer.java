package pjr.programmingchallenges.cardgame;

public class CardAndPlayer {
	Player player;
	Card card;
	
	CardAndPlayer(Player player,Card card)
	{
		this.player = player;
		this.card = card;
	}
	
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
	public Card getCard() {
		return card;
	}
	public void setCard(Card card) {
		this.card = card;
	}
	
	@Override
	public String toString()
	{
		return("Player:"+player.getName()+",Card:"+card.toString());
	}

}
