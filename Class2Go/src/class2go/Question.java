package class2go;

import java.io.Serializable;
import java.util.ArrayList;

public class Question implements Serializable{
	
	private static final long serialVersionUID = 11L;
	private String prompt;
	private String instructions;
	private ArrayList<Answer> answers = new ArrayList<Answer>();
	
	public Question(){
		prompt = "";
		instructions = "";
	}
	
	public Question(String prompt, String instructions){
		this.prompt = prompt;
		this.instructions = instructions;
	}
	
	public void addAnswer(Answer answer){
		answers.add(answer);
	}
	
	public void removeAnswer(Answer answer){
		answers.remove(answer);
	}
	
	public String getPrompt() {
		return prompt;
	}
	public void setPrompt(String prompt) {
		this.prompt = prompt;
	}
	public String getInstructions() {
		return instructions;
	}
	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}
	public ArrayList<Answer> getAnswers() {
		return answers;
	}
	public void setAnswers(ArrayList<Answer> answers) {
		this.answers = answers;
	}
}
