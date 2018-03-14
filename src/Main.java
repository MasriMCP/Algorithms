
import java.util.Arrays;

import javax.swing.JFrame;

public class Main{
	public static void main(String[] args) {
		JFrame frame = new JFrame("Sorting");
		frame.add(new Pane());
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setSize(600, 600);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
}
