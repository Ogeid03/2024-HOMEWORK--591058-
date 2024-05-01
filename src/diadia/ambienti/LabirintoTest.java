package diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import diadia.IO;
import diadia.IOConsole;
import diadia.Partita;

class LabirintoTest {
	IO io = new IOConsole();
	Partita game = new Partita(io);
	Stanza S = new Stanza("test");

	@Test
	public void testLabirintoStanzaVincente() {
		assertEquals("Biblioteca", game.getLabirinto().getStanzaVincente().getNome());
	}
	
	@Test
	public void testStanzaCorrente() {
		game.getLabirinto().setStanzaCorrente(S);
		assertEquals(S, game.getLabirinto().getStanzaCorrente());
	}
}
