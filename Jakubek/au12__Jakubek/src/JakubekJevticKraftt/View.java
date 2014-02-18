package JakubekJevticKraftt;

import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;

public class View {

	private static final String COMBOBOX = null;

	Control control;
	Cipher c;

	JButton encrypt;
	JButton decrypt;

	JFrame frame;

	JTextArea encrfield;
	JTextArea decrfield;

	JComboBox combobox;
	JScrollPane encrscroll;
	JScrollPane decrscroll;

	JMenuBar menuBar;
	JMenu mnEdit;
	JMenu mnHelp;
	JMenu menu;
	JMenu menuFile;
	JMenu menuTools;
	JMenu menuHelp;
	JMenu menuAbout;
	JMenuItem tofile;
	JMenuItem exit;
	JMenuItem getkey;

	String[] cbitems;
	JTextField textfield;

	@SuppressWarnings("unchecked")
	public View(Control c) {

		this.control = c;

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

		//String cbitems[] = {"Substitution", "Keyword","Shift"};

		this.combobox = new JComboBox(cbitems);
		combobox.setModel(new DefaultComboBoxModel(new String[] {"Substitution", "Keyword", "Shift"}));
		combobox.setToolTipText("Select an encryption method");
		combobox.setBounds(226, 414, 150, 20);
		frame.getContentPane().add(combobox);

		textfield = new JTextField();
		textfield.setBounds(10, 315, 583, 20);
		frame.getContentPane().add(textfield);
		textfield.setColumns(10);
		textfield.setToolTipText("Insert your key here!");

		/**
		 * 
		 */
		// Creating the JMenuBar
		this.menuBar = new JMenuBar();

		this.menuFile = new JMenu("File");
		this.menuTools = new JMenu("Tools");
		this.menuHelp = new JMenu("Help");
		this.menuAbout = new JMenu("About");
		this.tofile = new JMenuItem("To file");
		this.exit = new JMenuItem("Exit");
		this.getkey = new JMenuItem("Get key");

		// Add Items to the JMenuBar
		menuBar.add(menuFile);
		menuBar.add(menuTools);
		menuBar.add(menuHelp);
		menuBar.add(menuAbout);
		menuFile.add(tofile);
		menuFile.add(exit);
		menuTools.add(getkey);
		frame.setJMenuBar(menuBar);

		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.setResizable(false);
		this.frame.setSize(609, 510);
		this.frame.setVisible(true);

		this.combobox.setActionCommand(this.COMBOBOX);

		combobox.addActionListener(c);
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

	public boolean isCombo(ActionEvent e) {
		if (e.getSource() == this.combobox)
			return true;
		return false;
	}

	public void encrypt() {
		int selection = this.combobox.getSelectedIndex();
		switch (selection) {

		case 0:
			this.c = new SubstitutionCipher("bcdefghiklmnopqrstuvwxyzaäöüß");

		case 1:
			this.c = new ShiftCipher(2);

		case 3:
			this.c = new KeywordCipher("Hallo");

		}

	}
}
