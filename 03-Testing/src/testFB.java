import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class testFB {

	//@Test
	/*
	public final void testAvecValeurUn() {
		String res = FizzBuzz.fizzBuzz(1);
		assertEquals("1",res,"Probleme avec le nombre 1");
		
	}

	public final void testAvecValeurDeux() {
		String res = FizzBuzz.fizzBuzz(2);
		assertEquals("2",res,"Probleme avec le nombre 2");
		
	
	 */
	/*
	@ParameterizedTest
	public final void testFizzde() {
		
		String res = FizzBuzz.fizzBuzz(3);
		assertEquals("Fizz", res, "Problème dans 3");
	}
	*/

	/*
	@CsvSource({
		"1, 1",
		"2, 2",
		"3, Fizz",
		"4, 4",
		"6, Fizz",
		"9, Fizz"
	})
	public final void testFizzBuzz(int input, String expected) {
		String res = FizzBuzz.fizzBuzz(input);
		assertEquals(expected, res, "!!!");
	}
	*/
	static Point a;
	
	@BeforeAll
	static void init() {
		a = new Point(1,2);
		System.out.println("init");
	}
	
	/*
	
	@BeforeEach
	public void init() {
		a = new Point(1,2);
		System.out.println("inti All");
	}
	
	public void ens(){
		a=null;
		System.out.println("end");
	}
	*/
	@Test
	public final void testTranslater0_0() {
		//Point a = new Point(1,2);
		Point attendu = new Point(1,2);
		Point obtenu = a.translater(0, 0);
		assertEquals(attendu, obtenu);
		
	}
	@Test
	public final void testEquals() {
		//Point a = new Point(1,2);
		Point b = new Point(1,2);
		assertTrue(a.equals(b));
		
	}
	
	@RepeatedTest(10)
	public final void testTranslater1_3() {
		//Point a = new Point(1,2);
		Point attendu = new Point(2,5);
		Point obtenu = a.translater(1,3);
		assertEquals(attendu, obtenu);
	}
	public void testAll() {
		Random rd = new Random();
		int i = rd.nextInt();
		int j = rd.nextInt();
		
		assertAll(
				() -> assertEquals(new Point(i,j),(new Point(i,j)).translater(0, 0)),
				() -> testTranslater1_3(), 
				() -> testEquals(),
				() -> testTranslater0_0()
		);
	}
	
	
	
	
	
	
}
