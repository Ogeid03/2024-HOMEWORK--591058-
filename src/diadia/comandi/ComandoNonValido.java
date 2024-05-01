package diadia.comandi;

import diadia.Partita;

public class ComandoNonValido implements Comando{
	
	
	@Override
	public void esegui(Partita partita) {
		partita.getIO().mostraMessaggio("Comando sconosciuto");
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
