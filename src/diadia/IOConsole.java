package diadia;
import java.util.Scanner;

/**
 * Classe Input/Output gestisce tutti i System.in/System.out
 * @author d1390
 * @version base 1.0
 */
public class IOConsole {
	
	public void mostraMessaggio(String msg) {
		System.out.println(msg);
	}
	
	public void mostraMessaggioInLinea(String msg) {
		System.out.print(msg);
	}
	
	public String leggiRiga() {
		Scanner scannerDiLinee = new Scanner(System.in);
		String riga = scannerDiLinee.nextLine();
		//scannerDiLinee.close();
		return riga;
	}
}
