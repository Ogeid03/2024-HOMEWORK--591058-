package diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import diadia.IO;
import diadia.IOConsole;
import diadia.Partita;
import diadia.ambienti.Labirinto;

class AbstractComandoTest {
	
		ConcreteComando cc;
		Partita p;
		IO io = new IOConsole();
		
		@Before
		public void setUp() throws Exception {
			cc = new ConcreteComando();
			p = new Partita(io, Labirinto.newLabBuilder("labirinto.txt").getLabirinto());
		}

		@After
		public void tearDown() throws Exception {
		}

		@Test
		public void testConcreteComandoGetNome() {
			 assertNotEquals("AbstractComando", cc.getNome());
			 assertEquals("ConcreteComando", cc.getNome());
		}
		
		@Test
		public void testConcreteComandoEsegui() {
			cc.esegui(p);
			 assertTrue(p.isFinita());
		}

		@Test
		public void testConcreteComandoGetIO() {
			cc.setIo(new IOConsole(new Scanner(System.in)));
			 assertNotNull(cc.getIo());
		}
		
		@Test
		public void testConcreteComandoParametro() {
			cc.setParametro("pippo");
			 assertNotNull(cc.getParametro());
		}

}
