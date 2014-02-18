package JakubekJevticKraftt;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.UIManager;

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
		this.mono = new MonoalphabeticCipher();
		this.sc = new ShiftCipher(0);
		this.subst = new SubstitutionCipher("cdefghijklmnopqrstuvwxyzab");
		this.kc = new KeywordCipher("Crypt");
	}
	
	public void actionPerformed(ActionEvent e) {
		if (this.v.isEncrypt(e)) {
			this.v.encrypt();
		}
		if (this.v.isDecrypt(e)) {
			this.v.decrypt();
		}
		if(this.v.isCombo(e)) {
			System.out.println("1");
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