package SerengetiPark;

import java.util.Random;

import packSpecimenHierarchy.GPS;


/**
 * Simulate the GPS position capture device
 * 
 * @author PMOO Profesors
 *
 */
public class TrackingDevice {
	private final double CORRECTION_VALUE = 85;
	private Random displacement = new Random(); // 0- not move,
									// 1-low speed, 2 high speed
	private Random orientation = new Random(); // 0(-135�), 1(-90�),
	// 2(-45), 3(0�), 4(45�), ...
	
	private final double DISTANCE = 10; 
	

	private GPS lastPosition;

	public TrackingDevice(GPS lastPosition) {
		this.lastPosition = lastPosition;
	}

	public GPS whereIAm() {
		int d = displacement.nextInt(3);
//		System.out.println("Move & velocity " + d);
		if (d > 0) {
			double latitude = lastPosition.getLatitude();
			double longitude = lastPosition.getLongitude();
			int o = orientation.nextInt(8);
//			System.out.println("Orientation: " + o);
			double a = d * DISTANCE / CORRECTION_VALUE;
//			System.out.println("Distance: " + a * VALOR_CORRECTOR);
			switch (o) {
				case 0:
					latitude = latitude + a * Math.sin(-135 * Math.PI / 180);
					longitude = longitude + a * Math.cos(-135 * Math.PI / 180);
					break;
				case 1:
					latitude = latitude - a;
					break;
				case 2:
					latitude = latitude + a * Math.sin(-45 * Math.PI / 180);
					longitude = longitude + a * Math.cos(-45 * Math.PI / 180);
					break;
				case 3:
					longitude = longitude + a;
					break;
				case 4:
					latitude = latitude + a * Math.sin(45 * Math.PI / 180);
					longitude = longitude + a * Math.cos(45 * Math.PI / 180);
					break;
				case 5:
					latitude = latitude + a;
					break;
				case 6:
					latitude = latitude + a * Math.sin(135 * Math.PI / 180);
					longitude = longitude + a * Math.cos(135 * Math.PI / 180);
					break;
				default:
					longitude = longitude - a;
			}
			lastPosition = new GPS(latitude, longitude);
		}
		return lastPosition;
	}

	public static void main(String[] args) {
		GPS donostia, bilbo, gasteiz;
		gasteiz = new GPS(42.8591338, -2.6818614);
		donostia = new GPS(43.318334, -1.9812313);
		bilbo = new GPS(43.2630126, -2.9349852);
		Specimen perro = new Specimen("perro", gasteiz);
		Specimen gato = new Specimen("gato", donostia);
		Specimen canario = new Specimen("canario", bilbo);

		GPS newGasteiz = perro.register();
		System.out.println("        de " + gasteiz.toString() + " a " + newGasteiz.toString());
		System.out.println("El perro se ha desplazado " + gasteiz.distanceTo(newGasteiz));
		System.out.println();
		GPS newDonostia = gato.register();
		System.out.println("El gato se ha desplazado " + donostia.distanceTo(newDonostia));
		System.out.println("        de " + donostia.toString() + " a " + newDonostia.toString());
		System.out.println();
		GPS newBilbo = canario.register();
		System.out.println("El canario se ha desplazado " + bilbo.distanceTo(newBilbo));
		System.out.println("        de " + bilbo.toString() + " a " + newBilbo.toString());
		System.out.println();
		System.out.println("Seno de 90 " + Math.sin(90*Math.PI/180) + ", coseno de 90 " + Math.cos(90*Math.PI/180));
	}
}