package JakubekJevticKraftt;

import javax.swing.UIManager;

/**
 * StartCipher
 * 
 * @param args
 */
public class StartCipher {
	
	/**
	 * Main class
	 * 
	 * @param args
	 */
	public static void main(String[]args){
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		Control c = new Control();
	}
}
