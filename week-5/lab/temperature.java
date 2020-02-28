
public class temperature {
	
	public static enum Scale{C, F};
	
	
	private float temp = 0;
	private Scale scale = Scale.F;
	
	
	
	public temperature(){}
	
	public float getCelsius() {
		float DegreesC = temp;
		if (scale == Scale.F) {
			DegreesC = (5 * (temp - 32) / 9);
		}
		return DegreesC;
	}
	
	public float getFahrenheit() {
		float DegreesF = temp;
		if (scale == Scale.C) {
			DegreesF = (9 * temp / 5) + 32;
		}
		return DegreesF;
	}
	
	
	
	public void setTemp(float value) {
		temp = value;
	}
	
	public void setScale(Scale scale) {
		this.scale = scale;
	}
	
	public void setTempScale(float value, Scale scale) {
		this.scale = scale;
		temp = value;
	}
	
	public boolean equals(temperature t) {
		return (this.getCelsius() == t.getCelsius());
	}
	
	public int compareTo(temperature t) {
		if (this.getCelsius() > t.getCelsius()) return 1;
		else if (this.getCelsius() < t.getCelsius()) return -1;
		else return 0;
	}
	
	public String toString() {
		return "The current temperature is " + this.getFahrenheit() + " Fahrenheit or " + this.getCelsius() + " Celsius";
		
	}
}
