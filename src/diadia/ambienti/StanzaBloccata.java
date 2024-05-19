package diadia.ambienti;

public class StanzaBloccata extends Stanza{
	private String KEY;
	private String lockedDoor;
	
	public StanzaBloccata(String nome, String chiave, String direzioneBloccata) {
		super(nome);
		this.KEY = chiave;
		this.lockedDoor = direzioneBloccata;
	}
	
	public String getKey() {
		return this.KEY;
	}
	public void setKey(String KEY) {
		this.KEY = KEY;
	}
	public String getLockedDoor() {
		return this.lockedDoor;
	}
	public void setLockedDoor(String lockedDoor) {
		this.lockedDoor = lockedDoor;
	}
	
	@Override
	public Stanza getStanzaAdiacente(String direzione) {
		if(direzione.equals(this.lockedDoor) && !(this.hasAttrezzo(this.KEY))) 
			return this;
		Stanza stanza = null;
		if (this.Direzione_stanzeAdiacenti.containsKey(direzione))
			stanza = this.Direzione_stanzeAdiacenti.get(direzione);
		return stanza;
		
	}
	
	@Override
	public String toString() {
		StringBuilder risultato = new StringBuilder();
    	risultato.append(this.getNome());
    	risultato.append("\nUscite: ");
    	for (String direzione : this.getDirezioni()) {
    		if(direzione.equals(this.lockedDoor))
    			risultato.append(" " + direzione + "_(Bloccato)");
    		else if (direzione!=null)
    			risultato.append(" " + direzione);
    	}	
    	risultato.append("\n" + this.getDescrizioneAttrezzi());
    	
    	return risultato.toString();
	}
}
