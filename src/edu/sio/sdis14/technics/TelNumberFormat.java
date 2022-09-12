package edu.sio.sdis14.technics;

import edu.sio.sdis14.exceptions.TelNumberException;

public class TelNumberFormat {

	public static String telAsNumber(String numero) throws TelNumberException {
		
		numero = numero.replaceFirst("^\\+33", "0").replaceAll("[^0-9]", "");
		
		if(numero.length() != 10) {
			throw new TelNumberException("Un numéro de téléphone doit contenir 10 chiffres !");
		}
		
		return numero;
		
	}
	
	public static String NumberAsTel(String number) {
		return number.replaceFirst("(\\d{2})(\\d{2})(\\d{2})(\\d{2})(\\d{2})", "$1.$2.$3.$4.$5");
	}
	
	public static String cleanNumber(String numero) throws TelNumberException {
		return NumberAsTel(telAsNumber(numero));
	}

}
