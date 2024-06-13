package diadia.comandi;

import diadia.Partita;
import diadia.ambienti.Direzione;
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
 * @version base 4.0
 */
public class ComandoVai extends AbstractComando {
	private Direzione direzione;
	private final static String NOME = "vai";

	public ComandoVai() {}
	
	public ComandoVai(String direzione) {
		Direzione dir = Direzione.valueOf(direzione);
		this.direzione = dir;
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
	public String getNome() {
		return NOME;
	}
	
}
