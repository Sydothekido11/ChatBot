package chat.controller;

import chat.model.ChatBot;
import chat.view.ChatbotView;

/**
 * Controller for the Chatbot project. Created a popup for the user name, and displays the response.
 * @author snem8901
 * @version 1.2 10/23/15 Displays the Chatbot's userName variable.
 */
public class ChatController
{
	private ChatBot myBot;
	private ChatbotView myChatView;
	
	public ChatController()
	{
		myChatView = new ChatbotView();
		String user = myChatView.getUserInput("What is your name?");
		myBot = new ChatBot(user);
	}
		
	public void start()
	{
		myChatView.displayResponse("Hello child " + myBot.getUserName());
		chat();
	}
	
	private void chat()
	{
		String textFromUser = myChatView.getUserInput("Talk to the chatbot.");
		while(myBot.lengthChecker(textFromUser))
		{
			textFromUser = myChatView.getUserInput("borf " + textFromUser);
		}
	}
	
}
