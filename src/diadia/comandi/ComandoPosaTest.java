package diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import diadia.IO;
import diadia.IOConsole;
import diadia.Partita;
import diadia.attrezzi.Attrezzo;

class ComandoPosaTest {
	
	IO io = new IOConsole();
	Partita partita = new Partita(io);
	Comando comandoPosa;
	FabbricaDiComandiFisarmonica factory = new FabbricaDiComandiFisarmonica();
	
	Attrezzo attrezzoTest = new Attrezzo("Vasetto_Nutella", 1);
	String istruzionePosa = "posa Vasetto_Nutella";
	
	@Test
	public void testEseguiPosa() {
		this.partita.getPlayer().getZaino().addAttrezzo(attrezzoTest);
		this.comandoPosa = factory.costruisciComando(istruzionePosa);

		this.comandoPosa.esegui(this.partita);
		
		assertNull(this.partita.getPlayer().getZaino().getAttrezzi()[0]);
	}
	
	@Test
	public void testEseguiPosaNullParametro() {
		this.comandoPosa = factory.costruisciComando("posa");
		this.comandoPosa.esegui(this.partita);
		assertNull(this.comandoPosa.getParametro());
	}

}
