package diadia.ambienti;
import diadia.attrezzi.Attrezzo;

/**
 * Classe StanzaMagica - una stanza speciale in un gioco di ruolo.
 * Una stanza e' un luogo fisico nel gioco.
 * E' collegata ad altre stanze attraverso delle uscite.
 * Ogni uscita e' associata ad una direzione.
 * 
 * Nel caso specifico di questa tipologia di stanze gli ATTREZZI 
 * possono variare in base alle azioni del PERSONAGGIO.
 * 
 * @author docente di POO, Diego De Martino
 * @see Attrezzo
 * @see Stanza
 * @version base 3.1
*/
public class StanzaMagica extends Stanza{
	
	final static private int SOGLIA_MAGICA_DEFAULT = 3;
	private int contatoreAttrezziPosati;
	private int sogliaMagica;
	
	public StanzaMagica(String nome) {
		this(nome, SOGLIA_MAGICA_DEFAULT);
	}
	
	public StanzaMagica(String nome, int soglia) {
		super(nome);
		this.contatoreAttrezziPosati = 0;
		this.sogliaMagica = soglia;
	}
	
	/**
	 * Sovrascrizione dell'omonimo metodo della classe Stanza
	 * in cui se vengono aggiunti e quindi posati più ATTREZZI rispetto 
	 * ad una SOGLIA_MAGICA questi ultimi in "eccesso" subiranno delle variazioni
	 * @return true se viene aggiunto l'ATTREZZO alla STANZA, false altrimenti
	 */
	@Override
	public boolean addAttrezzo(Attrezzo attrezzo) {
		this.contatoreAttrezziPosati++;
		if (this.contatoreAttrezziPosati>this.sogliaMagica)
			attrezzo = this.modificaAttrezzo(attrezzo);
		if (this.numeroAttrezzi<this.attrezzi.size()) {
			this.attrezzi.put(attrezzo.getNome(), attrezzo);
			this.numeroAttrezzi++;
			return true;

			}
		else return false;
	}
	
	/**
	 * Restituisce un ATTREZZO modificato delle sue caratteristiche 
	 * @return ATTREZZO con doppio del PESO e NOME invertito
	 */
	private Attrezzo modificaAttrezzo(Attrezzo attrezzo) {
		StringBuilder nomeInvertito;
		int pesoX2 = attrezzo.getPeso() * 2;
		nomeInvertito = new StringBuilder(attrezzo.getNome());
		nomeInvertito = nomeInvertito.reverse();
		attrezzo = new Attrezzo(nomeInvertito.toString(),
		pesoX2);
		return attrezzo;
	}

}
