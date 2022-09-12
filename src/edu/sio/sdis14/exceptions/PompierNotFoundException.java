package edu.sio.sdis14.exceptions;

public class PompierNotFoundException extends Exception {

	public PompierNotFoundException() {
		this("Le pompier est introuvable");
	}
	
	public PompierNotFoundException(String message) {
		super(message);
	}

}
