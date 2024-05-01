package diadia;


import diadia.comandi.Comando;
import diadia.comandi.FabbricaDiComandiFisarmonica;


/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO, Diego De Martino
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *          
 * @version base 1.0.0
 */

public class DiaDia { 
	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";
	
	static final private String MESSAGGIO_AIUTO = "\n\nPer conoscere le istruzioni usa il comando 'aiuto'.";

	Partita partita;
	IO iO;
	private boolean flag = false;;

	public DiaDia(IO io) {
		this.iO = io;
		this.partita = new Partita(iO);
	}
	
	public DiaDia() {
		this.iO = new IOConsole();
		this.partita = new Partita(iO);
	}

	public void gioca() {
		String istruzione; 

		iO.mostraMessaggio(MESSAGGIO_BENVENUTO);		
		do {		
			if(this.flag == true) iO.mostraMessaggio(MESSAGGIO_AIUTO);
			istruzione = iO.leggiRiga();
		}while (!processaIstruzione(istruzione));
	}   

	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {
		
		Comando comandoDaEseguire;
		FabbricaDiComandiFisarmonica factory = new FabbricaDiComandiFisarmonica();
		comandoDaEseguire = factory.costruisciComando(istruzione);
		comandoDaEseguire.esegui(this.partita);
		if (this.partita.vinta())
			iO.mostraMessaggio("\n\n🏆 Hai vinto! 🏆");
		if (!this.partita.giocatoreIsVivo())
			iO.mostraMessaggio("\n\nGAME OVER\nHai esaurito i CFU...");

		return this.partita.isFinita();
	}   
	
	public static void main(String[] argc) {
		IO io = new IOConsole();
		DiaDia gioco = new DiaDia(io);
		gioco.gioca();
	}
}