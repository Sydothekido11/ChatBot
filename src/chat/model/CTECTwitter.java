package chat.model;

import twitter4j.*;
import java.util.ArrayList;
import chat.controller.ChatController;
import java.util.*;
/**
 * Made a declaration and constructor with a success message.
 * @author snem8901 3/7/16
 *
 */

public class CTECTwitter 
{

	private Twitter chatbotTwitter;
	private List statusList;
	private List wordsList;
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
	
	public void loadTweets(String twitterHandle) throws TwitterException
	{
		Paging statusPage = new Paging(1, 200);
		int page = 1;
		while (page <= 10)
		{
			statusPage.setPage(page);
			statusList.addAll(chatbotTwitter.getUserTimeline(twitterHandle, statusPage));
			page++;
		}
		for (Status currentStatus : statusList)
		{
			String[] tweetText = currentStatus.getText().split(" ");
			for (String word : tweetText)
			{
				wordsList.add(removePunctuation(word).toLowerCase());
			}
		}
		removeCommonEnglishWords(wordsList);
		removeEmptyText();
	}
	
	private void removeEmptyText()
	{
		
	}
	
	private List removeCommonEnglishWords(List<String> wordList)
	{
		return null;
	}
	
	private String removePunctuation(String currentString)
	{
		return null;
	}
	
	
}
