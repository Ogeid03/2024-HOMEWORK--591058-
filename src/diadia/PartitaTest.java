package diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import diadia.ambienti.Labirinto;

class PartitaTest {
	IO io = new IOConsole();
	Labirinto labirinto = new Labirinto();
	Partita game = new Partita(io, labirinto);
	
	@Test
	public void testIsFinitaFinita(){
		game.setFinita();
		assertTrue(game.isFinita());
	}
	
	@Test
	public void testIsNotFinita(){
		assertFalse(game.isFinita());
	}
	
	@Test
	public void testIsFinitaVinta() {
		game.getLabirinto().setStanzaCorrente(game.getLabirinto().getStanzaVincente());
		assertTrue(game.isFinita());
	}
	
	@Test
	public void testIsFinitaNOCFU(){
		game.getPlayer().setCFU(0);
		assertTrue(game.isFinita());
	}
	
	@Test
	public void testIsVinta() {
		game.getLabirinto().setStanzaCorrente(game.getLabirinto().getStanzaVincente());
		assertTrue(game.vinta());
	}
	
	@Test
	public void testIsNOTVinta() {
		assertFalse(game.vinta());
	}
	

}
