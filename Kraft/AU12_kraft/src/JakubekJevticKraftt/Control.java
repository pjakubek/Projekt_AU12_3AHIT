package JakubekJevticKraftt;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.UIManager;

public class Control implements ActionListener {
	View v;
	MonoalphabeticCipher mono;
	SubstitutionCipher subst;
	Cipher cipher;
	
	public Control() {
		this.v = new View(this);
		this.cipher = new SubstitutionCipher("cdefghijklmnopqrstuvwxyzab");
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if (this.v.isEncrypt(e)) {
			this.v.decrfield.setText(cipher.encrypt(this.v.encrfield.getText()));
			this.v.encrfield.setText("");
		}
		if (this.v.isDecrypt(e)) {
			this.v.encrfield.setText(cipher.decrypt(this.v.decrfield.getText()));
			this.v.encrfield.setText("");
		}
	}
	
	public static void main(String[]args){
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		Control c = new Control();
	}
}