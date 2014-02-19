package JakubekJevticKraftt;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;

/**
 * Control
 * 
 * @author Jakubek
 * @version 1.0
 * 
 */
public class Control implements ActionListener {

	View v;
	MonoalphabeticCipher mono;
	ShiftCipher sc;
	SubstitutionCipher subst;
	KeywordCipher kc;
	Cipher cipher;

	public Control() {
		this.v = new View(this);
	}
	
	/**
	 * @param e ActionEvent
	 * 
	 */
	public void actionPerformed(ActionEvent e) {
		if (this.v.isEncrypt(e)) {

			this.v.encrypt();

		}
		if (this.v.isDecrypt(e)) {
			this.v.decrypt();
		}
		if (this.v.isCombo(e)) {
			// System.out.println("1");
		}
		if (this.v.isExit(e)) {
			this.v.frame.setVisible(false);
			this.v.frame.dispose();
		}
		
		if (this.v.isManual(e)) {
			this.v.manualPage();
		}
		
		if (this.v.isAbout(e)) {
			this.v.frame.setVisible(false);
			this.v.frame.dispose();
		}
		
		if(this.v.isKeys(e)) {
			this.v.keyPage();
		}

	}

}
