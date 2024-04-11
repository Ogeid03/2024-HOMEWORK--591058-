package diadia.giocatore;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class testGiocatore {

	Giocatore player = new Giocatore();
	
	@Test
	public void testCFU() {
		player.setCFU(16);
		assertEquals(16, player.getCFU());
	}
	
	@Test
	public void testGetBorsaNotNull() {
		assertNotNull(player.getZaino());
	}

}
