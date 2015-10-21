package chat.view;

import javax.swing.JOptionPane;

/**
 * This class displays the popup.
 * @author snem8901
 *@version 1.0 10/21/15
 */
public class ChatbotView
{
	/**
	 * This displays the text in a popup window and collects the user input.
	 * @param displayText
	 * @return
	 */
		public String getUserInput(String displayText)
		{
				
			String answer = "";
					
			answer = JOptionPane.showInputDialog(null, displayText);
			
			return answer;
			
		}
		
		/**
		 * This returns and displays the user's input in a separate popup window after it has been entered.
		 * @param displayText
		 */
		public void displayResponse(String displayText)
		{
			JOptionPane.showMessageDialog(null, displayText);
		}
}

