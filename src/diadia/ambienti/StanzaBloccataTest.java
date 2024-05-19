package diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import diadia.attrezzi.Attrezzo;

class StanzaBloccataTest {
	
	StanzaBloccata stanza = new StanzaBloccata("test", "chiave", "nord");
	Stanza stanza1 = new Stanza("test1");
	
	Attrezzo chiave = new Attrezzo("chiave", 1);
	
	
	@BeforeEach
	public void init() {
		stanza.impostaStanzaAdiacente("nord", stanza1);
		stanza1.impostaStanzaAdiacente("sud", stanza);
	}
	
	@Test
	void testGetStanzaAdiacente() {
		stanza.addAttrezzo(chiave);
		assertEquals(stanza1, stanza.getStanzaAdiacente("nord"));
	}
	
	@Test
	void testGetStanzaAdiacenteNull() {
		stanza.addAttrezzo(chiave);
		assertNull(stanza.getStanzaAdiacente("sud"));
	}
	
	@Test
	void testGetStanzaAdiacenteNoKey() {
		assertEquals(stanza, stanza.getStanzaAdiacente("nord"));
	}

}
