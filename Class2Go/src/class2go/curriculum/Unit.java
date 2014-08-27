package class2go.curriculum;

import java.util.ArrayList;

public class Unit {

	private String title;
	private int displayOrder;
	private ArrayList<Assignment> assignments = new ArrayList<Assignment>();
	
	public Unit(){
		title = "";
		displayOrder = -1;
	}
	
	public Unit(String title, int displayOrder){
		this.title = title;
		this.displayOrder = displayOrder;
	}
	
	public void addAssignment(Assignment assignment){
		assignments.add(assignment);
	}
	
	public void removeTopic(Assignment assignment){
		assignments.remove(assignment);
	}
	
	public void removeTopic(String title){
		for (Assignment a: assignments)
			if (a.getTitle().equals(title)) assignments.remove(a);
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public ArrayList<Assignment> getAssignments() {
		return assignments;
	}

	public void setTopics(ArrayList<Assignment> assignments) {
		this.assignments = assignments;
	}

	public int getDisplayOrder() {
		return displayOrder;
	}

	public void setDisplayOrder(int displayOrder) {
		this.displayOrder = displayOrder;
	}
}
