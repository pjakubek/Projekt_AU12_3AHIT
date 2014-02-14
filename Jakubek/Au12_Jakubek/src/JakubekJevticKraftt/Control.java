package JakubekJevticKraftt;

import javax.swing.UIManager;

public class Control {
	View v;
	public Control() {
		this.v = new View(this);
	}
	
	public static void main(String[]args){
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
