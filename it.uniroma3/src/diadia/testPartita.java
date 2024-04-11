package diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class testPartita {
	
	Partita game = new Partita();
	
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
