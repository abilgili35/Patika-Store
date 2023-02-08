import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class BrandMenu extends AppMenu<Product>{
    

    public BrandMenu(ArrayList<Brand> brandList){
        super("Marka Listele", brandList);
    }

    public void listBrands(){
        Collections.sort(this.brandList, new BrandComparatorByName());

        for(Brand b : brandList){
            System.out.println("- " + b.getName());
        }
    }

    public ArrayList<Brand> getBrandList() {
        return brandList;
    }

    public void setBrandList(ArrayList<Brand> brandList) {
        this.brandList = brandList;
    }

    @Override
    protected void display() {
        System.out.println("############ MARKA LISTELE ##############");
        System.out.println();
        System.out.println();
        System.out.println("Markalarimiz");
        System.out.println("-----------------------------------");
        listBrands();
    }

    @Override
    protected void performActions() {
        askToContinue();
    }

    @Override
    protected void printProducts(ArrayList<Product> list, Comparator<Product> comp) {
    }

    @Override
    protected void addProduct() {
        
    }
}
