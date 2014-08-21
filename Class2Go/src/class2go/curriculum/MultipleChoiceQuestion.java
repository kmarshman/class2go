package class2go.curriculum;

import java.util.ArrayList;

public class MultipleChoiceQuestion implements Question {
	
	private String prompt;
	private String instructions;
	private String answer;
	private ArrayList<String> options = new ArrayList<String>();
	private double weight;
	
	public MultipleChoiceQuestion(){
		prompt = "";
		instructions = "";
		answer = "";
		weight = 0;
	}
	
	public MultipleChoiceQuestion(String prompt, String instructions, String answer, double weight){
		this.prompt = prompt;
		this.instructions = instructions;
		this.answer = answer;
		options.add(answer);
		this.weight = weight;
	}
	
	public void addOption(String option){
		options.add(option);
	}
	
	public void removeOption(String option){
		options.remove(option);
	}
	
	@Override
	public String getPrompt() {
		return prompt;
	}
	public void setPrompt(String prompt) {
		this.prompt = prompt;
	}
	
	@Override
	public String getInstructions() {
		return instructions;
	}
	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}
	public ArrayList<String> getOptions() {
		return options;
	}
	public void setOptions(ArrayList<String> options) {
		this.options = options;
	}

	@Override
	public String getAnswer() {
		return answer;
	}

	@Override
	public double getWeight() {
		return weight;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}
}
