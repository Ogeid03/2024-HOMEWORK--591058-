package diadia.comandi;

import diadia.IO;
import diadia.Partita;

public abstract class AbstractComando implements Comando{

	private IO io;
	private String parametro;
	private final static String NOME = "AbstractComando";
	
	public AbstractComando() {}
	
	abstract public void esegui(Partita partita);
	

	@Override
	public String getParametro() {
		return this.parametro;
	}
	
	@Override
	public void setParametro(String parametro) {
		this.parametro  = parametro;
	}

	@Override
	public void setIo(IO io) {
		this.io = io;
	}

	public IO getIo() {
		return io;
	}

	@Override
	public String getNome() {
		return NOME;
	}
}
