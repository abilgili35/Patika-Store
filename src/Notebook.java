public class Notebook extends Product {
    private int memorySize;
    private int diskSize;
    private double screenSize;

    public Notebook(String productName, Brand brand, int stockCount, double price, double discountRate, int memorySize, int diskSize, double screenSize){
        super(productName, brand, stockCount, price, discountRate);
        setMemorySize(memorySize);
        setDiskSize(diskSize);
        setScreenSize(screenSize);
    }
    

    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }

    public int getDiskSize() {
        return diskSize;
    }

    public void setDiskSize(int diskSize) {
        this.diskSize = diskSize;
    }

    public int getMemorySize() {
        return memorySize;
    }

    public void setMemorySize(int memorySize) {
        this.memorySize = memorySize;
    }
    
    
}
