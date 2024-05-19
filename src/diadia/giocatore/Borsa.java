package diadia.giocatore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

import diadia.attrezzi.Attrezzo;


/**
 * Classe Borsa 
 * La borsa contiene tutti gli attrezzi che un giocatore vuole raccogliere
 * entro il limite di peso
 * 
 * @author docente di POO, Diego De Martino
 * @see Attrezzo
 * @see Giocatore
 * @version base 1.0
*/
public class Borsa {
	
	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	//private static int NUMERO_MASSIMO_ATTREZZI = 10;
	//private int numeroAttrezzi;
	//private Attrezzo[] slots;
	private Map<String, Attrezzo> slots;
	private int pesoMax;
	
	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
	}
	
	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.slots = new TreeMap<>(); // speriamo bastino...
		//this.numeroAttrezzi = 0;
	}
	
	/**
     * Restituisce la collezione di attrezzi presenti nella borsa.
     * @return la collezione di attrezzi nella borsa.
     */
    public Map<String, Attrezzo> getAttrezzi() {
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
    	this.slots.put(attrezzo.getNome(), attrezzo);
    	//this.numeroAttrezzi++;
    	return true;
    }
    
    public int getPesoMax() {
    	return pesoMax;
    }
    
    public int getPeso() {
    	int peso = 0;
    	for (Map.Entry<String, Attrezzo> attrezzo : this.slots.entrySet())
    			peso += attrezzo.getValue().getPeso();

    	return peso;
    }
    
    public boolean isEmpty() {
    	return this.slots.size() == 0;
    }
    
    /**
	* Controlla se un attrezzo esiste nella borsa (uguaglianza sul nome).
	* @return true se l'attrezzo esiste nella borsa, false altrimenti.
	*/
	public boolean hasAttrezzo(String nomeAttrezzo) {
		boolean trovato;
		trovato = false;
	    	if (this.slots.containsKey(nomeAttrezzo))
	    		trovato = true;
		
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
		if (this.slots.containsKey(nomeAttrezzo))
			attrezzoCercato = this.slots.get(nomeAttrezzo);
		return attrezzoCercato;	
	}

	/**
	 * Rimuove un attrezzo dalla borsa (ricerca in base al nome).
	 * @param nomeAttrezzo
	 * @return true se l'attrezzo e' stato rimosso, false altrimenti
	 */
	public boolean removeAttrezzo(String attrezzo) {
		if(this.slots.containsKey(attrezzo)) {
			this.slots.remove(attrezzo);
			return true;
		}
		return false;
	}
	
	public List<Attrezzo> getContenutoOrdinatoPerPeso (){
		List<Attrezzo> contenutoOrdinato = new ArrayList<>();
		Collections.sort(contenutoOrdinato, (a1, a2) -> {
			Integer p1 = a1.getPeso();
			return p1.compareTo(a2.getPeso());
		});
		
		
		contenutoOrdinato.addAll(slots.values());
		return contenutoOrdinato;
	}
	
	public SortedSet<Attrezzo> getContenutoOrdinatoPerNome(){
	
		SortedSet<Attrezzo> contenutoOrdinato = new TreeSet<>(new Comparator<Attrezzo>() {
		
			@Override
			public int compare(Attrezzo a1, Attrezzo a2) {
	        	return a1.getNome().compareTo(a2.getNome());
	    	}
		});

	    contenutoOrdinato.addAll(slots.values());

	    return contenutoOrdinato;
	}
	
	public Map<Integer,Set<Attrezzo>> getContenutoRaggruppatoPerPeso(){
		Map<Integer,Set<Attrezzo>> contenutoOrdinato = new HashMap<>();
		
		for (Attrezzo attrezzo : slots.values()) {
            int peso = attrezzo.getPeso();

            contenutoOrdinato.putIfAbsent(peso, new TreeSet<>());
            contenutoOrdinato.get(peso).add(attrezzo);
        }

        return contenutoOrdinato;
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
    		for (Map.Entry<String, Attrezzo> attrezzo : this.slots.entrySet())
    			s.append(attrezzo.getValue().toString()+" ");
    	}
    	else s.append("Borsa vuota");
    	return s.toString();
    }
    
    public String getDescrizione() {
		return this.toString();	
	}

}
