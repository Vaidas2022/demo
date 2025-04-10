package lt.kauneta.edemocracy.quiz.model;

public enum QuizAnswerOption {
	TAIP("Taip"),
	NE("Ne"),
	KITAS("Kitas");
	
	private final String displayName;
	
	
	QuizAnswerOption(String displayName) { 
		this.displayName = displayName; 
	}
	
	public String getDisplayName() { return displayName; }

}
