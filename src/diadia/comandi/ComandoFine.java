package diadia.comandi;

import diadia.Partita;

public class ComandoFine extends AbstractComando {
	private final static String NOME = "fine";
	
	public ComandoFine() {}
	
	@Override
	public void esegui(Partita partita) {
		partita.getIO().mostraMessaggio("\n\nGAME OVER\nGrazie di aver giocato!");  // si desidera smettere
	}
	
	@Override
	public String getNome() {
		return NOME;
	}

}
