package diadia.ambienti;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import diadia.attrezzi.Attrezzo;
import diadia.personaggi.AbstractPersonaggio;

/**
 * Classe Stanza - una stanza in un gioco di ruolo.
 * Una stanza e' un luogo fisico nel gioco.
 * E' collegata ad altre stanze attraverso delle uscite.
 * Ogni uscita e' associata ad una direzione.
 * 
 * @author docente di POO, Diego De Martino
 * @see Attrezzo
 * @version base 4.0
*/

public class Stanza {
	
	static final private int NUMERO_MASSIMO_DIREZIONI = 4;
	static final private int NUMERO_MASSIMO_ATTREZZI = 10;
	
	private String nome;
    protected Map<String, Attrezzo> attrezzi;
    protected int numeroAttrezzi;
    protected Map<Direzione, Stanza> Direzione_stanzeAdiacenti;
    protected int numeroStanzeAdiacenti;
    
    private AbstractPersonaggio personaggio;
    
    /**
     * Crea una stanza. Non ci sono stanze adiacenti, non ci sono attrezzi.
     * @param nome il nome della stanza
     */
    public Stanza(String nome) {
        this.nome = nome;
        this.numeroStanzeAdiacenti = 0;
        this.numeroAttrezzi = 0;
        //this.direzioni = new String[NUMERO_MASSIMO_DIREZIONI];
        this.Direzione_stanzeAdiacenti = new HashMap<>();
        this.attrezzi = new HashMap<>();
    }

    /**
     * Imposta una stanza adiacente.
     *
     * @param direzione direzione in cui sara' posta la stanza adiacente.
     * @param stanza stanza adiacente nella direzione indicata dal primo parametro.
     */
    public void impostaStanzaAdiacente(Direzione direzione, Stanza stanza) {
        if(!this.Direzione_stanzeAdiacenti.containsKey(direzione))
        	if (this.numeroStanzeAdiacenti < NUMERO_MASSIMO_DIREZIONI) {
    				this.Direzione_stanzeAdiacenti.put(direzione, stanza);
    				this.numeroStanzeAdiacenti++;
        	}	
    }

    /**
     * Restituisce la stanza adiacente nella direzione specificata
     * @param direzione
     */
	public Stanza getStanzaAdiacente(Direzione direzione) {
        Stanza stanza = null;
        if (this.Direzione_stanzeAdiacenti.containsKey(direzione))
        	stanza = this.Direzione_stanzeAdiacenti.get(direzione);
        return stanza;
	}

    /**
     * Restituisce la nome della stanza.
     * @return il nome della stanza
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * Restituisce la descrizione della stanza.
     * @return la descrizione della stanza
     */
    public String getDescrizione() {
        return this.toString();
    }
    
    public List<Stanza> getStanzeAdiacenti() {
		List<Stanza> listaStanzeAdiacenti = new ArrayList<>();
		for (Stanza s : this.Direzione_stanzeAdiacenti.values()) {
			listaStanzeAdiacenti.add(s);
		}
		return listaStanzeAdiacenti;
	}

    /**
     * Restituisce la collezione di attrezzi presenti nella stanza.
     * @return la collezione di attrezzi nella stanza.
     */
    public Map<String, Attrezzo> getAttrezzi() {
        return this.attrezzi;
    }
    
    public AbstractPersonaggio getPersonaggio() {
    	return this.personaggio;
    }
    
    public void setPersonaggio(AbstractPersonaggio personaggio) {
    	this.personaggio = personaggio;
    }

    /**
     * Mette un attrezzo nella stanza.
     * @param attrezzo l'attrezzo da mettere nella stanza.
     * @return true se riesce ad aggiungere l'attrezzo, false atrimenti.
     */
    public boolean addAttrezzo(Attrezzo attrezzo) {
        if (this.numeroAttrezzi < NUMERO_MASSIMO_ATTREZZI) {
        	this.attrezzi.put(attrezzo.getNome(), attrezzo);
        	this.numeroAttrezzi++;
        	return true;
        }
        else {
        	return false;
        }
    }

   /**
	* Restituisce una rappresentazione stringa di questa stanza,
	* stampadone la descrizione, le uscite e gli eventuali attrezzi contenuti
	* @return la rappresentazione stringa
	*/
    public String toString() {
    	StringBuilder risultato = new StringBuilder();
    	risultato.append(this.nome);
    	risultato.append("\nUscite: ");
    	for (Direzione direzione : this.getDirezioni())
    			risultato.append(" " + direzione);
    	risultato.append("\n" + this.getDescrizioneAttrezzi());
    	
    	return risultato.toString();
    }

    /**
	* Controlla se un attrezzo esiste nella stanza (uguaglianza sul nome).
	* @return true se l'attrezzo esiste nella stanza, false altrimenti.
	*/
	public boolean hasAttrezzo(String nomeAttrezzo) {
		boolean trovato = false;
			if (this.attrezzi.containsKey(nomeAttrezzo))
				trovato = true;
		return trovato;
	}

	/**
     * Restituisce l'attrezzo nomeAttrezzo se presente nella stanza.
	 * @param nomeAttrezzo
	 * @return l'attrezzo presente nella stanza.
     * 		   null se l'attrezzo non e' presente.
	 */
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo attrezzoCercato = null;
			if (this.attrezzi.containsKey(nomeAttrezzo))
				attrezzoCercato = this.attrezzi.get(nomeAttrezzo);
		return attrezzoCercato;	
	}

	/**
	 * Rimuove un attrezzo dalla stanza (ricerca in base al nome).
	 * @param nomeAttrezzo
	 * @return true se l'attrezzo e' stato rimosso, false altrimenti
	 */
	public boolean removeAttrezzo(String attrezzo) {
		
			if(this.attrezzi.containsKey(attrezzo)) {
				this.attrezzi.remove(attrezzo);
				this.numeroAttrezzi--;
				return true;
			}
		return false;
	}

	/**
	 * Ritorna le direzioni disponibili in base alla stanza. 
	 * 
	 * @return un array contenente le direzioni
	 */
	public Direzione[] getDirezioni() {
		Direzione[] direzioni = new Direzione[this.numeroStanzeAdiacenti];
		int i=0;
	    for(Map.Entry<Direzione, Stanza> direzione : this.Direzione_stanzeAdiacenti.entrySet()) {
	    	direzioni[i] = direzione.getKey();
	    	i++;
		}	
	    return direzioni;
    }
	
	/**
	 * Ritorna la descrizione degli attrezzi presenti nella stanza.
	 * 
	 * @return una stringa contenente tutti gli attrezzi nella stanza e i relativi dettagli
	 */
	public String getDescrizioneAttrezzi() {
		StringBuilder risultato = new StringBuilder();
		risultato.append("Attrezzi nella stanza: ");
		for (Map.Entry<String, Attrezzo> attrezzo : this.attrezzi.entrySet())
			risultato.append(attrezzo.getValue().toString()+" ");
			
		return risultato.toString();
	}	
}