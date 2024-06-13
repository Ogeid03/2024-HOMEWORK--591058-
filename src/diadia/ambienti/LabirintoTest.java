package diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import diadia.ambienti.Labirinto.LabirintoBuilder;

class LabirintoTest {
	static Labirinto labirinto;
	

	@BeforeEach
	public void init() {
		labirinto = new LabirintoBuilder().addStanzaIniziale("LabCampusOne")
				.addStanzaVincente("Biblioteca")
				.addAdiacenza(Direzione.ovest, "LabCampusOne","Biblioteca")
				.getLabirinto();
	}
	
	@Test
	public void testLabirintoStanzaVincente() {
		assertEquals("Biblioteca", labirinto.getStanzaVincente().getNome());
	}
	
	@Test
	public void testStanzaCorrente() {
		assertEquals("LabCampusOne", labirinto.getStanzaCorrente().getNome());
	}
}
