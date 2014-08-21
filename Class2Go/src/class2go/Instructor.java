package class2go;

import grading.Report;

public class Instructor extends UserRole{
	
	public Instructor(){
		setRoleTitle("Instructor");
	}

	@Override
	public Report getGrades(User user, int courseID) {
		// TODO Auto-generated method stub
		return null;
	}

}