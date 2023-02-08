import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public abstract class AppMenu <T extends Product>{
    protected ArrayList<T> productList;
    protected ArrayList<Brand> brandList;
    protected Scanner input;
    protected String name;

   

    public AppMenu(String name, ArrayList<Brand> brandList){
        setName(name);
        this.productList = new ArrayList<>();
        setBrandList(brandList);
        input = new Scanner(System.in);
    }

    

    public void onMenu(){
        clearScreen();
        display();
        performActions();
    }

    public void filterByBrand(){
        Brand brand;
        ArrayList<T> filterList = new ArrayList<>();

        System.out.print("Urunun  Markasi: ");
        System.out.println();

        for(Brand b : brandList){
            System.out.println("  " + b.getId() + " " + b.getName());
        }
        
        
        brand = getBrand();
        System.out.println("Secilen marka :" + brand.getName());


        Iterator<T> itr = productList.iterator();

        while(itr.hasNext()){
            T n = itr.next();
            if(n.getBrand().getName().equals(brand.getName())){
                filterList.add(n);
            }
        }

        printProducts(filterList, new DeviceComparatorByID());
    }

    protected void listProducts(){
        int selection;
        System.out.println("Lutfen uygulamak istediginiz listeleme turunu seciniz.");
        System.out.println("1- ID ye gore listele");
        System.out.println("2- Markaya gore listele");
        System.out.println("3- Markaya gore filtrele ve listele");
        
        while(true){
            selection = input.nextInt();
            if((selection > 1) || (selection < 3)){
                break;
            }else{
                System.out.println("Yanlis bir secim yaptiniz.Tekrar deneyiniz.");
            }

        }
        if(selection == 1){
            printProducts(this.productList, new DeviceComparatorByID());
        }else if(selection == 2){
            printProducts(this.productList, new DeviceComparatorByBrand());
        }else if(selection == 3){
            filterByBrand();
        }
        
    }

    protected void deleteProduct(){

        if(productList.isEmpty()){
            System.out.println("Sistemde silinecek bir urun yok.");
        }else{
            System.out.println("Lutfen Sistemden Silmek Istediginiz Urunun ID sini giriniz\n\n");
            printProducts(this.productList, new DeviceComparatorByID());
            while(!tryToDelete());
        }
        
        
    }

    private boolean tryToDelete(){
        int selection;
        selection = getIntegerInput();

        
        for(T n : productList){
            if(n.getId() == selection){
                System.out.println(n.getBrand().getName() + " " + n.getProductName() + " urunu sistemden silindi.");
                return productList.remove(n);
            }
        }

        System.out.println("Yanlis bir ID numarasi girdiniz.");
        return false;

    
        
    }

    protected int getIntegerInput(){
        
        int userInput = 0;
        while (true) {
            try {
                userInput = Integer.parseInt(this.input.next());
                break; 
            }catch (NumberFormatException ignore) {
                System.out.println("Yanlis turde bir veri girisi yaptiniz.Integer deger girmalisiniz.");
            }
        }
        return userInput;
    }

    protected double getDoubleInput(){
        
        double userInput = 0;
        while (true) {
            try {
                userInput = Double.parseDouble(this.input.next());
                break; 
            }catch (NumberFormatException ignore) {
                System.out.println("Yanlis turde bir veri girisi yaptiniz.Integer deger girmalisiniz.");
            }
        }
        return userInput;
    }



    protected Brand getBrand(){
        int id = this.input.nextInt();
        int index = -1;
        
        try{
            for(Brand b : brandList){
                if(b.getId() == id){
                    index = brandList.indexOf(b);
                }
            }
            return brandList.get(index);
        }catch(IndexOutOfBoundsException e){
            System.out.println("Yanlis secim yaptiniz.Tekrar deneyiniz.");
            return getBrand();
            
        }
    }

    protected void askToContinue(){
        System.out.println("<D>evam...");
        while(true){
            
            String s = input.next();
            s = s.toUpperCase();
            if(s.equals("D")){
                break;
            }else{
                System.out.println("Gecersiz komut!");
            }
        }
    }

    protected void clearScreen(){
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (InterruptedException e) {
            
            e.printStackTrace();
        } catch (IOException e) {
            
            e.printStackTrace();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Brand> getBrandList() {
        return brandList;
    }

    public void setBrandList(ArrayList<Brand> brandList) {
        this.brandList = brandList;
    }

    public ArrayList<T> getProductList() {
        return productList;
    }

    public void setProductList(ArrayList<T> productList) {
        this.productList = productList;
    }

    protected abstract void printProducts(ArrayList<T> list, Comparator<Product> comp);

    protected abstract void addProduct();

    protected abstract void display();

    protected abstract void performActions();
    
}
