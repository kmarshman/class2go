package assignment;

import java.util.ArrayList;

public class Schedule {
	
	private ArrayList<Assignment> assignments;
	
	public Schedule(ArrayList<Assignment> assignments) {
		super();
		this.assignments = assignments;
	}

	public ArrayList<Assignment> getAssignments() {
		return assignments;
	}
	
	public Assignment getAssignment(int assignmentID){
		for (Assignment a: assignments)
			if (a.getId() == assignmentID) return a;
		return null;
	}


}
