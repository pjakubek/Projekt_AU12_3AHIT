package JakubekJevticKraftt;

public class SubstitutionCipher extends MonoalphabeticCipher {

	public SubstitutionCipher(String secretalphabet) {
		super(secretalphabet);
	}

	public void setSecretAlphabet(String secretAlphabet) {
		super.setSecretAlphabet(secretAlphabet);
	}
	
	public static void main(String[] args) {
		Cipher c = new SubstitutionCipher("cdefghijklmnopqrstuvwxyzab");
		String en = c.encrypt("Test");
		System.out.println(en);
		System.out.println(c.decrypt(en));
	}
}
