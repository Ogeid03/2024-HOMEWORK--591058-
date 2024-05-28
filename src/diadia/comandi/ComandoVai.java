package diadia.comandi;

import diadia.Partita;
import diadia.ambienti.Labirinto;
import diadia.ambienti.Stanza;

/**
 * Questa classe modella un comando di gioco.
 * Richiamando il metodo ESEGUI viene aggiornata la
 * STANZA_CORRENTE con quella presente nella DIREZIONE 
 * passata come parametro, ove presente, altrimenti ritorna 
 * la STANZA attuale.
 * 
 * @author Diego De Martino
 * @see Labirinto
 * @version base 3.1
 */
public class ComandoVai implements Comando {
	private String direzione;

	public ComandoVai(String direzione) {
		this.direzione = direzione;
	}
	

	/**
	* esecuzione del comando
	* 
	* Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	* e ne stampa il nome, altrimenti stampa un messaggio di errore
	*/
	@Override
	public void esegui(Partita partita) {
		Stanza stanzaCorrente = partita.getLabirinto().getStanzaCorrente();
		Stanza prossimaStanza = null;
		
		if(direzione == null) {
			partita.getIO().mostraMessaggio("Dove vuoi andare? (Devi specificare una direzione)");
			return;
		}
		
		prossimaStanza = stanzaCorrente.getStanzaAdiacente(this.direzione);
		
		if(prossimaStanza == null) {
			partita.getIO().mostraMessaggio("DIREZIONE INESISTENTE");
			return;
		}
		
		partita.getLabirinto().setStanzaCorrente(prossimaStanza);
		partita.getIO().mostraMessaggio(partita.getLabirinto().getStanzaCorrente().getNome());
		partita.getPlayer().setCFU(partita.getPlayer().getCFU() - 1);
	}
	
	@Override
	public void setParametro(String param) {
		this.direzione = param;
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
