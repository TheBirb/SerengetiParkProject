package packSimulator;

import Exceptions.CaptureErrorException;
import Exceptions.ImpossibleToCaptureException;
import SerengetiPark.Drone;
import SerengetiPark.SerengetiMonitor;
import SerengetiPark.Specimen;
import packSpecimenHierarchy.GPS;

public class SerengetiSimulator{

	public static void main(String[] args) throws CaptureErrorException, ImpossibleToCaptureException  {
		GPS drones= new GPS(-2.949865, 35.062473);
		GPS a1= new GPS(-2.949865,35.062473);
		GPS a2= new GPS(-3.049865,34.962472999999996);
		GPS a3= new GPS(-2.749865,35.262473);
		GPS a4= new GPS(-3.249865,34.762473);
		GPS a5= new GPS(-2.549865,35.462472999999996);
		GPS a6= new GPS(-3.449865,34.562473);
		GPS a7= new GPS(-2.349865,35.662473 );
		GPS a8= new GPS(-3.649865,34.362472999999994);
		GPS a9= new GPS(-2.149865,35.862472999999994);
		GPS a10= new GPS(-3.849865,34.162473);
		
		Specimen s1= new Specimen("Tigre",a1);
		Specimen s2= new Specimen("Leopardo",a2);
		Specimen s3= new Specimen("Panda",a3);
		Specimen s4= new Specimen("Ciervo",a4);
		Specimen s5= new Specimen("Aguila",a5);
		Specimen s6= new Specimen("Agapornis",a6);
		Specimen s7= new Specimen("Cacatua",a7);
		Specimen s8= new Specimen("Leon",a8);
		Specimen s9= new Specimen("Suricato",a9);
		Specimen s10= new Specimen("Cuervo",a10);
		
		Drone d1= new Drone("Dron1", drones);
		Drone d2= new Drone("Dron2", drones);
		Drone d3= new Drone("Dron3", drones);
		
		SerengetiMonitor m=SerengetiMonitor.getInstance();
		m.addDrone(d1);
		m.addDrone(d2);
		m.addDrone(d3);
		
		m.addSpecimen(s1);
		m.addSpecimen(s2);
		m.addSpecimen(s3);
		m.addSpecimen(s4);
		m.addSpecimen(s5);
		m.addSpecimen(s6);
		m.addSpecimen(s7);
		m.addSpecimen(s8);
		m.addSpecimen(s9);
		m.addSpecimen(s10);
		m.closestSpecimen(300, s1);
		System.out.println("\n");
		m.collectImage(90, s1);
		
		
		
		
		
		
		
	}

}
