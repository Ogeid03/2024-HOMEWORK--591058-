package diadia.ambienti;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Test;


public class LabirintoBuilderTest {
	LabirintoBuilder builder = new LabirintoBuilder();

    @Test
    public void testAddStanzaPartenza() {
        builder.addStanzaIniziale("StanzaIniziale");
        assertEquals("StanzaIniziale", builder.getLabirinto().getStanzaCorrente().getNome());
    }

    @Test
    public void testAddStanzaVincente() {
        builder.addStanzaVincente("StanzaVincente");
        assertEquals("StanzaVincente", builder.getLabirinto().getStanzaVincente().getNome());
    }

    @Test
    public void testAddStanzaNormale() {
        builder.addStanzaNormale("StanzaNormale");
        assertTrue(builder.getStanze().containsKey("StanzaNormale"));
    }
    

    @Test
    public void testAddAttrezzo() {
        builder.addStanzaNormale("StanzaConAttrezzo").addAttrezzo("Martello", 5);
        assertTrue(builder.getStanze().get("StanzaConAttrezzo").hasAttrezzo("Martello"));
    }

    @Test
    public void testAddStanzaMagica() {
        builder.addStanzaMagica("StanzaMagica", 3);
        assertTrue(builder.getStanze().get("StanzaMagica") instanceof Stanza);
    }

    @Test
    public void testAddStanzaBloccata() {
        builder.addStanzaBloccata("StanzaBloccata", "Chiave", "Nord");
        assertTrue(builder.getStanze().get("StanzaBloccata") instanceof Stanza);
    }

    @Test
    public void testAddStanzaBuia() {
        builder.addStanzaBuia("StanzaBuia", "Fiamma");
        assertTrue(builder.getStanze().get("StanzaBuia") instanceof Stanza);
    }

    @Test
    public void testGetListaStanze() {
        builder.addStanzaNormale("Stanza1").addStanzaNormale("Stanza2").addStanzaNormale("Stanza3");
        Map<String, Stanza> stanze = builder.getListaStanze();
        assertEquals(3, stanze.size());
    }
}
