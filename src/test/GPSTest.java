package test;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import packSpecimenHierarchy.GPS;

class GPSTest {

	@Test @DisplayName("La distancia entre bernabeu y Camp Nou ")
	public void test1() {
		GPS g1= new GPS(40.452961,-3.688333);
		GPS g2= new GPS(41.380833,2.122778);
		assertEquals(g1.distanceTo(g2), 500.2014023941193);
		
	}
	@Test @DisplayName("La distancia entre dos puntos cercanos ")
	public void test2() {
		GPS g3= new GPS(43.5372001,-5.6370439);
		GPS g4= new GPS(43.5402668,-5.6475824);
		assertEquals(g3.distanceTo(g4), 0.9329292363231048);
		
	}
	@Test @DisplayName("La distancia entre dos puntos muy cercanos ")
	public void test3() {
		GPS g5= new GPS(43.5291675,-5.639102);
		GPS g6= new GPS( 43.5292752,-5.6390161);
		assertEquals(g5.distanceTo(g6), 0.011709687122280063);
		
	}
	
	@Test @DisplayName("La distancia entre dos puntos")
	public void test4() {
		GPS g7= new GPS( 42.8591338,-2.6818614);
		GPS g8= new GPS(43.318334,-1.9812313);
		assertEquals(g7.distanceTo(g8), 71.2048079914636);
		
	}
	@Test @DisplayName("La distancia entre dos puntos")
	public void test5() {
		GPS g9= new GPS(42.8591338,-2.6818614);
		GPS g10= new GPS( 43.2630126,-2.9349852);
		assertEquals(g9.distanceTo(g10), 40.51476144240195);
		
	}
	@Test @DisplayName("La distancia entre dos puntos")
	public void test6() {
		GPS g11= new GPS(43.2630126, -2.9349852);
		GPS g12= new GPS(43.318334,-1.9812313);
		
		assertEquals(g11.distanceTo(g12),  81.2053432923684);
		
	}
}
