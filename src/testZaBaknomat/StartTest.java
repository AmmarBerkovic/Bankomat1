package testZaBaknomat;

import static org.junit.Assert.*;

import java.util.InputMismatchException;

import org.junit.Test;

import bankomat.Start;

public class StartTest extends Start{
	int broj;
	@Test
	public void ScanStrTest() {
		System.out.println("Ammar");
		String ime=ScanStr();
		assertEquals("Ammar", ime);

	}
	@Test
	public void ScanStrTest1() {
		System.out.println("bilo sta");
		String ime=ScanStr();
		assertTrue(!ime.equals(""));
	}
	@Test
	public void ScanIntTest() {
		System.out.println("3");
		broj=ScanInt();
		assertEquals(3, broj);

	}
	@Test
	public void pristupTest() {
		String pristup=pristup(1);
		assertEquals("Uspijesno odradjena radnja!!!", pristup);
		
	}
	@Test
	public void pristupTest1() {
		String pristup=pristup(3);
		assertEquals("Zao nam je sto ste imali poteskoca sa unosom\nPokusajte ponovo!!", pristup);
		
	}
	@Test
	public void pristupTest2() {
		String pristup=pristup(5);
		assertEquals("Dobro dosli!!!", pristup);
		
	}
	@Test
	public void pristupTest3() {
		String pristup=pristup(2);
		assertEquals("===================\n1 - Prijava\n2 - Kreiraj racun\\n3 - Izlaz\n===================", pristup);
		
	}
	@Test
	public void pristupTest4() {
		String pristup=pristup(4);
		assertEquals("===================\n1 - Transfer novca\n2 - Status\n3 - Izlaz\n===================", pristup);
		
	}
	@Test
	public void pristupTest5() {
		String pristup=pristup(6);
		assertEquals("==============\nDovidjenja!!!\n==============", pristup);
		
	}
	
	
}
