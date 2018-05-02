import Graph.ListGraph;

import javax.swing.*;

public class Main{
	public static void main(String[] args) {
		JFrame frame = new JFrame("Graph");
		frame.add(GraphUI.getInstance());
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setSize(1000, 1000);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
}
