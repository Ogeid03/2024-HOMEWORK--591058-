package diadia.ambienti;

public class StanzaBuia extends Stanza{
	private String light;
	
	public StanzaBuia(String nome, String AttrezzoLuminoso) {
		super(nome);
		this.light = AttrezzoLuminoso;
	}
	
	public String getLight() {
		return this.light;
	}
	
	public void setLight(String light) {
		this.light = light;
	}
	
	@Override
	public String toString() {
		StringBuilder risultato = new StringBuilder();
		
		if(this.hasAttrezzo(this.light)) {
			risultato.append(this.getNome());
			risultato.append("\nUscite: ");
			for (String direzione : this.getDirezioni())
					risultato.append(" " + direzione);
			risultato.append("\n" + this.getDescrizioneAttrezzi());
		}else risultato.append("Qui c'è buio pesto...");
		
		return risultato.toString();	}
}
