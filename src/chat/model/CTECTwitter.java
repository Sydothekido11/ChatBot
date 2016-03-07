package chat.model;

import twitter4j.*;
import java.util.ArrayList;
/**
 * Made a declaration and constructor with a success message.
 * @author snem8901 3/7/16
 *
 */

public class CTECTwitter 
{

	private ArrayList<Status> statusList;
	private ArrayList<String> wordsList;
	
	public CTECTwitter()
	{
		this.statusList = new ArrayList<Status>();
		this.wordsList = new ArrayList<String>();
		
		
	}
	public boolean sendTweet(String input)
	{
		return true;
	}
	
}
