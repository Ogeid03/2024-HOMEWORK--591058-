package diadia.ambienti;

import diadia.Partita;

/**
 * Labirinto, questa classe modella la mappa di gioco
 * 
 * @author Diego De Martino
 * @see Partita
 * @see Stanza
 * @version base 3.1
 */

public class Labirinto {
	private Stanza stanzaCorrente;
	private Stanza stanzaVincente;
    
    public void setStanzaVincente(Stanza stanzaVincente) {
    	this.stanzaVincente = stanzaVincente;
    }
    
    public Stanza getStanzaVincente() {
		return stanzaVincente;
	}

	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.stanzaCorrente = stanzaCorrente;
	}

	public Stanza getStanzaCorrente() {
		return this.stanzaCorrente;
	}
	
	public static LabirintoBuilder newLabBuilder() {
		return new LabirintoBuilder();
	}
	
	/**
	 * Ritorna una stanza randomica dato un pool di opzioni valide. 
	 * Può essere utile in ottica futura per implementare generazione randomica della mappa di gioco
	 * o per impostare randomicamente la Stanza Vincente.
	 * 
	 * @param Array di Stanze
	 * @return una stanza randomica dal pool di scelte.
	 */
	/*public Stanza getRNDStanza(Stanza[] listaS) {
		return listaS[(int)Math.random() * listaS.length];
	}*/
}

