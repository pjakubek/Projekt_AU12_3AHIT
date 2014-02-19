package JakubekJevticKraftt;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;

/**
 * GUITest testing
 * 
 * @author Kraft
 * @version 1.0
 *
 */
public class GUITest {

	private Control c;
	private View v;
	
	@Before
	public void before(){
		this.c=new Control();
		this.v=c.v;
	}
	
	@Test
	public void testEncryptSubs() {
		v.encrfield.setText("Test");
		v.combobox.setSelectedIndex(0);
		v.keyfield.setText("bcdefghijklmnopqrstuvwxyzäöüßa");
		v.encrbtn.doClick();
		assertEquals("uftu",v.decrfield.getText());
	}
	
	@Test
	public void testEncryptShift(){
		v.encrfield.setText("Test");
		v.combobox.setSelectedIndex(1);
		v.keyfield.setText("2");
		v.encrbtn.doClick();
		assertEquals("vguv",v.decrfield.getText());
	}

	@Test
	public void testEncryptKeyWord(){
		v.encrfield.setText("Test");
		v.combobox.setSelectedIndex(2);
		v.keyfield.setText("efghijklmnopqrstuvwxyzäöüßabcd");
		v.encrbtn.doClick();
		assertEquals("xiwx",v.decrfield.getText());
	}
	
	@Test
	public void testDecryptKeyWord(){
		v.decrfield.setText("xiwx");
		v.combobox.setSelectedIndex(0);
		v.keyfield.setText("efghijklmnopqrstuvwxyzäöüßabcd");
		v.decrbtn.doClick();
		assertEquals("test",v.encrfield.getText());
	}
	
	@Test
	public void testDecryptShift(){
		v.decrfield.setText("vguv");
		v.combobox.setSelectedIndex(1);
		v.keyfield.setText("2");
		v.decrbtn.doClick();
		assertEquals("test",v.encrfield.getText());
	}
	
	@Test
	public void testDecryptSubs(){
		v.decrfield.setText("uftu");
		v.combobox.setSelectedIndex(0);
		v.keyfield.setText("bcdefghijklmnopqrstuvwxyzäöüßa");
		v.decrbtn.doClick();
		assertEquals("test",v.encrfield.getText());
	}
}
