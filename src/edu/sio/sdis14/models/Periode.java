package edu.sio.sdis14.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.sio.sdis14.exceptions.PompierNotFoundException;

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
	public char getStatut(Pompier pompier) throws PompierNotFoundException {
		
		if(disponible.contains(pompier)) {
			
			return 'd';
			
		} else if(auTravail.contains(pompier)) {
			
			return 't';
			
		} else if(enMission.contains(pompier)) {
			
			return 'm';
			
		}
		
		throw new PompierNotFoundException();
		
	}
	
	public boolean missionner(Pompier pompier) throws PompierNotFoundException {
		
		if(auTravail.remove(pompier) || disponible.remove(pompier)) {
			
			return enMission.add(pompier);
			
		} 
		
		if(enMission.contains(pompier)) {
			
			return false;
			
		}
		
		throw new PompierNotFoundException();
		
	}
	
	public void ajouterPompier(Pompier pompier, char statut) {
		
		auTravail.remove(pompier);
		disponible.remove(pompier);
		enMission.remove(pompier);
		
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
		
		List<Pompier> selecteds = new ArrayList<>();
		int selectedCount = 0;
		int maxDisp = Math.min(disponible.size(), nbPompiers);
		
		for (selectedCount = 0; selectedCount < maxDisp; selectedCount++) {
			selecteds.add(disponible.get(selectedCount));
		}
		
		int maxAuTravail = Math.min(auTravail.size(), nbPompiers - selectedCount);
		
		for (int i = 0; i < maxAuTravail; i++) {
			selecteds.add(auTravail.get(i));
		}
		
//		for (selectedCount = 0; selectedCount < maxDisp; selectedCount++) {
//			selecteds.add(disponible.get(selectedCount));
//		}
		
		return selecteds;
		
	}
	
}
