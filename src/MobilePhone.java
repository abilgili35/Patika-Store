public class MobilePhone extends Product{
    private int diskSize;
    private int memorySize;
    private double screenSize;
    private int batteryPower;
    private String color;
    private int cameraResolution;

    

    public MobilePhone(String productName, Brand brand, int stockCount, double price, double discountRate,int memorySize, int diskSize, double screenSize, int batteryPower, String color){
        super(productName, brand, stockCount, price, discountRate);
        setMemorySize(memorySize);
        setDiskSize(diskSize);
        setScreenSize(screenSize);
        setBatteryPower(batteryPower);
        setColor(color);
    }
    

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getBatteryPower() {
        return batteryPower;
    }

    public void setBatteryPower(int batteryPower) {
        this.batteryPower = batteryPower;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }

    public int getMemorySize() {
        return memorySize;
    }

    public void setMemorySize(int memorySize) {
        this.memorySize = memorySize;
    }
    
    public int getDiskSize() {
        return diskSize;
    }

    public void setDiskSize(int diskSize) {
        this.diskSize = diskSize;
    }

    public int getCameraResolution() {
        return cameraResolution;
    }


    public void setCameraResolution(int cameraResolution) {
        this.cameraResolution = cameraResolution;
    }


    
    
}
