package edu.sio.sdis14.models;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import edu.sio.sdis14.exceptions.PompierNotFoundException;
import edu.sio.sdis14.exceptions.TelNumberException;
import edu.sio.sdis14.technics.TelNumberFormat;

public class Caserne {

	private List<Pompier> lesPompiers;
	
	public Caserne() {
		lesPompiers = new ArrayList<>();
	}
	
	public boolean appeler(String numero) throws TelNumberException {
		
		numero = TelNumberFormat.cleanNumber(numero);
		boolean found = false;
		Iterator<Pompier> it = lesPompiers.iterator();
		
		while (found != true && it.hasNext()) {
			
			found = numero.equals(it.next().getTel());
			
		}
		
		return found;
		
	}
	
	public int appelEquipe(Periode unePeriode, int nbPompiers) throws TelNumberException, PompierNotFoundException {
		
		List<Pompier> selectedPompiers = unePeriode.selecEquipe(nbPompiers);
		int pompierCount = 0;
		
		for (Pompier pompier : selectedPompiers) {
			
			if (appeler(pompier.getTel())) {
				
				unePeriode.missionner(pompier);
				pompierCount++;
				
			}
			
		}
		
		return pompierCount;
		
	}
	
	public void enroler(Pompier unPompier) {
		
		lesPompiers.add(unPompier);
		
	}
	
	public boolean quitter(String identite) {
		
		return lesPompiers.remove( new Pompier(identite));
		
	}
	
}
