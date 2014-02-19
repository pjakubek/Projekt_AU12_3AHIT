package JakubekJevticKraftt;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.concurrent.CancellationException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * View
 * 
 * @author Jakubek
 * @version 1.0
 * 
 */
public class View {

	Control control;
	Cipher c;

	JButton encrbtn;
	JButton decrbtn;

	JFrame frame;

	JTextArea encrfield;
	JTextArea decrfield;

	JComboBox combobox;
	JScrollPane encrscroll;
	JScrollPane decrscroll;

	JTextField keyfield;

	JMenuBar menubar;
	JMenu file;
	JMenu tools;
	JMenu help;
	JMenuItem exit;
	JMenuItem manual;
	JMenuItem about;
	JMenuItem keys;

	/**
	 * GUI initialization
	 * 
	 * @param c
	 *            Control
	 */
	@SuppressWarnings("unchecked")
	public View(Control c) {

		this.control = c;

		this.frame = new JFrame("Cipher v1.1");
		frame.getContentPane().setLayout(null);

		this.decrbtn = new JButton("Decrypt");
		decrbtn.setBounds(10, 400, 150, 49);
		frame.getContentPane().add(decrbtn);

		this.encrbtn = new JButton("Encrypt");
		encrbtn.setBounds(443, 400, 150, 49);
		frame.getContentPane().add(encrbtn);

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
		combobox.setModel(new DefaultComboBoxModel(new String[] {
				"Substitution", "Shift", "Keyword" }));
		combobox.setToolTipText("Select an encryption method");
		combobox.setBounds(226, 414, 150, 20);
		frame.getContentPane().add(combobox);
		combobox.setSelectedIndex(-1);

		keyfield = new JTextField();
		keyfield.setBounds(10, 315, 583, 20);
		frame.getContentPane().add(keyfield);
		keyfield.setColumns(10);
		keyfield.setToolTipText("Insert your key/alphabet/shift-count here!");
		encrfield.setToolTipText("Insert your text(encryption)!");
		decrfield.setToolTipText("Insert your text(decryption)!");
		
		
		

		// New JMenu: Bar, Menu, Items
		this.menubar = new JMenuBar();
		this.file = new JMenu("File");
		this.help = new JMenu("Help");
		this.exit = new JMenuItem("Exit");
		this.manual = new JMenuItem("Manual");

		this.keys = new JMenuItem("Keys");
		
		menubar.add(file);
		
		menubar.add(help);
		file.add(exit);
		help.add(manual);
		help.add(keys);
	
		// add JmMenuBar to frame
		frame.setJMenuBar(menubar);

		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.setResizable(false);
		this.frame.setSize(609, 510);
		this.frame.setVisible(true);

		// Menuitem Listener
		exit.addActionListener(c);
		manual.addActionListener(c);
		help.addActionListener(c);
		keys.addActionListener(c);

		// Button & Combobox Listener
		combobox.addActionListener(c);
		encrbtn.addActionListener(c);
		decrbtn.addActionListener(c);

	}

	public boolean isEncrypt(ActionEvent e) {
		if (e.getSource() == this.encrbtn)
			return true;
		return false;

	}

	public boolean isDecrypt(ActionEvent e) {
		if (e.getSource() == this.decrbtn)
			return true;
		return false;

	}

	public boolean isCombo(ActionEvent e) {
		if (e.getSource() == this.combobox)
			return true;
		return false;
	}

	public boolean isExit(ActionEvent e) {
		if (e.getSource() == this.exit)
			return true;
		return false;
	}

	public boolean isManual(ActionEvent e) {
		if (e.getSource() == this.manual)
			return true;
		return false;
	}

	public boolean isAbout(ActionEvent e) {
		if (e.getSource() == this.about)
			return true;
		return false;
	}
	
	public boolean isKeys(ActionEvent e) {
		if (e.getSource() == this.keys)
			return true;
		return false;
	}
	
	/**
	 * Encrypts the text from the Textarea
	 * 
	 */
	public void encrypt() {
		switch (this.combobox.getSelectedIndex()) {

		case 0:
			
			
			this.c = new MonoalphabeticCipher(this.keyfield.getText());
			break;

		case 1:

			this.c = new ShiftCipher(
					(Integer.parseInt(this.keyfield.getText())));
			break;

		case 2:
			
			
			this.c = new KeywordCipher(this.keyfield.getText());
			break;

		default:
		}
		if (c != null) {

			this.decrfield.setText(c.encrypt(this.encrfield.getText()));
			this.encrfield.setText("");

		}
	}

	/**
	 * Encrypts the text from the Textarea
	 * 
	 */
	public void decrypt() {
		switch (this.combobox.getSelectedIndex()) {

		case 0:

			this.c = new SubstitutionCipher(this.keyfield.getText());
			break;

		case 1:

			this.c = new ShiftCipher(
					(Integer.parseInt(this.keyfield.getText())));
			break;

		case 2:

			this.c = new KeywordCipher(this.keyfield.getText());
			break;
		default:

		}
		if (c != null) {

			this.encrfield.setText(c.decrypt(this.decrfield.getText()));
			//this.decrfield.setText("");

		}
	}
	
	/**
	 * 
	 * Creates new JFrame for the JMenuItem "manual"
	 * 
	 */
	public void manualPage() {
		JFrame man = new JFrame("Manual");
		man.setLayout(new BorderLayout());
		JLabel head = new JLabel("Manual", JLabel.CENTER);
		head.setFont(head.getFont().deriveFont(30.0f));
		man.add(head, BorderLayout.NORTH);
		JLabel mantext = new JLabel("<html>1. Click in the top textfield and enter your message"
				+ "<br><br>2. Select an encryption method from the box between the buttons"
				+ "<br><br>3. Click on the encrypt button to encrypt your message with the selected encryption method"
				+ "<br><br>4. Click on the decrypt button to decrypt a message"
				+ "<br><br>5. WARNING!: Never decrypt a message with a different encryption method it has been encrypted</html>");
		man.add(mantext, BorderLayout.CENTER);
		man.setSize(300,400);
		man.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		man.setVisible(true);
	}
	
	/**
	 * 
	 * Creates new JFrame for the JMenuItem "keys"
	 * 
	 */
	public void keyPage() {
		JFrame keyframe = new JFrame("Keys");
		keyframe.setLayout(new BorderLayout());
		JLabel head = new JLabel("Keys", JLabel.CENTER);
		head.setFont(head.getFont().deriveFont(30.0f));
		keyframe.add(head, BorderLayout.NORTH);
		JLabel mantext = new JLabel("<html>1. Type your key in the key-textfield"
				+ "<br><br>2. Examples for keys are:"
				+ "<br><br> Substitution: <br> abcdefghijklmnopqrstuvwxyzäöüß"
				+ "<br><br> Shift: <br> 3"
				+ "<br><br>Keyword: <br> test "
				+ "<br><br> 3. Be sure that you type the right key for the right encryption method!"
				+ "<br><br> 4. Be sure that you type only 1 key in the key-textfield!"
				+ " </html>");
		keyframe.add(mantext, BorderLayout.CENTER);
		keyframe.setSize(300,400);
		keyframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		keyframe.setVisible(true);
	}
}
