import static org.junit.jupiter.api.Assertions.*;

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
	@ParameterizedTest
	/*
	public final void testFizzde() {
		
		String res = FizzBuzz.fizzBuzz(3);
		assertEquals("Fizz", res, "Problème dans 3");
	}
	*/

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
	
}
