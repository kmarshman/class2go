package class2go.curriculum;

public class InstructorCurriculum extends Curriculum {
	
	public InstructorCurriculum(String title){
		setTitle(title);
	}
	
	public void addUnit(Unit unit){
		getUnits().add(unit);
	}
	
	public void removeUnit(Unit unit){
		getUnits().remove(unit);
	}
	
	public void removeUnit(String title){
		for (Unit u: getUnits())
			if (u.getTitle().equals(title)) getUnits().remove(u);
	}

}
