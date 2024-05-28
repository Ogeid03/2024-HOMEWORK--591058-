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
 * @version base 3.1
 */
public class ComandoNonValido implements Comando{
	
	
	@Override
	public void esegui(Partita partita) {
		partita.getIO().mostraMessaggio("Comando sconosciuto");
	}	
	
	@Override
	public void setParametro(String param) {
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
