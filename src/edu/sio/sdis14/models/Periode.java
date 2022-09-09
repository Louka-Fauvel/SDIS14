package edu.sio.sdis14.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Periode {

	private Date laDate;
	private int laTranche;
	private List<Pompier> disponible;
	private List<PompierVolontaire> auTravail;
	private List<Pompier> enMission;
	
	public Periode(Date date, int tranche) {
		
		disponible = new ArrayList();
		auTravail = new ArrayList();
		enMission = new ArrayList();
		
	}
	
	/**
	 * Retourne ‘m’ si le pompier “unPompier” est en mission pour la période 
	 * courante \\Retourne ‘t’ si le pompier “unPompier” est au travail pour la 
	 * période courante
	 * Retourne ‘d’ si le pompier “unPompier” est disponible pour la période courante
	 * 
	 * @param pompier
	 * @return
	 */
	public char getStatut(Pompier pompier) {
		return 'm';
	}
	
	public void missionner(Pompier pompier) {
		this.ajouterPompier(pompier, 'm');
	}
	
	public void ajouterPompier(Pompier pompier, char statut) {
		
		switch(statut) {
		case 't':
			auTravail.add(((PompierVolontaire)pompier));
			break;
		case 'd':
			disponible.add(pompier);
			break;
		case 'm':
			enMission.add(pompier);
			break;
		}
		
	}
	
	public List<Pompier> selecEquipe(int nbPompiers) {
		
	}
	
}
