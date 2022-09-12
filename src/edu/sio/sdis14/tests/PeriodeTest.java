package edu.sio.sdis14.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.sio.sdis14.exceptions.PompierNotFoundException;
import edu.sio.sdis14.models.Periode;
import edu.sio.sdis14.models.Pompier;
import edu.sio.sdis14.models.PompierVolontaire;

class PeriodeTest {

	private Periode periode;
	
	@BeforeEach
	void setUp() throws Exception {
		
		periode = new Periode(null, 10);
		
	}

	@Test
	void testGetStatut() throws PompierNotFoundException {
		
		Pompier pompier = new Pompier("Iris Sheeban");
		assertThrows(PompierNotFoundException.class, () -> {
			periode.getStatut(pompier);
		});
		
		periode.ajouterPompier(pompier, 'd');
		assertEquals('d', periode.getStatut(pompier));
		
		periode.missionner(pompier);
		assertEquals('m', periode.getStatut(pompier));
		Pompier leMemePompier = new Pompier("Iris Sheeban");
		assertEquals('m', periode.getStatut(leMemePompier));
		
	}

	@Test
	void testMissionner() throws PompierNotFoundException {
		
		assertThrows(PompierNotFoundException.class, () -> {
			periode.missionner(null);
		});
		
		Pompier pompier1 = new PompierVolontaire("louka Fauvel", "Artisan");
		Pompier pompier2 = new Pompier("Akou Velfau");
		assertThrows(PompierNotFoundException.class, () -> {
			periode.missionner(pompier2);
		});
		Pompier pompier3 = new Pompier("Iris Sheeban");
		periode.ajouterPompier(pompier1, 't');
		assertEquals(true, periode.missionner(pompier1));
		
	}

	@Test
	void testSelecEquipe() {
		
		Pompier pompier1 = new PompierVolontaire("louka Fauvel", "Artisan");
		Pompier pompier2 = new Pompier("Akou Velfau");
		Pompier pompier3 = new Pompier("Iris Sheeban");
		assertEquals(0, periode.selecEquipe(10).size());
		assertEquals(0, periode.selecEquipe(0).size());
		periode.ajouterPompier(pompier1, 't');
		assertEquals(1, periode.selecEquipe(10).size());
		assertEquals(1, periode.selecEquipe(1).size());
		assertEquals(0, periode.selecEquipe(0).size());
		
		periode.ajouterPompier(pompier2, 'd');
		assertEquals(2, periode.selecEquipe(10).size());
		assertEquals(2, periode.selecEquipe(2).size());
		assertEquals(1, periode.selecEquipe(1).size());
		assertEquals(pompier2, periode.selecEquipe(1).get(0));
		
		assertEquals(pompier2, periode.selecEquipe(2).get(0));
		assertEquals(pompier1, periode.selecEquipe(2).get(1));
		
	}

}
