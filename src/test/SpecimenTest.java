package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import SerengetiPark.Specimen;
import packSpecimenHierarchy.GPS;

class SpecimenTest {
	GPS g1;
	Specimen s;
	@BeforeEach
	public void setUp() {
		g1= new GPS(40.452961,-3.688333);
		 s= new Specimen("s", g1);
	}
	@Test @DisplayName("Without any point registered")
	public void test1() {
		
		assertEquals(s.kmsTravelled(), 0);
		
		
	}
	@Test @DisplayName("With only one registered point")
	public void test2() {
		
		GPS g2= new GPS(43.5372001,-5.6370439);
		s.setGPS(g2);
		assertEquals(s.kmsTravelled(),310.1044761184953 );
		
		
	}
	@Test @DisplayName("With more than one registered point")
	public void test3() {
		GPS g3= new GPS(43.5402668,-5.6475824);
		GPS g2= new GPS(43.5372001,-5.6370439);
		s.setGPS(g2);
		s.setGPS(g3);
		assertEquals(s.kmsTravelled(),311.0374053548184);
		
		
		
	}
	
	


}
