package JakubekJevticKraftt;

public class MonoalphabeticCipher implements Cipher {

	private String secretAlphabet;
	private String abc = "abcdefghijklmnopqrstuvwxyz����";

	public MonoalphabeticCipher() {
		this.secretAlphabet = "abcdefghijklmnopqrstuvwxyz����";
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
		char txt[] = text.toLowerCase().toCharArray();
		char secret[] = this.secretAlphabet.toCharArray();
		for (int i = 0; i < txt.length; i++) {
			int c = txt[i];
			if(txt[i] >= 'a' && txt[i] <= 'z'){
				txt[i] = secret[c - 'a'];
			}
			else{
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
	 * @see JakubekJevticKraft.Cipher#decrypt(JakubekJevticKraft.lang.String)
	 */
	@Override
	public String decrypt(String text) {
		char a[] = abc.toCharArray();
		char txt[] = text.toLowerCase().toCharArray();
		for (int i = 0; i < txt.length; i++) {
			if (txt[i] >= 'a' && txt[i] <= 'z' || txt[i] == '�' || txt[i] == '�' || txt[i] == '�' || txt[i] == '�') {
				txt[i] = a[secretAlphabet.indexOf(txt[i])];
			}
		}
		return String.valueOf(txt);
	}
	public static void main(String[] args) {
		Cipher c = new SubstitutionCipher("bcdefghijklmnopqrstuvwxyz����a");
		String en = c.encrypt("H�sslicher");
		System.out.println(en);
		System.out.println(c.decrypt(en));
	}
}
