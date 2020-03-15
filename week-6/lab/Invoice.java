
public class Invoice{

    private String inv_num = "";
    private Account acct;
    private double amount;
    private Date date;
    private Product[] products;

    public Invoice(){}

    public Invoice(String inv_num, Account acct, double amount,
                    Date date){
        this.inv_num = inv_num;
        this.acct = acct;
        this.amount = amount;
        this.date = date;
    }

    public Account getAccount(){
        return acct;
    }

    public double getAmount(){
        return amount;
    }

    public Date getDate(){
        return date;
    }

    public double getAmountDue(){
        double totalDue = 0.0;
        for (int i = 0, i < products.length(), i++){
            totalDue += products[i].getPrice();

        }
        return totalDue;
    }

    public void setDate(Date date){
        this.date = date;
    }

    public String toString(){
        String message = acct;
        for (int i = 0, i < products.length; i++){
            message += products[i] + "\n";
        }
        message += "\n\n Total: " + this.getAmountDue();
        return message
    }

    
}