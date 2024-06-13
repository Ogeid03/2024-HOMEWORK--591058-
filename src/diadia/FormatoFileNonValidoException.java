package diadia;

/**
 * Classe relativa alle possibili eccezioni sollevate da un file non valido
 *
 * @author  Diego De Martino
 *          
 * @version base 4.0
 */
public class FormatoFileNonValidoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FormatoFileNonValidoException(String msg){
		super(msg);
	}
}