package bankomat;

import java.util.ArrayList;
import java.util.Scanner;

public class Racuni extends Start {
	public static ArrayList<Racuni> users = new ArrayList<Racuni>();
	private static Scanner x = new Scanner(System.in);
	public static String trenutnoIme;
	public static String trenutnaSifra;
	public static double trenutnePare;
	public static int trenutniId;
	private int id;
	private String ime;
	private double pare;
	private String sifra;

	public static void crate() {
		if(!x.equals(null)) {
			System.out.println("Just sfdf");
			x.nextLine();
		}
		System.out.print("Postavite korisnicko ime: ");
		String ime = ScanStr();
		System.out.print("Postavite korisnicku sifru: ");
		String sifra = ScanStr();
		int rnd = rnd();
		new Racuni(ime, sifra, rnd,0);
		menu(1);
	}

	/**
	 * Ova metoda trazi random broj koji se ne poklapa sa drugim ID-ovima
	 * 
	 * @return - Vraca random broj od 1 do 10000
	 */
	public static int rnd() {
		int rnd = (int) (Math.random() * 10000 + 1);
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getId() == rnd) {
				i = -1;
				rnd = (int) (Math.random() * 10000 + 1);
			}
		}
		return rnd;
	}

	public static void login() {
		System.out.print("Unesite korisnicko ime: ");
		String ime = ScanStr();
		System.out.print("Unesite korisnicku sifru: ");
		String sifra = ScanStr();
		String listaGreski = "============================\nError:";
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getIme().equals(ime)) {
				if (users.get(i).getSifra().equals(sifra)) {
					setTrenutnoIme(users.get(i).getIme());
					setTrenutnaSifra(users.get(i).getSifra());
					setTrenutnePare(users.get(i).getPare());
					setTrenutniId(users.get(i).getId());
					userMenu(1);
					return;
				} else {
					listaGreski += "Netacno unesena sifra!!";
					greska(listaGreski);
				}
			} else if (i == users.size() - 1) {
				listaGreski = listaGreski + "Nepronadjeno ime!!";
				greska(listaGreski);
			}
		}
	}

	public static void transfer() {
		String listaGreski = "============================\nError:";
		System.out.println("===============================");
		System.out.println("Unos informacija o korisniku\nkome saljete novac");
		System.out.println("===============================");
		System.out.print("ID: ");
		int id = ScanInt();
		System.out.println("==============");
		System.out.print("Ime: ");
		String ime = ScanStr();
		System.out.println("==============");
		for (int i = 0; i < users.size(); i++) {
			if (id == users.get(i).getId()) {
				if (users.get(i).getIme().equals(ime)) {
					System.out.println("====================");
					System.out.println("Korsnik " + ime + " je pronadjen!!!");
					System.out.println("====================");
					System.out.print("Koliko KM zelite poslati: ");
					double iznos = ScanInt();
					setTrenutnePare(trenutnePare - iznos);
					userMenu(1);
				} else {
					listaGreski += "Ime ne pripada unjetom ID-ju!!!!\\n=============================";
					System.out.println(listaGreski);
					userMenu(3);
				}
			} else if (i == users.size() - 1) {
				listaGreski += "Ne postoji odredjeni ID!!!\n=============================";
				System.out.println(listaGreski);
				userMenu(3);
			}
		}

	}

	public static void status() {
		System.out.println("======================");
		System.out.println("Ime: " + trenutnoIme);
		System.out.println("Id: " + trenutniId);
		System.out.println("Sifra: " + trenutnaSifra);
		System.out.println("Pare: "+ trenutnePare);
		System.out.println("======================");
		userMenu(1);
	}
	/**
	 * Ova metoda obavlja logout funkciju.
	 * U ovom slucaju obavlja duznosti vracanja staticnih varijabli na default 
	 * 
	 * @return - Vraca random broj od 1 do 10000
	 */
	public static void izlaz() {
		for (int i = 0; i < users.size(); i++) {
			if (trenutniId == users.get(i).getId()) {
				users.get(i).pare = trenutnePare;
				trenutnePare=0;
				trenutnoIme=null;
				trenutniId=0;
				trenutnaSifra=null;
				menu(4);
			}
		}
	}

	public static void greska(String listaGreski) {
		System.out.println(listaGreski);
		System.out.println("==============================");
		System.out.println("1 - Pokusaj ponovo\n2 - Izlaz");
		System.out.println("==============================");
		System.out.print("Vas izbor: ");
		int odluka = ScanInt();
		switch (odluka) {
		case 1:
			String br = ScanStr();
			System.out.println("=================");
			login();
			break;
		case 2:
			menu(3);
			break;
		default:
			System.out.println("==============");
			System.out.println("Nevazeci unos!");
			System.out.println("==============");
			greska(listaGreski);
			break;
		}
	}

	private static String ScanStr() {
		int cross = 0;
		String str = " ";
		do {
			try {
				str = x.nextLine();
				cross = 1;
			} catch (Exception e) {
				x.nextLine();
				System.out.println("========================");
				System.out.println("Greska: " + e);
				System.out.print("Pokusaj ponovo: ");
				System.out.println("========================");
			}
		} while (cross == 0);

		return str;
	}

	private static int ScanInt() {
		int cross = 0, broj = 0;
		do {
			try {
				broj = x.nextInt();
				cross = 1;
			} catch (Exception e) {
				x.nextInt();
				System.out.println("========================");
				System.out.println("Greska: " + e);
				System.out.println("========================");
				System.out.print("Pokusaj ponovo: ");

			}
		} while (cross == 0);
		return broj;
	}

	// KORSTRUKTORI & GET\SET METODE
	String getIme() {
		return ime;
	}

	void setIme(String ime) {
		this.ime = ime;
	}

	String getSifra() {
		return sifra;
	}

	void setSifra(String sifra) {
		this.sifra = sifra;
	}

	static String getTrenutnoIme() {
		return trenutnoIme;
	}

	static void setTrenutnoIme(String trenutnoIme) {
		Racuni.trenutnoIme = trenutnoIme;
	}

	static String getTrenutnaSifra() {
		return trenutnaSifra;
	}

	static void setTrenutnaSifra(String trenutnaSifra) {
		Racuni.trenutnaSifra = trenutnaSifra;
	}

	static double getTrenutnePare() {
		return trenutnePare;
	}

	static void setTrenutnePare(double trenutnePare) {
		Racuni.trenutnePare = trenutnePare;
	}

	double getPare() {
		return pare;
	}

	void setPare(double pare) {
		this.pare = pare;
	}

	static int getTrenutniId() {
		return trenutniId;
	}

	static void setTrenutniId(int trenutniId) {
		Racuni.trenutniId = trenutniId;
	}

	int getId() {
		return id;
	}

	void setId(int id) {
		this.id = id;
	}

	public Racuni(String ime, String sifra, int rnd,int test) {
		this.ime = ime;
		this.sifra = sifra;
		this.pare = 0;
		this.id = rnd;
		if(test==1)
		users.add(this);
	}

	public Racuni(String ime, String sifra, double pare, int id,int test) {
		this.ime = ime;
		this.sifra = sifra;
		this.pare = pare;
		this.id = id;
		if(test==1)
		users.add(this);
	}

	public Racuni() {

	}

}
