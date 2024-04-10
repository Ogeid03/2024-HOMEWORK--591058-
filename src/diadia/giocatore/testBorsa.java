package diadia.giocatore;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import diadia.attrezzi.Attrezzo;

class testBorsa {
	
	private Borsa bag = new Borsa();
	private Attrezzo A = new Attrezzo("testPiuma", 1);
	private Attrezzo B = new Attrezzo("testFoglia", 1);
	private Attrezzo C  = new Attrezzo("testAnvil", 11);

	@Test
	public void testAddAttrezzoLeggero() {
		bag.addAttrezzo(A);
		assertTrue(bag.hasAttrezzo("testPiuma"));
	}
	
	@Test
	public void testAddAttrezzoPesante() {
		bag.addAttrezzo(C);
		assertFalse(bag.hasAttrezzo("testAnvil"));
	}

	@Test
	public void testRemoveAttrezzo() {
		bag.addAttrezzo(A);
		bag.addAttrezzo(B);
		bag.removeAttrezzo(A.getNome());
		/*for(int i=0; i<10;i++){
			if(bag.getAttrezzi()[i]!=null)
			System.out.println(i + " " + bag.getAttrezzi()[i].getNome());
		}*/	
		assertFalse(bag.hasAttrezzo("testPiuma"));
		
	}

}
