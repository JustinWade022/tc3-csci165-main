
import java.util.Scanner;
import java.io.IOException;
import java.io.FileReader;

public class Address{

	private String 	street = "";
	private String 	city = "";
	private String 	state = "";
	private String 	zip = "";

	public Address(){}

	public Address(String s, String c, String state, String z){
		this.street = s;
		setZip(z);
	}

	public Address(String street, String z){
		this.street = street;
		setZip(z);
	}
		
	public void setStreet(String street) {
		this.street = street;
	}

	public void setZip(String zip) {
		boolean iszip = false;
		String[] zipline = new String[30];
        String filename = "zip_code_database.csv";
        try{
		    FileReader fr1 = new FileReader(filename);
		    Scanner s = new Scanner(fr1);
		    s.nextLine();
		    while (s.hasNextLine()) {
			    String line = s.nextLine();
			    String[] v = line.split(",");
			    String filezip = v[0];
			    if (filezip.equals(zip)) {
				    zipline = v;
				    iszip = true;
			    }
		    }
		    if (iszip) {
			    if ((state == "") || (city == "")) {
					int quote1 = 0;
					int quote2 = 0;
					state = zipline[6];
					for (int i = 2; i < 9; i++){
						if ((zipline[i].indexOf("\"") == 0) && ((zipline[i].indexOf("\"", 1)) != (zipline[i].length() - 1))) {
							quote1 = i;
						}
						if ((quote1 > 0) && ((zipline[i].indexOf("\"", 1)) == (zipline[i].length() - 1))) {
							quote2 = i;
							state = zipline[quote2 + 1];
						}
					}
				    city = zipline[3];
			    }
			    this.zip = zip;
			}
			fr1.close();
			s.close();
        }
        catch (IOException ioe) {}
		
		
	}

	public String getStreet(){
		return street;
	}

	public String getCity(){
		return city;
	}

	public String getState(){
		return state;
	}

	public String getZip(){
		return zip;
	}

	public boolean equals(Address a){
		return 	this.street.equals(a.street) 	&&
				this.city.equals(a.city) 		&&
				this.state.equals(a.state) 		&&
				this.zip.equals(a.zip);

	}
	
	public String toString(){
		if (zip == ""){
			return street + "\n" + city + ", " + state + " " + "Zip Unidentified! - Re-enter Address";
		}
		return street + "\n" + city + ", " + state + " " + zip;
	}

}