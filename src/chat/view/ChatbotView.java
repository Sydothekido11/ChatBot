package chat.view;

import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

/**
 * This class displays the popup.
 * @author snem8901
 *@version 1. 11/4/15 Added a constructor and an icon to the input window and output window.
 */
public class ChatbotView
{
	private String windowMessage;
	private ImageIcon chatIcon;
	
	public ChatbotView()
	{
		windowMessage = "This message is brought to you by the chatbot.";
		chatIcon = new ImageIcon(getClass().getResource("images/botIcon.png"));
	}
	/**
	 * This displays the text in a popup window and collects the user input.
	 * @param displayText
	 * @return
	 */
		public String getUserInput(String displayText)
		{
				
			String answer = "";
					
			answer = JOptionPane.showInputDialog(null, displayText, windowMessage, JOptionPane.INFORMATION_MESSAGE, chatIcon, null, "Type here yo.").toString();
			
			return answer;
			
		}
		
		/**
		 * This returns and displays the user's input in a separate popup window after it has been entered.
		 * @param displayText
		 */
		public void displayResponse(String displayText)
		{
			JOptionPane.showMessageDialog(null, displayText, windowMessage, JOptionPane.PLAIN_MESSAGE, chatIcon);
		}
}

