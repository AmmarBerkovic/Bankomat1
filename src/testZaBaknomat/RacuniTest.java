package testZaBaknomat;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import bankomat.LRCRacuni;
import bankomat.Racuni;

public class RacuniTest extends Racuni {
	Racuni racun;
	int broj;
	@Before
	public void pre() {
		
	}

	@After
	public void posle() {
		racun=null;
	}

	@Test
	public void rndTest1() {
		int rnd=Racuni.rnd();
		assertTrue(rnd<10000);
	}
	@Test 
	public void rndTest2() {
		int rnd=Racuni.rnd();
		assertTrue(0<rnd);
	}
	

	@Test
	public void createTest1() {
		racun = Racuni.crate("Ammar", "ammar");
		assertEquals(trenutniId, racun.getId());
		

		
	}
	@Test
	public void createTest2() {
		racun = Racuni.crate("Ammar", "ammar");
		assertEquals(trenutnaSifra, racun.getSifra());
		

		
	}
	@Test
	public void createTest3() {
		racun = Racuni.crate("Ammar", "ammar");
		assertEquals(trenutnoIme, racun.getIme());
	}
	
	@Test
	public void createTest4() {
		racun = Racuni.crate("Ammar", "ammar");
		assertEquals(trenutnePare, racun.getPare(),2);
	}
	@Test 
	public void loadTest() {
		assertTrue(LRCRacuni.load());
	}
	
	@Test
	public void dodajTest() {
		racun = new Racuni(50);
		racun.dodaj(40);
		assertEquals(90, racun.getPare(),1);
	}
	@Test
	public void oduzmiTest() {
		racun = new Racuni(50);
		racun.oduzmi(40);
		assertEquals(10, racun.getPare(),1);
	}
	@Test
	public void ScanStrTest() {
		String ime=ScanStr();
		assertEquals("Ammar", ime);

	}
	@Test
	public void ScanStrTest1() {
		String ime=ScanStr();
		assertTrue(!ime.equals(""));
	}
	@Test
	public void ScanIntTest() {
		broj=ScanInt();
		assertEquals(3, broj);

	}
	@Test
	public void statusTest() {
		racun=new Racuni(32);
		assertEquals(32, racun.getPare(),5);
	}
	@Test
	public void statusTest1() {
		racun=new Racuni("Ammar","ammar",420,3466);
		racun.status();
		assertEquals("Ammar", racun.getIme());
	}
	@Test
	public void statusTest2() {
		racun=new Racuni("Ammar","ammar",420,3466);
		racun.status();
		assertEquals("ammar", racun.getSifra());
	}
	@Test
	public void statusTest3() {
		racun=new Racuni("Ammar","ammar",420,3466);
		racun.status();
		assertEquals(3466, racun.getId(),1);
	}
	@Test
	public void statusTest4() {
		racun=new Racuni("Ammar","ammar",420,3466);
		racun.status();
		assertEquals(3466, racun.getId(),1);
	}
	
	@Test
	public void loginTest4() {
		racun=Racuni.login("Ammar", "ammar123");
		assertEquals(trenutniId, racun.getId(),1);
	}
	@Test
	public void loginTest5() {
		racun=Racuni.login("Ammar", "ammar123");
		assertEquals(trenutnoIme, racun.getIme());
	}
	@Test
	public void loginTest6() {
		racun=Racuni.login("Ammar", "ammar123");
		assertEquals(trenutnaSifra, racun.getSifra());
	}
	@Test
	public void loginTest7() {
		racun=Racuni.login("Ammar", "ammar123");
		assertEquals(trenutnePare, racun.getPare(),1);
	}
	
	
}
