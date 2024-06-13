package diadia.ambienti;

import diadia.attrezzi.Attrezzo;

/**
 * Classe StanzaBloccata - una stanza speciale in un gioco di ruolo.
 * Una stanza e' un luogo fisico nel gioco.
 * E' collegata ad altre stanze attraverso delle uscite.
 * Ogni uscita e' associata ad una direzione.
 * 
 * Nel caso specifico di questa tipologia di stanze una/più delle stanze adiacenti
 * può/possono risultare bloccate e accessibili solo se presente un determinato
 * oggetto nella BORSA del PERSONAGGIO.
 * 
 * @author docente di POO, Diego De Martino
 * @see Attrezzo
 * @see Stanza
 * @version base 4.0
*/
public class StanzaBloccata extends Stanza{
	private String KEY;
	private Direzione lockedDoor;
	
	public StanzaBloccata(String nome, String chiave, Direzione direzioneBloccata) {
		super(nome);
		this.KEY = chiave;
		this.lockedDoor = direzioneBloccata;
	}
	
	public String getKey() {
		return this.KEY;
	}
	public void setKey(String KEY) {
		this.KEY = KEY;
	}
	public Direzione getLockedDoor() {
		return this.lockedDoor;
	}
	public void setLockedDoor(Direzione lockedDoor) {
		this.lockedDoor = lockedDoor;
	}
	
	@Override
	public Stanza getStanzaAdiacente(Direzione direzione) {
		if(direzione.equals(this.lockedDoor) && !(this.hasAttrezzo(this.KEY))) 
			return this;
		Stanza stanza = null;
		if (this.Direzione_stanzeAdiacenti.containsKey(direzione))
			stanza = this.Direzione_stanzeAdiacenti.get(direzione);
		return stanza;
	}
	
	@Override
	public String toString() {
		StringBuilder risultato = new StringBuilder();
    	risultato.append(this.getNome());
    	risultato.append("\nUscite: ");
    	for (Direzione direzione : this.getDirezioni()) {
    		if(direzione.equals(this.lockedDoor))
    			risultato.append(" " + direzione + "_(Bloccato)");
    		else if (direzione!=null)
    			risultato.append(" " + direzione);
    	}	
    	risultato.append("\n" + this.getDescrizioneAttrezzi());
    	
    	return risultato.toString();
	}
}
