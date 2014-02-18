package JakubekJevticKraftt;

/**
 * ShiftCipher
 * 
 * @author Kraft
 * @version 1.1
 *
 */
public class ShiftCipher extends MonoalphabeticCipher {
	
	/**
	 * Konstruktor um den Shiftvalue zu setzen.
	 * 
	 * @param value ist der Wert indem das Alphabet verschoben wird.
	 */
	
	public ShiftCipher(int value) {
		setShiftAmount(value);
	}
	
	/**
	 * Verschiebt das Alphabet um den eingegeben Wert
	 * 
	 * @param shiftvalue
	 */

	public void setShiftAmount(int shiftvalue) {
		// Strong für das abc
		String abc = this.getSecretAlphabet();

		//Secret abc welches "verschoben" wird
		char secret[] = "abcdefghijklmnopqrstuvwxyzäöüß".toCharArray();

		//Falls der Value kleiner 0 ist wird eine Exception geworfen
		if (shiftvalue < 0) {
			throw new IllegalArgumentException(
					"Bitte geben sie eine Wert größer 0 an!");
		}
		
		//Verschiebt das Alphabet um den eigegeben shiftvalue
		for (int i = 0; i < abc.length(); i++) {
			secret[i]= abc.charAt((i + shiftvalue) % 30);
		}
		
		//Rückgabe des secret Alphabets
		this.setSecretAlphabet(String.valueOf(secret));
	}

	public static void main(String[] args) {
		Cipher c = new ShiftCipher(0);
		String en = c.encrypt("abcdefghijklmnopqrstuvwxyzäöüß");
		System.out.println(en);
		System.out.println(c.decrypt(en));
	}
}