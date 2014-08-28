package class2go.curriculum;

import java.util.ArrayList;
import java.util.Observable;

public class Curriculum extends Observable{

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
		
		setChanged();
		notifyObservers(this);
	}
	
	public String toString(){
		return title;
	}
	
	public void addUnit(Unit u){
		units.add(u);
		
		setChanged();
		notifyObservers(this);
	}
	
	public void removeUnit(Unit u){
		units.remove(u);
		
		setChanged();
		notifyObservers(this);
	}
}
