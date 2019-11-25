package _04_HangMan;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class HangMan implements KeyListener {

	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel label = new JLabel();
	JLabel score = new JLabel();

	Stack<String> words;
	String userInput;
	int numWords;
	String currentWord;
	String blanks = "";
	char userKey;
	int lives = 3;
	boolean correct = false;

	public static void main(String[] args) {
		HangMan hangMan = new HangMan();
		hangMan.game();
		hangMan.makeGUI();
	}

	public void makeGUI() {
		frame.setVisible(true);
		frame.setSize(300, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		panel.add(label);
		panel.add(score);
		score.setText("Lives: " + lives);
		label.setText(blanks);
		frame.addKeyListener(this);
	}

	public void game() {
		words = new Stack<String>();
		userInput = JOptionPane.showInputDialog("How many rounds do you want to play?");
		numWords = Integer.parseInt(userInput);
		start();

	}

	void start() {
		blanks = "";
		lives = 3;
		score.setText("Lives: " + lives);
		for (int i = 0; i < numWords; i++) {
			String word = Utilities.readRandomLineFromFile("dictionary.txt");
			if (!(words.contains(word))) {
				currentWord = words.push(word);
			}
		}
		for (int i = 0; i < currentWord.length(); i++) {
			blanks += "_";
			label.setText(blanks);
		}
		System.out.println(currentWord);
	}

	void checkLost() {
		lives--;
		score.setText("Lives: " + lives);
		if (lives == 0) {
			JOptionPane.showMessageDialog(null, "You lost!");
		}
	}

	void checkCorrect(char key) {
		for (int i = 0; i < currentWord.length(); i++) {
			if (key == currentWord.charAt(i)) {
				blanks = blanks.substring(0, i) + key + blanks.substring(i + 1);
				label.setText(blanks);
				correct = true;
			}
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
		correct = false;
		checkCorrect(userKey);
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			correct = true;
		}
		if (!correct) {
			checkLost();
		}
		frame.repaint();
		if (label.getText().equals(currentWord) && e.getKeyCode() == KeyEvent.VK_ENTER) {
			words.pop();
			numWords --;
			start();
		}
		if(numWords == 0)
		{
			int response = JOptionPane.showConfirmDialog(null, "Play again?");
			if(response == 0)
			{
				game();
			}
			else
			{
				label.setText("game over");
				score.setText("");
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}