package class2go;

import scheduling.Schedule;

public class Course {
	
	private String title;
	private Curriculum curriculum;
	private Schedule schedule;
	
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

}
