package class2go.curriculum;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Observable;

public class Assignment extends Observable{
	
	private int id;
	private ArrayList<Question> questions;
	private String title;
	private Calendar dueDate;
	private Double grade;
	
	public Assignment(){
		super();
		questions = null;
		title = "";
		dueDate = null;
		grade = null;
		questions = new ArrayList<Question>();
	}
	
	public Assignment(int id, String title, ArrayList<Question> questions, Calendar dueDate) {
		super();
		this.id = id;
		this.questions = questions;
		this.title = title;
		this.dueDate = dueDate;
		grade = null;
		questions = new ArrayList<Question>();
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
		setChanged();
		notifyObservers(this);
	}
	public ArrayList<Question> getQuestions() {
		return questions;
	}
	public void setQuestions(ArrayList<Question> questions) {
		this.questions = questions;
		setChanged();
		notifyObservers(this);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
		setChanged();
		notifyObservers(this);
	}

	public Calendar getDueDate() {
		return dueDate;
	}

	public void setDueDate(Calendar dueDate) {
		this.dueDate = dueDate;
		setChanged();
		notifyObservers(this);
	}
	
	public String toString(){
		return "Assignment: " + title;
	}

	public Double getGrade() {
		return grade;
	}

	public void setGrade(Double grade) {
		this.grade = grade;
		setChanged();
		notifyObservers(this);
	}
	
	public void addQuestion(Question q){
		questions.add(q);
		setChanged();
		notifyObservers(this);
	}
	
	public void removeQuestion(Question q){
		questions.remove(q);
		setChanged();
		notifyObservers(this);
	}

}
