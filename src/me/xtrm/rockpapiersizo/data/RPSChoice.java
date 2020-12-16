package me.xtrm.rockpapiersizo.data;

public enum RPSChoice {
	ROCK(Messages.getString("rps.choice.0"), 2, 1), //$NON-NLS-1$
	PAPER(Messages.getString("rps.choice.1"), 0, 2), //$NON-NLS-1$
	SCISSORS(Messages.getString("rps.choice.2"), 1, 0); //$NON-NLS-1$
	
	private final String name;
	private final int winIndex, loseIndex;
	
	private RPSChoice(String name, int winIndex, int loseIndex) {
		this.name = name;
		this.winIndex = winIndex;
		this.loseIndex = loseIndex;
	}
	
	public String getName() {
		return name;
	}
	
	public RPSResult getResultAgainst(RPSChoice choice) {
		if(this == choice) return RPSResult.DRAW;
		if(choice.ordinal() == loseIndex) return RPSResult.LOSE;
		if(choice.ordinal() == winIndex) return RPSResult.WIN;
		throw new RuntimeException("Not supposed to happen... wtf");
	}
}
