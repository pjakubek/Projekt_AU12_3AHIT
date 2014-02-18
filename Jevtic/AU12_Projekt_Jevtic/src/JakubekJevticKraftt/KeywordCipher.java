package JakubekJevticKraftt;
import java.util.Random;

/* Der KeywordCipher funktioniert aenlich, wie die Caeser Verschluesselung, indem
 * er einen Text verschlüsselt. Beispiel: ABCD wird verschlüsselt in CDEF
 * Um +n ein oder mehrere Zeichen werden die Buchstaben verschoben, dass hier ist niemandem bekannt, wie
 * hier die Verschlüsselung funktioniert, weil es werden maximal 100 Zufallszeichen generiert und der Text
 * wird durch diese Zufallszeichen ersetzt
 * Vorteil: Es ist unmöglich, dass jemand durch Tricks, Kombinationen oder Algorithmen den originalen Text wiederherstellen kann
 * Nachteil: Man kann den Text nicht mehr entschlüsseln, wenn man ihn schon verschlüsselt hat
 */
public class KeywordCipher {
	public static void main(String[]args) {
		Random r = new Random();
		// Alle Buchstaben in einem Char-Array speichern
        char[] letters;
        letters=new char[100];
        char[] message = "What?".toCharArray();
        char[] eMessage = new char[message.length];
        for(int i=0; i<100; i++) {
        	if((letters.length>='A')&&(letters.length<='Z'));
            
    		if((letters.length>='a')&&(letters.length<='z'));
    		                   
    		if((letters.length>='0')&&(letters.length<='9'));
        	letters[i]=(char) ('a'+Math.random()*32);
        	
        }
        
        //Ausgabe der Zufallszeichen
        for(int i = 0; i < message.length; i++)
        {
            
            System.out.print(letters[i]);     
        } 
		                
	}
}	            

