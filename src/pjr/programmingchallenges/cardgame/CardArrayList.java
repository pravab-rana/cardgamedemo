package pjr.programmingchallenges.cardgame;

import java.util.ArrayList;

public class CardArrayList<T> extends ArrayList<T> 
{
	
	public boolean add(T card) 
	{
		if (this.size() < 52) 
	    {
	        return super.add(card);
	    }
	    return false;
	}

}
