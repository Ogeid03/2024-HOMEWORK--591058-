package diadia;


import diadia.ambienti.Stanza;


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
	
	static final private String[] elencoComandi = {"vai", "prendi", "posa", "aiuto", "fine"};

	Partita partita;
	IOConsole IO;
	private boolean flag = false;;

	public DiaDia(IOConsole io) {
		this.partita = new Partita();
		this.IO = io;
	}
	
	public DiaDia() {
		this.partita = new Partita();
		this.IO = new IOConsole();
	}

	public void gioca() {
		String istruzione; 

		IO.mostraMessaggio(MESSAGGIO_BENVENUTO);		
		do {		
			if(this.flag == true) IO.mostraMessaggio(MESSAGGIO_AIUTO);
			istruzione = IO.leggiRiga();
		}while (!processaIstruzione(istruzione));
	}   


	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {
		Comando comandoDaEseguire = new Comando(istruzione);
		this.flag = true;
		if (comandoDaEseguire.sconosciuto()) {
	        IO.mostraMessaggio(istruzione);
	        return false;
		}
		if (comandoDaEseguire.getNome().equals("fine")) { 
			this.fine(); 
			return true;
		} else if (comandoDaEseguire.getNome().equals("vai")) {
			this.vai(comandoDaEseguire.getParametro());			
		}
		else if (comandoDaEseguire.getNome().equals("aiuto")) {
			this.flag = false;
			this.aiuto();
		}
		else if(comandoDaEseguire.getNome().equals("prendi")) 
			this.prendi(comandoDaEseguire.getParametro());
		else if(comandoDaEseguire.getNome().equals("posa")) 
			this.posa(comandoDaEseguire.getParametro());
		else
			IO.mostraMessaggio("Comando sconosciuto");
		if (this.partita.vinta()) {
			IO.mostraMessaggio("\n\n🏆 Hai vinto! 🏆");
			return true;
		} else
			return false;
	}   

	// implementazioni dei comandi dell'utente:

	/**
	 * Stampa informazioni di aiuto.
	 */
	private void aiuto() {
		IO.mostraMessaggio("\nI comandi sono: ");
		for(int i=0; i< elencoComandi.length; i++) 
			IO.mostraMessaggioInLinea(elencoComandi[i] + " ");
		IO.mostraMessaggio("");
	}

	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
	private void vai(String direzione) {
		if(direzione==null)
			IO.mostraMessaggio("\n--> Dove vuoi andare ? (prova con: vai nome_direzione)");
		Stanza prossimaStanza = null;
		prossimaStanza = this.partita.getLabirinto().getStanzaCorrente().getStanzaAdiacente(direzione);
		if (prossimaStanza == null)
			IO.mostraMessaggio("       (Direzione inesistente)");
		else {
			this.partita.getLabirinto().setStanzaCorrente(prossimaStanza);
			int cfu = this.partita.getPlayer().getCFU();
			this.partita.getPlayer().setCFU(cfu--);
		}
		if(partita.getLabirinto().getStanzaCorrente() != partita.getLabirinto().getStanzaVincente())
			IO.mostraMessaggio("\nTu sei qui: " + partita.getLabirinto().getStanzaCorrente().getDescrizione()); 
	}
	
	/**
	 * Mette l'oggetto presente nella borsa del giocatore nella stanza
	 * @param attrezzo
	 */
	void prendi(String attrezzo) {
		if(attrezzo==null)
			IO.mostraMessaggio("\n--> Quale attrezzo vuoi prendere ? (prova con: prendi nome_attrezzo)");
		if(this.partita.getLabirinto().getStanzaCorrente().getAttrezzi()[0]!=null) { 
		  if(this.partita.getLabirinto().getStanzaCorrente().hasAttrezzo(attrezzo)==true) {
			  
			  this.partita.getPlayer().getZaino().addAttrezzo(this.partita.getLabirinto().getStanzaCorrente().getAttrezzo(attrezzo));
			  this.partita.getLabirinto().getStanzaCorrente().removeAttrezzo(attrezzo);
			  
			  IO.mostraMessaggio("\n" + partita.getPlayer().getZaino().getDescrizione()); 
			  
		  } else {
			  IO.mostraMessaggio("       (Attrezzo inesistente)\n" + this.partita.getLabirinto().getStanzaCorrente().getDescrizioneAttrezzi());
		    }
		}else IO.mostraMessaggio("Non ci sono attrezzi nella stanza");		
	}
	
	/**
	 * Mette l'oggetto presente nella stanza nella borsa del giocatore
	 * @param attrezzo
	 */
	void posa(String attrezzo) {
		if(attrezzo==null)
			IO.mostraMessaggio("\n--> Quale Attrezzo vuoi posare ? (prova con: posa nome_attrezzo)");
		if(this.partita.getPlayer().getZaino().getAttrezzi()[0]!=null) {
		  if(this.partita.getPlayer().getZaino().hasAttrezzo(attrezzo)==true) {
			  this.partita.getLabirinto().getStanzaCorrente().addAttrezzo(this.partita.getPlayer().getZaino().getAttrezzo(attrezzo));
			  this.partita.getPlayer().getZaino().removeAttrezzo(attrezzo);
			  
			  IO.mostraMessaggio("\n" + partita.getPlayer().getZaino().getDescrizione());
		  } else {
			  IO.mostraMessaggio("       (Attrezzo inesistente)\n" + partita.getPlayer().getZaino().getDescrizione());
		    }
		} else IO.mostraMessaggio("Non ci sono attrezzi nella borsa");		;
	}

	/**
	 * Comando "Fine".
	 */
	private void fine() {
		IO.mostraMessaggio("\n\nGAME OVER\nGrazie di aver giocato!");  // si desidera smettere
	}

	public static void main(String[] argc) {
		IOConsole IO = new IOConsole();
		DiaDia gioco = new DiaDia(IO);
		gioco.gioca();
	}
}