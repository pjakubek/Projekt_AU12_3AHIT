package JakubekJevticKraftt;

import javax.swing.UIManager;

/**
 * StartCipher
 * 
 * 
 * 
 */
public class StartCipher {
	
	/**
	 * Main class
	 * 
	 * @param args Command line arguments
	 */
	public static void main(String[]args){
		
		/*
		 *  Set the look and feel of the application to the operating system's look and feel.
		 */
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		Control c = new Control();
	}
}
