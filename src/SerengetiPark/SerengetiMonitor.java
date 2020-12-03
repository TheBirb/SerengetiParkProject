package SerengetiPark;

import java.util.ArrayList;

import Exceptions.CaptureErrorException;
import Exceptions.ImpossibleToCaptureException;
import packSpecimenHierarchy.GPS;

public class SerengetiMonitor {
	//Attributes
	private static SerengetiMonitor instance;
	private ArrayList<Specimen> species;
	private ArrayList<Drone> drones;
	private ArrayList<Specimen> closest;
	
	private ArrayList<byte[][]> photolist;
	/**
	 * Singleton of class SerengetiMonitor
	 * @return class's instance
	 */
	public static SerengetiMonitor getInstance() {
		if(instance==null) {
			instance= new SerengetiMonitor();
			
		}
		return instance;
	}
	/**
	 * Constructor of class SerengtiMonitor
	 */
	private SerengetiMonitor() {
		drones= new ArrayList<Drone>();
		species= new ArrayList<Specimen>();
		photolist= new ArrayList<byte[][]>();
		
		
		
	}
	/**
	 * Method used to add an specimen to the specimen list
	 * @param s, Specimen type object
	 */
	public void addSpecimen(Specimen s) {
		species.add(s);
	}
	/**
	 * Method used to add a drone to the drone list
	 * @param d, drone type object
	 */
	public void addDrone(Drone d) {
		drones.add(d);
	}
	public ArrayList<Specimen> closestSpecimen(double max, Specimen s) {
		closest= new ArrayList<Specimen>();
		System.out.println("Animales cercanos a menos de"+" "+max+" "+"kms del espcimen otorgado");
		int i=0;
		GPS s1=s.lastPosition();
		while(i<species.size()) {
			if(s.getName()!=species.get(i).getName()) {
				GPS s2=species.get(i).lastPosition();
				if(s1.distanceTo(s2)<=max) {
					System.out.println(species.get(i)+" "+" distancia:"+" "+s1.distanceTo(s2));
					closest.add(species.get(i));
				}
			}
			i++;
		}
		return closest;
		
	}
	/**
	 * Method used to make a drone capture an image of a specimen but with a certain number of attempts
	 * @param n, number of attempts
	 * @param l, specimen from which you want to take a photo
	 * @return an image
	 * @throws CaptureErrorException, exception elevated when no photo can be captured
	 * @throws ImpossibleToCaptureException, exception elevated when after a series of attempts, the image could not be captured
	 */
	public byte[][] captureWithAttempts(int n, Specimen l) throws ImpossibleToCaptureException {
		int i=0;
		boolean done=false;
		byte[][] photo=null;
		while(i<drones.size() && done==false) {
			if(drones.get(i).getAvailability()==true) {
				drones.get(i).setAvailability(false);
				int times=1;
				
				while(times<=n && done==false) {
					System.out.println("\n");
					System.out.println("--intento: "+times+","+" "+drones.get(i).toString()+"\n");
					try{photo=drones.get(i).moveAndCaptureImage(l.lastPosition());
						
					}catch(CaptureErrorException e) {
					times++;	
					
					
					}
					if(photo!=null) {
						done=true;
					}
					
				}
				
					drones.get(i).setAvailability(true);
				
				
			}
		
			
			i++;
		}
		if(done=false) {
			throw new ImpossibleToCaptureException();
			
		}
		return photo;
		
		
		
		
		
	}
	/**
	 * Method used to collect images from specimen that are close to another specimen
	 * @param maxkms, max kilometers from the desired specimen
	 * @param s, selected specimen
	 * @return different images
	 * @throws CaptureErrorException, exception elevated when no photo can be captured
	 */
	public ArrayList<byte[][]> collectImage(double maxkms, Specimen s)  {
		
		System.out.println("Especie en revision: "+" "+" "+ s.getName()+" "+"captura de imagenes de animales cercanos a"+" "+maxkms+" "+ "kms");
		
		closestSpecimen(maxkms, s);
		int i=0;
		int not=0;
		byte[][] photo=null;
		while(i<closest.size()) {
			System.out.println("\n"); 
			System.out.println("==> Revision"+closest.get(i).toString());
			try{
				photo=captureWithAttempts(5, closest.get(i));
			
			}catch (ImpossibleToCaptureException e) {
				not++;
			
			}
			if(photo!=null) {
				photolist.add(photo);
			}
			
			i++;
			photo=null;
		}
		if(not!=0) {
		System.out.println("An imaged could not be captured from :"+" "+not+" "+ "specimen");
		}else {
			System.out.println("\n");
			System.out.println(closest.size()-not+" "+"imagen/nes ha/han sido capturada/s");
			System.out.println("habia"+" "+ closest.size()+" "+"animales a "+ " "+ maxkms+" "+" kms");
			
	}
		
		return photolist;
		
		
	}
	/**
	 * Method used to simulate time and the movement of the specimen
	 * @param time, the period that it is wanted to be active
	 */
	public void updatePositions(int time) {
		for(int i=0; i<species.size(); i++) {
			species.get(i).updatePositions(time);
		}
	}
	
	
}
