package JakubekJevticKraftt;

public class MonoalphabeticCipher implements Cipher {

	private String secretAlphabet;
	private String abck = "abcdefghijklmnopqrstuvwxyz";
	private String abcg = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	public MonoalphabeticCipher() {
		this.secretAlphabet = "abcdefghijklmnopqrstuvwxyz";
	}

	public MonoalphabeticCipher(String secretAlphabet) {
		this.setSecretAlphabet(secretAlphabet);
	}

	public void setSecretAlphabet(String secretAlphabet) {
		this.secretAlphabet = secretAlphabet;
	}

	public String getSecretAlphabet() {
		return secretAlphabet;
	}

	/**
	 * @see JakubekJevticKraft.Cipher#encrypt(JakubekJevticKraft.lang.String)
	 */
	@Override
	public String encrypt(String text) {
		char txt[] = text.toCharArray();
		char secret[] = this.secretAlphabet.toCharArray();
		for (int i = 0; i < txt.length; i++) {
			int c = txt[i];
			if (Character.isUpperCase(c)) {
				txt[i] = secret[c - 'A'];
			} else if (Character.isLowerCase(c)) {
				txt[i] = secret[c - 'a'];
			}
		}
		return String.valueOf(txt);
	}

	/**
	 * @see JakubekJevticKraft.Cipher#decrypt(JakubekJevticKraft.lang.String)
	 */
	@Override
	public String decrypt(String text) {
		char ak[] = abck.toCharArray();
		char ag[] = abcg.toCharArray();
		char txt[] = text.toCharArray();
		for (int i = 0; i < txt.length; i++) {
			if (txt[i] >= 'a' && txt[i] <= 'z') {
				txt[i] = ak[secretAlphabet.indexOf(txt[i])];
			} else {
				txt[i] = ag[secretAlphabet.indexOf(txt[i])];
			}
		}
		return String.valueOf(txt);

	}
	public static void main(String[] args) {
		Cipher c = new SubstitutionCipher("cdefghijklmnopqrstuvwxyzab");
		String en = c.encrypt("Test");
		System.out.println(en);
		System.out.println(c.decrypt(en));
	}
}
