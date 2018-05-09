import Graph.AVLTree;
import Graph.ListGraph;

import javax.swing.*;

public class Main{
	public static void main(String[] args) {
		AVLTree<Integer> t = new AVLTree<Integer>(15);
		t.insert(16);
		t.insert(35);
		t.insert(3);
		t.insert(81);
		t.insert(-45);
		t.insert(8);
		t.insert(10);
		t.insert(9);
		t.printInorder();
		
	}
	
}
