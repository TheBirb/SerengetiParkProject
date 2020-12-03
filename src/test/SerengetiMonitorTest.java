package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import SerengetiPark.Drone;
import SerengetiPark.SerengetiMonitor;
import SerengetiPark.Specimen;
import packSpecimenHierarchy.GPS;


class SerengetiMonitorTest {
	ArrayList<Specimen> w;
	GPS a1;
	GPS drones;
	GPS a2;
	GPS a3;
	Specimen s1;
	Specimen s2;
	Specimen s3;
	SerengetiMonitor s;
	
	
	@BeforeEach
	void test() {
		w= new ArrayList<Specimen>();
		 s=SerengetiMonitor.getInstance();
		 drones= new GPS(-2.949865, 35.062473);
		 a1= new GPS(-2.949865,35.062473);
		 a2= new GPS(-3.049865,34.962472999999996);
		 a3= new GPS(-2.749865,35.262473);
		 s1= new Specimen("Tiger",a1);
		 s2= new Specimen("Leopard",a2);
		 s3= new Specimen("Panda",a3);
		Drone d1= new Drone("Dron1", drones);
		Drone d2= new Drone("Dron2", drones);
		Drone d3= new Drone("Dron3", drones);
		 s.addSpecimen(s1);
		 s.addSpecimen(s2);
		 s.addSpecimen(s3);
		 s.addDrone(d1);
		 s.addDrone(d2);
		 s.addDrone(d3);
		 
		 w.add(s2);
		 w.add(s3);
	}
	@Test @DisplayName("Two animal close to the selected animal(ClosestSpecimen)")
	public void test1() {

		ArrayList<Specimen> l = s.closestSpecimen(3000000, s1);
		
		assertEquals(w, l);
		
		
	}
	@Test @DisplayName("Method that with a certain attempts return an image(CaptureWithAttempts)")
	public void test2() {
		
		assertDoesNotThrow(() ->{s.captureWithAttempts(3, s1);});
		
		
		
		
		
		
	}
	@Test@DisplayName("Method that captures an image from each animal that is close to a specified one(collectImage)")
	public void test3() {
	assertEquals(2, s.collectImage(3000, s1).size());
	}

}
