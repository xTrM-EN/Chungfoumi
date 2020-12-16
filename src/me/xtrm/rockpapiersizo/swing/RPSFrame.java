package me.xtrm.rockpapiersizo.swing;

import java.io.IOException;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class RPSFrame extends JFrame {
	
	private static final RPSFrame INSTANCE = new RPSFrame();
	
	public void init() {
		this.setSize(500, 500);
		this.setResizable(false);
		this.setLayout(null);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		try {
			this.setContentPane(new RPSPanel());
		} catch(IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}
		this.setVisible(true);
	}
	
	public static RPSFrame getInstance() {
		return INSTANCE;
	}
	
}
