package JakubekJevticKraftt;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Cipher-Klassen testing
 * 
 * @author Jakubek
 * @version 1.0
 *
 */
public class CipherTest {

	@Test
	public void testsetSecAlphabet() {
		MonoalphabeticCipher mc = new MonoalphabeticCipher();
		mc.setSecretAlphabet("efghijklmnopqrstuvwxyzäöüßabcd");
		assertArrayEquals("efghijklmnopqrstuvwxyzäöüßabcd".toCharArray(), mc
				.getSecretAlphabet().toCharArray());
	}
	
	@Test
	public void testSubstitutionCipher(){		
		SubstitutionCipher sc = new SubstitutionCipher("abcdefghijklmnopqrstuvwxyzäöüß");
		sc.setSecretAlphabet("defghijklmnopqrstuvwxyzäöüßabc");
		assertEquals("defghijklmnopqrstuvwxyzäöüßabc",sc.getSecretAlphabet());	 
	}
	
	@Test
	public void testKeyWordCipher(){		
		KeywordCipher kc = new KeywordCipher("xyz");
		assertEquals("xyzabcdefghijklmnopqrstuvwäöüß",kc.getSecretAlphabet());	 
	}
	
	@Test
	public void testShiftCipher1(){
		ShiftCipher sc = new ShiftCipher(4);
		assertEquals("efghijklmnopqrstuvwxyzäöüßabcd",sc.getSecretAlphabet());	 
	}
	
	@Test
	public void testShiftCipherFailure(){		
		ShiftCipher sc = new ShiftCipher(5);
		assertEquals("abcdefghijklmnopqrstuvwxyzäöüß",sc.getSecretAlphabet());	 
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testShiftException(){
		new ShiftCipher(-2);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSubstitutionException(){
		SubstitutionCipher sc = new SubstitutionCipher("abcdefghijklmnopqrstuvwxyzäöüß??");
		sc.setSecretAlphabet("defghijklmnopqrstuvwxyzäöüßabcabc");
		assertEquals("defghijklmnopqrstuvwxyzäöüßabc",sc.getSecretAlphabet());	 
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testMonoalphabeticException(){
		MonoalphabeticCipher mc = new MonoalphabeticCipher();
		mc.setSecretAlphabet("abcdefghijklmnopqrstuvwxyzäöüßabc");
		assertEquals("abcdefghijklmnopqrstuvwxyzäöüßabc".toCharArray(),mc.getSecretAlphabet().toCharArray());	
	}
	@Test(expected = IllegalArgumentException.class)
	public void testKeywordException2(){
	new KeywordCipher("Test#?!");		
	}
	
	@Test
	public void testKeywordFailure(){		
		KeywordCipher kc = new KeywordCipher("Keyword");
		assertEquals("Keywordabcdefghijklmnopqrstuvwxyzäöüß",kc.getSecretAlphabet());	 
	}
	
	@Test
	public void testSubstFailure(){		
		SubstitutionCipher sc = new SubstitutionCipher("abc");
		assertEquals("abcdefghijklmnopqrstuvwxyzäöüß",sc.getSecretAlphabet());	 
	}
}
