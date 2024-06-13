package diadia.personaggi;

import java.util.List;

import diadia.Partita;
import diadia.ambienti.Stanza;
import diadia.attrezzi.Attrezzo;

/**
 * Questa classe modella un Personaggio.
 * Classe Strega.
 * 
 * @author Diego De Martino
 * @see AbstractPersonaggio
 * @version base 4.0
 */
public class Strega extends AbstractPersonaggio{
	
	private static final String MESSAGGIO_SALUTATA = "Solo perche' mi hai salutato, non ti mando in uno scantinato!";
	private static final String MESSAGGIO_NON_SALUTATA = "Sei proprio una brutta persona, vai nella stanza con meno attrezzi!";

	public Strega(String nome, String presentaz) {
		super(nome, presentaz);
	}

	@Override
	public String agisci(Partita partita) {
		String msg;
		List<Stanza> stanzeAdiacenti = partita.getLabirinto().getStanzaCorrente().getStanzeAdiacenti();

		Stanza maxAtrezzi = stanzeAdiacenti.get(0);
		Stanza minAtrezzi = stanzeAdiacenti.get(0);

		for(Stanza s : stanzeAdiacenti) {
			if(s != null) {
				if(s.getAttrezzi().size() > maxAtrezzi.getAttrezzi().size())
					maxAtrezzi = s;
				if(s.getAttrezzi().size() < minAtrezzi.getAttrezzi().size())
					minAtrezzi = s;
			}
		}

		if(this.haSalutato()) {
			partita.getLabirinto().setStanzaCorrente(maxAtrezzi);
			msg = MESSAGGIO_SALUTATA;
		} else {
			partita.getLabirinto().setStanzaCorrente(minAtrezzi);
			msg = MESSAGGIO_NON_SALUTATA;
		}

		return msg;
	}

	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		return "MUAHAHAHAH MUAHAHHAAA";
	}
}
