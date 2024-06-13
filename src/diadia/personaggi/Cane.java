package diadia.personaggi;

import diadia.Partita;
import diadia.attrezzi.Attrezzo;

/**
 * Questa classe modella un Personaggio.
 * Classe Cane.
 * 
 * @author Diego De Martino
 * @see AbstractPersonaggio
 * @version base 4.0
 */
public class Cane extends AbstractPersonaggio{

	private static final String MESSAGGIO_CANE = "WOOF! WOOF! (-1 CFU)";
	private static String CIBO_PREFERITO= "osso";
	
	public Cane(String nome, String presentazione) {
		super(nome, presentazione);
	}
	
	@Override
	public String agisci(Partita partita) {
		String msg = MESSAGGIO_CANE;
		partita.getPlayer().setCFU(partita.getPlayer().getCFU()-1);
		return msg;
	}
	
	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		StringBuilder risposta = new StringBuilder("Bau grazie per avermi regalato ");

		if(attrezzo.getNome().equals(CIBO_PREFERITO)) {
			risposta.append("il mio cibo preferito.");
			partita.getLabirinto().getStanzaCorrente().addAttrezzo(new Attrezzo("collare", 2));
		} else {
		risposta.append(attrezzo.getNome()+",ma non e' il mio cibo preferit, bau!");
		partita.getPlayer().setCFU(partita.getPlayer().getCFU()-1);
		}
		
		return risposta.toString();
	}

}
