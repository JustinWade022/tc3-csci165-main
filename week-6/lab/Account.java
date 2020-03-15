
import java.util.Calendar;

public class Account{

    private String id;
    private Customer customer;
    private double balance;
    private double creditLimit;
    private Date date;
    private double discountLevel;
    private int year = Calendar.getInstance().get(Calendar.YEAR);

    public Account(){}

    public Account(String id, Customer customer){
        this.id = id;
        this.customer = customer;
    }

    public Account(String id, Customer customer, double balance, double creditLimit, Date date){
        this.id = id;
        this.customer = customer;
        this.balance = balance;
        this.date = date;
        discountLevel = (year - date.getYear()) * 0.02;
        setCreditLimit(creditLimit);
    }


	public Customer getCustomer() {
		return this.customer;
	}

	public double getBalance() {
		return this.balance;
	}

	public void setBalance(double balance) {
        if (balance >= 0){
            this.balance = balance;
        }
	}

	public double getCreditLimit() {
		return this.creditLimit;
	}

	public void setCreditLimit(double creditLimit) {
        if (creditLimit > (balance * 2)){
            creditLimit = (balance * 2);
        }
        if (creditLimit >= 0){
            this.creditLimit = creditLimit;
        }
    }


    public boolean equals(Account otheraccount){
        return  this.customer.equals(otheraccount.getCustomer()) &&
                this.balance == otheraccount.getBalance()       &&
                this.creditLimit == otheraccount.getCreditLimit();

    }

    public int compareTo(Account otheraccount){
        return id.compareTo(otheraccount.id);
    }

    @Override
    public String toString() {
        return String.format("%30s%40s", customer, date);
    }
}