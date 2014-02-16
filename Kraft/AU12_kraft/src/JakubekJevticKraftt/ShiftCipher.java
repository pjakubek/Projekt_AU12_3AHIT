package JakubekJevticKraftt;

public class ShiftCipher extends MonoalphabeticCipher {

	public ShiftCipher(int value) {
		setShiftAmount(value);
	}

	public void setShiftAmount(int shiftvalue) {
		
		String abc = this.getSecretAlphabet();

		char secret[] = "abcdefghijklmnopqrstuvwxyzäöüß".toCharArray();

		if (shiftvalue < 0) {
			throw new IllegalArgumentException(
					"Bitte geben sie eine Wert größer 0 an!");
		}

		for (int i = 0; i < abc.length(); i++) {
			secret[i]= abc.charAt((i + shiftvalue) % 30);
		}
		
		this.setSecretAlphabet(String.valueOf(secret));
	}

	public static void main(String[] args) {
		Cipher c = new ShiftCipher(3);
		String en = c.encrypt("abcdefghijklmnopqrstuvwxyzäöüß");
		System.out.println(en);
		System.out.println(c.decrypt(en));
	}
}
