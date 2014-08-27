package grading;

import class2go.curriculum.Assignment;

public class Report {
	
	private Assignment assignment;
	private int studentID;
	private String[] answers;
	private int index;
	
	public Report(Assignment assignment, int studentID){
		this.setAssignment(assignment);
		this.setStudentID(studentID);
		answers = new String[assignment.getQuestions().size()];
		index = 0;
	}
	
	public void addAnswer(String answer){
		answers[index] = answer;
		index++;
	}

	public Assignment getAssignment() {
		return assignment;
	}

	public void setAssignment(Assignment assignment) {
		this.assignment = assignment;
	}

	public int getStudentID() {
		return studentID;
	}

	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}
	
	public String[] getAnswers() {
		return answers;
	}

	public void setAnswers(String[] answers) {
		this.answers = answers;
	}

}
