package JakubekJevticKraftt;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.UIManager;

/**
 * Control
 * 
 * @author Jakubek
 * @version 1.0
 *
 */
public class Control implements ActionListener {
	private static final String COMBOBOX = null;
	private static final String COMBO = null;
	View v;
	MonoalphabeticCipher mono;
	ShiftCipher sc;
	SubstitutionCipher subst;
	KeywordCipher kc;
	Cipher cipher;

	public Control() {
		this.v = new View(this);
	}

	public void actionPerformed(ActionEvent e) {
		if (this.v.isEncrypt(e)) {
			this.v.encrypt();
		}
		if (this.v.isDecrypt(e)) {
			this.v.decrypt();
		}
		if(this.v.isCombo(e)) {
			//System.out.println("1");
		}
	}
	public static void main(String []args) {
		Control c = new Control();
	}
}