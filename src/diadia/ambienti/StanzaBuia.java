package diadia.ambienti;

import diadia.attrezzi.Attrezzo;

/**
 * Classe StanzaBuia - una stanza speciale in un gioco di ruolo.
 * Una stanza e' un luogo fisico nel gioco.
 * E' collegata ad altre stanze attraverso delle uscite.
 * Ogni uscita e' associata ad una direzione.
 * 
 * Nel caso specifico di questa tipologia di stanze non sarà possibile visualizzare
 * le stanze adiacenti a meno che non sia presente un determinato
 * oggetto nella STANZA_CORRENTE.
 * 
 * @author docente di POO, Diego De Martino
 * @see Attrezzo
 * @see Stanza
 * @version base 3.1
*/
public class StanzaBuia extends Stanza{
	private String light;
	
	public StanzaBuia(String nome, String AttrezzoLuminoso) {
		super(nome);
		this.light = AttrezzoLuminoso;
	}
	
	public String getLight() {
		return this.light;
	}
	
	public void setLight(String light) {
		this.light = light;
	}
	
	@Override
	public String toString() {
		StringBuilder risultato = new StringBuilder();
		
		if(this.hasAttrezzo(this.light)) {
			risultato.append(this.getNome());
			risultato.append("\nUscite: ");
			for (String direzione : this.getDirezioni())
					risultato.append(" " + direzione);
			risultato.append("\n" + this.getDescrizioneAttrezzi());
		}else risultato.append("Qui c'è buio pesto...");
		
		return risultato.toString();	}
}
