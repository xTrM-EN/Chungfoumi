package me.xtrm.rockpapiersizo;

import java.security.SecureRandom;
import java.util.Random;

import me.xtrm.rockpapiersizo.data.RPSChoice;
import me.xtrm.rockpapiersizo.data.RPSResult;

public enum RPSLogic {
	INSTANCE;
	
	private final Random random;
	
	private RPSChoice computerChoice;
	private int playerScore, computerScore;
	
	private RPSLogic() {
		this.random = new SecureRandom();
	}

	public RPSChoice performChoice() {
		return this.computerChoice = RPSChoice.values()[random.nextInt(RPSChoice.values().length)];
	}
	
	public RPSResult checkChoice(int choiceIndex) {
		RPSChoice playerChoice = RPSChoice.values()[choiceIndex];
		return playerChoice.getResultAgainst(this.computerChoice);
	}
	
	public void score(RPSResult result) {
		switch(result) {
			case WIN:
				playerScore++;
				break;
			case LOSE:
				computerScore++;
				break;
			case DRAW:
			default:
				break;
		}
	}
	
	public int[] getScores() {
		return new int[] { playerScore, computerScore };
	}
	
	public RPSChoice getLastChoice() {
		return computerChoice;
	}
}
