package diadia;

import java.util.ArrayList;
import java.util.List;

/**
 * IOSimulator è una classe che simula l'interazione di input/output del sistema.
 * Viene utilizzata per leggere righe di test predefinite e registrare messaggi generati.
 * 
 * Questa classe implementa l'interfaccia IO, fornendo metodi per mostrare messaggi
 * e leggere righe in modo simile alla console di sistema.
 * 
 * @author Diego De Martino
 * @see IO
 * @version 3.1
 */
public class IOSimulator implements IO {

	private List<String> lette;
	private int indice;
	private List<String> generati;
	private int iGenerati;
	private int iMostrati;
	
	public void setgenerati(List<String> generati) {
		this.generati = generati;
	}
	
	public List<String> getgenerati() {
		return generati;
	}
	
	public IOSimulator(List<String> righeDaLeggere) {
		this.lette = righeDaLeggere;
		this.iMostrati = 0;
		this.indice = 0;
		this.generati = new ArrayList<String>();
	}
	/**
	 * Mostra un messaggio.
	 * Aggiunge un messaggio alla lista dei messaggi generati durante l'esecuzione.
	 * 
	 * @param msg il messaggio da mostrare
	 */
	@Override
	public void mostraMessaggio(String msg) {
		this.generati.add(this.iGenerati, msg);
		this.iGenerati++;
	}
	/**
	 * Legge una riga.
	 * Restituisce la riga successiva nella lista delle righe da leggere.
	 * 
	 * @return la riga successiva da leggere
	 */
	@Override
	public String leggiRiga() {
		String riga = null;
		riga = this.lette.get(indice);
		this.indice++;
		return riga;
	}
	/**
	 * Restituisce il prossimo messaggio nella lista dei messaggi generati durante l'esecuzione.
	 * 
	 * @return il prossimo messaggio
	 */
	public String nextMessaggio() {
		String next = this.generati.get(iMostrati);
		this.iMostrati++;
		return next;
	}
	/**
	 * Verifica se ci sono altri messaggi nella lista dei messaggi generati che non sono ancora stati mostrati.
	 * 
	 * @return true se ci sono altri messaggi disponibili, false altrimenti
	 */
	public boolean hasNextMessaggio() {
		return this.iMostrati < this.iGenerati;
	}

	@Override
	public void mostraMessaggioInLinea(String msg) {
	}

}