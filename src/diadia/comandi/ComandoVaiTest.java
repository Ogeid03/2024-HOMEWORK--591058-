package diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import diadia.FormatoFileNonValidoException;
import diadia.IO;
import diadia.IOConsole;
import diadia.Partita;
import diadia.ambienti.Direzione;
import diadia.ambienti.Labirinto;

class ComandoVaiTest {
	
	IO io = new IOConsole(new Scanner(System.in));
	Labirinto labirinto;
	Partita partita = new Partita(io, labirinto);
	Comando comandoVai;
	FabbricaDiComandiFisarmonica factory = new FabbricaDiComandiFisarmonica();
	
	String istruzioneVaiNord = "vai nord";
	
	@BeforeEach
	public void init() throws FileNotFoundException, FormatoFileNonValidoException {
		this.labirinto = Labirinto.newLabBuilder("labirinto.txt").getLabirinto();
	}
	
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
		this.partita.getLabirinto().setStanzaCorrente(this.partita.getLabirinto().getStanzaCorrente().getStanzaAdiacente(Direzione.est));
		this.comandoVai = factory.costruisciComando(this.istruzioneVaiNord);
		this.comandoVai.esegui(this.partita);
		assertEquals("Aula N11", this.partita.getLabirinto().getStanzaCorrente().getNome());
	}

}
