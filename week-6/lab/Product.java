public class Product {
    
    private String name = "";
    private String description = "";
    private double price = 0.0;
    private String sku  = "";
    private String[] skuCodes = {"001", "002", "003", "004",
                                "110"};


    public Product(){}

    public Product(String name, String description, double price, String sku){
        this.name = name;
        this.description = description;
        setPrice(price);
        setSku(sku);
    }

    public Product(String sku){
        this.sku = sku;
    }

    public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
        if (price > 0){
            this.price = price;
        }
    }
    
    public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
    }
    
    public boolean equals(Product otherProduct){
        return this.price == otherProduct.price &&
                this.name.equals(otherProduct.name) &&
                this.description.equals(otherProduct.description) &&
                this.sku.equals(otherProduct.sku);
    }

    private void setSku(String sku) {
        for (int i = 0; i < 5; i++){
            if (sku.indexOf(skuCodes[i]) == 0) {
                this.sku = sku;
            }
        }

    }


    @Override
    public String toString() {
        return

            String.format("%10s%40s", name,"$" + price);
    }







}