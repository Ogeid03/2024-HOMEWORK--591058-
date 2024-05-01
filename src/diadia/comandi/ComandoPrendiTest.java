package diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import diadia.IO;
import diadia.IOConsole;
import diadia.Partita;
import diadia.attrezzi.Attrezzo;

class ComandoPrendiTest {

	IO io = new IOConsole();
	Partita partita = new Partita(io);
	Comando comandoPrendi;
	FabbricaDiComandiFisarmonica factory = new FabbricaDiComandiFisarmonica();
	
	Attrezzo attrezzoTest = new Attrezzo("Vasetto_Nutella", 1);
	String istruzionePrendi = "prendi Vasetto_Nutella";
	
	@Test
	public void testEseguiPrendi() {
		this.partita.getLabirinto().getStanzaCorrente().addAttrezzo(attrezzoTest);
		this.comandoPrendi = factory.costruisciComando(istruzionePrendi);
		this.comandoPrendi.esegui(this.partita);
		
		assertTrue(this.partita.getPlayer().getZaino().hasAttrezzo(this.attrezzoTest.getNome()));
	}
	
	@Test
	public void testEseguiPrendiNullParametro() {
		this.comandoPrendi = factory.costruisciComando("prendi");
		this.comandoPrendi.esegui(this.partita);
		assertNull(this.comandoPrendi.getParametro());
	}

}
