import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class PatikaStoreApp {
    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);

        ArrayList<Brand> brandList= new ArrayList<>();
        String[] brandNames = {"Samsung", "Lenovo", "Apple", "Huawei", "Casper", "Asus", "HP", "Xiomi", "Monster"};

        for(String name : brandNames){
            brandList.add(new Brand(name));
        }

        Collections.sort(brandList, new BrandComparatorByName());

        ArrayList<AppMenu> menuList = new ArrayList<>();
        
        menuList.add(new NotebookMenu(brandList));
        menuList.add(new MobilePhoneMenu(brandList));
        menuList.add(new BrandMenu(brandList));
        MainMenu menu = new MainMenu(brandList, menuList);
        menu.onMenu();

        
    }
}
