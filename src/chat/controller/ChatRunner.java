package chat.controller;

/**
 * Starts the Chatbot program. 
 *@author snem8901
 *@version 1.0 10/21/15
 */
public class ChatRunner
{
	public static void main (String [] args)
	{
		ChatController myChatController = new ChatController();
		myChatController.start();
	}
}
