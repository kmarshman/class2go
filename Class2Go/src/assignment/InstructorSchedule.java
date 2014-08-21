package assignment;

import java.util.ArrayList;

public class InstructorSchedule extends Schedule {

	public InstructorSchedule(ArrayList<Assignment> assignments) {
		super(assignments);
	}
	
	public void addAssignment(Assignment a){
		getAssignments().add(a);
	}
	
	public void removeAssignment(Assignment a){
		getAssignments().remove(a);
	}

}
