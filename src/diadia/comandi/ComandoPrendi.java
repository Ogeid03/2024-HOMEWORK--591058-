package diadia.comandi;

import diadia.Partita;

public class ComandoPrendi implements Comando{
	
	private String attrezzo;
	
	public ComandoPrendi(String param) {
		this.attrezzo = param;
	}

	/**
	* esecuzione del comando
	* 
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
	public void setParametro(String param) {
		this.attrezzo = param;
	}
	
	@Override
	public String getParametro() {
		return null;
	}
	
	@Override
	public String getNome() {
		return null;
	}

}
