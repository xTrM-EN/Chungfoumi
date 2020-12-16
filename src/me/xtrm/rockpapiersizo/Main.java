package me.xtrm.rockpapiersizo;

import java.awt.EventQueue;

import javax.swing.UIManager;

import me.xtrm.rockpapiersizo.swing.RPSFrame;

public class Main {
	
	public static void main(String[] args) throws Exception {
		// Define the jSwing look'n'feel to the system one (aka windows) because it looks way fucking cooler than metal-ui 
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		
		// Initialize the first random choice
		RPSLogic.INSTANCE.performChoice(); 
		
		// Launch jswing in its own thread
		EventQueue.invokeLater(RPSFrame.getInstance()::init);
	}

}
