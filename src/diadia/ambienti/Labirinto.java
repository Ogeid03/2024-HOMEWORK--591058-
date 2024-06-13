package diadia.ambienti;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import diadia.FormatoFileNonValidoException;
import diadia.Partita;
import diadia.attrezzi.Attrezzo;
import diadia.personaggi.Cane;
import diadia.personaggi.Mago;
import diadia.personaggi.Strega;

/**
 * Labirinto, questa classe modella la mappa di gioco
 * 
 * @author Diego De Martino
 * @see Partita
 * @see Stanza
 * @version base 4.0
 */

public class Labirinto {
	private Stanza stanzaCorrente;
	private Stanza stanzaVincente;
	
	private  Labirinto() {}
	
	private Labirinto(String nomeFile) throws FileNotFoundException, FormatoFileNonValidoException {
		CaricatoreLabirinto c = new CaricatoreLabirinto(nomeFile);
		c.carica();
		this.stanzaCorrente = c.getStanzaIniziale();
		this.stanzaVincente = c.getStanzaVincente();
	}
    
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
	
	public static LabirintoBuilder newLabBuilder(String labirinto) throws FileNotFoundException, FormatoFileNonValidoException {
		return new LabirintoBuilder(labirinto);
	}
	
	public static LabirintoBuilder newLabBuilder() {
		return new LabirintoBuilder();
	}
	
	/*public String getDescrizione() {
		StringBuilder risultato = new StringBuilder();
		risultato.append("Stanze:");
		for(Map.Entry<String, Stanza> stanza : newLabBuilder().getStanze().entrySet()) {
			risultato.append(stanza.getKey() + ", S");
		}
		
		risultato.append("Inizio: " + this.getStanzaCorrente());
		risultato.append("Vincente: " + this.getStanzaVincente());
		
		risultato.append("Attrezzi:");
		for(Map.Entry<String, Stanza> stanza : newLabBuilder().getStanze().entrySet()) {
			if(!stanza.getValue().getAttrezzi().isEmpty())	
				for(Map.Entry<String, Attrezzo> attrezzo : stanza.getValue().getAttrezzi().entrySet()) {
					risultato.append(attrezzo.getValue().getNome() + " " + attrezzo.getValue().getPeso() + " " + stanza.getKey() + ", ");
				}
		}
		
		risultato.append("Uscite:");
		for(Map.Entry<String, Stanza> stanza : newLabBuilder().getStanze().entrySet()) {
			if(stanza.getValue().getDirezioni() != null)	
				for (Direzione direzione : stanza.getValue().getDirezioni())
					risultato.append(stanza + " " + direzione + stanza.getValue().getStanzaAdiacente(direzione) + ", ");
		}
		
		return risultato.toString();
	}*/
	
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
	
	public static class LabirintoBuilder {
		private Labirinto labirinto;
		private Stanza stanzaAttuale;
		private Map<String, Stanza> stanze;
		
		public LabirintoBuilder(String labirinto) throws FileNotFoundException, FormatoFileNonValidoException {
			this.labirinto=new Labirinto(labirinto);
			this.stanze=new HashMap<>();
		}
		
		public LabirintoBuilder() {
			this.labirinto=new Labirinto();
			this.stanze=new HashMap<>();
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
		public LabirintoBuilder addAdiacenza(Direzione direzione, String stanzaAttuale, String stanzaAdiacente) {
		    Stanza attuale = this.stanze.get(stanzaAttuale);
		    Stanza adiacente = this.stanze.get(stanzaAdiacente);
		    
		    attuale.impostaStanzaAdiacente(direzione, adiacente);
		    Direzione direzioneOpposta = calcolaDirezioneOpposta(direzione);
		    adiacente.impostaStanzaAdiacente(direzioneOpposta, attuale);
		    return this;
		}
		
		/**
		 * Calcola la direzione opposta a quella specificata.
		 * @param direzione la direzione di partenza
		 * @return la direzione opposta
		 */
		private Direzione calcolaDirezioneOpposta(Direzione direzione) {
		    if ("nord".equals(direzione.name())) return Direzione.sud;
		    if ("sud".equals(direzione.name())) return Direzione.nord;
		    if ("est".equals(direzione.name())) return Direzione.ovest;
		    return Direzione.est;
		}
		
		public LabirintoBuilder  addMago(String nome, String presentazione, Attrezzo attrezzo) {
			Mago m = new Mago(nome, presentazione, attrezzo);
			if(this.stanzaAttuale==null)
				return this;
			this.stanzaAttuale.setPersonaggio(m);
			return this;
		}

		public LabirintoBuilder  addCane(String nome, String presentazione) {
			Cane c = new Cane(nome, presentazione);
			if(this.stanzaAttuale==null)
				return this;
			this.stanzaAttuale.setPersonaggio(c);
			return this;
		}

		public LabirintoBuilder  addStrega(String nome, String presentazione) {
			Strega s = new Strega(nome, presentazione);
			if(this.stanzaAttuale==null)
				return this;
			this.stanzaAttuale.setPersonaggio(s);
			return this;
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
		public LabirintoBuilder addStanzaBloccata(String stanzaBloccata, String attrezzoChiave, Direzione direzioneBloccata) {
			Stanza s = new StanzaBloccata(stanzaBloccata,attrezzoChiave,direzioneBloccata);
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

}

