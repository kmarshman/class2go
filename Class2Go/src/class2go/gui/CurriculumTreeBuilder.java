package class2go.gui;

import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;

import class2go.curriculum.Assignment;
import class2go.curriculum.Curriculum;
import class2go.curriculum.Question;
import class2go.curriculum.Unit;

public class CurriculumTreeBuilder {
	
	public static JTree buildTree(Curriculum curriculum){
		if(curriculum != null){
			SimpleDateFormat date_format = new SimpleDateFormat("EEE, MMM d");
			DefaultMutableTreeNode root = new DefaultMutableTreeNode(curriculum);
			
			ArrayList<DefaultMutableTreeNode> nodes = new ArrayList<DefaultMutableTreeNode>();
			int index = 0;
			for (Unit u: curriculum.getUnits()){
				  nodes.add(new DefaultMutableTreeNode(u));
				  root.add(nodes.get(index));
				  int topicIndex = index + 1;
				  for (Assignment a: u.getAssignments()){
					  nodes.add(new DefaultMutableTreeNode(a));
					  nodes.get(index).add(nodes.get(topicIndex));
					  nodes.add(new DefaultMutableTreeNode("Due: " + date_format.format((a.getDueDate().getTime()))));
					  nodes.get(topicIndex).add(nodes.get(topicIndex+1));
					  nodes.add(new DefaultMutableTreeNode("Points: " + a.calculateTotalPoints()));
					  nodes.get(topicIndex).add(nodes.get(topicIndex+2));
					  nodes.add(new DefaultMutableTreeNode("Questions: " + a.getQuestions().size()));
					  nodes.get(topicIndex).add(nodes.get(topicIndex+3));
					  
					  int questions = a.getQuestions().size();
					  int qnum = 1;
					  for (Question q: a.getQuestions()){
						  nodes.add( new DefaultMutableTreeNode(q));
						  nodes.get(topicIndex + 3).add(nodes.get(topicIndex + 3 + qnum));
						  qnum++;
					  }
					  topicIndex += (questions + 4);
				  }
				  index = topicIndex;
			}
			JTree tree = new JTree(root);
			tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
			//tree.setBackground(new Color(238, 238, 238));
			tree.setFont(new Font("Arial", Font.PLAIN, 20));
			return tree;
		}
		return null;
	}

}
