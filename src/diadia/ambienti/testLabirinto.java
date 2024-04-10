package diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import diadia.Partita;

class testLabirinto {
	Partita game = new Partita();
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
