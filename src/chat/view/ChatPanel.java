package chat.view;

import javax.swing.JPanel;

import chat.controller.ChatController;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.JTextArea;

import java.awt.Color;
import java.awt.event.*;

public class ChatPanel extends JPanel
{
	private ChatController baseController;
	private JButton chatButton;
	private JButton submitButton;
	private JTextField chatTextField;
	private SpringLayout chatLayout;
	private JTextArea chatTextArea;

	/**
	 * Panel for the chatbot. Setup the panel, layout and listeners.
	 * @author snem8901
	 * @param baseController
	 * @version 1.3 12/4/15
	 */
	public ChatPanel(ChatController baseController)
	{
		this.baseController = baseController;
		chatLayout = new SpringLayout();
		submitButton = new JButton("Submit");
		chatButton = new JButton("Press here for colors.");
		chatTextField = new JTextField(30);
		chatTextArea = new JTextArea(10,30);
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	/**
	 * Puts in the buttons and textfields needed for the panel.
	 */
	private void setupPanel()
	{
		this.setLayout(chatLayout);
		this.setBackground(Color.CYAN);
		this.add(chatTextArea);
		this.add(chatButton);
		this.add(chatTextField);
		this.add(submitButton);
		chatTextField.setToolTipText("Type here for the chatbot");
		chatTextArea.setEnabled(false);
		
	
		
	}
	
	/**
	 * Holds the garbage code.
	 */
	private void setupLayout()
	{
		chatLayout.putConstraint(SpringLayout.SOUTH, submitButton, -21, SpringLayout.SOUTH, this);
		chatLayout.putConstraint(SpringLayout.WEST, chatButton, 69, SpringLayout.WEST, this);
		chatLayout.putConstraint(SpringLayout.SOUTH, chatButton, 0, SpringLayout.SOUTH, submitButton);
		chatLayout.putConstraint(SpringLayout.SOUTH, chatTextField, -30, SpringLayout.NORTH, chatButton);
		chatLayout.putConstraint(SpringLayout.NORTH, chatTextField, 5, SpringLayout.SOUTH, chatTextArea);
		chatLayout.putConstraint(SpringLayout.EAST, chatTextField, 0, SpringLayout.EAST, chatTextArea);
		chatLayout.putConstraint(SpringLayout.NORTH, chatTextArea, 25, SpringLayout.NORTH, this);
		chatLayout.putConstraint(SpringLayout.SOUTH, chatTextArea, -113, SpringLayout.SOUTH, this);
		chatLayout.putConstraint(SpringLayout.EAST, chatTextArea, -21, SpringLayout.EAST, this);
		chatLayout.putConstraint(SpringLayout.EAST, submitButton, 0, SpringLayout.EAST, chatTextArea);
		
	}
	
	/**
	 * Makes the text field available.
	 * @return
	 */
	public JTextField getTextField()
	{
		return chatTextField;
	}

	/**
	 * Listeners for the chatButton and the submitButton. chatButton changes the colors when pressed 
	 * while the submitButton gets text from the controller.
	 */
	private void setupListeners()
	{
		chatButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				int red = (int) (Math.random() * 256);
				int blue = (int) (Math.random() * 256);
				int green = (int) (Math.random() * 256);
				setBackground(new Color(red, blue, green));
				chatTextField.setText("press it fool");
			}
		});
		
		submitButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String userText = chatTextField.getText();	//Grab user from text
				String response = baseController.fromUserToChatbot(userText);	//Send the text to the controller, gives text to chatbot to process, gets chatbot answer.
				chatTextArea.append("\nUser: " + userText);	//displays user text
				chatTextArea.append("\nChatbot: " + response); //displays answer
				chatTextField.setText("Submit");	//clears the user field
				
			}
		});	
	}
	
	public JButton getButton()
	{
		return submitButton;
	}
}
