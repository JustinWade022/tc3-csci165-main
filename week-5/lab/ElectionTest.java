import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ElectionTest {

	@Test
	void fillArraytest() {
		ElectionDriver.fillArray();
		assertEquals(ElectionDriver.results[31].demVotes, 4848);
	}
	
	@Test
	void findLargestMarginTest() {
		ElectionDriver.fillArray();
		assertEquals(ElectionDriver.findLargestMargin().difference, ElectionDriver.results[204].difference);
	}
	
	@Test
	void findLargestMarginStateTest() {
		ElectionDriver.fillArray();
		double f = ElectionDriver.results[2003].difference;
		double c = ElectionDriver.findLargestMargin("NY").difference;
		assertEquals(f, c);
	}

}
