public abstract class Product {
    private static int nextId = 1;
    private int id;
    private String productName;
    private Brand brand;
    private int stockCount;
    private double price;
    private double discountRate;

    public Product(String productName, Brand brand, int stockCount, double price, double discountRate){
        setId();
        setProductName(productName);
        setBrand(brand);
        setStockCount(stockCount);
        setPrice(price);
        setDiscountRate(discountRate);
    }
    
    



    public double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStockCount() {
        return stockCount;
    }

    public void setStockCount(int stockCount) {
        this.stockCount = stockCount;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getId() {
        return id;
    }

    public void setId() {
        this.id = this.nextId;
        nextId++;
    }
    
}
