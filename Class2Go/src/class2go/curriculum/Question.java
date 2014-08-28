package class2go.curriculum;

import java.util.ArrayList;

public class Question {
	
	private int id;
	private String prompt;
	private String instructions;
	private String answer;
	private ArrayList<String> options = new ArrayList<String>();
	private double weight;
	private String type;
	
	public Question(){
		type = "";
		prompt = "";
		instructions = "";
		answer = "";
		options = new ArrayList<String>();
		weight = 0;
	}
	
	public ArrayList<String> getOptions() {
		return options;
	}
	public void setOptions(ArrayList<String> options) {
		this.options = options;
	}
	public void setPrompt(String prompt) {
		this.prompt = prompt;
	}
	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public String getPrompt(){
		return prompt;
	}
	public String getInstructions(){
		return instructions;
	}
	public String getAnswer(){
		return answer;
	}
	public double getWeight(){
		return weight;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public String toString(){
		return "Question: " + prompt;
	}

}
