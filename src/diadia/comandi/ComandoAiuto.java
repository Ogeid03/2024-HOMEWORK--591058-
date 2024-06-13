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
 * @version base 4.0
 */
public class ComandoAiuto extends AbstractComando {
	static final private String[] elencoComandi = {"vai", "prendi", "posa", "guarda", "interagisci", "regala", "aiuto", "fine"};
	private final static String NOME = "aiuto";
	
	public ComandoAiuto() {}
	
	@Override
	public void esegui(Partita partita) {
		partita.getIO().mostraMessaggio("\nI comandi sono: ");
		for(int i=0; i< elencoComandi.length; i++) 
			partita.getIO().mostraMessaggioInLinea(elencoComandi[i] + " ");
		partita.getIO().mostraMessaggio("");
	}
	
	@Override
	public String getNome() {
		return NOME;
	}
}
