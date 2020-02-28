import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class temperatureTests {
	
	temperature t = new temperature();

	@Test
	void testgetsetTempF() {
		float value = 56;
		t.setTemp(value);
		
		assertEquals(value, t.getFahrenheit());
	}
	
	@Test
	void testgetsetTempC() {
		float desired = 100;
		float value = 212;
		t.setTemp(value);
		
		assertEquals(100, t.getCelsius());
	}
	
	temperature u = new temperature();
	
	@Test
	void testequals() {
		t.setTempScale(-40, temperature.Scale.C);
		u.setTemp(-40);
		
		assertEquals(t.equals(u), true);
	}
	
	@Test
	void testCompareto() {
		assertEquals(t.compareTo(u), 0);
	}

}
