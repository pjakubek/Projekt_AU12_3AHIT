package JakubekJevticKraftt;

import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JProgressBar;

public class View {
	
	JButton encrypt;
	JButton crypt;
	
	JFrame frame;
	
	@SuppressWarnings("unchecked")
	public View(Control c) {
		
		this.frame = new JFrame();
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Decrypt");
		btnNewButton.setBounds(10, 400, 150, 49);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnCrypt = new JButton("Encrypt");
		btnCrypt.setBounds(443, 400, 150, 49);
		frame.getContentPane().add(btnCrypt);
		
		JTextArea txtpnYourTextHere = new JTextArea();
		txtpnYourTextHere.setBounds(10, 11, 583, 141);
		frame.getContentPane().add(txtpnYourTextHere);
		
		JTextArea textPane = new JTextArea();
		textPane.setBounds(10, 163, 583, 141);
		frame.getContentPane().add(textPane);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setToolTipText("Select an encryption method");
		comboBox.setBounds(226, 414, 150, 20);
		frame.getContentPane().add(comboBox);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(226, 348, 150, 14);
		frame.getContentPane().add(progressBar);
		
		String mono = "Monoalphabetical";
		String subst = "Substitution";
		String key = "Keyword";
		String shift = "Shift";
		comboBox.addItem(mono);
		comboBox.addItem(subst);
		comboBox.addItem(key);
		comboBox.addItem(shift);
		
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.frame.setVisible(true);
		
		
		
		
		
		
	}
}
