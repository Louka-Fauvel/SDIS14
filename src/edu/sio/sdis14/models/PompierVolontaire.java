package edu.sio.sdis14.models;

public class PompierVolontaire extends Pompier {

	private String profession;
	
	public PompierVolontaire(String identite, String profession) {
		super(identite);
		this.profession = profession;
	}
	
}
