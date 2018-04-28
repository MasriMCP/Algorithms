package Graph;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import java.awt.Label;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JList;

public class UI extends JPanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public UI() {
		
		JButton btnNewButton = new JButton("Confirm");
		btnNewButton.setBounds(649, 411, 97, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		setLayout(null);
		add(btnNewButton);
		
		Label label = new Label("Search");
		label.setBounds(35, 44, 62, 22);
		add(label);
		
		textField = new JTextField();
		textField.setBounds(92, 44, 177, 20);
		add(textField);
		textField.setColumns(10);
		
		JCheckBox chckbxMember = new JCheckBox("Member");
		chckbxMember.setSelected(true);
		chckbxMember.setBounds(649, 381, 97, 23);
		add(chckbxMember);
		
		JLabel lblNetPrice = new JLabel("net price");
		lblNetPrice.setBounds(649, 266, 46, 14);
		add(lblNetPrice);
		
		JLabel label_1 = new JLabel("15.00");
		label_1.setBounds(649, 286, 46, 14);
		add(label_1);
		
		JList list = new JList();
		list.setBounds(35, 72, 578, 332);
		add(list);
		
		JCheckBox chckbxReturnInvoice = new JCheckBox("return invoice");
		chckbxReturnInvoice.setBounds(649, 359, 97, 23);
		add(chckbxReturnInvoice);
		
		JButton btnViewProductIndex = new JButton("view product index");
		btnViewProductIndex.setBounds(470, 43, 143, 23);
		add(btnViewProductIndex);

	}
}
