package JakubekJevticKraftt;

/**
 * SubstitutionCipher
 * 
 * @author Kraft
 * @version 1.0
 */
public class SubstitutionCipher extends MonoalphabeticCipher {

	public SubstitutionCipher(String secretalphabet) {
		super(secretalphabet);
	}

	public void setSecretAlphabet(String secretAlphabet) {
		super.setSecretAlphabet(secretAlphabet);
	}
}