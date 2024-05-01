package diadia.ambienti;

import diadia.Partita;
import diadia.attrezzi.Attrezzo;

/**
 * Labirinto, questa classe modella la mappa di gioco
 * 
 * @author Diego De Martino
 * @see Partita
 * @see Stanza
 * @version base 1.0
 */

public class Labirinto {
	private Stanza stanzaCorrente;
	private Stanza stanzaVincente;
	
	/**
     * Crea tutte le stanze e le porte di collegamento
     * 
     * 
     *   ___________________________________________________________
  		|                   |                   |                   |
  		|                   |     Biblioteca    |                   |
  		|    Laboratorio    |        	        |     Aule 11	    |
  		|                   |                   |        	        |
  		|                   |_________X_________|                   |
  		|                   |                   |                   |
  		|                   |                   |                   |
  		<-                  X       Atrio       X                  ->
  		|                   |                   |                   |
  		|                   |_________X_________|                   |
  		|                   |                   |                   |
  		|                   |                   |                   |
  		|                   X                   X                   |
  		|                   |       Aule 10     |                   |
  		|___________________|___________________|___________________|
	 *
     */
    public void init() {

		/* crea gli attrezzi */
    	Attrezzo lanterna = new Attrezzo("lanterna",3);
		Attrezzo osso = new Attrezzo("osso",1);
    	
		/* crea stanze del labirinto */
		Stanza atrio = new Stanza("Atrio");
		Stanza aulaN11 = new Stanza("Aula N11");
		Stanza aulaN10 = new Stanza("Aula N10");
		Stanza laboratorio = new Stanza("Laboratorio Campus");
		Stanza biblioteca = new Stanza("Biblioteca");
		
		//->Stanza listaS[] = {aulaN11, aulaN10, laboratorio, biblioteca};
		
		/* collega le stanze */
		atrio.impostaStanzaAdiacente("nord", biblioteca);
		atrio.impostaStanzaAdiacente("est", aulaN11);
		atrio.impostaStanzaAdiacente("sud", aulaN10);
		atrio.impostaStanzaAdiacente("ovest", laboratorio);
		aulaN11.impostaStanzaAdiacente("est", laboratorio);
		aulaN11.impostaStanzaAdiacente("ovest", atrio);
		aulaN10.impostaStanzaAdiacente("nord", atrio);
		aulaN10.impostaStanzaAdiacente("est", aulaN11);
		aulaN10.impostaStanzaAdiacente("ovest", laboratorio);
		laboratorio.impostaStanzaAdiacente("est", atrio);
		laboratorio.impostaStanzaAdiacente("ovest", aulaN11);
		biblioteca.impostaStanzaAdiacente("sud", atrio);

        /* pone gli attrezzi nelle stanze */
		aulaN10.addAttrezzo(lanterna);
		atrio.addAttrezzo(osso);

		// il gioco comincia nell'atrio
        stanzaCorrente = atrio;  
		//->stanzaVincente = this.getRNDStanza(listaS);
        stanzaVincente = biblioteca;
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

