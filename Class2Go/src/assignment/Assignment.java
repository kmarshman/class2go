package assignment;

import java.util.ArrayList;
import java.util.Calendar;

import class2go.curriculum.Question;

public class Assignment {
	
	private int id;
	private ArrayList<Question> questions;
	private String title;
	private Calendar dueDate;
	
	public Assignment(){
		super();
		id = -1;
		questions = null;
		title = "";
		dueDate = null;
	}
	
	public Assignment(int id, String title, ArrayList<Question> questions, Calendar dueDate) {
		super();
		this.id = id;
		this.questions = questions;
		this.title = title;
		this.dueDate = dueDate;
	}
	
	public double calculateTotalPoints(){
		double points = 0;
		for (Question q: questions)
			points += q.getWeight();
		return points;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public ArrayList<Question> getQuestions() {
		return questions;
	}
	public void setQuestions(ArrayList<Question> questions) {
		this.questions = questions;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Calendar getDueDate() {
		return dueDate;
	}

	public void setDueDate(Calendar dueDate) {
		this.dueDate = dueDate;
	}

}
