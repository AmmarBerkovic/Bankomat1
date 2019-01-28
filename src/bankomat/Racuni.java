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
	/**
     * Dodaje racun na users ArrayListu
     * 
     * 
     */
	public static Racuni crate(String ime, String sifra) {
		int rnd = rnd();
		Racuni rcn = new Racuni(ime, sifra, 0, rnd);
		tren(rcn);
		return rcn;

	}
	/**
     * Ova metoda postavlja static varijable uzimajuci podatke od odredjenog racuna
     * 
     * 
     */
	public static void tren(Racuni racun) {
		trenutnoIme = racun.ime;
		trenutniId = racun.id;
		trenutnePare = racun.pare;
		trenutnaSifra = racun.sifra;
	}
	/**
     * Ova metoda dodaje pare na odredjeni racun
     * 
     * 
     */
	public void dodaj(double iznos) {
		this.pare += iznos;
	}
	/**
     * Ova metoda oduzima pare od odredjenog racuna
     * 
     * 
     */
	public void oduzmi(double iznos) {
		this.pare -= iznos;
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
	/**
     * Ova metoda prima ime i sifru te istrazuje da li ce se to dvoje podudarati sa racunom u users ArrayListi, ako je to ispunjeno ulazi u user menu
     * 
     * 
     */
	public static Racuni login(String ime, String sifra) {
		Racuni taj=new Racuni();
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getIme().equals(ime)) {
				if (users.get(i).getSifra().equals(sifra)) {
					setTrenutnoIme(users.get(i).getIme());
					setTrenutnaSifra(users.get(i).getSifra());
					setTrenutnePare(users.get(i).getPare());
					setTrenutniId(users.get(i).getId());
					userMenu(1,users.get(i).getId());
					taj = users.get(i);
				} else {
					System.out.println("Netacno unesena sifra!!");
					menu(3);
				}
			} else if (i == users.size() - 1) {
				System.out.println("Nepronadjeno ime!!");
				menu(3);
			}
		}
		return taj;
	}

	/**
     * Ova metoda vraca sve podatke o odredjenom racunu 
     * 
     * 
     */

	public void status() {
		System.out.println("======================");
		System.out.println("Ime: " + this.getIme());
		System.out.println("Id: " + this.getId());
		System.out.println("Sifra: " + this.getSifra());
		System.out.println("Pare: " + this.getPare());
		System.out.println("======================");
	}

	/**
	 * Ova metoda obavlja logout funkciju. U ovom slucaju obavlja duznosti vracanja
	 * staticnih varijabli na default
	 * 
	 * 
	 */
	public void izlaz() {
		this.pare = trenutnePare;
		trenutnePare = 0;
		trenutnoIme = null;
		trenutniId = 0;
		trenutnaSifra = null;
		
		
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
				System.out.println("========================");
				System.out.println("Greska: " + e);
				System.out.print("Pokusaj ponovo: ");
				System.out.println("========================");
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
	/**
     * 
     * 
     * 
     * @return Vracanje imena odredjnog racuna
     */
	public String getIme() {
		return ime;
	}
	/**
     * 
     * 
     * 
     * postavljanje  imena odredjenog racuna
     */
	void setIme(String ime) {
		this.ime = ime;
	}
	/**
     * 
     * 
     * 
     * @return Vracanje sifre odredjnog racuna
     */
	public String getSifra() {
		return sifra;
	}
	/**
     * 
     * 
     * 
     * postavljanje sifre odredjenog racuna
     * 
     *      */
	void setSifra(String sifra) {
		this.sifra = sifra;
	}
	/**
     * 
     * 
     * 
     * @return Vraca odredjeno ime
     */
	static String getTrenutnoIme() {
		return trenutnoIme;
	}
	/**
     * 
     * 
     * 
     * postavljanje staticnog imena
     */
	static void setTrenutnoIme(String trenutnoIme) {
		Racuni.trenutnoIme = trenutnoIme;
	}
	/**
     * 
     * 
     * 
     * @return Vracanje staticne sifre
     */
	static String getTrenutnaSifra() {
		return trenutnaSifra;
	}
	/**
     * 
     * 
     * 
     * postavljenje  staticne sifre
     */
	static void setTrenutnaSifra(String trenutnaSifra) {
		Racuni.trenutnaSifra = trenutnaSifra;
	}
	/**
     * 
     * 
     * 
     * @return Vracanje staticnog pare varijable
     */
	static double getTrenutnePare() {
		return trenutnePare;
	}
	/**
     * postavljanje para na static pare varijablu
     * 
     * 
     * 
     */
	static void setTrenutnePare(double trenutnePare) {
		Racuni.trenutnePare = trenutnePare;
	}

	public double getPare() {
		return pare;
	}
	
	void setPare(double pare) {
		this.pare = pare;
	}
	/**
     * 
     * 
     * 
     * @return Vracanje staticnog id-a
     */
	static int getTrenutniId() {
		return trenutniId;
	}

	/**
     * postavljanje id na static id varijablu
     * 
     * 
     * 
     */
	static void setTrenutniId(int trenutniId) {
		Racuni.trenutniId = trenutniId;
	}
	/**
     * 
     * 
     * 
     * @return Vracanje id odabranog racuna
     */
	public int getId() {
		return id;
	}
	/**
     * postavljanje id na neki racun
     * 
     * 
     * 
     */
	void setId(int id) {
		this.id = id;
	}
	/**
     * Konstruktor koji postavlja pare,ime,sifru i id na novonapravljeni racun
     * 
     * 
     * 
     */
	public Racuni(String ime, String sifra, int rnd) {
		this.ime = ime;
		this.sifra = sifra;
		this.pare = 50;
		this.id = rnd;
		users.add(this);
	}
	/**
     * Konstruktor koji postavlja sifru,ime i pare na novonapravljeni racun
     * 
     * 
     * 
     */
	public Racuni(String ime, String sifra, double rnd) {
		this.ime = ime;
		this.sifra = sifra;
		this.pare = rnd;
		users.add(this);
	}
	/**
     * Konstruktor koji postavlja pare,sifru,ime i id na novonapravljeni racun
     * 
     * 
     * 
     */
	public Racuni(String ime, String sifra, double pare, int id) {
		this.ime = ime;
		this.sifra = sifra;
		this.pare = pare;
		this.id = id;
		users.add(this);
	}
	/**
     * Konstruktor koji formira novi napravljeni racun
     * 
     * 
     * 
     */
	public Racuni() {

	}
	/**
     * Konstruktor koji postavlja pare na novonapravljeni racun
     * 
     * 
     * 
     */
	public Racuni(double pare) {
		this.pare=pare;
	}
}
