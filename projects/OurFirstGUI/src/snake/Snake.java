package snake;

import snakeDemo.SnakePanel;

import javax.swing.*;

public class Snake {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setBounds(450,200, 900, 720);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		snakeDemo.SnakePanel panel = new SnakePanel();
		frame.add(panel);
		
		frame.setVisible(true);
	}
	
}