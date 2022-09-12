package edu.sio.sdis14.exceptions;

public class TelNumberException extends Exception {

	public TelNumberException() {
		this("Ce numéro de téléphone n'est pas valide");
	}

	public TelNumberException(String message) {
		super(message);
	}

//	public TelNumberException(Throwable cause) {
//		super(cause);
//	}
//
//	public TelNumberException(String message, Throwable cause) {
//		super(message, cause);
//	}
//
//	public TelNumberException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
//		super(message, cause, enableSuppression, writableStackTrace);
//	}

}
