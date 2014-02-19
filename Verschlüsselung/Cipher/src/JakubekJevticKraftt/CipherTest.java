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
		mc.setSecretAlphabet("efghijklmnopqrstuvwxyz����abcd");
		assertArrayEquals("efghijklmnopqrstuvwxyz����abcd".toCharArray(), mc
				.getSecretAlphabet().toCharArray());
	}
	
	@Test
	public void testSubstitutionCipher(){		
		SubstitutionCipher sc = new SubstitutionCipher("abcdefghijklmnopqrstuvwxyz����");
		sc.setSecretAlphabet("defghijklmnopqrstuvwxyz����abc");
		assertEquals("defghijklmnopqrstuvwxyz����abc",sc.getSecretAlphabet());	 
	}
	
	@Test
	public void testKeyWordCipher(){		
		KeywordCipher kc = new KeywordCipher("xyz");
		assertEquals("xyzabcdefghijklmnopqrstuvw����",kc.getSecretAlphabet());	 
	}
	
	@Test
	public void testShiftCipher1(){
		ShiftCipher sc = new ShiftCipher(4);
		assertEquals("efghijklmnopqrstuvwxyz����abcd",sc.getSecretAlphabet());	 
	}
	
	@Test
	public void testShiftCipherFailure(){		
		ShiftCipher sc = new ShiftCipher(5);
		assertEquals("abcdefghijklmnopqrstuvwxyz����",sc.getSecretAlphabet());	 
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testShiftException(){
		new ShiftCipher(-2);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSubstitutionException(){
		SubstitutionCipher sc = new SubstitutionCipher("abcdefghijklmnopqrstuvwxyz����??");
		sc.setSecretAlphabet("defghijklmnopqrstuvwxyz����abcabc");
		assertEquals("defghijklmnopqrstuvwxyz����abc",sc.getSecretAlphabet());	 
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testMonoalphabeticException(){
		MonoalphabeticCipher mc = new MonoalphabeticCipher();
		mc.setSecretAlphabet("abcdefghijklmnopqrstuvwxyz����abc");
		assertEquals("abcdefghijklmnopqrstuvwxyz����abc".toCharArray(),mc.getSecretAlphabet().toCharArray());	
	}
	@Test(expected = IllegalArgumentException.class)
	public void testKeywordException2(){
	new KeywordCipher("Test#?!");		
	}
	
	@Test
	public void testKeywordFailure(){		
		KeywordCipher kc = new KeywordCipher("Keyword");
		assertEquals("Keywordabcdefghijklmnopqrstuvwxyz����",kc.getSecretAlphabet());	 
	}
	
	@Test
	public void testSubstFailure(){		
		SubstitutionCipher sc = new SubstitutionCipher("abc");
		assertEquals("abcdefghijklmnopqrstuvwxyz����",sc.getSecretAlphabet());	 
	}
}
