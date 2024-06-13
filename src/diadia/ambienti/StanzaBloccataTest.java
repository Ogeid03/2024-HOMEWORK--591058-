package diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import diadia.attrezzi.Attrezzo;

class StanzaBloccataTest {
	
	Direzione dir = Direzione.nord;
	StanzaBloccata stanza = new StanzaBloccata("test", "chiave", dir);
	Stanza stanza1 = new Stanza("test1");
	
	Attrezzo chiave = new Attrezzo("chiave", 1);
	
	
	@BeforeEach
	public void init() {
		stanza.impostaStanzaAdiacente(dir, stanza1);
		stanza1.impostaStanzaAdiacente(Direzione.sud, stanza);
	}
	
	@Test
	void testGetStanzaAdiacente() {
		stanza.addAttrezzo(chiave);
		assertEquals(stanza1, stanza.getStanzaAdiacente(dir));
	}
	
	@Test
	void testGetStanzaAdiacenteNull() {
		stanza.addAttrezzo(chiave);
		assertNull(stanza.getStanzaAdiacente(Direzione.sud));
	}
	
	@Test
	void testGetStanzaAdiacenteNoKey() {
		assertEquals(stanza, stanza.getStanzaAdiacente(dir));
	}

}
