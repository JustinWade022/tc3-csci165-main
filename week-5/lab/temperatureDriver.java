
public class temperatureDriver {

	public static void main(String[] args) {
		temperature t1 = new temperature();
		temperature t2 = new temperature();
		
		
		t1.setTemp(0);

		
		t1.setScale(temperature.Scale.C);
		
		System.out.println(t1.getFahrenheit());
		
		
		
		t2.setTempScale(32, temperature.Scale.F);
		
		System.out.println(t2.getCelsius());
		
		//Printing out each objects to Strings
		System.out.println(t1.toString());
		System.out.println(t2.toString());
		
		if (t1.equals(t2)) {
			System.out.println("These two temps are the same");
		}
		else {
			System.out.println("These are two different temps");
		}
	}
}
