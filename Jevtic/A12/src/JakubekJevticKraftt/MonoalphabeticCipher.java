package JakubekJevticKraftt;

import java.util.HashSet;

/**
 * Super Cipher
 * 
 * @author Kraft
 * @version 1.1
 * 
 */
public class MonoalphabeticCipher implements Cipher {

	// Secret Alphabet
	private String secretAlphabet;

	// Alphabet
	private String abc = "abcdefghijklmnopqrstuvwxyz����";

	/**
	 * secretAlphabet wird gesetzt.
	 */
	public MonoalphabeticCipher() {
		this.secretAlphabet = "abcdefghijklmnopqrstuvwxyz����";
	}

	/**
	 * Konstruktor, gibt das secretAlphabet
	 * 
	 * @param secretAlphabet
	 */
	public MonoalphabeticCipher(String secretAlphabet) {
		this.setSecretAlphabet(secretAlphabet);
	}

	/**
	 * Setzt das secretAlphabet
	 * 
	 * @param secretAlphabet
	 */
	public void setSecretAlphabet(String secretAlphabet)
			throws IllegalArgumentException {
		secretAlphabet = secretAlphabet.toLowerCase();

		if (secretAlphabet == null) {
			throw new IllegalArgumentException("Secret Alphabet ben�tigt!");
		}

		for (int i = 0; i < secretAlphabet.length(); i++) {
			if (!abc.contains("" + secretAlphabet.charAt(i))) {
				throw new IllegalArgumentException(
						"Nicht zul�ssige Buchstaben!");
			}
		}

		if (secretAlphabet.length() > 30) {
			throw new IllegalArgumentException("Zu viele Buchstaben!");
		}

		if (secretAlphabet.length() < 30) {
			throw new IllegalArgumentException("Zu wenige Buchstaben!");
		}

		HashSet<Character> check = new HashSet<Character>();
		for (int i = 0; i < secretAlphabet.length(); i++) {
			check.add(secretAlphabet.charAt(i));
		}
		if (check.size() != 30) {
			throw new IllegalArgumentException(
					"Das Secret Alphabet enth�lt doppelte Buchstaben");
		}

		for (int i = 0; i < secretAlphabet.length(); i++) {
			if (!abc.contains("" + secretAlphabet.charAt(i))) {
				throw new IllegalArgumentException(
						"Das Secret Alphabet enth�lt unerlaubte Buchstaben");
			}
		}

		this.secretAlphabet = secretAlphabet;

	}

	/**
	 * Gibt secretAlphabet zur�ck
	 * 
	 * @return secretAlphabet
	 */
	public String getSecretAlphabet() {
		return secretAlphabet;
	}

	/**
	 * Verschl�sselt einen eingegeben Text
	 * 
	 * @return txt Verschl�sselter Text
	 * @param text
	 *            Text der verschl�sselt werden soll
	 */
	public String encrypt(String text) {
		char txt[] = text.toLowerCase().toCharArray();
		char secret[] = this.secretAlphabet.toCharArray();
		for (int i = 0; i < txt.length; i++) {
			int c = txt[i];
			if (txt[i] >= 'a' && txt[i] <= 'z') {
				txt[i] = secret[c - 'a'];
			} else {
				switch (txt[i]) {
				case '�':
					txt[i] = secret[26];
					break;
				case '�':
					txt[i] = secret[27];
					break;
				case '�':
					txt[i] = secret[28];
					break;
				case '�':
					txt[i] = secret[29];
					break;
				}
			}
		}
		return String.valueOf(txt);
	}

	/**
	 * 
	 * @return txt entschl�sselnter Text
	 * @param text
	 *            zu entschl�sselnder Text
	 */
	public String decrypt(String text) {
		char a[] = abc.toCharArray();
		char txt[] = text.toLowerCase().toCharArray();
		for (int i = 0; i < txt.length; i++) {
			if (txt[i] >= 'a' && txt[i] <= 'z' || txt[i] == '�'
					|| txt[i] == '�' || txt[i] == '�' || txt[i] == '�') {
				txt[i] = a[secretAlphabet.indexOf(txt[i])];
			}
		}
		return String.valueOf(txt);
	}

	public static void main(String[] args) {
		Cipher c = new SubstitutionCipher("dbcefghilkjmnoxpqrstuvwyz����a");
		String en = c.encrypt("Test����");
		System.out.println(en);
		System.out.println(c.decrypt(en));
	}
}