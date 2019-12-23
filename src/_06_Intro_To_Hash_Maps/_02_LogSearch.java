package _06_Intro_To_Hash_Maps;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_LogSearch implements ActionListener {
  /* 
	 * Crate a HashMap of Integers for the keys and Strings for the values.
	 * Create a GUI with three buttons. 
	 * Button 1: Add Entry
	 * 				When this button is clicked, use an input dialog to ask the user to enter an ID number.
	 * 				After an ID is entered, use another input dialog to ask the user to enter a name.
	 * 				Add this information as a new entry to your HashMap.
	 * 
	 * Button 2: Search by ID
	 * 				When this button is clicked, use an input dialog to ask the user to enter an ID number.
	 * 				If that ID exists, display that name to the user.
	 * 				Otherwise, tell the user that that entry does not exist.
	 * 
	 * Button 3: View List
	 * 				When this button is clicked, display the entire list in a message dialog in the following format:
	 * 				ID: 123  Name: Harry Howard
	 * 				ID: 245  Name: Polly Powers
	 * 				ID: 433  Name: Oliver Ortega
	 * 				etc...
	 * 
	 * When this is complete, add a fourth button to your window.
	 * Button 4: Remove Entry
	 * 				When this button is clicked, prompt the user to enter an ID using an input dialog.
	 * 				If this ID exists in the HashMap, remove it. Otherwise, notify the user that the ID
	 * 				is not in the list. 
	 *
	 * */
	
	public static void main(String[] args) 
	{
		_02_LogSearch logSearch = new _02_LogSearch();
		logSearch.makeGUI();
		
		
	}
	
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton addEntry = new JButton();
	JButton searchByID = new JButton();
	JButton viewList = new JButton();
	JButton removeEntry = new JButton();
	public void makeGUI()
	{
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 500);
		frame.add(panel);
		panel.add(addEntry);
		addEntry.addActionListener(this);
		addEntry.setText("Add Entry");
		panel.add(searchByID);
		searchByID.addActionListener(this);
		searchByID.setText("Search By ID");
		panel.add(viewList);
		viewList.addActionListener(this);
		viewList.setText("View List");
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton buttonPressed = (JButton) e.getSource();
		HashMap<Integer, String> search = new HashMap<Integer, String>();
		if(buttonPressed == addEntry)
		{
			String userInputID = JOptionPane.showInputDialog("Enter ID number");
			int userID = Integer.parseInt(userInputID);
			String userName = JOptionPane.showInputDialog("Enter a name");
			search.put(userID, userName);
		}
		if(buttonPressed == searchByID)
		{
			String userInputID = JOptionPane.showInputDialog("Enter ID number");
			int userID = Integer.parseInt(userInputID);
			for(Integer i : search.keySet())
			{
				if(userID == i)
				{
					System.out.println(search.get(i));
				}
			}
			
		}
		if(buttonPressed == viewList)
		{
			
		}
	}
}
