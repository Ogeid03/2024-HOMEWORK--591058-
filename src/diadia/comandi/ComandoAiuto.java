package diadia.comandi;

import diadia.Partita;

public class ComandoAiuto implements Comando {
	static final private String[] elencoComandi = {"vai", "prendi", "posa", "guarda", "aiuto", "fine"};
	//private IOConsole IO = new IOConsole();
	
	@Override
	public void esegui(Partita partita) {
		partita.getIO().mostraMessaggio("\nI comandi sono: ");
		for(int i=0; i< elencoComandi.length; i++) 
			partita.getIO().mostraMessaggioInLinea(elencoComandi[i] + " ");
		partita.getIO().mostraMessaggio("");
	}
	
	@Override
	public void setParametro(String param) {
		//auto-generated
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
