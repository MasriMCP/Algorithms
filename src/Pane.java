import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Pane extends JPanel {
	private JTextField t1;
	int[] arr;
	int randomSize = 11,randomBound= 100;
	String[] algos = new String[]{"Bubble sort","Selection sort","Insertion sort","Merge sort","Quick sort","Heap sort"};
	JComboBox comboBox = new JComboBox(algos);
	public Pane() {
		setLayout(null);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.setBounds(143, 82, 89, 23);
		add(btnConfirm);
		
		JButton btnRandom = new JButton("Random");
		btnRandom.setBounds(242, 82, 89, 23);
		add(btnRandom);
		
		comboBox.setBounds(224, 116, 107, 20);
		add(comboBox);
		
		JLabel lblAlgorithm = new JLabel("Algorithm:");
		lblAlgorithm.setBounds(163, 119, 61, 14);
		add(lblAlgorithm);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(64, 315, 352, 93);
		add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JButton btnSort = new JButton("Sort");
		btnSort.setBounds(198, 147, 89, 23);
		add(btnSort);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(64, 31, 352, 23);
		add(scrollPane_1);
		
		t1 = new JTextField();
		scrollPane_1.setViewportView(t1);
		t1.setColumns(10);
		btnConfirm.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String[] s = t1.getText().trim().split("[,\\s.*]");
				
				arr = new int[s.length];
				try{
					for (int i = 0; i < s.length; i++) {
						arr[i] = Integer.parseInt(s[i]);
					}
					System.out.println(Arrays.toString(arr));
				}
				catch(NumberFormatException ex){
					System.out.println("hell no");
				}
				
			}
		});
		btnRandom.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				arr = new int[randomSize];
				java.util.Random rand = new java.util.Random();
				for(int i=0;i<arr.length;i++){
					arr[i] = rand.nextInt(randomBound)+1;
				}
				t1.setText(Arrays.toString(arr));
				
			}
		});
		btnSort.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				long start = System.currentTimeMillis();
				int[] temp = new int[arr.length];
				System.arraycopy(arr, 0, temp, 0, arr.length);
				sort(temp,comboBox.getSelectedIndex());
				long end = System.currentTimeMillis();
				long diffrence = end - start;
				textArea.setText(Arrays.toString(temp)+"\ntime taken: "+diffrence+" ms");
			}
		});
	}
	private void sort(int[] arr,int algorithm){
		switch(algorithm){
		case 0:
			Sorting.bubbleSort(arr);
			break;
		case 1:
			Sorting.selectionSort(arr);
			break;
		case 2:
			Sorting.insertionSort(arr);
			break;
		case 3:
			Sorting.mergeSort(arr);
			break;
		case 4:
			Sorting.quickSort(arr);
			break;
		case 5:
			Sorting.heapSort(arr);
			break;
		}
	}
}
