package edu.sio.sdis14.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.sio.sdis14.exceptions.TelNumberException;
import edu.sio.sdis14.models.Pompier;

class PompierTest {
	
	private Pompier pompier;

	@BeforeEach
	void setUp() throws Exception {
		pompier = new Pompier("Louka Fauvel");
	}

	@Test
	void testSetIdentite() {
		
		assertEquals("Louka Fauvel", pompier.getIdentite());
		pompier.setIdentite("Louka Jules Fauvel");
		assertEquals("Louka Jules Fauvel", pompier.getIdentite());
		pompier.setIdentite(" Louka Fauvel");
		assertEquals("Louka Fauvel", pompier.getIdentite());
		pompier.setIdentite("Louka                        Fauvel");
		assertEquals("Louka Fauvel", pompier.getIdentite());
		pompier.setIdentite("Fauvel");
		assertEquals("Fauvel", pompier.getIdentite());
		pompier.setIdentite(null);
		assertEquals("", pompier.getIdentite());
		pompier.setIdentite("");
		assertEquals("", pompier.getIdentite());
		pompier.setIdentite("Lou4&k'(a Fauvel");
		assertEquals("Louka Fauvel", pompier.getIdentite());
		pompier.setIdentite("Loukâ Fauvel");
		assertEquals("Loukâ Fauvel", pompier.getIdentite());
		
	}

	@Test
	void testGetTel() {
		fail("Not yet implemented");
	}

	@Test
	void testSetTel() throws TelNumberException {
		
		pompier.setTel("0674018434");
		assertEquals("06.74.01.84.34", pompier.getTel());
		pompier.setTel("06.74.01.84.34");
		assertEquals("06.74.01.84.34", pompier.getTel());
		pompier.setTel("0.6.7.4.0.1.84.34");
		assertEquals("06.74.01.84.34", pompier.getTel());
		pompier.setTel("06+74?01 84 34");
		assertEquals("06.74.01.84.34", pompier.getTel());
		pompier.setTel("+336.74.01.84.34");
		assertEquals("06.74.01.84.34", pompier.getTel());
		
		assertThrows(NumberFormatException.class, ()-> {
			
			pompier.setTel("06.74.84.34");
			
		});
		//pompier.setTel(null);
		
	}

	@Test
	void testMissionner() {
		fail("Not yet implemented");
	}

	@Test
	void testGetStatut() {
		fail("Not yet implemented");
	}

}
