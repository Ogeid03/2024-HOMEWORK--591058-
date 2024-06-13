package diadia;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import diadia.ambienti.Direzione;
import diadia.ambienti.Labirinto;

class PartitaTest {
	IO io = new IOConsole(new Scanner(System.in));
	Labirinto labirinto;
	Partita game;
	
	@BeforeEach
	public void init() throws FileNotFoundException, FormatoFileNonValidoException {
		this.labirinto =  Labirinto.newLabBuilder("labirinto.txt").getLabirinto();
		this.game = new Partita(io, labirinto);
	}
	
	@Test
	public void testIsFinitaFinita(){
		game.setFinita();
		assertTrue(game.isFinita());
	}
	
	@Test
	public void testIsNotFinita(){
		game.getIO().mostraMessaggio(game.getLabirinto().getStanzaCorrente().toString());
		game.getIO().mostraMessaggio(game.getLabirinto().getStanzaVincente().toString());
		System.out.println(game.getPlayer().getCFU());
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
