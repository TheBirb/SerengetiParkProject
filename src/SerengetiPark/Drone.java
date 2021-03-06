//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : SerengetiPark
//  @ File Name : Drone.java
//  @ Date : 03/04/2020
//  @ Author : mmjon 
//
//
package SerengetiPark;
import Exceptions.*;
import packSpecimenHierarchy.GPS;
/**
 * Used to create and control a drone
 * @author mmjon
 *
 */
public class Drone {
	//Attributes
	private String name;
	private boolean availability;
	private GPS position;
	/**
	 * Constructor of Drone class
	 * @param name, name of the drone
	 * @param position, position of the drone
	 */
	public Drone(String name, GPS position) {
		this.name= name;
		this.availability= true;
		this.position=position;
	}
	/**
	 * Method used to know the availability of the Drone
	 * @return availability, attribute
	 */
	public boolean getAvailability() {
		return availability;
	}
	/**
	 * Method used to set the availability of the Drone
	 * @param availability, availability of the Drone
	 */
	public void setAvailability(boolean availability) {
		this.availability=availability;
	}
	/**
	 * Method used to know the location of the Drone
	 * @return position,  location of the Drone
	 */
	public GPS whereIAm() {
		return position;
	}
	/**
	 * Method used to move the Drone and Capture an image
	 * @param position, location of the drone
	 * @return An image
	 * @throws CaptureErrorException, exception elevated when no photo can be captured
	 */
	public byte[][] moveAndCaptureImage(GPS position) throws CaptureErrorException{
		move(position);
		return tryToCapture();
	}
	/**
	 * Simulates the travel time and drone position change
	 * @param newPosition new position to move
	 */
	public void move(GPS newPosition){
		System.out.print("  ...desplaz�ndose a "+newPosition+" ...");
		double distance= position.distanceTo(newPosition);
		boolean yes = false;
		while (!yes) {
			try {
				Thread.sleep((long)distance  * 100);
				yes = true;
			} catch (InterruptedException e) {
				System.out.print("... No he podido dormir");
				Thread.currentThread().interrupt();
			}
		}
		position= newPosition;
		System.out.println("    ... he llegado.");
	}
	/**
	 * Simulate image capture with potential failure
	 * @param distance kilometers made by the drone
	 * @return the captured image
	 * @throws CaptureErrorException when it was not possible to capture the image
	 */
	private byte[][] tryToCapture() throws CaptureErrorException{
		System.out.print("    ... intento de realizar la captura ...");

		byte[][] image = new byte[1000][1000];
		
		// Simulates the possibility or not of image capture
		int time = (int)Math.floor(Math.random()*116+1); System.out.print(time);
		if (time % 3 == 0) {
			throw new CaptureErrorException();
		}
		System.out.println("... imagen capturada ...");		
		return image;
	}
	@Override
	public String toString(){
		return "Name:"+" "+name+" "+","+"Coordinates:" +"["+ position.toString()+"]"+","+ " "+"Availability:"+" "+ availability;
	}

}
