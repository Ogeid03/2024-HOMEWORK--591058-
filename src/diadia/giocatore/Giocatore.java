package diadia.giocatore;

/**
 * Classe Giocatore - un giocatore per un gioco di ruolo.
 *  
 * @author Diego De Martino
 * @see Borsa
 * @version base 4.0
*/
public class Giocatore {
	
	static final private int CFU_INIZIALI = 20;
	
	private Borsa zaino = new Borsa();
	private int cfu = 0;
	
	public Giocatore() {
		this.cfu=CFU_INIZIALI;
	}
	
	public int getCFU() {
		return this.cfu;
	}
	
	public void setCFU(int cfu) {
		this.cfu = cfu;		
	}
	
	public Borsa getZaino() {
		return this.zaino;	
	}
	
}
