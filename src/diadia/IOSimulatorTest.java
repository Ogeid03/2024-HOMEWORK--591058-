package diadia;
import java.util.List;

import diadia.ambienti.Direzione;
import diadia.ambienti.Labirinto;
import diadia.ambienti.Stanza;
import diadia.attrezzi.Attrezzo;

public class IOSimulatorTest {
	
	public static IOSimulator creaEGiocaPartita(List<String> daLeggere) throws Exception {
		IOSimulator io = new IOSimulator(daLeggere);
		Labirinto labirinto = Labirinto.newLabBuilder()
				.addStanzaIniziale("Atrio")
				.addAttrezzo("bastone", 4)
				.addStanzaVincente("Biblioteca")
				.addAdiacenza(Direzione.nord,"Atrio", "Biblioteca")
				.addAdiacenza(Direzione.sud,"Biblioteca", "Atrio")
				.getLabirinto();
		DiaDia gioco = new DiaDia(io, labirinto);
		gioco.gioca();
		return io;
	}
	
	public static IOSimulator creaEGiocaPartitaDifficile(List<String> daLeggere) throws Exception {
		IOSimulator io = new IOSimulator(daLeggere);
		Labirinto labirinto = Labirinto.newLabBuilder()
				.addStanzaIniziale("Atrio")
				.addAttrezzo("bastone", 3)
				.addStanzaVincente("Biblioteca")
				.addAdiacenza(Direzione.nord,"Atrio", "Biblioteca")
				.addAdiacenza(Direzione.sud,"Biblioteca", "Atrio")
				.addStanzaNormale("Bagno")
				.addAdiacenza(Direzione.sud,"Bagno", "Atrio")
				.addAdiacenza(Direzione.nord,"Atrio", "Bagno")
				.addStanzaNormale("Ripostiglio")
				.addAdiacenza(Direzione.ovest,"Ripostiglio", "Atrio")
				.addAdiacenza(Direzione.est,"Atrio", "Ripostiglio")
				.getLabirinto();
		DiaDia gioco = new DiaDia(io, labirinto);
		try {
			gioco.gioca();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return io;
	}
	
	public static IOSimulator creaEGIocaUnaStanza(List<String> daLeggere) throws Exception {
		IOSimulator io = new IOSimulator(daLeggere);
		Labirinto singola = Labirinto.newLabBuilder()
				.addStanzaIniziale("biblioteca") 
				.addStanzaVincente("biblioteca") 
				.getLabirinto();
		DiaDia gioco = new DiaDia(io, singola);
		try {
			gioco.gioca();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return io;
	}
	
	
	public static IOSimulator creaEGiocaDueStanze(List<String> daLeggere) throws Exception {
		IOSimulator io = new IOSimulator(daLeggere);
		Labirinto bilocale = Labirinto.newLabBuilder()
				.addStanzaIniziale("biblioteca")
				.addStanzaVincente("camera")
				.addAttrezzo("letto",10) 
				.addAdiacenza(Direzione.nord,"biblioteca", "camera")
				.getLabirinto();
		DiaDia gioco = new DiaDia(io, bilocale);
		try {
			gioco.gioca();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return io;
	}
	
	public static IOSimulator creaEGiocaTreStanze(List<String> daLeggere) throws Exception {
		IOSimulator io = new IOSimulator(daLeggere);
		Labirinto trilocale = Labirinto.newLabBuilder()
				.addStanzaIniziale("biblioteca")
				.addStanzaNormale("bagno")
				.addAttrezzo("pentola",1) 
				.addStanzaVincente("camera")
				.addAdiacenza(Direzione.nord,"biblioteca", "bagno")
				.addAdiacenza(Direzione.ovest,"bagno", "camera")
				.getLabirinto();
		DiaDia gioco = new DiaDia(io, trilocale);
		gioco.gioca();
		return io;
	}

	public static Attrezzo creaAttrezzoEAggiugniAStanza(Stanza daRiempire, String nomeAttrezzo, int peso) {
		Attrezzo attrezzo = new Attrezzo(nomeAttrezzo, peso);
		daRiempire.addAttrezzo(attrezzo);
		return attrezzo;
	}

}
