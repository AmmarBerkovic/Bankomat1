package bankomat;

import java.io.File;
import java.util.Scanner;

public class LRCRacuni extends Racuni {
	public static Scanner x;

	LRCRacuni() {

	}

	public static void load() {
		try {
			x = new Scanner(new File("racuni.txt"));
		} catch (Exception e) {
			System.out.println(e + "/nNisu ucitani korisnici...");
		}
	}

	public static void read() {
		while (x.hasNext()) {
			String ime = x.next();
			double pare = x.nextDouble();
			String sifra = x.next();
			int id = x.nextInt();
			new Racuni(ime, sifra, pare, id,0);
		}
	}

	public static void close() {
		x.close();
	}
}
