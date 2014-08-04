package class2go;

import java.io.Serializable;
import java.util.ArrayList;

public class Topic implements Serializable{
	
	private static final long serialVersionUID = 15L;
	private String title;
	private ArrayList<Question> questions = new ArrayList<Question>();
	
	public Topic(){
		title = "";
	}
	
	public Topic(String title){
		this.title = title;
	}
	
	public void addQuestion(Question question){
		questions.add(question);
	}
	
	public void removeQuestion(Question question){
		questions.remove(question);
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public ArrayList<Question> getQuestions() {
		return questions;
	}
	public void setQuestions(ArrayList<Question> questions) {
		this.questions = questions;
	}
}
