import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MobilePhoneMenu extends AppMenu<MobilePhone>{
    
    public MobilePhoneMenu(ArrayList<Brand> brandList){
        super("Cep Telefonu Islemleri", brandList);
        initMobilePhoneList();
    }

    private void initMobilePhoneList(){
        productList.add(new MobilePhone("Galaxy A51", brandList.get(4), 4, 3199, 0.1, 6, 128, 6.5, 4000, "Siyah"));
        productList.add(new MobilePhone("Iphone 11 64 GB", brandList.get(2), 7, 7379, 0.1, 6, 64, 6.1, 3046, "Mavi"));
        productList.add(new MobilePhone("RedMi Note 10 Pro 8GB", brandList.get(5), 2, 4012, 0.05, 16, 128, 6.5, 4000, "Beyaz"));
    }


    @Override
    protected void display() {
        System.out.println("############## " + getName().toUpperCase() + " ###############");
        System.out.println();
        System.out.println("1 - Urunleri Listele");
        System.out.println("2 - Urun Ekle");
        System.out.println("3 - Urun Sil");
        System.out.println("0 - Cikis Yap");
        
    }

    @Override
    protected void performActions() {
        int selection;
        boolean exitMenu = false;

        while(true){
            if(exitMenu){
                break;
            }
            
            selection = getIntegerInput();

            switch (selection){
                case 0:
                    exitMenu = true;
                    break;
                case 1:
                    listProducts();
                    askToContinue();
                    break;
                case 2:
                    addProduct();
                    askToContinue();
                    break;
                case 3:
                    deleteProduct();
                    askToContinue();
                    break;

                default:
                System.out.println("Yanlis bir secim yaptiniz tekrar deneyiniz.");
            }
            clearScreen();
            display();
        }
    }

    @Override
    protected void printProducts(ArrayList<MobilePhone> list, Comparator<Product> comp) {
        System.out.println("Cep Telefonu Listesi");


        Collections.sort(list, comp);

        if(list.isEmpty()){
            System.out.println("Sisteme girilmis herhangi bir urun yok.");
            return;
        }

        for(int i=0; i<148; i++){
            System.out.print("-");
        }

        System.out.println();

        System.out.format("| %-2s | %-30s | %-10s | %-12s | %-12s | %-10s | %-12s| %-10s | %-10s | %-10s |\n", "ID", "Urun Adi", "Fiyat", "Marka", "Depolama", "Ekran", "Kamera", "Pil", "RAM", "Renk");

        for(int i=0; i<148; i++){
            System.out.print("-");
        }

        System.out.println();

        for(MobilePhone n : list){
            System.out.format("| %-2s | %-30s | %-7.2f TL | %-12s | %-12d | %-10.2f| %-12s | %-10s | %-10d | %-10s |\n", n.getId(), n.getBrand().getName().toUpperCase() + " " + n.getProductName(), n.getPrice(), n.getBrand().getName(), n.getDiskSize(), n.getScreenSize(), n.getCameraResolution(), n.getBatteryPower(), n.getMemorySize(), n.getColor());
        }

        for(int i=0; i<148; i++){
            System.out.print("-");
        }

        System.out.println();
    }


    @Override
    protected void addProduct() {
        
        String productName;
        Brand brand;
        int stockCount;
        double price;
        double discount;
        int diskSize;
        int ram;
        double screenSize;
        int cameraResolution;
        int batteryPower;
        String color;


        System.out.println("Lutfen Yeni Cep Telefonu Urunune Ait Bilgileri Giriniz");
        System.out.println();
       
        System.out.print("Urun Adi: ");
        productName = this.input.next();
        
        System.out.print("Urunun  Markasi: ");
        System.out.println();
        for(Brand b : brandList){
            System.out.println("  " + b.getId() + " " + b.getName());
        }
        
        
        brand = getBrand();
        System.out.println("Secilen marka :" + brand.getName());

        System.out.println("Urunun Stok Miktari: ");
        stockCount = getIntegerInput();

        System.out.println("Urunun Fiyati : ");
        price = getDoubleInput();

        System.out.println("Urunun Indirim Orani : ");
        discount = getDoubleInput();

        System.out.println("Urunun RAM Miktari : ");
        ram = getIntegerInput();

        System.out.println("Urunun Hafiza Miktari : ");
        diskSize = getIntegerInput();

        System.out.println("Urunun Ekran Boyutu : ");
        screenSize = getDoubleInput();

        System.out.println("Urunun Pil Gucu :");
        batteryPower = getIntegerInput();

        System.out.println("Urunun Rengi :");
        color = this.input.next();

        this.productList.add(new MobilePhone(productName, brand, stockCount, price, discount, ram, diskSize, screenSize, batteryPower, color));
        System.out.println("Urun Bilgilieri Sisteme Eklendi.");
        
    }
}
