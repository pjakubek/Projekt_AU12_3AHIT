/* Der ShiftCipher funktioniert aenlich, wie die Caeser Verschluesselung, indem
 * er einen Text verschlüsselt. Beispiel: ABCD wird verschlüsselt in CDEF
 * Um +2 Zahlen werden die Buchstaben verschoben, anschließend soll der verschlüsselte Text auch wieder entschlüsselt werden
 * z. B. von CDEF --> ABCD
 * 
 * anderes Beispiel 
 * 
 */

import java.util.*;
public class ShiftCipher {
	private String text;
	private char []charArray;
	public ShiftCipher() {
		this.text="Mahlzeit";
		this.charArray=new char[100];
		toCipher();
		toDecipher();
	}
	// Methode toCipher erstellen, um Texte verschlüsseln zu können
	public void toCipher() {
		// Mit replace() Methode werden alle Umlaute ersetzt
		text=text.replace("ä","ae");           
		text=text.replace("ö","oe");           
		text=text.replace("ü","ue");           
		text=text.replace("Ä","Ae");           
		text=text.replace("Ö","Oe");            
		text=text.replace("Ü","Ue");            
		text=text.replace("ß","ss");
		System.out.print("Ihr Text wurde verschlüsselt: ");
		// Länge des Textes ermitteln
		for(int i=0; i<text.length(); i++) {
			// Hier werden die Zeichen im Char angegeben, um wie viele Stellen die Zeichen verschoben werden
			char c=(char)(text.charAt(i)+7);
			// Zeichen einschränken: von A-Z, a-z und 0-9                   
			if((text.charAt(i)>='A')&&(text.charAt(i)<='Z'));                 
			if((text.charAt(i)>='a')&&(text.charAt(i)<='z'));                
			if((text.charAt(i)>='0')&&(text.charAt(i)<='9'));
			// Alle Zeichen in einem char Array koppieren
			charArray[i]=c;
			// Und ausgeben
			System.out.print(charArray[i]);
		}
	}
	// Methode toDecipher erstellen, um Texte wieder entschlüsseln zu können
	public void toDecipher() {
			System.out.println();
			System.out.print("Ihr Text wurde entschlüsselt: ");
			// Länge des Textes im ermitteln
			for(int i=0; i<text.length(); i++) {
				// Der Text wird am einfachsten entschlüsselt, indem man das charAt nicht erhöht und nicht senkt
				char c=(char)(text.charAt(i));
				charArray[i]=c;
				System.out.print(charArray[i]);
			}
		}
	// Testmethode
	public static void main(String []args) {
		ShiftCipher c = new ShiftCipher();
	}
}
