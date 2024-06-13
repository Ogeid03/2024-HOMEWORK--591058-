package diadia.comandi;

import diadia.IO;
import diadia.IOConsole;
import diadia.Partita;
import diadia.personaggi.AbstractPersonaggio;

/**
 * Questa classe modella un comando di gioco.
 * Richiamando il metodo ESEGUI viene gestita l'interazione tra il 
 * GIOCATORE e un PERSONAGGIO.
 * 
 * @author Diego De Martino
 * @version base 4.0
 */
public class ComandoInteragisci extends AbstractComando {
	private static final String MESSAGGIO_CON_CHI = "Con chi dovrei interagire?... Non c'è nessuno...";
	private String messaggio;
	private IO io = new IOConsole();
	
	public ComandoInteragisci() {}
	
	@Override
	public void esegui(Partita partita) {
		AbstractPersonaggio personaggio;
		personaggio = partita.getLabirinto().getStanzaCorrente().getPersonaggio();
		if (personaggio!=null) {
			this.messaggio = personaggio.agisci(partita);
			io.mostraMessaggio(this.messaggio);

		} else io.mostraMessaggio(MESSAGGIO_CON_CHI);
	}	
	
	public String getMessaggio() {
		return this.messaggio;
	}
	
	@Override
	public void setParametro(String parametro) {}
	}
