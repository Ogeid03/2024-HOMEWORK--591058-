package diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import diadia.ambienti.Stanza;
import diadia.attrezzi.Attrezzo;

class testDiaDia {
	
	private DiaDia game = new DiaDia();
	private Stanza S = new Stanza("room");
	private Attrezzo A = new Attrezzo("test", 1);
	
	
	@Test
	public void testPrendi() {
		S.addAttrezzo(A);
		game.partita.getLabirinto().setStanzaCorrente(S);
		
		//System.out.println(game.partita.maze.getStanzaCorrente().getDescrizione());
		//System.out.println(game.partita.getPlayer().getZaino().getDescrizione());
		
		game.prendi("test");
		
		//System.out.println("\n\nPost prendi()\n\n" + game.partita.maze.getStanzaCorrente().getDescrizione());
		//System.out.println(game.partita.getPlayer().getZaino().getDescrizione());
		
		assertEquals(A, game.partita.getPlayer().getZaino().getAttrezzo("test"));
	}
	
	@Test
	public void testPosa() {
		game.partita.getPlayer().getZaino().addAttrezzo(A);
		game.partita.getLabirinto().setStanzaCorrente(S);
		
		//System.out.println(game.partita.getLabirinto().getStanzaCorrente().getDescrizione());
		//System.out.println(game.partita.getPlayer().getZaino().getDescrizione());
		
		game.posa("test");
		
		//System.out.println("\n\nPost posa()\n\n" + game.partita.getLabirinto().getStanzaCorrente().getDescrizione());
		//System.out.println(game.partita.getPlayer().getZaino().getDescrizione());
		
		assertEquals(A, game.partita.getLabirinto().getStanzaCorrente().getAttrezzo("test"));
	}

}
