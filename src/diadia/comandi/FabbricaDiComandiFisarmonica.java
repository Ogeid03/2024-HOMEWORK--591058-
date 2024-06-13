package diadia.comandi;
import java.util.Scanner;

public class FabbricaDiComandiFisarmonica implements FabbricaDiComandi{
	
	@Override
	public Comando costruisciComando(String istruzione) {
		try (Scanner scannerDiParole = new Scanner(istruzione)) {
			String nomeComando = null;
			String parametro = null;
			Comando comando = null;
			
			if (scannerDiParole.hasNext())
				nomeComando = scannerDiParole.next(); // prima parola: nome del comando
			if (scannerDiParole.hasNext())
				parametro = scannerDiParole.next(); // seconda parola: eventuale parametro
			
			if (nomeComando == null)
				comando = new ComandoNonValido();
			
			else if (nomeComando.equals("vai"))
				comando = new ComandoVai(parametro);
			
			else if (nomeComando.equals("prendi"))
				comando = new ComandoPrendi(parametro);
			
			else if (nomeComando.equals("posa"))
				comando = new ComandoPosa(parametro);
			
			else if (nomeComando.equals("aiuto"))
				comando = new ComandoAiuto();
			
			else if (nomeComando.equals("fine"))
				comando = new ComandoFine();
			
			else if (nomeComando.equals("guarda"))
				comando = new ComandoGuarda(parametro);
			
			else if (nomeComando.equals("regala"))
				comando = new ComandoGuarda(parametro);
			
			else if (nomeComando.equals("interagisci"))
				comando = new ComandoGuarda(parametro);
			
			else comando = new ComandoNonValido();
				
			return comando;
		}
		}
}
