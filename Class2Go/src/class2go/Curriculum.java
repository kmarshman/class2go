package class2go;

import java.util.ArrayList;

public class Curriculum {

	private String title;
	private ArrayList<Unit> units = new ArrayList<Unit>();
	
	public Curriculum(){
		title = "";
	}
	
	public Curriculum(String title){
		this.title = title;
	}
	
	public void addUnit(Unit unit){
		units.add(unit);
	}
	
	public void removeUnit(Unit unit){
		units.remove(unit);
	}
	
	public void removeUnit(String title){
		for (Unit u: units)
			if (u.getTitle().equals(title)) units.remove(u);
	}

	public ArrayList<Unit> getUnits() {
		return units;
	}

	public void setUnits(ArrayList<Unit> units) {
		this.units = units;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
