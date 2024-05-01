package diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import diadia.IO;
import diadia.IOConsole;
import diadia.Partita;

class ComandoVaiTest {
	
	IO io = new IOConsole();
	Partita partita = new Partita(io);
	Comando comandoVai;
	FabbricaDiComandiFisarmonica factory = new FabbricaDiComandiFisarmonica();
	
	String istruzioneVaiNord = "vai nord";
	
	@Test
	public void testEseguiVaiNord() {
		this.comandoVai = factory.costruisciComando(this.istruzioneVaiNord);
		this.comandoVai.esegui(this.partita);
		assertEquals("Biblioteca", this.partita.getLabirinto().getStanzaCorrente().getNome());
	}
	
	@Test
	public void testEseguiVaiNull() {
		this.comandoVai = factory.costruisciComando("vai");
		this.comandoVai.esegui(this.partita);
		assertEquals("Atrio", this.partita.getLabirinto().getStanzaCorrente().getNome());
	}
	
	@Test
	public void testEseguiVaiNullParametro() {
		this.comandoVai = factory.costruisciComando("vai");
		this.comandoVai.esegui(this.partita);
		assertNull(this.comandoVai.getParametro());
	}
	
	@Test
	public void testEseguiVaiControMuro() {
		this.partita.getLabirinto().setStanzaCorrente(this.partita.getLabirinto().getStanzaCorrente().getStanzaAdiacente("est"));
		this.comandoVai = factory.costruisciComando(this.istruzioneVaiNord);
		this.comandoVai.esegui(this.partita);
		assertEquals("Aula N11", this.partita.getLabirinto().getStanzaCorrente().getNome());
	}

}
