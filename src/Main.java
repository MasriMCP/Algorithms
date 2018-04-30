import Graph.ListGraph;

import javax.swing.*;

public class Main{
	public static void main(String[] args) {
		ListGraph<String> g = ListGraph.readGraph("g.txt");
		for(String i:g){
			System.out.println(i);
		}
		JFrame frame = new JFrame("Graph");
		frame.add(GraphUI.getInstance());
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setSize(1000, 1000);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
}
