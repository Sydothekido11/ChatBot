package chat.view;

import javax.swing.JPanel;

import chat.controller.ChatController;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpringLayout;
import javax.swing.JTextArea;

import java.awt.Color;
import java.awt.event.*;

public class ChatPanel extends JPanel
{
	private ChatController baseController;
	private JButton chatButton;
	private JButton submitButton;
	private JButton tweetButton;
	private JButton checkTwitterButton;
	private JButton saveButton;
	private JButton openButton;
	private JTextField chatTextField;
	private SpringLayout chatLayout;
	private JTextArea chatTextArea;
	private JScrollPane textPane;

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
		tweetButton = new JButton("Send a tweet!");
		checkTwitterButton = new JButton("Check the tweet.");
		saveButton = new JButton("Save the tweet.");
		openButton = new JButton("open the tweet?");
		chatTextField = new JTextField(30);	
		
		
		setupChatPane();
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupChatPane()
	{
		chatTextArea.setLineWrap(true);
		chatTextArea.setWrapStyleWord(true);
		chatTextArea.setEnabled(false);
		chatTextArea.setEditable(false);
		textPane = new JScrollPane();
		
		
		textPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		textPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
	}
	
	/**
	 * Puts in the buttons and textfields needed for the panel.
	 */
	private void setupPanel()
	{
		this.setLayout(chatLayout);
		this.setBackground(Color.CYAN);
		//this.add(chatTextArea);
		this.add(chatButton);
		this.add(tweetButton);
		this.add(checkTwitterButton);
		this.add(saveButton);
		this.add(openButton);
		this.add(chatTextField);
		this.add(submitButton);
		this.add(textPane);
		chatTextField.setToolTipText("Type here for the chatbot");
		chatTextArea = new JTextArea(10,30);
		
		chatTextArea.setEnabled(false);
		
	
		
	}
	
	/**
	 * Holds the garbage code.
	 */
	private void setupLayout()
	{
		chatLayout.putConstraint(SpringLayout.NORTH, chatTextArea, 25, SpringLayout.NORTH, this);
		chatLayout.putConstraint(SpringLayout.SOUTH, chatTextArea, -113, SpringLayout.SOUTH, this);
		chatLayout.putConstraint(SpringLayout.EAST, chatTextArea, -21, SpringLayout.EAST, this);
		chatLayout.putConstraint(SpringLayout.EAST, chatTextField, -21, SpringLayout.EAST, this);
		chatLayout.putConstraint(SpringLayout.NORTH, textPane, 0, SpringLayout.NORTH, this);
		chatLayout.putConstraint(SpringLayout.SOUTH, textPane, -107, SpringLayout.SOUTH, this);
		chatLayout.putConstraint(SpringLayout.WEST, textPane, 82, SpringLayout.WEST, this);
		chatLayout.putConstraint(SpringLayout.EAST, textPane, -81, SpringLayout.EAST, this);
		chatLayout.putConstraint(SpringLayout.WEST, submitButton, 193, SpringLayout.WEST, this);
		chatLayout.putConstraint(SpringLayout.EAST, chatButton, -6, SpringLayout.WEST, submitButton);
		chatLayout.putConstraint(SpringLayout.NORTH, tweetButton, 6, SpringLayout.SOUTH, chatButton);
		chatLayout.putConstraint(SpringLayout.WEST, tweetButton, 0, SpringLayout.WEST, chatButton);
		chatLayout.putConstraint(SpringLayout.NORTH, checkTwitterButton, 6, SpringLayout.SOUTH, chatButton);
		chatLayout.putConstraint(SpringLayout.NORTH, saveButton, 199, SpringLayout.NORTH, this);
		chatLayout.putConstraint(SpringLayout.NORTH, chatButton, 0, SpringLayout.NORTH, saveButton);
		chatLayout.putConstraint(SpringLayout.NORTH, submitButton, 0, SpringLayout.NORTH, saveButton);
		chatLayout.putConstraint(SpringLayout.WEST, openButton, 298, SpringLayout.WEST, this);
		chatLayout.putConstraint(SpringLayout.EAST, checkTwitterButton, -6, SpringLayout.WEST, openButton);
		chatLayout.putConstraint(SpringLayout.NORTH, openButton, 6, SpringLayout.SOUTH, saveButton);
		chatLayout.putConstraint(SpringLayout.EAST, saveButton, 0, SpringLayout.EAST, chatTextField);
		chatLayout.putConstraint(SpringLayout.NORTH, chatTextField, 278, SpringLayout.NORTH, this);
		chatLayout.putConstraint(SpringLayout.SOUTH, chatTextField, -80, SpringLayout.SOUTH, this);
	
		
		
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
				chatTextField.setText("Submit");	
				
			}
		});	
	}
	
	public JButton getButton()
	{
		return submitButton;
	}
}
