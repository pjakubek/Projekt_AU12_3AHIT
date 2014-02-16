package JakubekJevticKraftt;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class View {
	
	Control c;
	
	JButton encrypt;
	JButton decrypt;
	
	JFrame frame;
	
	JTextArea encrfield;
	JTextArea decrfield;
	
	JComboBox combobox;
	JProgressBar progressbar;
	JScrollPane encrscroll;
	JScrollPane decrscroll;
	
	private JMenuBar menuBar;
	private JMenu mnEdit;
	private JMenu mnHelp;
	private JMenu menu;
	private JMenu menuFile;
	private JMenu menuEdit;
	private JMenu menuHelp;
	private JMenu menuAbout;

	
	@SuppressWarnings("unchecked")
	public View(Control c) {
		
		this.c = c;
		
		this.frame = new JFrame();
		frame.getContentPane().setLayout(null);
		
		this.decrypt = new JButton("Decrypt");
		decrypt.setBounds(10, 400, 150, 49);
		frame.getContentPane().add(decrypt);
		
		this.encrypt = new JButton("Encrypt");
		encrypt.setBounds(443, 400, 150, 49);
		frame.getContentPane().add(encrypt);
		
		this.encrfield = new JTextArea();
		encrfield.setLineWrap(true);
	    encrfield.setWrapStyleWord(true);
		encrfield.setBounds(10, 11, 583, 141);
		frame.getContentPane().add(encrfield);
		
		this.decrfield = new JTextArea();
		decrfield.setLineWrap(true);
	    decrfield.setWrapStyleWord(true);
		decrfield.setBounds(10, 163, 583, 141);
		frame.getContentPane().add(decrfield);
		
		this.combobox = new JComboBox();
		combobox.setToolTipText("Select an encryption method");
		combobox.setBounds(226, 414, 150, 20);
		frame.getContentPane().add(combobox);
		
		this.progressbar = new JProgressBar();
		progressbar.setBounds(226, 348, 150, 14);
		frame.getContentPane().add(progressbar);
		
	
		
		String mono = "Monoalphabetical";
		String subst = "Substitution";
		String key = "Keyword";
		String shift = "Shift";
		combobox.addItem(mono);
		combobox.addItem(subst);
		combobox.addItem(key);
		combobox.addItem(shift);
		

		//frame.setLocationRelativeTo(null);
		
		
		this.menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		this.menuFile = new JMenu("File");
		this.menuEdit = new JMenu("Edit");
		this.menuHelp = new JMenu("Help");
		this.menuAbout = new JMenu("About");
		
		menuBar.add(menuFile);
		menuBar.add(menuEdit);
		menuBar.add(menuHelp);
		menuBar.add(menuAbout);
		
		
		
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.setResizable(false);
		this.frame.setSize(609,510);
		this.frame.setVisible(true);
		
		encrypt.addActionListener(c);
		
		decrypt.addActionListener(c);
		
		
	}
	
	
	public boolean isEncrypt(ActionEvent e) {
		if (e.getSource() == this.encrypt)
			return true;
		return false;

	}
	
	public boolean isDecrypt(ActionEvent e) {
		if (e.getSource() == this.decrypt)
			return true;
		return false;

	}
}