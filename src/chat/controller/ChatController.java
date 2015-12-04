package chat.controller;

import chat.model.ChatBot;
import chat.view.ChatView;
import chat.view.ChatFrame;

/**
 * Controller for the Chatbot project. Created a popup for the user name, and displays the response. 
 * @author snem8901
 * @version 1.4 12/4/15 Displays the Chatbot's userName variable. Made a while loop as well. 
 * Added the getters for Chabot, Chatview and Chatframe
 */
public class ChatController
{
	private ChatBot myBot;
	private ChatView myChatView;
	private ChatFrame chatFrame;
	
	public ChatController()
	{
		myChatView = new ChatView();
		String user = myChatView.getUserInput("What is your name?");
		myBot = new ChatBot(user);
		chatFrame = new ChatFrame(this);
	}
		
	public void start()
	{
		myChatView.displayResponse("Hello child " + myBot.getUserName());
		//chat();
	}
	
	private void chat()
	{
		String textFromUser = myChatView.getUserInput("Talk to the chatbot.");
		while(myBot.lengthChecker(textFromUser))
		{
			
			textFromUser = myBot.processQuestion(textFromUser);
			textFromUser = myChatView.getUserInput(textFromUser);
		}
		
	
	}
	
	public String fromUserToChatbot(String textFromUser)
	{
		String botResponse ="";
		
		if(myBot.quitChecker(textFromUser))
		{
			shutDown();
		}
		
		botResponse = myBot.processQuestion(textFromUser);
		
		return botResponse;
	}
	
	private void shutDown()
	{
		myChatView.displayResponse("Goodbye, " + myBot.getUserName() + "it was swell good sir");
		System.exit(0);
	}

	public ChatBot getChatbot()
	{
		return null;
	}
	
	public ChatView getChatView()
	{
		return null;
	}
	
	public ChatFrame getBaseFrame()
	{
		return null;
	}
	
	

	
	
}
