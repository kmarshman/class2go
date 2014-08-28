package class2go.curriculum;

import java.util.ArrayList;
import java.util.Observable;

public class Unit extends Observable{

	private String title;
	private int displayOrder;
	private ArrayList<Assignment> assignments = new ArrayList<Assignment>();
	private int id;
	
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
		
		setChanged();
		notifyObservers(this);
	}
	
	public void removeAssignment(Assignment assignment){
		assignments.remove(assignment);
		
		setChanged();
		notifyObservers(this);
	}
	
	public void removeAssignment(String title){
		for (Assignment a: assignments)
			if (a.getTitle().equals(title)) assignments.remove(a);
		
		setChanged();
		notifyObservers(this);
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
		
		setChanged();
		notifyObservers(this);
	}

	public ArrayList<Assignment> getAssignments() {
		return assignments;
	}

	public void setAssignments(ArrayList<Assignment> assignments) {
		this.assignments = assignments;
		
		setChanged();
		notifyObservers(this);
	}

	public int getDisplayOrder() {
		return displayOrder;
	}

	public void setDisplayOrder(int displayOrder) {
		this.displayOrder = displayOrder;
		
		setChanged();
		notifyObservers(this);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
		
		setChanged();
		notifyObservers(this);
	}
	
	public String toString(){
		return "Unit: " +  title;
	}
}
