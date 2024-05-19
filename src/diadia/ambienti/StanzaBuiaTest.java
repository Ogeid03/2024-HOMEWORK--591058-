package diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import diadia.attrezzi.Attrezzo;

class StanzaBuiaTest {

	StanzaBuia stanza = new StanzaBuia("test", "lumino");
	Attrezzo light = new Attrezzo("lumino", 1);
	
	
	@BeforeEach
	public void init() {
		
	}
	
	@Test
	void testToString() {
		stanza.addAttrezzo(light);
		System.out.println(stanza.toString());
		assertEquals("test\n" + "Uscite: \n"+ "Attrezzi nella stanza: lumino (1kg); ", 
				stanza.toString());
	}
	
	@Test
	void testToStringBuio() {
		assertEquals("Qui c'è buio pesto...", 
				stanza.toString());
	}

}
