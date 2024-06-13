package diadia.comandi;

import diadia.Partita;
import diadia.ambienti.Labirinto;

/**
 * Questa classe modella un comando di gioco.
 * Richiamando il metodo ESEGUI viene mostrato in output il
 * messaggio "Comando Sconosciuto".
 * 
 * @author Diego De Martino
 * @see Labirinto
 * @see Borsa
 * @version base 4.0
 */
public class ComandoNonValido extends AbstractComando{
	private final static String NOME = "comandoNonValido";

	
	@Override
	public void esegui(Partita partita) {
		partita.getIO().mostraMessaggio("Comando sconosciuto");
	}	
	
	@Override
	public String getNome() {
		return NOME;
	}

	

}
