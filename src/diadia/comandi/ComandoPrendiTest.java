package diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import diadia.IO;
import diadia.IOConsole;
import diadia.Partita;
import diadia.ambienti.Labirinto;
import diadia.ambienti.LabirintoBuilder;
import diadia.attrezzi.Attrezzo;

class ComandoPrendiTest {

	IO io = new IOConsole();
	Labirinto labirinto = new Labirinto();
	Partita partita;
	Comando comandoPrendi;
	FabbricaDiComandiFisarmonica factory = new FabbricaDiComandiFisarmonica();
	
	Attrezzo attrezzoTest = new Attrezzo("Vasetto_Nutella", 1);
	String istruzionePrendi = "prendi Vasetto_Nutella";
	
	
	@BeforeEach
	public void init() {
		this.labirinto = new LabirintoBuilder()
				.addStanzaIniziale("LabCampusOne")
				.addStanzaVincente("Biblioteca")
				.addAdiacenza("ovest", "LabCampusOne","Biblioteca")
				.getLabirinto();
		this.partita = new Partita(io, labirinto);
	}
	
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
