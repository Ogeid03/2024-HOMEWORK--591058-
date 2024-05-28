package diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LabirintoTest {
	static Labirinto labirinto;
	

	@BeforeEach
	public void init() {
		labirinto = new LabirintoBuilder().addStanzaIniziale("LabCampusOne")
				.addStanzaVincente("Biblioteca")
				.addAdiacenza("ovest", "LabCampusOne","Biblioteca")
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
