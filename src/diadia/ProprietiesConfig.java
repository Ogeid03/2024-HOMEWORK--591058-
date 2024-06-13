package diadia;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


/**
 * Classe per l'impostazione tramite file esterno delle properties iniziali di default
 *
 * @author  Diego De Martino    
 *          
 * @version base 4.0
 */
public final class ProprietiesConfig {

	private static final String DIADIA_PROPERTIES = "diadia.properties";
	private static final String PESO_MAX = "pesoMax";
	private static final String CFU = "cfu";
	private static Properties prop = null;
	
	public static int getCFU() {
		if(prop == null)
			carica();
		return Integer.parseInt(prop.getProperty(CFU));
	}
	
	public static int getPesoMax() {
		if(prop == null)
			carica();
		return Integer.parseInt(prop.getProperty(PESO_MAX));
	}

	private static void carica() {
		prop = new Properties();
		try {
			FileInputStream input = new FileInputStream(DIADIA_PROPERTIES);
			prop.load(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}