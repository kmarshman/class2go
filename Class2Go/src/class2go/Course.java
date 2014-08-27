package class2go;

import class2go.curriculum.Curriculum;

public class Course {
	
	private int id;
	private String title;
	private Curriculum curriculum;
	private StudentRoster roster;
	
	public Course(){
		title = "";
		curriculum = null;
		roster = new StudentRoster();
	}
	
	public Course(String title, Curriculum curriculum){
		this.title = title;
		this.curriculum = curriculum;
		roster = new StudentRoster();
	}
	
	public void addStudent(User student){
		if(roster == null) roster = new StudentRoster();
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

	public StudentRoster getRoster() {
		return roster;
	}

	public void setRoster(StudentRoster roster) {
		this.roster = roster;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
