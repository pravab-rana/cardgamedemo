package pjr.programmingchallenges.cardgame;

import java.util.ArrayList;

@SuppressWarnings("serial")
public class CardArrayList<T> extends ArrayList<T> 
{
	/**
	 * Method to add to the ArrayList to a maximum size of 52 which is the deck size
	 * @param Card - Card to add
	 * @return true able to add, false otherwise
	 */
	public boolean add(T card) 
	{
		if (this.size() < 52) 
	    {
	        return super.add(card);
	    }
	    return false;
	}

}
