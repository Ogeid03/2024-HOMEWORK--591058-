package diadia.comandi;

import diadia.IO;
import diadia.IOConsole;
import diadia.Partita;
import diadia.ambienti.Labirinto;
import diadia.attrezzi.Attrezzo;

/**
 * Questa classe modella un comando di gioco.
 * Richiamando il metodo ESEGUI viene effettuato uno scambio di ATTREZZI tra
 * il GIOCATORE e un PERSONAGGIO
 * 
 * @author Diego De Martino
 * @see Labirinto
 * @see Borsa
 * @version base 4.0
 */
public class ComandoRegala extends AbstractComando{
	private IO io = new IOConsole();

	public ComandoRegala() {}
	
	@Override
	public void esegui(Partita partita) {
		if(partita.getLabirinto().getStanzaCorrente().getPersonaggio() != null) {
			Attrezzo attrezzo = partita.getPlayer().getZaino().getAttrezzo(this.getParametro());
			io.mostraMessaggio(partita.getLabirinto().getStanzaCorrente().getPersonaggio().riceviRegalo(attrezzo, partita));
			partita.getPlayer().getZaino().removeAttrezzo(this.getParametro());
		} else io.mostraMessaggio("Non c'è nessuno qui...");
	}

	@Override
	public void setIo(IO io) {
		this.io = io;
	}
}
