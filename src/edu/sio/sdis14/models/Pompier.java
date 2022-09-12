package edu.sio.sdis14.models;

import edu.sio.sdis14.exceptions.TelNumberException;

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
		return tel.replaceFirst("(\\d{2})(\\d{2})(\\d{2})(\\d{2})(\\d{2})", "$1.$2.$3.$4.$5");
	}

	public void setTel(String tel) throws TelNumberException {
		
		this.tel = cleanTel(tel);
		
	}
	
	public static String cleanTel(String numero) throws TelNumberException {
		
		numero = numero.replaceFirst("^\\+33", "0").replaceAll("[^0-9]", "");
		
		if(numero.length() != 10) {
			throw new TelNumberException("Un numéro de téléphone doit contenir 10 chiffres !");
		}
		
		return numero;
		
	}
	
	public void missionner(Periode periode) {
		
	}
	
	public char getStatut(Periode periode) {
		return ' ';
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
