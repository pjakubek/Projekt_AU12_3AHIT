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
	private String abc = "abcdefghijklmnopqrstuvwxyzäöüß";

	/**
	 * secretAlphabet wird gesetzt.
	 */
	public MonoalphabeticCipher() {
		this.secretAlphabet = "abcdefghijklmnopqrstuvwxyzäöüß";
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
			throw new IllegalArgumentException("Secret Alphabet benötigt!");
		}

		for (int i = 0; i < secretAlphabet.length(); i++) {
			if (!abc.contains("" + secretAlphabet.charAt(i))) {
				throw new IllegalArgumentException(
						"Nicht zulässige Buchstaben!");
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
					"Das Secret Alphabet enthält doppelte Buchstaben");
		}

		for (int i = 0; i < secretAlphabet.length(); i++) {
			if (!abc.contains("" + secretAlphabet.charAt(i))) {
				throw new IllegalArgumentException(
						"Das Secret Alphabet enthält unerlaubte Buchstaben");
			}
		}

		this.secretAlphabet = secretAlphabet;

	}

	/**
	 * Gibt secretAlphabet zurück
	 * 
	 * @return secretAlphabet
	 */
	public String getSecretAlphabet() {
		return secretAlphabet;
	}

	/**
	 * Verschlüsselt einen eingegeben Text
	 * 
	 * @return txt Verschlüsselter Text
	 * @param text
	 *            Text der verschlüsselt werden soll
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
				case 'ä':
					txt[i] = secret[26];
					break;
				case 'ö':
					txt[i] = secret[27];
					break;
				case 'ü':
					txt[i] = secret[28];
					break;
				case 'ß':
					txt[i] = secret[29];
					break;
				}
			}
		}
		return String.valueOf(txt);
	}

	/**
	 * 
	 * @return txt entschlüsselnter Text
	 * @param text
	 *            zu entschlüsselnder Text
	 */
	public String decrypt(String text) {
		char a[] = abc.toCharArray();
		char txt[] = text.toLowerCase().toCharArray();
		for (int i = 0; i < txt.length; i++) {
			if (txt[i] >= 'a' && txt[i] <= 'z' || txt[i] == 'ä'
					|| txt[i] == 'ö' || txt[i] == 'ü' || txt[i] == 'ß') {
				txt[i] = a[secretAlphabet.indexOf(txt[i])];
			}
		}
		return String.valueOf(txt);
	}

	public static void main(String[] args) {
		Cipher c = new SubstitutionCipher("dbcefghilkjmnoxpqrstuvwyzäöüßa");
		String en = c.encrypt("Testäöüß");
		System.out.println(en);
		System.out.println(c.decrypt(en));
	}
}