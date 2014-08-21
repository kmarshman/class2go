package assignment;

import java.util.ArrayList;

import org.codehaus.jackson.annotate.JsonProperty;

public class Schedule {
	
	@JsonProperty("assignments")
	private ArrayList<Assignment> assignments;
	
	public Schedule(){
		super();
		assignments = new ArrayList<Assignment>();
	}
	
	public Schedule(ArrayList<Assignment> assignments) {
		super();
		this.assignments = assignments;
	}

	@JsonProperty("assignments")
	public ArrayList<Assignment> getAssignments() {
		return assignments;
	}
	
	public void setAssignments(ArrayList<Assignment> assignments){
		this.assignments = assignments;
	}
	
	public Assignment getAssignment(int assignmentID){
		for (Assignment a: assignments)
			if (a.getId() == assignmentID) return a;
		return null;
	}


}
