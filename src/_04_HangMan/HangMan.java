package _04_HangMan;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.plaf.FontUIResource;

public class HangMan implements KeyListener{
	
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel label = new JLabel();
	
	Stack<String> words;
	String userInput;
	int numWords;
	String currentWord;
	String  blanks = "";
	char userKey;
	
	public static void main(String[] args)
	{
		HangMan hangMan = new HangMan();
		hangMan.game();
		hangMan.makeGUI();
	}
	
	public void makeGUI()
	{
		frame.setVisible(true);
		frame.setSize(300, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		panel.add(label);
		label.setText(blanks);
		frame.addKeyListener(this);
	}
	
	public void game()
	{
		words = new Stack<String>();
		userInput = JOptionPane.showInputDialog("How many rounds do you want to play?");
		numWords = Integer.parseInt(userInput);
		
		for(int i = 0; i < numWords; i ++)
		{
			String word = Utilities.readRandomLineFromFile("dictionary.txt");
			if(!(words.contains(word)))
			{
				currentWord = words.push(word);
			}
		}
		for(int i = 0; i < currentWord.length(); i ++)
		{
			blanks = "_ "+ blanks;
			
			
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		userKey = e.getKeyChar();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
