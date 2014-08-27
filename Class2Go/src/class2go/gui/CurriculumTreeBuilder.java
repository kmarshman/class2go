package class2go.gui;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

import class2go.curriculum.Assignment;
import class2go.curriculum.Curriculum;
import class2go.curriculum.Unit;

public class CurriculumTreeBuilder {
	
	public static JTree buildTree(Curriculum curriculum){
		if(curriculum != null){
			DefaultMutableTreeNode root = new DefaultMutableTreeNode(curriculum.getTitle());
			
			ArrayList<DefaultMutableTreeNode> nodes = new ArrayList<DefaultMutableTreeNode>();
			int index = 0;
			for (Unit u: curriculum.getUnits()){
				  nodes.add(new DefaultMutableTreeNode(u.getTitle()));
				  root.add(nodes.get(index));
				  int topicIndex = index + 1;
				  for (Assignment a: u.getAssignments()){
					  nodes.add(new DefaultMutableTreeNode(a.getTitle()));
					  nodes.get(index).add(nodes.get(topicIndex));
					  topicIndex++;
				  }
				  index = topicIndex;
			}
			JTree tree = new JTree(root);
			tree.setBackground(new Color(238, 238, 238));
			tree.setFont(new Font("Arial", Font.PLAIN, 15));
			return tree;
		}
		return null;
	}

}
