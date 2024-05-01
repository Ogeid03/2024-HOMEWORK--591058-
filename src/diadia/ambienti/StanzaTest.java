package diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import diadia.attrezzi.Attrezzo;

class StanzaTest {
	Stanza S = new Stanza("test");
	Stanza S1 = new Stanza("stanza_adiacente");
	Attrezzo A = new Attrezzo("tastiera", 1);
	Attrezzo B = new Attrezzo("mouse", 1);
	
	@Test
	public void testStanzaAdiacente() {
		S.impostaStanzaAdiacente("nord", S1);
		assertEquals(S1, S.getStanzaAdiacente("nord"));
	}
	
	@Test
	public void testGetStanzaAdiacenteNULL() {
		assertNull(S.getStanzaAdiacente("sud"));
	}
	
	@Test
	public void testAddAttrezzo() {
		S.addAttrezzo(A);
		assertTrue(S.hasAttrezzo("tastiera"));
	}
	
	@Test
	public void testAddTroppiAttrezzi() {
		for(byte i=0; i<10; i++) {
			S.addAttrezzo(A);
		}
		
		S.addAttrezzo(B);
		assertFalse(S.hasAttrezzo("mouse"));
	}
	
	@Test
	public void testHasNOTAttrezzo() {	
		assertFalse(S.hasAttrezzo("test"));
	}

}
