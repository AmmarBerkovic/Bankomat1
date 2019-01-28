package bankomat;

import java.io.File;
import java.util.Scanner;

public class LRCRacuni extends Racuni {
	public static Scanner x;

	LRCRacuni() {

	}
	/**
     * Metoda koja otvara odredjeni tekstualni fajl
     * 
     * 
     * @return uvjek vraca true
     */
	public static boolean load() {
		try {
			x = new Scanner(new File("racuni.txt"));
		} catch (Exception e) {
			System.out.println(e + "/nNisu ucitani korisnici...");
		}
		return true;
	}
	/**
     * Metoda koja kupi informacije iz tekstualnog fajla i od njeg pravi nove racune
     * 
     * 
     * 
     */
	public static void read() {
		while (x.hasNext()) {
			String ime = x.next();
			double pare = x.nextDouble();
			String sifra = x.next();
			int id = x.nextInt();
			new Racuni(ime, sifra, pare, id);
		}
	}
	/**
     * Metoda koja zatvara tekstualni fajl kad smo vec zavrsili sa koristenjem istog
     * 
     * 
     * 
     */
	public static void close() {
		x.close();
	}
	
}
