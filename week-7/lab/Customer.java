public class Customer {
	
	private String firstName;
	private String lastName;
	private String email;
	private Address address;
	
	public Customer() {}

	public Customer(String firstName, String lastName, String email, Address address) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		setEmail(email);
		this.address = address;
	}

	public Customer(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public void setName(String first, String last) {
		this.firstName = first;
		this.lastName = last;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		
		int l = email.length();
		int counta = 0;
		int countd = 0;
		
		
		if ((email.contains("@")) && (email.contains("."))){
			if ((email.indexOf(".") < (l - 2)) && ((email.indexOf(".")) >= (l - 4))) {
				for (int i = 0; i < l; i++) {
					if (email.charAt(i) == '@') {
						counta += 1;
					}
					if (email.charAt(i) == '.') {
						countd += 1;
					}
				}
				if ((counta == 1) && (countd == 1)) {
					this.email = email;
					
				}
				else {
					this.email = "none on file";
				}
			}
			else {
				this.email = "none on file";
				
			}
			
		}
		else {
			this.email = "none on file";
		}
	}
	
	public String getName() {
		return firstName + " " + lastName;
	}
	
	public boolean equals(Customer a) {
		return 	this.getName().equals(a.getName())		&&
				this.email.equals(getEmail())			&&
				this.address.equals(a);
	}

	@Override
	public String toString() {
		if (address != null) {
			return "Name: " + firstName + " " + lastName + "\nEmail: " + email + "\n\nAddress\n" + address.toString();
		}
		else return "Name: " + firstName + " " + lastName + "\nEmail: " + email + "\n\nAddress: None";
	
	}
}