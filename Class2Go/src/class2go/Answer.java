package class2go;

import java.util.ArrayList;

public class Answer {

	public enum Type{
		MULTIPLE_CHOICE,
		SHORT_ANSWER
	}
	
	private Type type;
	private ArrayList<String> options = new ArrayList<String>();
	private String solution;
	
	public Answer(){
		type = null;
		solution = "";
	}
	
	public Answer(Type type, ArrayList<String> options, String solution){
		this.type = type;
		this.options = options;
		this.solution = solution;
	}
	
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public ArrayList<String> getOptions() {
		return options;
	}
	public void setOptions(ArrayList<String> options) {
		this.options = options;
	}
	public String getSolution() {
		return solution;
	}
	public void setSolution(String solution) {
		this.solution = solution;
	}
}
