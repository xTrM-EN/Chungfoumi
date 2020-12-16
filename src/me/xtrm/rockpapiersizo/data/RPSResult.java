package me.xtrm.rockpapiersizo.data;

public enum RPSResult {
	DRAW(Messages.getString("rps.result.0")), //$NON-NLS-1$
	WIN(Messages.getString("rps.result.1")),  //$NON-NLS-1$
	LOSE(Messages.getString("rps.result.2")); //$NON-NLS-1$
	
	private String name;
	
	private RPSResult(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
