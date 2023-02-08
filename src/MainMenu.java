import java.util.ArrayList;
import java.util.Comparator;

public class MainMenu extends AppMenu<Product>{
    private AppMenu currentAppMenu;
    private ArrayList<AppMenu> menuList;

    public MainMenu(ArrayList<Brand> brandList, ArrayList<AppMenu> menuList){
        super("Main", brandList);
        this.menuList = menuList;
    }

    @Override
    protected void display() {
        int index = 1;
        System.out.println("############## ANA MENU #############");
        for(AppMenu menu : menuList){
            System.out.println(index + "- " + menu.getName());
            index++;
        }
        System.out.println("0- Cikis Yap");
        
    }

    @Override
    protected void performActions() {
        int selection;

        while(true){
            currentAppMenu = null;
            

            selection = getIntegerInput();


            switch(selection){
                case 0:
                    System.exit(0);
                    break;
                default:
                    try{
                        currentAppMenu = menuList.get(selection - 1);
                    }catch(IndexOutOfBoundsException e){
                        System.out.println("Yanlis bir secim yaptiniz.");
                        askToContinue();
                    }
                    
                    
            
            }
            if(currentAppMenu != null){
                currentAppMenu.onMenu();
            }

            clearScreen();
            display();
            
        }
    }

    @Override
    protected void printProducts(ArrayList<Product> list, Comparator<Product> comp) {
        
    }

    @Override
    protected void addProduct() {
        // TODO Auto-generated method stub
        
    }
    
}
