

import Graph.Graph;
import Graph.ListGraph;
import Graph.MatrixGraph;
import Graph.Pane2;

import java.nio.file.Paths;

public class Main{
	public static void main(String[] args) {
		ListGraph<String> g = ListGraph.readGraph(Paths.get("home","inso","cat.txt").toString());
		System.out.println(g);
//		JFrame frame = new JFrame("Sorting");
//		frame.add(new SortPane());
//		frame.setResizable(false);
//		frame.setVisible(true);
//		frame.setSize(600, 600);
//		frame.setLocationRelativeTo(null);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
}
