package JakubekJevticKraftt;
/**
 * 
 * @author Max
 * @version 1.0
 */
public class KeywordCipher extends MonoalphabeticCipher {

	/**
	 * 
	 * @param keyword setzen
	 */
	public KeywordCipher(String keyword) {
		this.setKeyword(keyword);
	}

	/**
	 * 
	 * @param keyword zum hinzufügen des secret alphabet
	 */
	public void setKeyword(String keyword) {
		String abc = getSecretAlphabet().toLowerCase();
		char key[] = keyword.toLowerCase().toCharArray();
		
		for (int i=0; i<key.length; i++){
			if(abc.contains(""+key[i])){
				abc=abc.replaceAll("" + key[i],"");
			}
		}
		
		String secret = String.valueOf(key) + abc;
		
		this.setSecretAlphabet(secret);
	}
	public static void main(String[]args){
		KeywordCipher sc=new KeywordCipher("dsg");
		String en = sc.encrypt("sdx");
		System.out.println(en);
		System.out.println(sc.decrypt(en));
	}
}
