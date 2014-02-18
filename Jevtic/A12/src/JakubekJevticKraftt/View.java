
package JakubekJevticKraftt;

import java.awt.event.ActionEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
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

	private static final String COMBOBOX = null;

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

	/**
	 * 	GUI initialization
	 * 
	 * @param c Control
	 */
	@SuppressWarnings("unchecked")
	public View(Control c) {

		this.control = c;

		this.frame = new JFrame();
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
				"Substitution", "Shift","Keyword" }));
		combobox.setToolTipText("Select an encryption method");
		combobox.setBounds(226, 414, 150, 20);
		frame.getContentPane().add(combobox);
		combobox.setSelectedIndex(-1);

		keyfield = new JTextField();
		keyfield.setBounds(10, 315, 583, 20);
		frame.getContentPane().add(keyfield);
		keyfield.setColumns(10);
		keyfield.setToolTipText("Insert your key/alphabet/shift-count here!");

		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.setResizable(false);
		this.frame.setSize(609, 510);
		this.frame.setVisible(true);

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

	/**
	 * Encrypts the text from the Textarea
	 * 
	 */
	public void encrypt() {
		switch (this.combobox.getSelectedIndex()) {

		case 0:

			this.c = new MonoalphabeticCipher("bcdefghijklmnopqrstuvwxyzäöüßa");
			break;

		case 1:

			this.c = new ShiftCipher(2);
			break;

		case 2:

			this.c = new KeywordCipher("Hallo");
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

			this.c = new SubstitutionCipher("bcdefghijklmnopqrstuvwxyzäöüßa");
			break;

		case 1:

			this.c = new ShiftCipher(2);
			break;

		case 2:

			this.c = new KeywordCipher("Hallo");
			break;
		default:

		}
		if (c != null) {

			this.encrfield.setText(c.decrypt(this.decrfield.getText()));
			this.decrfield.setText("");

		}
	}
}