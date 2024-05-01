package diadia.comandi;

import diadia.Partita;

public class ComandoFine implements Comando {
	
	@Override
	public void esegui(Partita partita) {
		partita.getIO().mostraMessaggio("\n\nGAME OVER\nGrazie di aver giocato!");  // si desidera smettere
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
