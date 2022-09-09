package edu.sio.sdis14.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.sio.sdis14.models.Periode;
import edu.sio.sdis14.models.Pompier;

class PeriodeTest {

	private Periode periode;
	
	@BeforeEach
	void setUp() throws Exception {
		
		periode = new Periode(null, 0);
		
	}

	@Test
	void testGetStatut() {
		
		Pompier pompier = new Pompier("Iris Sheeban");
		periode.missionner(pompier);
		assertEquals('m', periode.getStatut(pompier));
		
	}

	@Test
	void testMissionner() {
		fail("Not yet implemented");
	}

	@Test
	void testSelecEquipe() {
		fail("Not yet implemented");
	}

}
