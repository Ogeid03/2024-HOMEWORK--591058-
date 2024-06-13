package diadia.comandi;

import diadia.Partita;
import diadia.ambienti.Labirinto;

/**
 * Questa classe modella un comando di gioco.
 * Richiamando il metodo ESEGUI viene spostato l'ATTREZZO
 * passato come PARAMETRO dalla STANZA alla BORSA del
 * GIOCATORE.
 * 
 * @author Diego De Martino
 * @see Labirinto
 * @see Borsa
 * @version base 4.0
 */
public class ComandoPrendi extends AbstractComando{
	
	private String attrezzo;
	private final static String NOME = "prendi";
	
	public ComandoPrendi() {}
	
	public ComandoPrendi(String param) {
		this.attrezzo = param;
	}
	
	/**
	* esecuzione del comando
	* Mette l'oggetto presente nella borsa del giocatore nella stanza
	* 
	*/
	@Override
	public void esegui(Partita partita) {
		
		if(this.attrezzo == null) {
			partita.getIO().mostraMessaggio("Quale attrezzo vuoi prendere ? (Devi specificare un Attrezzo)");
			return;
		}
		if(partita.getLabirinto().getStanzaCorrente().getAttrezzi().size() != 0) { 
			 if(partita.getLabirinto().getStanzaCorrente().hasAttrezzo(this.attrezzo)==true) {
				  
				 partita.getPlayer().getZaino().addAttrezzo(partita.getLabirinto().getStanzaCorrente().getAttrezzo(this.attrezzo));
				 partita.getLabirinto().getStanzaCorrente().removeAttrezzo(this.attrezzo);
				  
				 partita.getIO().mostraMessaggio("\n" + partita.getPlayer().getZaino().getDescrizione());
				  
			 } else {
				 partita.getIO().mostraMessaggio("ATTREZZO INESISTENTE" + partita.getLabirinto().getStanzaCorrente().getDescrizioneAttrezzi());
			 }
		}else partita.getIO().mostraMessaggio("Non ci sono attrezzi nella stanza");	
	}
		
	
	@Override
	public String getNome() {
		return NOME;
	}

}
