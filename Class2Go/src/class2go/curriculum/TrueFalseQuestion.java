package class2go.curriculum;

public class TrueFalseQuestion implements Question {

	private String prompt;
	private String instructions;
	private String answer;
	private double weight;

	public TrueFalseQuestion(String prompt, String instructions, String answer, double weight){
		this.prompt = prompt;
		this.instructions = instructions;
		this.answer = answer;
		this.weight = weight;
	}
	
	@Override
	public String getPrompt() {
		return prompt;
	}

	@Override
	public String getInstructions() {
		return instructions;
	}

	@Override
	public String getAnswer() {
		return answer;
	}

	@Override
	public double getWeight() {
		return weight;
	}
	
	public void setPrompt(String prompt){
		this.prompt = prompt;
	}
	
	public void setInstructions(String instructions){
		this.instructions = instructions;
	}
	
	public void setAnswer(String answer){
		this.answer = answer;
	}
	
	public void setWeight(double weight){
		this.weight = weight;
	}

}
