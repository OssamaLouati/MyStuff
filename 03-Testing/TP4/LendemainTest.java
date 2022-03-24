package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import TP4.Lendemain;

class LendemainTest {

	

	@Test
	void testmoisDe31Jours() {
		Lendemain t = new Lendemain();
		assertAll(
				
				()-> assertEquals("31/1/2011", t.jourSuivant(30, 1, 2011),"it gotta be"),
				()-> assertEquals("31/3/2011", t.jourSuivant(30, 3, 2011),"it gotta be"),
				()-> assertEquals("31/5/2011", t.jourSuivant(30, 5, 2011),"it gotta be"),
				()-> assertEquals("21/7/2011", t.jourSuivant(20, 7, 2011),"it gotta be"),
				()-> assertEquals("31/8/2011", t.jourSuivant(30, 8, 2011),"it gotta be"),
				()-> assertEquals("31/10/2011", t.jourSuivant(30, 10, 2011),"it gotta be"),
				()-> assertEquals("31/12/2011", t.jourSuivant(30, 12, 2011),"it gotta be"),
				()-> assertEquals("1/2/2011", t.jourSuivant(31, 1, 2011),"it gotta be"),
				()-> assertEquals("1/4/2011", t.jourSuivant(31, 3, 2011),"it gotta be"),
				()-> assertEquals("1/6/2011", t.jourSuivant(31, 5, 2011),"it gotta be"),
				
				//anomalie 1 resultat: 32/7/2011
				()-> assertEquals("1/8/2011", t.jourSuivant(31, 7, 2011),"it gotta be"),
				
				//anomalie 2 resultat: 32/7/2010
				()-> assertEquals("1/1/2011", t.jourSuivant(31, 12, 2010),"it gotta be"),
				
				//anomalie 3  resultat: 32/12/2011
				()-> assertEquals("1/1/2012", t.jourSuivant(31, 12, 2011),"it gotta be")
				
				
		);
	}
	@Test
	void testlmoisDe30jours() {
		Lendemain t = new Lendemain();
		assertAll(
				()-> assertEquals("1/5/2011", t.jourSuivant(30, 4, 2011),"it gotta be"),
				()-> assertEquals("1/7/2011", t.jourSuivant(30, 6, 2011),"it gotta be"),
				()-> assertEquals("1/10/2011", t.jourSuivant(30, 9, 2011),"it gotta be"),
				()-> assertEquals("1/12/2011", t.jourSuivant(30, 11, 2011),"it gotta be")
			);
	}
	@Test
	void testdecembre() {
		Lendemain t=new Lendemain();
		String res1=t.jourSuivant( 31, 12, 2020);
		//assertEquals("1/1/2021",res1);
	}

	
	@Test
	void tesestfeverier() {
		Lendemain t=new Lendemain();
		String res1=t.jourSuivant( 28, 2, 2021);
		assertEquals("1/3/2021",res1);
	}
	
	
	
	

}
