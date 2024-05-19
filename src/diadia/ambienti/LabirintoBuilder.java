package diadia.ambienti;

import java.util.HashMap;
import java.util.Map;

import diadia.attrezzi.Attrezzo;

/**
 * Una classe LabirintoBuilder che fornisce tutti i
 * metodi necessari per creare un labirinto
 *
 * @author  Diego De Martino
 * @see Attrezzo
 * @version 3.0
 */
public class LabirintoBuilder {
	private Labirinto labirinto;
	private Stanza stanzaAttuale;
	private Map<String, Stanza> stanze;
	
	public LabirintoBuilder() {
		this.labirinto=new Labirinto();
		this.stanze=new HashMap<String, Stanza>();
	}
	
	public Labirinto getLabirinto() {
		return this.labirinto;
	}
	/**
	 * Restituisce la mappa delle stanze aggiunte al labirinto.
	 * @return la mappa delle stanze aggiunte al labirinto
	 */
	public Map<String, Stanza> getStanze(){
		return this.stanze;
	}
	
	public void setStanzaAttuale(Stanza stanzaAttuale) {
		this.stanzaAttuale=stanzaAttuale;
	}
	/**
	 * Aggiunge una stanza al labirinto.
	 * @param stanzaAttuale la stanza da aggiungere
	 */
	public void aggiungiStanza(Stanza stanzaAttuale) {
		this.setStanzaAttuale(stanzaAttuale);
		this.stanze.put(stanzaAttuale.getNome(),stanzaAttuale);
	}
	/**
	 * Aggiunge una stanza di partenza al labirinto.
	 * @param stanzaPartenza il nome della stanza di partenza
	 * @return il LabirintoBuilder per il chaining dei metodi
	 */
	public LabirintoBuilder addStanzaIniziale(String stanzaPartenza) {
		Stanza s=new Stanza(stanzaPartenza);
		this.labirinto.setStanzaCorrente(s);
		this.aggiungiStanza(s);
		return this;
	}
	/**
	 * Aggiunge una stanza vincente al labirinto.
	 * @param stanzaVincente il nome della stanza vincente
	 * @return il LabirintoBuilder per il chaining dei metodi
	 */
	public LabirintoBuilder addStanzaVincente(String stanzaVincente) {
		Stanza s=new Stanza(stanzaVincente);
		this.labirinto.setStanzaVincente(s);
		this.aggiungiStanza(s);
		return this;
	}
	/**
	 * Aggiunge una stanza normale al labirinto.
	 * @param stanzaNormale il nome della stanza normale
	 * @return il LabirintoBuilder per il chaining dei metodi
	 */
	public LabirintoBuilder addStanzaNormale(String stanzaNormale) {
		Stanza s=new Stanza(stanzaNormale);
		this.aggiungiStanza(s);
		return this;
	}
	/**
	 * Collega due stanze nel labirinto
	 * Collega la prima stanza fornita con la seconda nella
	 * direzione passata e viceversa sfruttando il metodo
	 * calcola direzione opposta in modo tale che il 
	 * collegamento sia bilaterale.
	 * @param direzione la direzione in cui collegare le stanze
	 * @param stanzaAttuale il nome della stanza attuale
	 * @param stanzaAdiacente il nome della stanza adiacente
	 * @return il LabirintoBuilder per il chaining dei metodi
	 */
	public LabirintoBuilder addAdiacenza(String direzione, String stanzaAttuale, String stanzaAdiacente) {
	    Stanza attuale = this.stanze.get(stanzaAttuale);
	    Stanza adiacente = this.stanze.get(stanzaAdiacente);
	    attuale.impostaStanzaAdiacente(direzione, adiacente);
	    String direzioneOpposta = calcolaDirezioneOpposta(direzione);
	    adiacente.impostaStanzaAdiacente(direzioneOpposta, attuale);
	    return this;
	}
	/**
	 * Calcola la direzione opposta a quella specificata.
	 * @param direzione la direzione di partenza
	 * @return la direzione opposta
	 */
	private String calcolaDirezioneOpposta(String direzione) {
	    if ("nord".equals(direzione)) return "sud";
	    if ("sud".equals(direzione)) return "nord";
	    if ("est".equals(direzione)) return "ovest";
	    if ("ovest".equals(direzione)) return "est";
	    return "Nessuna";
	}
	/**
	 * Aggiunge un attrezzo alla stanza attuale, se presente
	 * altrimenti non lo aggiunge.
	 * @param nomeAttrezzo il nome dell'attrezzo da aggiungere
	 * @param peso il peso dell'attrezzo da aggiungere
	 * @return il LabirintoBuilder per il chaining dei metodi
	 */
	public LabirintoBuilder addAttrezzo(String nomeAttrezzo,int peso) {
		Attrezzo attrezzo=new Attrezzo(nomeAttrezzo,peso);
		if(this.stanzaAttuale==null) return this;
		this.stanzaAttuale.addAttrezzo(attrezzo);
		return this;
	}
	/**
	 * Aggiunge una stanza magica al labirinto.
	 * @param stanzaMagica il nome della stanza magica
	 * @param soglia la soglia magica della stanza
	 * @return il LabirintoBuilder per il chaining dei metodi
	 */
	public LabirintoBuilder addStanzaMagica(String stanzaMagica,int soglia) {
		Stanza s = new StanzaMagica(stanzaMagica,soglia);
		this.aggiungiStanza(s);
		return this;
	}
	/**
	 * Aggiunge una stanza bloccata al labirinto.
	 * @param stanzaBloccata il nome della stanza bloccata
	 * @param attrezzoChiave il nome dell'attrezzo chiave per sbloccare la stanza
	 * @param direzioneBloccata la direzione bloccata dalla stanza
	 * @return il LabirintoBuilder per il chaining dei metodi
	 */
	public LabirintoBuilder addStanzaBloccata(String stanzaBloccata, String attrezzoChiave, String direzioneBloccata) {
		Stanza s = new StanzaBloccata(stanzaBloccata,direzioneBloccata,attrezzoChiave);
		this.aggiungiStanza(s);
		return this;
	}
	/**
	 * Aggiunge una stanza buia al labirinto.
	 * @param stanzaBuia il nome della stanza buia
	 * @param attrezzoBuio il nome dell'attrezzo che permette di vedere nella stanza buia
	 * @return il LabirintoBuilder per il chaining dei metodi
	 */
	public LabirintoBuilder addStanzaBuia(String stanzaBuia,String attrezzoBuio) {
		Stanza s = new StanzaBuia(stanzaBuia,attrezzoBuio);
		this.aggiungiStanza(s);
		return this;
	}
	/**
	 * Restituisce una copia della mappa delle stanze.
	 * @return una copia della mappa delle stanze
	 */
	public Map<String, Stanza> getListaStanze() {
        return new HashMap<>(this.stanze);
    }
	
	
}

