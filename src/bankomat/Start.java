package bankomat;

import java.util.Scanner;

import javax.net.ssl.SSLEngineResult.Status;

public class Start {
	private static Scanner x = new Scanner(System.in);
	/**
     * Ovo je main metoda u kojoj se ucitavaju svi racuni i spremaju se u ArrayListu svih racuna koji su u potrebi
     * 
     * 
     * 
     */
	public static void main(String[] args) {
		LRCRacuni.load();
		LRCRacuni.read();
		LRCRacuni.close();
		menu(5);

	}
	/**
     * Ovo je metoda koja sadrzi opcije pocetnog Menua
     * Ona sadrzi sign in sing up i izlaz iz programa
     * 
     * 
     */
	public static void menu(int pristup) {
		System.out.println(pristup(pristup));
		System.out.println(pristup(2));
		System.out.print("Vas izbor: ");
		int izbor=ScanInt();
		switch (izbor) {
		case 1:
			x.nextLine();
			System.out.print("Unesite korisnicko ime: ");
			String ime1 = ScanStr();
			System.out.print("Unesite korisnicku sifru: ");
			String sifra1 = ScanStr();
			Racuni.userMenu(5, Racuni.login(ime1,sifra1).getId());;
			break;
		case 2:
			x.nextLine();
			System.out.print("Postavite korisnicko ime: ");
			String ime = ScanStr();
			System.out.print("Postavite korisnicku sifru: ");
			String sifra = ScanStr();
			Racuni.crate(ime,sifra).status();
			menu(1);
			break;
		case 3:
			System.out.println(pristup(6));
			System.exit(0);
			break;
		default:
			menu(2);
			break;
		}
	}
	
	/**
     * Ovo je metoda koja sadrzi opcije userMenua
     * Ona sadrzi transakciju novca status profila i izlaz u pocetni menu
     * 
     * 
     */
	public static void userMenu(int pristup,int id) {
		System.out.println(pristup(pristup));
		System.out.println(pristup(4));
		System.out.print("Vas izbor: ");
		int izbor = ScanInt();
		switch (izbor) {
		case 1:
			System.out.print("Unesi kolko zelis prenjet: ");
			double iznos=ScanInt();
			for (int i = 0; i < Racuni.users.size(); i++) {
				if(id==Racuni.users.get(i).getId()) {
					Racuni.users.get(i).oduzmi(iznos);
				}
			}
			System.out.println("Unesi ID onog accounta na koji zelis prebacit novac");
			int ide=ScanInt();
			for (int i = 0; i < Racuni.users.size(); i++) {
				if(ide==Racuni.users.get(i).getId()) {
					Racuni.users.get(i).dodaj(iznos);
				}
			}
			break;
		case 2:
			for (int i = 0; i < Racuni.users.size(); i++) {
				if(id==Racuni.users.get(i).getId()) {
					Racuni.users.get(i).status();
					userMenu(1,id);
				}
			}
			
			break;
		case 3:
			for (int i = 0; i < Racuni.users.size(); i++) {
				if(id==Racuni.users.get(i).getId()) {
					Racuni.users.get(i).izlaz();
				}
			}
			menu(1);
			break;
		}
		
	}
	/**
     * Ova metoda sadrzi poruke koje ispisujemo na konzoli
     * Sadrzi razlicite vrste pristupa u zavisnosti od toga kakva je korisinik imo iskustva sa rukovanjem programa
     * 
     * @return vraca odgovarajucu poruku
     */
	public  static String pristup(int pristup) {
		String poruka="";
		switch (pristup) {
		case 5:
			poruka="Dobro dosli!!!";
			break;

		case 3:
			poruka="Zao nam je sto ste imali poteskoca sa unosom\nPokusajte ponovo!!";
			break;
		case 1:
			poruka="Uspijesno odradjena radnja!!!";
			break;
		case 2:
			poruka="===================\n1 - Prijava\n2 - Kreiraj racun\n3 - Izlaz\n===================";
			break;
		case 4:
			poruka="===================\n1 - Transfer novca\n2 - Status\n3 - Izlaz\n===================";
			break;
		case 6:
			poruka="==============\nDovidjenja!!!\n==============";
			break;
			
		}
		
		return poruka;
	}
	/**
     * Ova metoda rukuje sa exceptionima koji se nadju kada pokusamo unjeti String tip podataka
     * 
     * @return - Vraca unesenu String varijablu
     */
	public static String ScanStr() {
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
	public static int ScanInt() {
		int cross = 0, broj = 0;
		do {
			try {
				broj = x.nextInt();
				cross = 1;
			} catch (Exception e) {
				x.nextLine();
				System.out.println("Greska: " + e);
				System.out.print("Pokusaj ponovo: ");
			}
		} while (cross == 0);
		return broj;
	}
}
