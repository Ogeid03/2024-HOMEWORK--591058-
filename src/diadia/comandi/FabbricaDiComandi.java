package diadia.comandi;

public interface FabbricaDiComandi {
	public Comando costruisciComando(String istruzione)
		throws Exception;
}