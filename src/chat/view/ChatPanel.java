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
	private JTextField chatTextField;
	private SpringLayout chatLayout;
	private JTextArea chatTextArea;
	
	public ChatPanel(ChatController baseController)
	{
		this.baseController = baseController;
		chatLayout = new SpringLayout();
		chatButton = new JButton("Press here yo.");
		chatTextField = new JTextField("Type something!");
		chatTextArea = new JTextArea("");
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupPanel()
	{
		this.setLayout(chatLayout);
		this.setBackground(Color.CYAN);
		this.add(chatTextArea);
		this.add(chatButton);
		this.add(chatTextField);
		chatTextField.setToolTipText("Type here for the chatbot");
		chatTextArea.setEnabled(false);
		
	
		
	}
	
	private void setupLayout()
	{
		chatLayout.putConstraint(SpringLayout.WEST, chatButton, 169, SpringLayout.WEST, this);
		chatLayout.putConstraint(SpringLayout.NORTH, chatTextField, 96, SpringLayout.NORTH, this);
		chatLayout.putConstraint(SpringLayout.WEST, chatTextField, 6, SpringLayout.WEST, chatButton);
		chatLayout.putConstraint(SpringLayout.SOUTH, chatTextField, -176, SpringLayout.SOUTH, this);
		chatLayout.putConstraint(SpringLayout.NORTH, chatButton, 47, SpringLayout.SOUTH, chatTextField);
		
	}
	
	public JTextField getTextField()
	{
		return chatTextField;
	}

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
		
		
		
	}
}
