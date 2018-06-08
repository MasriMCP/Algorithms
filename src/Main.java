import Graph.AVLTree;
import Graph.ListGraph;

import javax.swing.*;

public class Main{
	public static void main(String[] args) {
		ListGraph<String> g = ListGraph.readGraph("g.txt");
		System.out.println(g.isConnected());
	}
	
}
