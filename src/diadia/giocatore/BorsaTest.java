package diadia.giocatore;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;
import java.util.Set;

//import java.util.Map;
//import java.util.TreeMap;

import org.junit.jupiter.api.Test;

import diadia.attrezzi.Attrezzo;

class BorsaTest {
	
	private Borsa bag = new Borsa();
	private Attrezzo A = new Attrezzo("testPiuma", 1);
	private Attrezzo B = new Attrezzo("testFoglia", 1);
	private Attrezzo C  = new Attrezzo("testAnvil", 11);
	private Attrezzo D  = new Attrezzo("testAnvil", 5);
	
	/*Map<Integer, Attrezzo> Dora = new TreeMap<>();
	
	@Test
	public void testacaso() {
		Dora.put(2, A);
		Dora.put(1, B);
		for(int i=1; i<3; i++)
			System.out.println(Dora.get(i).getNome());
	}*/

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
	
	@Test
	public void testOrdinaPerNome() {
		bag.addAttrezzo(A);
		bag.addAttrezzo(B);
		
		assertEquals(this.bag.getAttrezzi(), bag.getContenutoOrdinatoPerNome());		
	}
	
	@Test
	public void testOrdinaPerPeso() {
		
		bag.addAttrezzo(A);
		bag.addAttrezzo(D);
		bag.addAttrezzo(B);
		
		/*bag.getContenutoOrdinatoPerPeso().forEach(attr -> {
		    System.out.println(attr.getNome() + " " + 
		      attr.getPeso());
		});*/
		
		assertEquals("testAnvil", bag.getContenutoOrdinatoPerPeso().get(0).getNome());
		assertEquals("testFoglia", bag.getContenutoOrdinatoPerPeso().get(1).getNome());
		assertEquals("testPiuma", bag.getContenutoOrdinatoPerPeso().get(2).getNome());		
	}
	
	@Test
	public void testRaggruppaPerPeso() {
		
		bag.addAttrezzo(A);
		bag.addAttrezzo(D);
		bag.addAttrezzo(B);
		
		Map<Integer, Set<Attrezzo>> contenutoRaggruppato = bag.getContenutoRaggruppatoPerPeso();
		
        assertEquals(2, contenutoRaggruppato.size());
        assertTrue(contenutoRaggruppato.containsKey(1));
        assertTrue(contenutoRaggruppato.containsKey(5));
        assertFalse(contenutoRaggruppato.containsKey(15));
	}
	
	@Test 
	public void testStampe() {
		bag.addAttrezzo(A);
		bag.addAttrezzo(D);
		bag.addAttrezzo(B);
		
		System.out.println(bag.getContenutoOrdinatoPerNome().toString());
	}
	
	
}
