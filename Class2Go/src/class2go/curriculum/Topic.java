package class2go.curriculum;

import java.util.ArrayList;

public class Topic {
	
	private String title;
	private int displayOrder;
	private ArrayList<MultipleChoiceQuestion> questions = new ArrayList<MultipleChoiceQuestion>();
	
	public Topic(){
		title = "";
		displayOrder = -1;
	}
	
	public Topic(String title, int displayOrder){
		this.title = title;
		this.displayOrder = displayOrder;
	}
	
	public void addQuestion(MultipleChoiceQuestion question){
		questions.add(question);
	}
	
	public void removeQuestion(MultipleChoiceQuestion question){
		questions.remove(question);
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public ArrayList<MultipleChoiceQuestion> getQuestions() {
		return questions;
	}
	public void setQuestions(ArrayList<MultipleChoiceQuestion> questions) {
		this.questions = questions;
	}

	public int getDisplayOrder() {
		return displayOrder;
	}

	public void setDisplayOrder(int displayOrder) {
		this.displayOrder = displayOrder;
	}
}
