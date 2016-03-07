package chat.model;

import twitter4j.*;
import java.util.ArrayList;
import chat.controller.ChatController;
/**
 * Made a declaration and constructor with a success message.
 * @author snem8901 3/7/16
 *
 */

public class CTECTwitter 
{

	private ArrayList<Status> statusList;
	private ArrayList<String> wordsList;
	private Twitter chatbotTwitter;
	private ChatController baseController;
	
	
	public CTECTwitter(ChatController baseController)
	{
		this.baseController = baseController;
		this.statusList = new ArrayList<Status>();
		this.wordsList = new ArrayList<String>();
		this.chatbotTwitter = TwitterFactory.getSingleton();
		
		
	}
	public void sendTweet(String input)
	{
		try
		{
			chatbotTwitter.updateStatus("I just tweeted from my Java Chatbot program! #APCSRocks @CTECNow Thanks @cscheerleader & @codyhenrichsen! Sydney Nemelka");
		}
		
		catch(TwitterException error)
		{
			baseController.handleErrors(error.getErrorMessage());
		}
		
		
		
	}
	
	
	
	
}
