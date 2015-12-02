package chat.model;

import java.util.ArrayList;

/**
 * Base version of the 2015 Chatbot class. Only stub methods are provided. Students will complete methods as part
 * of the project.
 * @author Sydney Nemelka
 * @version 1.4 11/3/15 made a switch case. 
 */
public class ChatBot
{
	private ArrayList<String> memesList;
	private ArrayList<String> politicalTopicList;
	private String exit;
	private String userName;
	private String content;
	
	/**
	 * Creates an instance of the Chatbot with the supplied username.
	 * @param userName The username for the chatbot.
	 */
	public ChatBot(String userName)
	{
		this.memesList = new ArrayList<String>();
		this.politicalTopicList = new ArrayList<String>(); 
		this.userName = userName;
		this.content = "suga";
		
		buildMemesList();
		buildPoliticalTopicsList();		
	}
	
	/**
	 * Builds an array list of memes.
	 * 
	 */
	private void buildMemesList()
	{
		
		this.memesList.add("doge");
		this.memesList.add("Unamused face");
		this.memesList.add("Soon");
		this.memesList.add("Life with a cat");
		this.memesList.add("Challenge Accepted");
		this.memesList.add("Expectation vs reality");
		this.memesList.add("cute animals");
		this.memesList.add("Anti-joke chicken");
		this.memesList.add("pepe");
		this.memesList.add("Filthy Hobbitses");
	}
	
	private void buildPoliticalTopicsList()
	{
		this.politicalTopicList.add("election");
		this.politicalTopicList.add("Democrat");
		this.politicalTopicList.add("Republican");
		this.politicalTopicList.add("liberal");
		this.politicalTopicList.add("conservative");
		this.politicalTopicList.add("Trump");
		this.politicalTopicList.add("Clinton");
		this.politicalTopicList.add("Biden");
		this.politicalTopicList.add("Carson");
		this.politicalTopicList.add("Rubio");
		this.politicalTopicList.add("Fiorina");
		this.politicalTopicList.add("Sanders");
		this.politicalTopicList.add("vote");
		this.politicalTopicList.add("11/4/16");
	}
	
	/**
	 * Checks the length of the supplied string. Returns false if the supplied String is empty or null,
	 * otherwise returns true. 
	 * @param currentInput
	 * @return A true or false based on the length of the supplied String.
	 */
	public boolean lengthChecker(String currentInput)
	{
		boolean hasLength = false;
		if(currentInput != null)
		{
			if(currentInput.length() > 0)
			{
				hasLength = true;
			}
		}
		
		return hasLength;
	}
	
	/**
	 * Checks if the supplied String matches the content area for this Chatbot instance.
	 * @param currentInput The supplied String to be checked.
	 * @return Whether it matches the content area.
	 */
	public boolean contentChecker(String currentInput)
	{
		boolean hasContent = false;
		
		if(currentInput.toLowerCase().contains(content.toLowerCase()))
		{
			hasContent = true;
		}
		
		return hasContent;
	}
	
	/**
	 * Checks if supplied String matches ANY of the topics in the politicalTopicsList. Returns
	 * true if it does find a match and false if it does not match.
	 * @param currentInput The supplied String to be checked.
	 * @return Whether the String is contained in the ArrayList.
	 */
	public boolean politicalTopicChecker(String currentInput)
	{
		boolean hasTopics = false;
		
		for(String topics : politicalTopicList)
		{
			if(currentInput.toLowerCase().contains(topics.toLowerCase()));
			{
				hasTopics = true;
			}
		}
		
		return hasTopics;
	}
	
	
	/**
	 * Checks to see that the supplied String value is in the current memesList variable.
	 * @param currentInput The supplied String to be checked.
	 * @return Whether the supplied String is a recognized meme.
	 */
	public boolean memeChecker(String currentInput)

	{
		boolean hasMemes = false;
		
		for(String meme : memesList)
		{
			if(currentInput.toLowerCase().contains(meme.toLowerCase()));
			{
				hasMemes = true;
			}
		}
		
		return hasMemes;
	}
	
	public boolean quitChecker(String currentInput)
	
	{
		boolean hasQuit = false;
		
			if(currentInput.toLowerCase().contains(exit.toLowerCase()));
			{
				hasQuit = true;
			}
		
		
		return hasQuit;
	}
	
	public boolean keyboardMashChecker(String currentInput)
	{
		boolean isMash = false;
		if(currentInput.equals("sdf") || currentInput.equals(",./") || currentInput.equals("dfg") || currentInput.equals("cvb"))
		{
			 isMash = true;
		}
		return isMash;
	}
	
	public String processQuestion(String currentInput)
	{
		String talkBack = "Anything else?";
		int randomTopic = (int) (Math.random() * 5); //Generates a random number between 1 and 4.
		
		if(keyboardMashChecker(currentInput))
		{
			return "Stop mashing the keyboard!!";
		}
		
		switch (randomTopic)
		{
		case 0:
			if(contentChecker(currentInput))
			{
				talkBack = "Hey saaaame. What else?";
			}
			break;
		case 1:
			if(memeChecker(currentInput))
			{
				talkBack = "I like dat meme. I'm interested. Tell me more of the things.";
			}
			break;
		case 2:
			if(politicalTopicChecker(currentInput))
			{
				talkBack = "comment and question.";
			}
			break;
		case 3:
			if(currentInput.length() > 25)
			{
				talkBack = "Congrats. You like lengthy responses! If that's the case, do you take AP Classes? If so which ones?";
			}
			break;
		case 4:
			talkBack = "Swell. Real swell. Turtle or snake?";
			break;
		default:
			talkBack = "Meow meow. How about kangaroos?";
			break;
			
			
		}
		
		return talkBack;
	}
	
	
	/**
	 * Returns the username of this Chatbot instance.
	 * @return The username of the Chatbot.
	 */
	public String getUserName()
	{
		return userName;
	}
	
	/**
	 * Returns the content area for this Chatbot instance.
	 * @return The content area for this Chatbot instance.
	 */
	public String getContent()
	{
		return content;
	}
	
	/**
	 * Getter method for the memesList object.
	 * @return The reference to the meme list.
	 */
	public ArrayList<String> getMemesList()
	{
		return memesList;
	}
	
	/**
	 * Getter method for the politicalTopicList object.
	 * @return The reference to the political topic list.
	 */
	public ArrayList<String> getPoliticalTopicList()
	{
		return politicalTopicList;
	}
	
	/**
	 * Updates the content area for this Chatbot instance.
	 * @param content The updated value for the content area.
	 */
	public void setContent(String content)
	{
		
	}
	
	
}

