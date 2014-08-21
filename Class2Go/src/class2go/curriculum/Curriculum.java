package class2go.curriculum;

import java.util.ArrayList;

public class Curriculum {

	private String title;
	private ArrayList<Unit> units = new ArrayList<Unit>();
	
	public Curriculum(){
		title = "";
	}
	
	public Curriculum(String title, ArrayList<Unit> units){
		this.title = title;
		this.units = units;
	}

	public ArrayList<Unit> getUnits() {
		return units;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
