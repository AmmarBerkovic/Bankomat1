package testZaBaknomat;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import bankomat.Racuni;

public class RacuniTest extends Racuni {
	@Before
	public void pre() {
		
	}

	@After
	public void posle() {
		
	}

	@Test
	public void rndTest1() {
		int rnd=Racuni.rnd();
		assertTrue(rnd<10000);
		assertTrue(0<rnd);
	}
	@Test
	public void izlazTest() {
		Racuni.izlaz();
		assertTrue(trenutniId==0);
		assertTrue(trenutnePare==0);
		assertTrue(trenutnoIme==null);
		assertTrue(trenutnaSifra==null);
	}
	

}
