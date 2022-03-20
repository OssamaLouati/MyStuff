import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CalTest {
	@Test
	void addTest() {
		Calculator cal = new Calculator();
		assertEquals(1,cal.add(0, 1));
		
	}

}
