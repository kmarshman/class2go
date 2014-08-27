package class2go.curriculum;

public class ShortAnswerQuestion extends Question {
	
	public ShortAnswerQuestion(){
		setPrompt("");
		setInstructions("");
		setAnswer("");
		setWeight(0);
		setType("Short Answer");
	}
	
	public ShortAnswerQuestion(String prompt, String instructions, String answer, double weight){
		setPrompt(prompt);
		setInstructions(instructions);
		setAnswer(answer);
		setWeight(weight);
		setType("Short Answer");
	}

}
