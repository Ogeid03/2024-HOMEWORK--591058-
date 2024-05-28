package diadia.comandi;

import diadia.Partita;
import diadia.ambienti.Labirinto;

/**
 * Questa classe modella un comando di gioco.
 * Richiamando il metodo ESEGUI vengono riportati in output
 * all'utente i dati relativi alla STANZA.
 * 
 * @author Diego De Martino
 * @see Labirinto
 * @see Borsa
 * @version base 3.1
 */
public class ComandoAiuto implements Comando {
	static final private String[] elencoComandi = {"vai", "prendi", "posa", "guarda", "aiuto", "fine"};
	//private IOConsole IO = new IOConsole();
	
	@Override
	public void esegui(Partita partita) {
		partita.getIO().mostraMessaggio("\nI comandi sono: ");
		for(int i=0; i< elencoComandi.length; i++) 
			partita.getIO().mostraMessaggioInLinea(elencoComandi[i] + " ");
		partita.getIO().mostraMessaggio("");
	}
	
	@Override
	public void setParametro(String param) {
		//auto-generated
	}
	
	@Override
	public String getParametro() {
		return null;
	}
	
	@Override
	public String getNome() {
		return null;
	}
	
}
