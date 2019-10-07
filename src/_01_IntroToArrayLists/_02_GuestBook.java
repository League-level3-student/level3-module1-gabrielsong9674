package _01_IntroToArrayLists;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_GuestBook implements ActionListener {
	// Create a GUI with two buttons. One button reads "Add Name" and the other button reads "View Names". 
	// When the add name button is clicked, display an input dialog that asks the user to enter a name. Add
	// that name to an ArrayList. When the "View Names" button is clicked, display a message dialog that displays
	// all the names added to the list. Format the list as follows:
	// Guest #1: Bob Banders 
	// Guest #2: Sandy Summers
	// Guest #3: Greg Ganders
	// Guest #4: Donny Doners
	ArrayList<String> names = new ArrayList<String>();

	public static void main(String[] args) {
		_02_GuestBook book = new _02_GuestBook();
		book.makeGUI();
	}
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton add = new JButton("Add Name");
	JButton view = new JButton("View Names");
	
	public void makeGUI()
	{
		frame.add(panel);
		frame.setVisible(true);
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.add(add);
		add.addActionListener(this);
		panel.add(view);
		view.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton buttonPressed = (JButton) e.getSource();
		if(buttonPressed == add)
		{
			 names.add(JOptionPane.showInputDialog("Enter a name"));
		}
		if(buttonPressed == view)
		{
			String all = "";
			for(int i = 0; i < names.size(); i ++) {
				all = all + "Guest #"+(i+1)+": "+names.get(i)+"\n";
			}
			JOptionPane.showMessageDialog(null, all);
		}
		
	}
	
}
