package diadia.giocatore;

import diadia.attrezzi.Attrezzo;

public class Borsa {
	
	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	private static int NUMERO_MASSIMO_ATTREZZI = 10;
	private int numeroAttrezzi;
	private Attrezzo[] slots;
	private int pesoMax;
	
	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
	}
	
	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.slots = new Attrezzo[NUMERO_MASSIMO_ATTREZZI]; // speriamo bastino...
		this.numeroAttrezzi = 0;
	}
	
	/**
     * Restituisce la collezione di attrezzi presenti nella borsa.
     * @return la collezione di attrezzi nella borsa.
     */
    public Attrezzo[] getAttrezzi() {
        return this.slots;
    }

    /**
     * Mette un attrezzo nella borsa.
     * @param attrezzo l'attrezzo da mettere nella borsa.
     * @return true se riesce ad aggiungere l'attrezzo, false atrimenti.
     */
    public boolean addAttrezzo(Attrezzo attrezzo) {
    	if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
    		return false;
    	if (this.numeroAttrezzi==10)
    		return false;
    	this.slots[this.numeroAttrezzi] = attrezzo;
    	this.numeroAttrezzi++;
    	return true;
    }
    
    public int getPesoMax() {
    	return pesoMax;
    }
    
    public int getPeso() {
    	int peso = 0;
    	for (int i= 0; i<this.numeroAttrezzi; i++)
    		if(this.slots[i]!=null)
    			peso += this.slots[i].getPeso();

    	return peso;
    }
    
    public boolean isEmpty() {
    	return this.numeroAttrezzi == 0;
    }
    
    /**
	* Controlla se un attrezzo esiste nella borsa (uguaglianza sul nome).
	* @return true se l'attrezzo esiste nella borsa, false altrimenti.
	*/
	public boolean hasAttrezzo(String nomeAttrezzo) {
		boolean trovato;
		trovato = false;
	    for (Attrezzo attrezzo : this.slots) {
	    	if(attrezzo!=null)
	    	 if (attrezzo.getNome().equals(nomeAttrezzo))
				trovato = true;
		}
		return trovato;
	}

	/**
     * Restituisce l'attrezzo nomeAttrezzo se presente nella borsa.
	 * @param nomeAttrezzo
	 * @return l'attrezzo presente nella borsa.
     * 		   null se l'attrezzo non e' presente.
	 */
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo attrezzoCercato;
		attrezzoCercato = null;
		for (Attrezzo attrezzo : this.slots) {
			if(attrezzo!=null)
				if (attrezzo.getNome().equals(nomeAttrezzo))
					attrezzoCercato = attrezzo;
		}
		return attrezzoCercato;	
	}

	/**
	 * Rimuove un attrezzo dalla borsa (ricerca in base al nome).
	 * @param nomeAttrezzo
	 * @return true se l'attrezzo e' stato rimosso, false altrimenti
	 */
	public boolean removeAttrezzo(String attrezzo) {
		for(int i=0;i<NUMERO_MASSIMO_ATTREZZI;i++) {
			if(attrezzo.equals(this.slots[i].getNome())) {
				this.slots[i]=null;
				for(int j=i; j<NUMERO_MASSIMO_ATTREZZI-1;j++) this.slots[j]=this.slots[j+1];
				this.slots[NUMERO_MASSIMO_ATTREZZI-1]=null;
				this.numeroAttrezzi--;
				return true;
			}
		}
		return false;
	}
	
	/**
	* Restituisce una rappresentazione stringa di questa borsa,
	* stampadone gli eventuali attrezzi contenuti
	* @return la rappresentazione stringa
	*/
    public String toString() {
    	StringBuilder s = new StringBuilder();
    	if (!this.isEmpty()) {
    		s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
    		for (int i= 0; i<this.numeroAttrezzi; i++) s.append(slots[i].toString()+" ");
    	}
    	else s.append("Borsa vuota");
    	return s.toString();
    }
    
    public String getDescrizione() {
		return this.toString();	
	}

}
