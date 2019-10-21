package _03_IntroToStacks;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.xml.stream.events.Characters;

public class _02_TextUndoRedo implements KeyListener {
	/* 
	 * Create a JFrame with a JPanel and a JLabel.
	 * Every time a key is pressed, add that character to the JLabel. It should look like a basic text editor.
	 * 
	 * Make it so that every time the BACKSPACE key is pressed, the last character is erased from the JLabel.
	 * Save that deleted character onto a Stack of Characters.
	 * 
	 * Choose a key to be the Undo key. Make it so that when that key is pressed, the top Character is popped 
	 * off the Stack and added back to the JLabel.
	 * 
	 * */
	public static void main(String[] args) {
		_02_TextUndoRedo undoRedo = new _02_TextUndoRedo();
		undoRedo.makeGUI();
	}
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel label = new JLabel();
	ArrayList<Character> characters = new ArrayList<Character>(0);
	public void makeGUI()
	{
		frame.add(panel);
		frame.setVisible(true);
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.add(label);
		frame.addKeyListener(this);
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stu
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int size = characters.size();
	if(e.getKeyCode() != KeyEvent.VK_BACK_SPACE)
	{
		label.setText(label.getText() +e.getKeyChar());
	}

	if(e.getKeyCode()==KeyEvent.VK_BACK_SPACE)
	{
		int length = label.getText().length();
		char last = label.getText().charAt(length-1);
		characters.add(last);
		label.setText(label.getText().substring(0, label.getText().length()-1));
	}
	if(e.getKeyCode()==KeyEvent.VK_LEFT)
	{
		label.setText(label.getText().substring(0, label.getText().length()-1) + characters.get(characters.size()-1));
		characters.remove(characters.size()-1);
	}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
