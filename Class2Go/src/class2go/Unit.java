package class2go;

import java.util.ArrayList;

public class Unit {
	
	private String title;
	private ArrayList<Topic> topics = new ArrayList<Topic>();
	
	public Unit(){
		title = "";
	}
	
	public Unit(String title){
		this.title = title;
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
}
