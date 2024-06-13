package diadia;

import diadia.ambienti.Labirinto;
import diadia.giocatore.Giocatore;

/**
 * Questa classe modella una partita del gioco
 *
 * @author  docente di POO, Diego De Martino
 * @see Labirinto
 * @see giocatore
 * @see IO
 * @version base 4.0
 */

public class Partita {

	private Labirinto maze;
	private boolean finita;
	private Giocatore player = new Giocatore();
	private IO io;
	

	public Partita(IO io, Labirinto maze) {
		this.finita = false;
		this.io = io;
		this.maze = maze;
	}   

	/**
	 * Restituisce vero se e solo se la partita e' stata vinta
	 * @return vero se partita vinta
	 */
	public boolean vinta() {
		return this.maze.getStanzaCorrente() == maze.getStanzaVincente();
	}

	/**
	 * Restituisce vero se e solo se la partita e' finita
	 * @return vero se partita finita
	 */
	public boolean isFinita() {
		return finita || vinta() || (player.getCFU() == 0);
	}

	/**
	 * Imposta la partita come finita
	 *
	 */
	public void setFinita() {
		this.finita = true;
	}

	public Giocatore getPlayer() {
		return this.player;
	}
	
	public boolean giocatoreIsVivo() {
		if(this.player.getCFU() == 0) return false;
		return true;
	}
	
	public Labirinto getLabirinto() {
		return this.maze;
	}
	
	public IO getIO() {
		return this.io;
	}
}