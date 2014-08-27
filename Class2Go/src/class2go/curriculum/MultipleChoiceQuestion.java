package class2go.curriculum;

public class MultipleChoiceQuestion extends Question {

	public MultipleChoiceQuestion(){
		setPrompt("");
		setInstructions("");
		setAnswer("");
		setWeight(0);
		setType("Multiple Choice");
	}
	
	public MultipleChoiceQuestion(String prompt, String instructions, String answer, double weight){
		setPrompt(prompt);
		setInstructions(instructions);
		setAnswer(answer);
		setWeight(weight);
		getOptions().add(answer);
		setType("Multiple Choice");
	}
	
	public void addOption(String option){
		getOptions().add(option);
	}
	
	public void removeOption(String option){
		getOptions().remove(option);
	}
}
