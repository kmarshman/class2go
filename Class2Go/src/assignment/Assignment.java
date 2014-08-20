package assignment;

import java.util.ArrayList;

import class2go.curriculum.Question;

public abstract class Assignment {
	
	private int id;
	private ArrayList<Question> questions;
	
	
	public Assignment(int id, ArrayList<Question> questions) {
		super();
		this.id = id;
		this.questions = questions;
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

}
