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

class ComandoPosaTest {
	
	IO io = new IOConsole();
	Labirinto labirinto;
	Partita partita;
	Comando comandoPosa;
	FabbricaDiComandiFisarmonica factory = new FabbricaDiComandiFisarmonica();
	
	Attrezzo attrezzoTest = new Attrezzo("Vasetto_Nutella", 1);
	String istruzionePosa = "posa Vasetto_Nutella";
	
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
	public void testEseguiPosa() {
		this.partita.getPlayer().getZaino().addAttrezzo(attrezzoTest);
		this.comandoPosa = factory.costruisciComando(istruzionePosa);

		this.comandoPosa.esegui(this.partita);
		
		assertFalse(this.partita.getPlayer().getZaino().hasAttrezzo(attrezzoTest.getNome()));
	}
	
	@Test
	public void testEseguiPosaNullParametro() {
		this.comandoPosa = factory.costruisciComando("posa");
		this.comandoPosa.esegui(this.partita);
		assertNull(this.comandoPosa.getParametro());
	}

}
