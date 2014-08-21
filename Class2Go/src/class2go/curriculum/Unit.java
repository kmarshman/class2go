package class2go.curriculum;

import java.util.ArrayList;

public class Unit {

	private String title;
	private int displayOrder;
	private ArrayList<Topic> topics = new ArrayList<Topic>();
	
	public Unit(){
		title = "";
		displayOrder = -1;
	}
	
	public Unit(String title, int displayOrder){
		this.title = title;
		this.displayOrder = displayOrder;
	}
	
	public void addTopic(Topic topic){
		topics.add(topic);
	}
	
	public void removeTopic(Topic topic){
		topics.remove(topic);
	}
	
	public void removeTopic(String title){
		for (Topic t: topics)
			if (t.getTitle().equals(title)) topics.remove(t);
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public ArrayList<Topic> getTopics() {
		return topics;
	}

	public void setTopics(ArrayList<Topic> topics) {
		this.topics = topics;
	}

	public int getDisplayOrder() {
		return displayOrder;
	}

	public void setDisplayOrder(int displayOrder) {
		this.displayOrder = displayOrder;
	}
}
