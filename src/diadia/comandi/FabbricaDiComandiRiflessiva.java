package diadia.comandi;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

import diadia.IO;

/**
 * Classe riflessiva per la l'implementazione dei comandi
 *
 * @author  Diego De Martino
 *          
 * @version base 4.0
 */
public class FabbricaDiComandiRiflessiva implements FabbricaDiComandi {
	
	IO io;
	
	public FabbricaDiComandiRiflessiva(IO io) {
		this.io = io;
	}
	
	public Comando costruisciComando(String istruzione) throws Exception{
		Scanner scannerDiParole = new Scanner(istruzione);
		String nomeComando = null;
		String parametro = null;
		Comando comando = null;
		
		if (scannerDiParole.hasNext())
			nomeComando = scannerDiParole.next();//prima parola: nome del comando
		if (scannerDiParole.hasNext())
			parametro = scannerDiParole.next();//seconda parola: eventuale parametro
			
		StringBuilder nomeClasse = new StringBuilder("diadia.comandi.Comando");
		nomeClasse.append(Character.toUpperCase(nomeComando.charAt(0)));
		nomeClasse.append(nomeComando.substring(1));
		
		 try {
	            Class<?> classeComando = Class.forName(nomeClasse.toString());
	            Constructor<?> costruttore;
	            
	            if (parametro != null) {
	                costruttore = classeComando.getConstructor(String.class);
	                comando = (Comando) costruttore.newInstance(parametro);
	            } else {
	                costruttore = classeComando.getConstructor();
	                comando = (Comando) costruttore.newInstance();
	            }
	            
	            
	        } catch (ClassNotFoundException e) {
	            throw new Exception("Classe del comando non trovata: " + nomeClasse.toString(), e);
	        } catch (NoSuchMethodException e) {
	            throw new Exception("Costruttore appropriato non trovato per: " + nomeClasse.toString(), e);
	        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
	            throw new Exception("Errore durante l'istanza della classe comando: " + nomeClasse.toString(), e);
	        }
		 
		comando.setIo(io);
				
		return comando;
	}
}
