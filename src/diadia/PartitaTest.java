package diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import diadia.ambienti.Labirinto;
import diadia.ambienti.LabirintoBuilder;

class PartitaTest {
	IO io = new IOConsole();
	Labirinto labirinto;
	Partita game;
	
	@BeforeEach
	public void init() {
		this.labirinto = new LabirintoBuilder()
				.addStanzaIniziale("LabCampusOne")
				.addStanzaVincente("Biblioteca")
				.addAdiacenza("ovest", "LabCampusOne","Biblioteca")
				.getLabirinto();
		this.game = new Partita(io, labirinto);
	}
	
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
		labirinto.setStanzaCorrente(labirinto.getStanzaVincente());
		assertTrue(game.isFinita());
	}
	
	@Test
	public void testIsFinitaNOCFU(){
		game.getPlayer().setCFU(0);
		assertTrue(game.isFinita());
	}
	
	@Test
	public void testIsVinta() {
		labirinto.setStanzaCorrente(labirinto.getStanzaVincente());
		assertTrue(game.vinta());
	}
	
	@Test
	public void testIsNOTVinta() {
		assertFalse(game.vinta());
	}
	

}
