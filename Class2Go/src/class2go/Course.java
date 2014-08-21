package class2go;

import class2go.curriculum.Curriculum;
import assignment.Schedule;

public class Course {
	
	private String title;
	private Curriculum curriculum;
	private Schedule schedule;
	private StudentRoster roster;
	
	public Course(){
		title = "";
		curriculum = null;
		schedule = null;
	}
	
	public Course(String title, Curriculum curriculum){
		this.title = title;
		this.curriculum = curriculum;
		schedule = null;
	}
	
	public void addStudent(User student){
		roster.addStudent(student);
	}
	
	public void removeStudent(User student){
		roster.removeStudent(student);
	}
	
	public void removeStudent(String first, String last){
		roster.removeStudent(first, last);
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Curriculum getCurriculum() {
		return curriculum;
	}

	public void setCurriculum(Curriculum curriculum) {
		this.curriculum = curriculum;
	}

	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	public StudentRoster getRoster() {
		return roster;
	}

	public void setRoster(StudentRoster roster) {
		this.roster = roster;
	}

}
