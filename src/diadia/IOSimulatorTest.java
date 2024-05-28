package diadia;
import java.util.List;

import diadia.ambienti.Labirinto;
import diadia.ambienti.LabirintoBuilder;
import diadia.ambienti.Stanza;
import diadia.attrezzi.Attrezzo;

public class IOSimulatorTest {
	
	public static IOSimulator creaEGiocaPartita(List<String> daLeggere) {
		IOSimulator io = new IOSimulator(daLeggere);
		Labirinto labirinto = Labirinto.newLabBuilder()
				.addStanzaIniziale("Atrio")
				.addAttrezzo("bastone", 4)
				.addStanzaVincente("Biblioteca")
				.addAdiacenza("nord","Atrio", "Biblioteca")
				.addAdiacenza("sud","Biblioteca", "Atrio")
				.getLabirinto();
		DiaDia gioco = new DiaDia(io, labirinto);
		gioco.gioca();
		return io;
	}
	
	public static IOSimulator creaEGiocaPartitaDifficile(List<String> daLeggere) {
		IOSimulator io = new IOSimulator(daLeggere);
		Labirinto labirinto = Labirinto.newLabBuilder()
				.addStanzaIniziale("Atrio")
				.addAttrezzo("bastone", 3)
				.addStanzaVincente("Biblioteca")
				.addAdiacenza("nord","Atrio", "Biblioteca")
				.addAdiacenza("sud","Biblioteca", "Atrio")
				.addStanzaNormale("Bagno")
				.addAdiacenza("sud","Bagno", "Atrio")
				.addAdiacenza("nord","Atrio", "Bagno")
				.addStanzaNormale("Ripostiglio")
				.addAdiacenza("ovest","Ripostiglio", "Atrio")
				.addAdiacenza("est","Atrio", "Ripostiglio")
				.getLabirinto();
		DiaDia gioco = new DiaDia(io, labirinto);
		gioco.gioca();
		return io;
	}
	
	public static IOSimulator creaEGIocaUnaStanza(List<String> daLeggere) {
		IOSimulator io = new IOSimulator(daLeggere);
		Labirinto singola = Labirinto.newLabBuilder()
				.addStanzaIniziale("biblioteca") 
				.addStanzaVincente("biblioteca") 
				.getLabirinto();
		DiaDia gioco = new DiaDia(io, singola);
		gioco.gioca();
		return io;
	}
	
	
	public static IOSimulator creaEGiocaDueStanze(List<String> daLeggere) {
		IOSimulator io = new IOSimulator(daLeggere);
		Labirinto bilocale = Labirinto.newLabBuilder()
				.addStanzaIniziale("biblioteca")
				.addStanzaVincente("camera")
				.addAttrezzo("letto",10) 
				.addAdiacenza("nord","biblioteca", "camera")
				.getLabirinto();
		DiaDia gioco = new DiaDia(io, bilocale);
		gioco.gioca();
		return io;
	}
	
	public static IOSimulator creaEGiocaTreStanze(List<String> daLeggere) {
		IOSimulator io = new IOSimulator(daLeggere);
		Labirinto trilocale = new LabirintoBuilder()
				.addStanzaIniziale("biblioteca")
				.addStanzaNormale("bagno")
				.addAttrezzo("pentola",1) 
				.addStanzaVincente("camera")
				.addAdiacenza("nord","biblioteca", "bagno")
				.addAdiacenza("ovest","bagno", "camera")
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
