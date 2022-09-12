package edu.sio.sdis14.models;

import edu.sio.sdis14.exceptions.PompierNotFoundException;
import edu.sio.sdis14.exceptions.TelNumberException;
import edu.sio.sdis14.technics.TelNumberFormat;

public class Pompier {

	private String prenom;
	private String nom;
	private String tel;
	
	public Pompier(String identite) {
		
		setIdentite(identite);
		
	}
	
	public String getIdentite() {
		
		if(!nom.equals("")) {
			return prenom + " " + nom;
		}
		
		return prenom;
	}

	public void setIdentite(String identite) {

		if(identite == null) {
			identite = "";
		}
		
		String[] words = identite.trim().replaceAll("[^a-zA-Z ùûüÿàâæçéèêëïîôœ]", "").replaceAll(" +", " ").split(" ", 2);
		this.prenom = words[0];
		this.nom = "";
		
		if(words.length > 1) {
			this.nom = words[1];
		}
		
	}

	public String getTel() {
		return TelNumberFormat.NumberAsTel(tel);
	}

	public void setTel(String tel) throws TelNumberException {
		
		this.tel = TelNumberFormat.telAsNumber(tel);
		
	}
	
	public boolean missionner(Periode periode) throws PompierNotFoundException {
		return periode.missionner(this);
	}
	
	public char getStatut(Periode periode) throws PompierNotFoundException {
		return periode.getStatut(this);
	}
	
	@Override
	public String toString() {
		return getIdentite();
	}

	@Override
	public boolean equals(Object obj) {
		
		if(obj == null) {
			return false;
		}
		
		if(!(obj instanceof Pompier)) {
			return false;
		}
		
		return ((Pompier)obj).getIdentite().equals(getIdentite());
	}
	
}
