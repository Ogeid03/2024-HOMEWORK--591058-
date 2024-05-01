package diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FabbricaDiComandiFisarmonicaTest {

	FabbricaDiComandiFisarmonica fab = new FabbricaDiComandiFisarmonica();
	
	@Test
	void testComandoVai() {
		assertTrue(fab.costruisciComando("vai") instanceof ComandoVai);
	}
	
	@Test
	void testComandoPrendi() {
		assertTrue(fab.costruisciComando("prendi") instanceof ComandoPrendi);
	}
	
	@Test
	void testComandoPosa() {
		assertTrue(fab.costruisciComando("posa") instanceof ComandoPosa);
	}
	
	@Test
	void testComandoAiuto() {
		assertTrue(fab.costruisciComando("aiuto") instanceof ComandoAiuto);
	}
	
	@Test
	void testComandoFine() {
		assertTrue(fab.costruisciComando("fine") instanceof ComandoFine);
	}
	
	@Test
	void testComandoGuarda() {
		assertTrue(fab.costruisciComando("guarda") instanceof ComandoGuarda);
	}
	
	@Test
	void testComandoNull() {
		assertTrue(fab.costruisciComando("else&alsoNull") instanceof ComandoNonValido);
	}

}
