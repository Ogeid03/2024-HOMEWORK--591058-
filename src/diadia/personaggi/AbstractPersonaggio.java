package diadia.personaggi;

import diadia.Partita;
import diadia.attrezzi.Attrezzo;

public abstract class AbstractPersonaggio {
	private String nome;
	private String descrizione;
	private boolean haSalutato;
	
	public AbstractPersonaggio(String nome, String descrizione){
		this.nome = nome;
		this.descrizione = descrizione;
		this.haSalutato = false;
	}
	
	public String ComandoSaluta() {
		StringBuilder risposta = new StringBuilder("Ciao, io sono ");
		risposta.append(this.getNome()+".");
			if (!haSalutato)
				risposta.append(this.descrizione);
			else
				risposta.append("Ci siamo gia' presentati!");
			this.haSalutato = true;
			return risposta.toString();
	}  
	
	abstract public String agisci(Partita partita);
	
	public String getNome() {
		return this.nome;
	}
	
	public String getDescrizione() {
		return this.descrizione;
	}
	
	public boolean haSalutato() {
		return this.haSalutato;
	}
	
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		return null;
	}
	
	@Override
	public String toString() {
		return this.getNome();
	}
}
