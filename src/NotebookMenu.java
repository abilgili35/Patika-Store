import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class NotebookMenu extends AppMenu<Notebook>{

    

    public NotebookMenu(ArrayList<Brand> brandList){
        super("Notebook Islemleri", brandList);
        initNotebookList();
    }

    private void initNotebookList(){
        productList.add(new Notebook("Matebook", brandList.get(4), 4, 7000, 0.1, 128, 512, 14.1));
        productList.add(new Notebook("V14", brandList.get(2), 7, 3600, 0.1, 64, 512, 13.1));
        productList.add(new Notebook("Tuf Gaming", brandList.get(5), 2, 8200, 0.05, 64, 2018, 15.0));
    }

    



    public void printProducts(ArrayList<Notebook> list, Comparator<Product> comp){
        System.out.println("Notebook Listesi\n\n");

        Collections.sort(list, comp);

        if(list.isEmpty()){
            System.out.println("Sisteme girilmis herhangi bir urun yok.");
            return;
        }

        for(int i=0; i<103; i++){
            System.out.print("-");
        }

        System.out.println();

        System.out.format("| %-2s | %-25s | %-10s | %-12s | %-12s | %-10s | %-10s |\n", "ID", "Urun Adi", "Fiyat", "Marka", "Depolama", "Ekran", "RAM");

        for(int i=0; i<103; i++){
            System.out.print("-");
        }

        System.out.println();

        for(Notebook n : list){
            System.out.format("| %-2s | %-25s | %-8.2f TL | %-12s | %-12d | %-10.2f | %-10d |\n", n.getId(), n.getBrand().getName().toUpperCase() + " " + n.getProductName(), n.getPrice(), n.getBrand().getName(), n.getDiskSize(), n.getScreenSize(), n.getMemorySize());
        }

        for(int i=0; i<103; i++){
            System.out.print("-");
        }

        System.out.println();

        
    }

    

    

    protected void addProduct(){
        String productName;
        Brand brand;
        int stockCount;
        double price;
        double discount;
        int diskSize;
        int ram;
        double screenSize;


        System.out.println("Lutfen Yeni Notebook Urunune Ait Bilgileri Giriniz");
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

        this.productList.add(new Notebook(productName, brand, stockCount, price, discount, ram, diskSize, screenSize));
        System.out.println("Urun Bilgilieri Sisteme Eklendi.");
        

        
        
        


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

    
}
