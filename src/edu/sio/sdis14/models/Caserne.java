package edu.sio.sdis14.models;

import java.util.ArrayList;
import java.util.List;

import edu.sio.sdis14.exceptions.TelNumberException;

public class Caserne {

	private List<Pompier> lesPompiers;
	
	public Caserne() {
		lesPompiers = new ArrayList<>();
	}
	
	public void appeler(String numero) throws TelNumberException {
		
		numero = Pompier.cleanTel(numero);
		
	}
	
	public int appelEquipe(Periode unePeriode, int nbPompiers) {
		return 0;
	}
	
	public void enroler(Pompier unPompier) {
		
	}
	
	public boolean quitter(String identite) {
		return false;
	}
	
}
