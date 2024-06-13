package diadia.comandi;

import diadia.Partita;

public class ConcreteComando extends AbstractComando{

	public final static String MESSAGGIO= "Grazie di aver giocato!";
	private final static String NOME = "ConcreteComando";

	@Override
	public void esegui(Partita partita) {
		partita.setFinita();
	}

	@Override
	public String getNome() {
		return NOME;
	}

}
