/* Der ShiftCipher funktioniert aenlich, wie die Caeser Verschluesselung, indem
 * er einen Text verschl�sselt. Beispiel: ABCD wird verschl�sselt in CDEF
 * Um +2 Zahlen werden die Buchstaben verschoben, anschlie�end soll der verschl�sselte Text auch wieder entschl�sselt werden
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
	// Methode toCipher erstellen, um Texte verschl�sseln zu k�nnen
	public void toCipher() {
		// Mit replace() Methode werden alle Umlaute ersetzt
		text=text.replace("�","ae");           
		text=text.replace("�","oe");           
		text=text.replace("�","ue");           
		text=text.replace("�","Ae");           
		text=text.replace("�","Oe");            
		text=text.replace("�","Ue");            
		text=text.replace("�","ss");
		System.out.print("Ihr Text wurde verschl�sselt: ");
		// L�nge des Textes ermitteln
		for(int i=0; i<text.length(); i++) {
			// Hier werden die Zeichen im Char angegeben, um wie viele Stellen die Zeichen verschoben werden
			char c=(char)(text.charAt(i)+7);
			// Zeichen einschr�nken: von A-Z, a-z und 0-9                   
			if((text.charAt(i)>='A')&&(text.charAt(i)<='Z'));                 
			if((text.charAt(i)>='a')&&(text.charAt(i)<='z'));                
			if((text.charAt(i)>='0')&&(text.charAt(i)<='9'));
			// Alle Zeichen in einem char Array koppieren
			charArray[i]=c;
			// Und ausgeben
			System.out.print(charArray[i]);
		}
	}
	// Methode toDecipher erstellen, um Texte wieder entschl�sseln zu k�nnen
	public void toDecipher() {
			System.out.println();
			System.out.print("Ihr Text wurde entschl�sselt: ");
			// L�nge des Textes im ermitteln
			for(int i=0; i<text.length(); i++) {
				// Der Text wird am einfachsten entschl�sselt, indem man das charAt nicht erh�ht und nicht senkt
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
