package class2go.curriculum;

public class TrueFalseQuestion extends Question {
	
	public TrueFalseQuestion(){
		setPrompt("");
		setInstructions("");
		setAnswer("");
		setWeight(0);
		setType("True False");
	}

	public TrueFalseQuestion(String prompt, String instructions, String answer, double weight){
		setPrompt(prompt);
		setInstructions(instructions);
		setAnswer(answer);
		setWeight(weight);
		setType("True False");
	}
	
}
