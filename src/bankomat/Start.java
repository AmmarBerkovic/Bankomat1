package bankomat;

import java.util.Scanner;

import javax.net.ssl.SSLEngineResult.Status;

public class Start {
	private static Scanner x = new Scanner(System.in);

	public static void main(String[] args) {
		new LRCRacuni();
		LRCRacuni.load();
		LRCRacuni.read();
		LRCRacuni.close();
		menu(5);

	}
	
	public static void menu(int pristup) {
		pristup(pristup);
		System.out.println("===================");
		System.out.println("1 - Prijava\n2 - Kreiraj racun\n3 - Izlaz ");
		System.out.println("===================");
		System.out.print("Vas izbor: ");
		int izbor = ScanInt();
		switch (izbor) {
		case 1:
			new Racuni();
			Racuni.login();
			break;
		case 2:
			new Racuni();
			Racuni.crate();
			break;
		case 3:
			System.out.println("==============");
			System.out.println("Dovidjenja!!!");
			System.out.println("==============");
			System.exit(0);
			break;
		default:
			menu(2);
			break;
		}
	}
	public static void userMenu(int pristup) {
		pristup(pristup);
		System.out.println("===================");
		System.out.println("1 - Transfer novca\n2 - Status\n3 - Izlaz");
		System.out.println("===================");
		System.out.print("Vas izbor: ");
		int izbor = ScanInt();
		switch (izbor) {
		case 1:
			new Racuni();
			Racuni.transfer();
			break;
		case 2:
			new Racuni();
			Racuni.status();
			break;
		case 3:
			new Racuni();
			Racuni.izlaz();
			break;
		}
		
	}
	/**
     * Ova metoda sadrzi poruke koje ispisujemo na konzoli
     * Sadrzi razlicite vrste pristupa u zavisnosti od toga kakva je korisinik imo iskustva sa rukovanjem programa
     * 
     * 
     */
	private static void pristup(int pristup) {
		switch (pristup) {
		case 5:
			System.out.println("Dobro dosli!!!");
			break;
		case 2:
			System.out.println("Greska!!\nPokusajte ponovo!!");
			break;
		case 3:
			System.out.println("Zao nam je sto ste imali poteskoca sa unosom\nPokusajte ponovo!!");
			break;
		case 1:
			System.out.println("Uspijesno odradjena radnja!!!");
			break;
		case 4:
			System.out.println("Uspijesno ste izasli iz svog profila!!!");
			break;
			
		}
	}
	/**
     * Ova metoda rukuje sa exceptionima koji se nadju kada pokusamo unjeti String tip podataka
     * 
     * @return - Vraca unesenu String varijablu
     */
	private static String ScanStr() {
		int cross = 0;
		String str = " ";
		do {
			try {
				str = x.nextLine();
				cross = 1;
			} catch (Exception e) {
				x.nextLine();
				System.out.println("Greska: " + e);
				System.out.print("Pokusaj ponovo: ");
			}
		} while (cross == 0);
		return str;
	}
	/**
     * Ova metoda rukuje sa exceptionima koji se nadju kada pokusamo unjeti int tip podataka
     * 
     * @return - Vraca unesenu int varijablu
     */
	private static int ScanInt() {
		int cross = 0, broj = 0;
		do {
			try {
				broj = x.nextInt();
				cross = 1;
			} catch (Exception e) {
				x.nextLine();
				System.out.println("=========================================");
				System.out.println("Greska: " + e);
				System.out.println("=========================================");
				System.out.print("Pokusaj ponovo: ");
			}
		} while (cross == 0);
		return broj;
	}
}
