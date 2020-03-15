import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AddressTests {
	
	Address address = new Address();
	
	Address address1 = new Address();
	
	Address address2 = new Address();
	

	@Test
    void testSetZip(){
        address.setZip(54774);

        assertTrue((address.getState()).equals("WI"));
	}
	
	@Test
	void testSetZip1() {
        address1.setZip(501);

        assertTrue((address1.getState()).equals("NY"));
	}

	@Test
	void testEquals() {
		address.setZip(54774);
		address1.setZip(54774);
		address1.setStreet("Caswell");
		assertFalse(address.equals(address1));
	}
	
	@Test
	void testEquals1() {
		address1.setZip(75848);

		address2.setZip(75848);
		assertTrue(address1.equals(address2));
    }
    
    
}